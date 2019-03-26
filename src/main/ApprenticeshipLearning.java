package main;

import environments.IEnvironment;

import java.io.IOException;
import java.util.ArrayList;

class ApprenticeshipLearning
{

    /**
     * Variable registering the threshold of this apprenticeship learning instance.
     */
    private final double threshold;

    /**
     * Variable registering the discount factor of this apprenticeship learning instance.
     */
    private final double discountFactor;

    /**
     * Variable registering the grid world of this apprenticeship learning instance.
     */
    private GridWorld gridWorld;

    private Vector muExpert;

    private ArrayList<Double> ts = new ArrayList<>();
    private ArrayList<Vector> ws = new ArrayList<>();

    /**
     * Creates an apprenticeship learning instance for the given grid world and the given expert trajectory.
     * @param gridWorld         The given grid world.
     * @param expertTrajectory  The given expert trajectory.
     */
    ApprenticeshipLearning(GridWorld gridWorld, ArrayList<Position> expertTrajectory)
    {
        this(gridWorld, expertTrajectory, 0.01, 0.9);
    }

    /**
     * Creates an apprenticeship learning instance for the given grid world with the given expert trajectory,
     * the given threshold and discount factor.
     * @param gridWorld         The given grid world.
     * @param expertTrajectory  The given expert trajectory.
     * @param threshold         The given threshold.
     * @param discountFactor    The given discount factor.
     */
    private ApprenticeshipLearning(GridWorld gridWorld, ArrayList<Position> expertTrajectory, double threshold, double discountFactor)
    {
        this.gridWorld = gridWorld;
        this.muExpert = gridWorld.getFeatureExpectations(expertTrajectory);
        this.threshold = threshold;
        this.discountFactor = discountFactor;
    }

    Vector solve()
    {
        System.out.println("Solving apprenticeship learning.");
        // Vector muExpert = expertPolicy.getFeatureExpectations(discountFactor);

        System.out.printf("-STEP 1, ITERATION %d: Compute feature expectation mu(%d)\n", 0, 0);

        // Random initial policy π(0)
        GridWorldPolicy currentPolicy = PolicyFactory.getRandomPolicy(gridWorld, gridWorld.getActions().size());

        // Trajectory for random initial policy
        ArrayList<Position> currentTrajectory = currentPolicy.getTrajectory(gridWorld.getStartPosition());

        // Feature expectations for random initial policy
        Vector muCurrent = gridWorld.getFeatureExpectations(currentTrajectory); // μ(0)

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
            qLearning = new QLearning(gridWorld, discountFactor);
            qLearning.computeQTable(w, 100);
            gridWorld.getRewardHeatMap(i, w);
            currentPolicy = qLearning.getPolicy();
            System.out.println(w);
            System.out.println(t);
            currentTrajectory = currentPolicy.getTrajectory(gridWorld.getStartPosition());
            muCurrent = gridWorld.getFeatureExpectations(currentTrajectory);

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
