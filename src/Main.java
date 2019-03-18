public class Main
{
    public static void main(String [ ] args)
    {

        int rows = 4;
        int columns = 6;

        GridWorld gridWorld = new GridWorld(rows, columns);

        // Row 0
        gridWorld.setFeature(0,0, new double[] {0, 4});
        gridWorld.setFeature(0,1, new double[] {0, 5});
        gridWorld.setFeature(0,2, new double[] {0, 6});
        gridWorld.setFeature(0,3, new double[] {0, 6});
        gridWorld.setFeature(0,4, new double[] {0, 8});
        gridWorld.setFeature(0,5, new double[] {10, 9});


        // Row 1
        gridWorld.setFeature(1,0, new double[] {0, 3});
        gridWorld.setFeature(1,1, new double[] {0, 4});
        gridWorld.setFeature(1,2, new double[] {0, 5});
        gridWorld.setFeature(1,3, new double[] {0, 6});
        gridWorld.setFeature(1,4, new double[] {0, 7});
        gridWorld.setFeature(1,5, new double[] {0, 8});

        // Row 2
        gridWorld.setFeature(2,0, new double[] {0, 2});
        gridWorld.setFeature(2,1, new double[] {0, 3});
        gridWorld.setFeature(2,2, new double[] {1, 4});
        gridWorld.setFeature(2,3, new double[] {1, 5});
        gridWorld.setFeature(2,4, new double[] {0, 6});
        gridWorld.setFeature(2,5, new double[] {0, 7});

        // Row 3
        gridWorld.setFeature(3,0, new double[] {0, 1});
        gridWorld.setFeature(3,1, new double[] {0, 2});
        gridWorld.setFeature(3,2, new double[] {0, 3});
        gridWorld.setFeature(3,3, new double[] {0, 4});
        gridWorld.setFeature(3,4, new double[] {0, 5});
        gridWorld.setFeature(3,5, new double[] {0, 6});

        gridWorld.getStartPosition(0,0);
        gridWorld.setGoalPosition(0,5);


        GridWorld testingWorld = new GridWorld(rows, columns);

        // Row 0
        testingWorld.setFeature(0,0, new double[] {0, 1});
        testingWorld.setFeature(0,1, new double[] {0, 2});
        testingWorld.setFeature(0,2, new double[] {0, 3});
        testingWorld.setFeature(0,3, new double[] {0, 4});
        testingWorld.setFeature(0,4, new double[] {0, 5});
        testingWorld.setFeature(0,5, new double[] {0, 6});


        // Row 1
        testingWorld.setFeature(1,0, new double[] {0, 2});
        testingWorld.setFeature(1,1, new double[] {0, 3});
        testingWorld.setFeature(1,2, new double[] {0, 4});
        testingWorld.setFeature(1,3, new double[] {0, 5});
        testingWorld.setFeature(1,4, new double[] {0, 6});
        testingWorld.setFeature(1,5, new double[] {0, 7});

        // Row 2
        testingWorld.setFeature(2,0, new double[] {0, 3});
        testingWorld.setFeature(2,1, new double[] {0, 4});
        testingWorld.setFeature(2,2, new double[] {0, 5});
        testingWorld.setFeature(2,3, new double[] {0, 6});
        testingWorld.setFeature(2,4, new double[] {0, 7});
        testingWorld.setFeature(2,5, new double[] {0, 8});

        // Row 3
        testingWorld.setFeature(3,0, new double[] {1, 4});
        testingWorld.setFeature(3,1, new double[] {0, 5});
        testingWorld.setFeature(3,2, new double[] {0, 6});
        testingWorld.setFeature(3,3, new double[] {0, 7});
        testingWorld.setFeature(3,4, new double[] {0, 8});
        testingWorld.setFeature(3,5, new double[] {10, 9});

        testingWorld.getStartPosition(0,0);
        testingWorld.setGoalPosition(3,5);


        // Policy that goes straight to final destination
//        Policy expertPolicy = PolicyFactory.getRandomPolicy(gridWorld);
//        expertPolicy.setCell(0,0, new Vector(new double[] {0, 1, 0, 0}));
//        expertPolicy.setCell(0,1, new Vector(new double[] {0, 1, 0, 0}));
//        expertPolicy.setCell(0,2, new Vector(new double[] {0, 1, 0, 0}));
//        expertPolicy.setCell(0,3, new Vector(new double[] {0, 1, 0, 0}));
//        expertPolicy.setCell(0,4, new Vector(new double[] {0, 1, 0, 0}));
//        expertPolicy.setCell(0,5, new Vector(new double[] {0, 0, 1, 0}));
//
//        expertPolicy.setCell(1,0, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(1,1, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(1,2, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(1,3, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(1,4, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(1,5, new Vector(new double[] {1, 0, 0, 0}));
//
//        expertPolicy.setCell(2,0, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(2,1, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(2,2, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(2,3, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(2,4, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(2,5, new Vector(new double[] {1, 0, 0, 0}));
//
//        expertPolicy.setCell(3,0, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(3,1, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(3,2, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(3,3, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(3,4, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(3,5, new Vector(new double[] {1, 0, 0, 0}));

        // Policy that goes through rewards
        Policy expertPolicy = PolicyFactory.getRandomPolicy(gridWorld);
        expertPolicy.setCell(0,0, new Vector(new double[] {0, 0, 1, 0}));
        expertPolicy.setCell(0,1, new Vector(new double[] {0, 0, 1, 0}));
        expertPolicy.setCell(0,2, new Vector(new double[] {0, 0, 1, 0}));
        expertPolicy.setCell(0,3, new Vector(new double[] {0, 0, 1, 0}));
        expertPolicy.setCell(0,4, new Vector(new double[] {0, 1, 0, 0}));
        expertPolicy.setCell(0,5, new Vector(new double[] {0, 0, 1, 0}));

        expertPolicy.setCell(1,0, new Vector(new double[] {0, 0, 1, 0}));
        expertPolicy.setCell(1,1, new Vector(new double[] {0, 0, 1, 0}));
        expertPolicy.setCell(1,2, new Vector(new double[] {0, 0, 1, 0}));
        expertPolicy.setCell(1,3, new Vector(new double[] {0, 0, 1, 0}));
        expertPolicy.setCell(1,4, new Vector(new double[] {0, 1, 0, 0}));
        expertPolicy.setCell(1,5, new Vector(new double[] {1, 0, 0, 0}));

        expertPolicy.setCell(2,0, new Vector(new double[] {0, 1, 0, 0}));
        expertPolicy.setCell(2,1, new Vector(new double[] {0, 1, 0, 0}));
        expertPolicy.setCell(2,2, new Vector(new double[] {0, 1, 0, 0}));
        expertPolicy.setCell(2,3, new Vector(new double[] {0, 1, 0, 0}));
        expertPolicy.setCell(2,4, new Vector(new double[] {0, 1, 0, 0}));
        expertPolicy.setCell(2,5, new Vector(new double[] {1, 0, 0, 0}));

        expertPolicy.setCell(3,0, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(3,1, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(3,2, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(3,3, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(3,4, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(3,5, new Vector(new double[] {1, 0, 0, 0}));

        // Apply apprenticeship learning
        ApprenticeshipLearning apprenticeshipLearning = new ApprenticeshipLearning(gridWorld, expertPolicy);
        Vector weights = apprenticeshipLearning.solve();
        System.out.println(weights);

        //TODO: Switch 1 and -5 to see heat map difference
        //Vector weights = new Vector(new double[] {1, 0});

        //gridWorld.getRewardHeatMap(-1, weights);
        testingWorld.getRewardHeatMap(0, weights);

        // Apply Q-learning to example
        QLearning qLearning = new QLearning(testingWorld);
        qLearning.computeQTable(weights, 100);
        System.out.println(qLearning.toString());
    }
}
