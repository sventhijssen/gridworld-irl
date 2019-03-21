package examples;

import main.GridWorld;
import main.Policy;
import main.PolicyFactory;
import main.Vector;

public class Example_Bicycle_Miss_Walls implements IExample
{
    private static GridWorld learningWorld;
    private static GridWorld testingWorld;

    public Example_Bicycle_Miss_Walls()
    {
        learningWorld = new GridWorld(2, 16);
        testingWorld = new GridWorld(4, 16);
    }

    @Override
    public GridWorld getLearningWorld()
    {

        // Feature 1 defines whether the cell is hard road (0 is obstacle, 1 is road)

        // Row 0
        learningWorld.setFeature(0,0,  new double[] {0});
        learningWorld.setFeature(0,1,  new double[] {0});
        learningWorld.setFeature(0,2,  new double[] {1});
        learningWorld.setFeature(0,3,  new double[] {1});
        learningWorld.setFeature(0,4,  new double[] {1});
        learningWorld.setFeature(0,5,  new double[] {0});
        learningWorld.setFeature(0,6,  new double[] {0});
        learningWorld.setFeature(0,7,  new double[] {0});
        learningWorld.setFeature(0,8,  new double[] {1});
        learningWorld.setFeature(0,9,  new double[] {1});
        learningWorld.setFeature(0,10,  new double[] {1});
        learningWorld.setFeature(0,11,  new double[] {1});
        learningWorld.setFeature(0,12,  new double[] {1});
        learningWorld.setFeature(0,13,  new double[] {0});
        learningWorld.setFeature(0,14,  new double[] {0});
        learningWorld.setFeature(0,15,  new double[] {0});

        // Row 1
        learningWorld.setFeature(1,0,  new double[] {1});
        learningWorld.setFeature(1,1,  new double[] {1});
        learningWorld.setFeature(1,2,  new double[] {1});
        learningWorld.setFeature(1,3,  new double[] {0});
        learningWorld.setFeature(1,4,  new double[] {1});
        learningWorld.setFeature(1,5,  new double[] {1});
        learningWorld.setFeature(1,6,  new double[] {1});
        learningWorld.setFeature(1,7,  new double[] {1});
        learningWorld.setFeature(1,8,  new double[] {1});
        learningWorld.setFeature(1,9,  new double[] {0});
        learningWorld.setFeature(1,10,  new double[] {0});
        learningWorld.setFeature(1,11,  new double[] {0});
        learningWorld.setFeature(1,12,  new double[] {1});
        learningWorld.setFeature(1,13,  new double[] {1});
        learningWorld.setFeature(1,14,  new double[] {1});
        learningWorld.setFeature(1,15,  new double[] {1});

        learningWorld.setStartPosition(1,0);
        learningWorld.setGoalPosition(1,15);

        return learningWorld;
    }

