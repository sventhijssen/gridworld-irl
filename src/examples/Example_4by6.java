package examples;

import main.GridWorld;
import main.Policy;
import main.PolicyFactory;
import main.Vector;

public class Example_4by6 implements IExample
{

    private final static int rows = 4;

    private final static int columns = 6;

    private static GridWorld learningWorld;
    private static GridWorld testingWorld;

    public Example_4by6()
    {
        learningWorld = new GridWorld(rows, columns);
        testingWorld = new GridWorld(rows, columns);
    }

    @Override
    public GridWorld getLearningWorld()
    {
        // Row 0
        learningWorld.setFeature(0,0, new double[] {0, Math.exp(-1/4)});
        learningWorld.setFeature(0,1, new double[] {0, Math.exp(-1/5)});
        learningWorld.setFeature(0,2, new double[] {0, Math.exp(-1/6)});
        learningWorld.setFeature(0,3, new double[] {0, Math.exp(-1/6)});
        learningWorld.setFeature(0,4, new double[] {4, Math.exp(-1/8)});
        learningWorld.setFeature(0,5, new double[] {10, Math.exp(-1/9)});


        // Row 1
        learningWorld.setFeature(1,0, new double[] {0, Math.exp(-1/3)});
        learningWorld.setFeature(1,1, new double[] {0, Math.exp(-1/4)});
        learningWorld.setFeature(1,2, new double[] {4, Math.exp(-1/5)});
        learningWorld.setFeature(1,3, new double[] {4, Math.exp(-1/6)});
        learningWorld.setFeature(1,4, new double[] {0, Math.exp(-1/7)});
        learningWorld.setFeature(1,5, new double[] {4, Math.exp(-1/8)});

        // Row 2
        learningWorld.setFeature(2,0, new double[] {0, Math.exp(-1/2)});
        learningWorld.setFeature(2,1, new double[] {4, Math.exp(-1/3)});
        learningWorld.setFeature(2,2, new double[] {1, Math.exp(-1/4)});
        learningWorld.setFeature(2,3, new double[] {1, Math.exp(-1/5)});
        learningWorld.setFeature(2,4, new double[] {4, Math.exp(-1/6)});
        learningWorld.setFeature(2,5, new double[] {0, Math.exp(-1/7)});

        // Row 3
        learningWorld.setFeature(3,0, new double[] {0, Math.exp(-1)});
        learningWorld.setFeature(3,1, new double[] {0, Math.exp(-1/2)});
        learningWorld.setFeature(3,2, new double[] {0, Math.exp(-1/3)});
        learningWorld.setFeature(3,3, new double[] {0, Math.exp(-1/4)});
        learningWorld.setFeature(3,4, new double[] {0, Math.exp(-1/5)});
        learningWorld.setFeature(3,5, new double[] {0, Math.exp(-1/6)});

        learningWorld.getStartPosition(0,0);
        learningWorld.setGoalPosition(0,5);

        return learningWorld;
    }

