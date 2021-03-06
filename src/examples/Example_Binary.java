package examples;

import examples.IExample;
import main.GridWorld;
import main.Policy;
import main.PolicyFactory;
import main.Vector;

public class Example_Binary implements IExample
{
    private static GridWorld learningWorld;
    private static GridWorld testingWorld;

    public Example_Binary()
    {
        learningWorld = new GridWorld(5, 5);
        testingWorld = new GridWorld(10, 16);
    }

    @Override
    public GridWorld getLearningWorld()
    {
        // Feature 1 defines whether the cell is at the border
        // Feature 2 defines whether the cell is filled with water

        // Row 0
        learningWorld.setFeature(0,0,  new double[] {1, 0});
        learningWorld.setFeature(0,1,  new double[] {1, 0});
        learningWorld.setFeature(0,2,  new double[] {1, 0});
        learningWorld.setFeature(0,3,  new double[] {1, 0});
        learningWorld.setFeature(0,4,  new double[] {1, 0});

        // Row 1
        learningWorld.setFeature(1,0,  new double[] {1, 0});
        learningWorld.setFeature(1,1,  new double[] {0, 1});
        learningWorld.setFeature(1,2,  new double[] {0, 0});
        learningWorld.setFeature(1,3,  new double[] {0, 0});
        learningWorld.setFeature(1,4,  new double[] {1, 0});

        // Row 2
        learningWorld.setFeature(2,0,  new double[] {1, 0});
        learningWorld.setFeature(2,1,  new double[] {0, 1});
        learningWorld.setFeature(2,2,  new double[] {0, 0});
        learningWorld.setFeature(2,3,  new double[] {0, 0});
        learningWorld.setFeature(2,4,  new double[] {1, 0});

        // Row 3
        learningWorld.setFeature(3,0,  new double[] {1, 0});
        learningWorld.setFeature(3,1,  new double[] {0, 1});
        learningWorld.setFeature(3,2,  new double[] {0, 1});
        learningWorld.setFeature(3,3,  new double[] {0, 0});
        learningWorld.setFeature(3,4,  new double[] {1, 0});

        // Row 4
        learningWorld.setFeature(4,0,  new double[] {1, 0});
        learningWorld.setFeature(4,1,  new double[] {1, 0});
        learningWorld.setFeature(4,2,  new double[] {1, 0});
        learningWorld.setFeature(4,3,  new double[] {1, 0});
        learningWorld.setFeature(4,4,  new double[] {1, 0});

        learningWorld.setStartPosition(0,0);

        return learningWorld;
    }

    @Override
    public Policy getExpertPolicy()
    {
        // Policy that goes straight to final destination
        Policy expertPolicy = PolicyFactory.getRandomPolicy(learningWorld);

        // Row 0
        expertPolicy.setCell(0,0, new Vector(new double[] {0.02, 0.47, 0.47, 0.02}));
        expertPolicy.setCell(0,1, new Vector(new double[] {0.02, 0.94, 0.02, 0.02}));
        expertPolicy.setCell(0,2, new Vector(new double[] {0.02, 0.94, 0.02, 0.02}));
        expertPolicy.setCell(0,3, new Vector(new double[] {0.02, 0.94, 0.02, 0.02}));
        expertPolicy.setCell(0,4, new Vector(new double[] {0.02, 0.02, 0.47, 0.47}));

        // Row 1
        expertPolicy.setCell(1,0, new Vector(new double[] {0.02, 0.94, 0.02, 0.02}));
        expertPolicy.setCell(1,1, new Vector(new double[] {0.02, 0.02, 0.94, 0.02}));
        expertPolicy.setCell(1,2, new Vector(new double[] {0.02, 0.02, 0.02, 0.94}));
        expertPolicy.setCell(1,3, new Vector(new double[] {0.02, 0.02, 0.02, 0.94}));
        expertPolicy.setCell(1,4, new Vector(new double[] {0.02, 0.02, 0.02, 0.94}));

        // Row 2
        expertPolicy.setCell(2,0, new Vector(new double[] {0.02, 0.94, 0.02, 0.02}));
        expertPolicy.setCell(2,1, new Vector(new double[] {0.02, 0.02, 0.94, 0.02}));
        expertPolicy.setCell(2,2, new Vector(new double[] {0.02, 0.02, 0.02, 0.94}));
        expertPolicy.setCell(2,3, new Vector(new double[] {0.25, 0.02, 0.47, 0.47}));
        expertPolicy.setCell(2,4, new Vector(new double[] {0.02, 0.02, 0.02, 0.94}));

        // Row 3
        expertPolicy.setCell(3,0, new Vector(new double[] {0.02, 0.94, 0.02, 0.02}));
        expertPolicy.setCell(3,1, new Vector(new double[] {0.02, 0.94, 0.02, 0.02}));
        expertPolicy.setCell(3,2, new Vector(new double[] {0.02, 0.94, 0.02, 0.02}));
        expertPolicy.setCell(3,3, new Vector(new double[] {0.25, 0.25, 0.25, 0.25}));
        expertPolicy.setCell(3,4, new Vector(new double[] {0.02, 0.02, 0.02, 0.94}));

        // Row 4
        expertPolicy.setCell(4,0, new Vector(new double[] {0.02, 0.94, 0.02, 0.02}));
        expertPolicy.setCell(4,1, new Vector(new double[] {0.94, 0.02, 0.02, 0.02}));
        expertPolicy.setCell(4,2, new Vector(new double[] {0.94, 0.02, 0.02, 0.02}));
        expertPolicy.setCell(4,3, new Vector(new double[] {0.94, 0.02, 0.02, 0.02}));
        expertPolicy.setCell(4,4, new Vector(new double[] {0.02, 0.02, 0.02, 0.94}));

        return expertPolicy;
    }

