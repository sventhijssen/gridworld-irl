class ApprenticeshipLearning
{
    ApprenticeshipLearning(GridWorld gridWorld, Policy expertPolicy)
    {
        System.out.println("Initializing apprenticeship learning.");
        this.gridWorld = gridWorld;
        this.expertPolicy = expertPolicy;
    }

    Vector solve()
    {
        System.out.println("Solving apprenticeship learning.");
        Vector muExpert = expertPolicy.getFeatureExpectations(discountFactor);

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
            System.out.println("w = " + w);
            t = w.norm2();
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

    private double threshold = 0.00001;

    private double discountFactor = 0.9;

    private GridWorld gridWorld;

    private Policy expertPolicy;
}
