package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

class ApprenticeshipLearning
{

    private double threshold = 0.001;

    private double discountFactor = 0.9;

    private GridWorld gridWorld;

    private Vector muExpert;

    private ArrayList<Double> ts = new ArrayList<>();
    private ArrayList<Vector> ws = new ArrayList<>();

    ApprenticeshipLearning(GridWorld gridWorld, Vector muExpert)
    {
        System.out.println("Initializing apprenticeship learning.");
        this.gridWorld = gridWorld;
        this.muExpert = muExpert;
    }

    Vector solve()
    {
        System.out.println("Solving apprenticeship learning.");
        // Vector muExpert = expertPolicy.getFeatureExpectations(discountFactor);

        System.out.printf("-STEP 1, ITERATION %d: Compute feature expectation mu(%d)\n", 0, 0);
        Policy currentPolicy = PolicyFactory.getRandomPolicy(gridWorld); // π(0)
        Vector muCurrent = currentPolicy.getFeatureExpectations(discountFactor); // μ(0)

        Vector muFlat = muCurrent; // μ'(0)

        // Step 1: Set i = 1
        int i = 1;

        Vector w, a, b;
        double t;
        QLearning qLearning;

        // Step 4
        while(true)
        {

            if(i > 1)
            {
                a = muCurrent.minus(muFlat);
                b = muExpert.minus(muFlat);

                muFlat = muFlat.plus(a.scale(a.dot(b)/a.dot(a)));
            }

            // Step 2: Compute w_i and t_i
            System.out.printf("-STEP 2, ITERATION %d: Compute t and w\n", i);
            w = muExpert.minus(muFlat);
            ws.add(w);
            System.out.println("w = " + w);
            t = w.norm2();
            ts.add(t);
            System.out.printf("t = %f\n", t);

            System.out.printf("-STEP 3, ITERATION %d: Check t < e\n", i);
            // Step 3: If t < threshold, terminate
            if(t < threshold) break;

            System.out.printf("-STEP 4, ITERATION %d: Compute optimal policy pi(%d)\n", i, i);
            // Step 4: Compute optimal policy pi_i for the MDP using rewards R = w^T.phi
            qLearning = new QLearning(gridWorld);
            qLearning.computeQTable(w, 100);
            gridWorld.getRewardHeatMap(i, w);
            currentPolicy = qLearning.getPolicy();
            System.out.println(w);
            System.out.println(t);
            muCurrent = currentPolicy.getFeatureExpectations(discountFactor);

            System.out.printf("-STEP 5, ITERATION %d: Compute feature expectation mu(%d)\n", i, i);
            // Step 5: Compute mu_i

            System.out.printf("-STEP 6, ITERATION %d: Increment i to %d\n", i, i+1);
            // Step 6: Set i = i+1
            i++;
        }
        return w;
    }

    void drawEvolutionT() throws IOException
    {
        LineChart lineChart = new LineChart(640, 480);
        lineChart.setData(ts);
        lineChart.draw(
                "t.jpeg" ,
                "Error between expert feature expectation and learned feature expectation" ,
                "iteration",
                "t");
    }

    void drawEvolutionW() throws IOException
    {
        LineChart lineChart = new LineChart(640, 480);
        lineChart.setVectorData(ws);
        lineChart.draw(
                "w.jpeg",
                "Learned feature weights",
                "iteration",
                "w"
                );
    }
}