    @Override
    public GridWorld getTestingWorld()
    {
        // Row 0
        testingWorld.setFeature(0,0, new double[] {-5});
        testingWorld.setFeature(0,1, new double[] {1});
        testingWorld.setFeature(0,2, new double[] {1});
        testingWorld.setFeature(0,3, new double[] {1});
        testingWorld.setFeature(0,4, new double[] {1});
        testingWorld.setFeature(0,5, new double[] {1});
        testingWorld.setFeature(0,6, new double[] {1});
        testingWorld.setFeature(0,7, new double[] {1});
        testingWorld.setFeature(0,8, new double[] {1});
        testingWorld.setFeature(0,9, new double[] {1});
        testingWorld.setFeature(0,10, new double[] {1});
        testingWorld.setFeature(0,11, new double[] {-5});
        testingWorld.setFeature(0,12, new double[] {1});
        testingWorld.setFeature(0,13, new double[] {1});
        testingWorld.setFeature(0,14, new double[] {1});
        testingWorld.setFeature(0,15, new double[] {1});

        // Row 1
        testingWorld.setFeature(1,0, new double[] {-5});
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
        testingWorld.setFeature(2,0, new double[] {-5});
        testingWorld.setFeature(2,1, new double[] {-5});
        testingWorld.setFeature(2,2, new double[] {-5});
        testingWorld.setFeature(2,3, new double[] {1});
        testingWorld.setFeature(2,4, new double[] {-5});
        testingWorld.setFeature(2,5, new double[] {-5});
        testingWorld.setFeature(2,6, new double[] {-5});
        testingWorld.setFeature(2,7, new double[] {-5});
        testingWorld.setFeature(2,8, new double[] {-5});
        testingWorld.setFeature(2,9, new double[] {-5});
        testingWorld.setFeature(2,10, new double[] {1});
        testingWorld.setFeature(2,11, new double[] {-5});
        testingWorld.setFeature(2,12, new double[] {-5});
        testingWorld.setFeature(2,13, new double[] {-5});
        testingWorld.setFeature(2,14, new double[] {-5});
        testingWorld.setFeature(2,15, new double[] {1});

        // Row 3
        testingWorld.setFeature(3,0, new double[] {1});
        testingWorld.setFeature(3,1, new double[] {1});
        testingWorld.setFeature(3,2, new double[] {1});
        testingWorld.setFeature(3,3, new double[] {1});
        testingWorld.setFeature(3,4, new double[] {-1});
        testingWorld.setFeature(3,5, new double[] {-1});
        testingWorld.setFeature(3,6, new double[] {-1});
        testingWorld.setFeature(3,7, new double[] {1});
        testingWorld.setFeature(3,8, new double[] {1});
        testingWorld.setFeature(3,9, new double[] {1});
        testingWorld.setFeature(3,10, new double[] {-1});
        testingWorld.setFeature(3,11, new double[] {-1});
        testingWorld.setFeature(3,12, new double[] {1});
        testingWorld.setFeature(3,13, new double[] {1});
        testingWorld.setFeature(3,14, new double[] {1});
        testingWorld.setFeature(3,15, new double[] {1});

        // Row 4
        testingWorld.setFeature(4,0, new double[] {-5});
        testingWorld.setFeature(4,1, new double[] {-5});
        testingWorld.setFeature(4,2, new double[] {1});
        testingWorld.setFeature(4,3, new double[] {1});
        testingWorld.setFeature(4,4, new double[] {-5});
        testingWorld.setFeature(4,5, new double[] {-5});
        testingWorld.setFeature(4,6, new double[] {-5});
        testingWorld.setFeature(4,7, new double[] {-5});
        testingWorld.setFeature(4,8, new double[] {-5});
        testingWorld.setFeature(4,9, new double[] {-5});
        testingWorld.setFeature(4,10, new double[] {-1});
        testingWorld.setFeature(4,11, new double[] {-1});
        testingWorld.setFeature(4,12, new double[] {-5});
        testingWorld.setFeature(4,13, new double[] {-5});
        testingWorld.setFeature(4,14, new double[] {-5});
        testingWorld.setFeature(4,15, new double[] {1});

        // Row 5
        testingWorld.setFeature(5,0, new double[] {1});
        testingWorld.setFeature(5,1, new double[] {1, 0});
        testingWorld.setFeature(5,2, new double[] {1});
        testingWorld.setFeature(5,3, new double[] {1});
        testingWorld.setFeature(5,4, new double[] {1});
        testingWorld.setFeature(5,5, new double[] {1});
        testingWorld.setFeature(5,6, new double[] {1});
        testingWorld.setFeature(5,7, new double[] {1});
        testingWorld.setFeature(5,8, new double[] {-1});
        testingWorld.setFeature(5,9, new double[] {-1});
        testingWorld.setFeature(5,10, new double[] {-1});
        testingWorld.setFeature(5,11, new double[] {1});
        testingWorld.setFeature(5,12, new double[] {1});
        testingWorld.setFeature(5,13, new double[] {1});
        testingWorld.setFeature(5,14, new double[] {1});
        testingWorld.setFeature(5,15, new double[] {1});

        // Row 6
        testingWorld.setFeature(6,0, new double[] {1});
        testingWorld.setFeature(6,1, new double[] {1});
        testingWorld.setFeature(6,2, new double[] {1});
        testingWorld.setFeature(6,3, new double[] {1});
        testingWorld.setFeature(6,4, new double[] {1});
        testingWorld.setFeature(6,5, new double[] {1});
        testingWorld.setFeature(6,6, new double[] {1});
        testingWorld.setFeature(6,7, new double[] {1});
        testingWorld.setFeature(6,8, new double[] {-1});
        testingWorld.setFeature(6,9, new double[] {-1});
        testingWorld.setFeature(6,10, new double[] {-1});
        testingWorld.setFeature(6,11, new double[] {1});
        testingWorld.setFeature(6,12, new double[] {1});
        testingWorld.setFeature(6,13, new double[] {1});
        testingWorld.setFeature(6,14, new double[] {1});
        testingWorld.setFeature(6,15, new double[] {1});

        // Row 7
        testingWorld.setFeature(7,0, new double[] {-5});
        testingWorld.setFeature(7,1, new double[] {-5});
        testingWorld.setFeature(7,2, new double[] {-5});
        testingWorld.setFeature(7,3, new double[] {1});
        testingWorld.setFeature(7,4, new double[] {-5});
        testingWorld.setFeature(7,5, new double[] {-5});
        testingWorld.setFeature(7,6, new double[] {-5});
        testingWorld.setFeature(7,7, new double[] {-5});
        testingWorld.setFeature(7,8, new double[] {-5});
        testingWorld.setFeature(7,9, new double[] {-5});
        testingWorld.setFeature(7,10, new double[] {1});
        testingWorld.setFeature(7,11, new double[] {-5});
        testingWorld.setFeature(7,12, new double[] {-5});
        testingWorld.setFeature(7,13, new double[] {-5});
        testingWorld.setFeature(7,14, new double[] {-5});
        testingWorld.setFeature(7,15, new double[] {1});

        // Row 8
        testingWorld.setFeature(8,0, new double[] {1});
        testingWorld.setFeature(8,1, new double[] {1});
        testingWorld.setFeature(8,2, new double[] {1});
        testingWorld.setFeature(8,3, new double[] {1});
        testingWorld.setFeature(8,4, new double[] {1});
        testingWorld.setFeature(8,5, new double[] {1});
        testingWorld.setFeature(8,6, new double[] {1});
        testingWorld.setFeature(8,7, new double[] {1});
        testingWorld.setFeature(8,8, new double[] {1});
        testingWorld.setFeature(8,9, new double[] {1});
        testingWorld.setFeature(8,10, new double[] {1});
        testingWorld.setFeature(8,11, new double[] {1});
        testingWorld.setFeature(8,12, new double[] {1});
        testingWorld.setFeature(8,13, new double[] {1});
        testingWorld.setFeature(8,14, new double[] {1});
        testingWorld.setFeature(8,15, new double[] {1});

        // Row 9
        testingWorld.setFeature(9,0, new double[] {-5});
        testingWorld.setFeature(9,1, new double[] {-5});
        testingWorld.setFeature(9,2, new double[] {-5});
        testingWorld.setFeature(9,3, new double[] {-5});
        testingWorld.setFeature(9,4, new double[] {-5});
        testingWorld.setFeature(9,5, new double[] {-5});
        testingWorld.setFeature(9,6, new double[] {-5});
        testingWorld.setFeature(9,7, new double[] {-5});
        testingWorld.setFeature(9,8, new double[] {-5});
        testingWorld.setFeature(9,9, new double[] {-5});
        testingWorld.setFeature(9,10, new double[] {-5});
        testingWorld.setFeature(9,11, new double[] {-5});
        testingWorld.setFeature(9,12, new double[] {-5});
        testingWorld.setFeature(9,13, new double[] {-5});
        testingWorld.setFeature(9,14, new double[] {-5});
        testingWorld.setFeature(9,15, new double[] {1});

        testingWorld.setStartPosition(0,10);

        return testingWorld;
    }
}