    @Override
    public Policy getExpertPolicy()
    {
        // Policy that goes straight to final destination
        Policy expertPolicy = PolicyFactory.getRandomPolicy(learningWorld);
        expertPolicy.setCell(0,0, new Vector(new double[] {0, 1, 0, 0}));
        expertPolicy.setCell(0,1, new Vector(new double[] {0, 1, 0, 0}));
        expertPolicy.setCell(0,2, new Vector(new double[] {0, 1, 0, 0}));
        expertPolicy.setCell(0,3, new Vector(new double[] {0, 1, 0, 0}));
        expertPolicy.setCell(0,4, new Vector(new double[] {0, 1, 0, 0}));
        expertPolicy.setCell(0,5, new Vector(new double[] {0, 0, 1, 0}));

        expertPolicy.setCell(1,0, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(1,1, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(1,2, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(1,3, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(1,4, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(1,5, new Vector(new double[] {1, 0, 0, 0}));

        expertPolicy.setCell(2,0, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(2,1, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(2,2, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(2,3, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(2,4, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(2,5, new Vector(new double[] {1, 0, 0, 0}));

        expertPolicy.setCell(3,0, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(3,1, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(3,2, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(3,3, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(3,4, new Vector(new double[] {1, 0, 0, 0}));
        expertPolicy.setCell(3,5, new Vector(new double[] {1, 0, 0, 0}));


//        // Policy that goes through rewards
//        Policy expertPolicy = PolicyFactory.getRandomPolicy(learningWorld);
//        expertPolicy.setCell(0,0, new Vector(new double[] {0, 0, 1, 0}));
//        expertPolicy.setCell(0,1, new Vector(new double[] {0, 0, 1, 0}));
//        expertPolicy.setCell(0,2, new Vector(new double[] {0, 0, 1, 0}));
//        expertPolicy.setCell(0,3, new Vector(new double[] {0, 0, 1, 0}));
//        expertPolicy.setCell(0,4, new Vector(new double[] {0, 1, 0, 0}));
//        expertPolicy.setCell(0,5, new Vector(new double[] {0, 0, 1, 0}));
//
//        expertPolicy.setCell(1,0, new Vector(new double[] {0, 0, 1, 0}));
//        expertPolicy.setCell(1,1, new Vector(new double[] {0, 0, 1, 0}));
//        expertPolicy.setCell(1,2, new Vector(new double[] {0, 0, 1, 0}));
//        expertPolicy.setCell(1,3, new Vector(new double[] {0, 0, 1, 0}));
//        expertPolicy.setCell(1,4, new Vector(new double[] {0, 1, 0, 0}));
//        expertPolicy.setCell(1,5, new Vector(new double[] {1, 0, 0, 0}));
//
//        expertPolicy.setCell(2,0, new Vector(new double[] {0, 1, 0, 0}));
//        expertPolicy.setCell(2,1, new Vector(new double[] {0, 1, 0, 0}));
//        expertPolicy.setCell(2,2, new Vector(new double[] {0, 1, 0, 0}));
//        expertPolicy.setCell(2,3, new Vector(new double[] {0, 1, 0, 0}));
//        expertPolicy.setCell(2,4, new Vector(new double[] {0, 1, 0, 0}));
//        expertPolicy.setCell(2,5, new Vector(new double[] {1, 0, 0, 0}));
//
//        expertPolicy.setCell(3,0, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(3,1, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(3,2, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(3,3, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(3,4, new Vector(new double[] {1, 0, 0, 0}));
//        expertPolicy.setCell(3,5, new Vector(new double[] {1, 0, 0, 0}));

        return expertPolicy;
    }

    @Override
    public GridWorld getTestingWorld()
    {
        // Row 0
        testingWorld.setFeature(0,0, new double[] {0, Math.exp(-1/6)});
        testingWorld.setFeature(0,1, new double[] {0, Math.exp(-1/5)});
        testingWorld.setFeature(0,2, new double[] {0, Math.exp(-1/4)});
        testingWorld.setFeature(0,3, new double[] {0, Math.exp(-1/3)});
        testingWorld.setFeature(0,4, new double[] {0, Math.exp(-1/2)});
        testingWorld.setFeature(0,5, new double[] {0, Math.exp(-1/1)});


        // Row 1
        testingWorld.setFeature(1,0, new double[] {0, Math.exp(-1/7)});
        testingWorld.setFeature(1,1, new double[] {4, Math.exp(-1/6)});
        testingWorld.setFeature(1,2, new double[] {0, Math.exp(-1/5)});
        testingWorld.setFeature(1,3, new double[] {0, Math.exp(-1/4)});
        testingWorld.setFeature(1,4, new double[] {0, Math.exp(-1/3)});
        testingWorld.setFeature(1,5, new double[] {0, Math.exp(-1/2)});

        // Row 2
        testingWorld.setFeature(2,0, new double[] {4, Math.exp(-1/8)});
        testingWorld.setFeature(2,1, new double[] {1, Math.exp(-1/7)});
        testingWorld.setFeature(2,2, new double[] {4, Math.exp(-1/6)});
        testingWorld.setFeature(2,3, new double[] {0, Math.exp(-1/5)});
        testingWorld.setFeature(2,4, new double[] {0, Math.exp(-1/4)});
        testingWorld.setFeature(2,5, new double[] {0, Math.exp(-1/3)});

        // Row 3
        testingWorld.setFeature(3,0, new double[] {10, Math.exp(-1/9)});
        testingWorld.setFeature(3,1, new double[] {4, Math.exp(-1/8)});
        testingWorld.setFeature(3,2, new double[] {0, Math.exp(-1/7)});
        testingWorld.setFeature(3,3, new double[] {0, Math.exp(-1/6)});
        testingWorld.setFeature(3,4, new double[] {0, Math.exp(-1/5)});
        testingWorld.setFeature(3,5, new double[] {0, Math.exp(-1/4)});

        testingWorld.getStartPosition(0,0);
        testingWorld.setGoalPosition(3,0);

        return testingWorld;
    }
}