    @Override
    public Policy getExpertPolicy()
    {
        // Policy that goes straight to final destination
        Policy expertPolicy = PolicyFactory.getRandomPolicy(learningWorld);

        // Row 0
        expertPolicy.setCell(0,0, new Vector(new double[] {0.1, 0.1, 0.7}));
        expertPolicy.setCell(0,1, new Vector(new double[] {0.1, 0.4, 0.4}));
        expertPolicy.setCell(0,2, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(0,3, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(0,4, new Vector(new double[] {0.1, 0.1, 0.7}));
        expertPolicy.setCell(0,5, new Vector(new double[] {0.1, 0.1, 0.7}));
        expertPolicy.setCell(0,6, new Vector(new double[] {0.1, 0.1, 0.7}));
        expertPolicy.setCell(0,7, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(0,8, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(0,9, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(0,10, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(0,11, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(0,12, new Vector(new double[] {0.1, 0.1, 0.7}));
        expertPolicy.setCell(0,13, new Vector(new double[] {0.1, 0.1, 0.7}));
        expertPolicy.setCell(0,14, new Vector(new double[] {0.1, 0.1, 0.7}));
        expertPolicy.setCell(0,15, new Vector(new double[] {0.1, 0.1, 0.7}));

        // Row 1
        expertPolicy.setCell(1,0, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(1,1, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(1,2, new Vector(new double[] {0.7, 0.1, 0.1}));
        expertPolicy.setCell(1,3, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(1,4, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(1,5, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(1,6, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(1,7, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(1,8, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(1,9, new Vector(new double[] {0.7, 0.1, 0.1}));
        expertPolicy.setCell(1,10, new Vector(new double[] {0.7, 0.1, 0.1}));
        expertPolicy.setCell(1,11, new Vector(new double[] {0.7, 0.1, 0.1}));
        expertPolicy.setCell(1,12, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(1,13, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(1,14, new Vector(new double[] {0.1, 0.7, 0.1}));
        expertPolicy.setCell(1,15, new Vector(new double[] {0.1, 0.7, 0.1}));

        return expertPolicy;
    }

    @Override
    public GridWorld getTestingWorld()
    {
        // Row 0
        testingWorld.setFeature(0,0, new double[] {1});
        testingWorld.setFeature(0,1, new double[] {1});
        testingWorld.setFeature(0,2, new double[] {0});
        testingWorld.setFeature(0,3, new double[] {0});
        testingWorld.setFeature(0,4, new double[] {1});
        testingWorld.setFeature(0,5, new double[] {1});
        testingWorld.setFeature(0,6, new double[] {1});
        testingWorld.setFeature(0,7, new double[] {1});
        testingWorld.setFeature(0,8, new double[] {1});
        testingWorld.setFeature(0,9, new double[] {1});
        testingWorld.setFeature(0,10, new double[] {1});
        testingWorld.setFeature(0,11, new double[] {1});
        testingWorld.setFeature(0,12, new double[] {1});
        testingWorld.setFeature(0,13, new double[] {1});
        testingWorld.setFeature(0,14, new double[] {1});
        testingWorld.setFeature(0,15, new double[] {1});

        // Row 1
        testingWorld.setFeature(1,0, new double[] {1});
        testingWorld.setFeature(1,1, new double[] {1});
        testingWorld.setFeature(1,2, new double[] {1});
        testingWorld.setFeature(1,3, new double[] {1});
        testingWorld.setFeature(1,4, new double[] {1});
        testingWorld.setFeature(1,5, new double[] {1});
        testingWorld.setFeature(1,6, new double[] {1});
        testingWorld.setFeature(1,7, new double[] {1});
        testingWorld.setFeature(1,8, new double[] {1});
        testingWorld.setFeature(1,9, new double[] {1});
        testingWorld.setFeature(1,10, new double[] {1});
        testingWorld.setFeature(1,11, new double[] {1});
        testingWorld.setFeature(1,12, new double[] {1});
        testingWorld.setFeature(1,13, new double[] {1});
        testingWorld.setFeature(1,14, new double[] {1});
        testingWorld.setFeature(1,15, new double[] {1});

        // Row 2
        testingWorld.setFeature(2,0, new double[] {1});
        testingWorld.setFeature(2,1, new double[] {1});
        testingWorld.setFeature(2,2, new double[] {1});
        testingWorld.setFeature(2,3, new double[] {1});
        testingWorld.setFeature(2,4, new double[] {1});
        testingWorld.setFeature(2,5, new double[] {0});
        testingWorld.setFeature(2,6, new double[] {0});
        testingWorld.setFeature(2,7, new double[] {1});
        testingWorld.setFeature(2,8, new double[] {0});
        testingWorld.setFeature(2,9, new double[] {0});
        testingWorld.setFeature(2,10, new double[] {1});
        testingWorld.setFeature(2,11, new double[] {1});
        testingWorld.setFeature(2,12, new double[] {1});
        testingWorld.setFeature(2,13, new double[] {1});
        testingWorld.setFeature(2,14, new double[] {1});
        testingWorld.setFeature(2,15, new double[] {1});

        // Row 3
        testingWorld.setFeature(3,0, new double[] {1});
        testingWorld.setFeature(3,1, new double[] {1});
        testingWorld.setFeature(3,2, new double[] {1});
        testingWorld.setFeature(3,3, new double[] {0});
        testingWorld.setFeature(3,4, new double[] {0});
        testingWorld.setFeature(3,5, new double[] {1});
        testingWorld.setFeature(3,6, new double[] {1});
        testingWorld.setFeature(3,7, new double[] {1});
        testingWorld.setFeature(3,8, new double[] {1});
        testingWorld.setFeature(3,9, new double[] {0});
        testingWorld.setFeature(3,10, new double[] {0});
        testingWorld.setFeature(3,11, new double[] {0});
        testingWorld.setFeature(3,12, new double[] {0});
        testingWorld.setFeature(3,13, new double[] {1});
        testingWorld.setFeature(3,14, new double[] {1});
        testingWorld.setFeature(3,15, new double[] {1});

        testingWorld.setStartPosition(2,0);
        testingWorld.setGoalPosition(2,15);

        return testingWorld;
    }
}
