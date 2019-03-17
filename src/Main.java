import java.util.LinkedList;

public class Main
{
    public static void main(String [ ] args)
    {

        int rows = 4;
        int columns = 4;

        // Example gridWorld, see gridWorld.jpg for layout
//        GridWorld gridWorld = new GridWorld(rows, columns);
//        gridWorld.setFeature(0, 1, new double[]{0.9});
//        gridWorld.setFeature(0, 2, new double[]{0.1});
//        gridWorld.setFeature(0, 3, new double[]{0.9});
//
//        gridWorld.setFeature(1, 0, new double[]{0.1});
//        gridWorld.setFeature(1, 1, new double[]{0.9});
//        gridWorld.setFeature(1, 2, new double[]{0.9});
//        gridWorld.setFeature(1, 3, new double[]{0.9});
//
//        gridWorld.setFeature(2, 0, new double[]{0.9});
//        gridWorld.setFeature(2, 2, new double[]{0.9});
//        gridWorld.setFeature(2, 3, new double[]{0.1});
//
//        Policy expertPolicy = PolicyFactory.getRandomPolicy(gridWorld);
//        expertPolicy.setCell(0,0, new Vector(new double[] {0, 0.9, 0.1, 0}));
//        expertPolicy.setCell(0,1, new Vector(new double[] {0, 0.1, 0.8, 0.1}));
//        expertPolicy.setCell(1,1, new Vector(new double[] {0.1, 0.1, 0.7, 0.1}));
//        expertPolicy.setCell(2,1, new Vector(new double[] {0.1, 0.1, 0.7, 0.1}));
//        expertPolicy.setCell(3,1, new Vector(new double[] {0.1, 0.8, 0, 0.1}));
//        expertPolicy.setCell(3,2, new Vector(new double[] {0.1, 0.8, 0, 0.1}));
//
//
//        ApprenticeshipLearning apprenticeshipLearning = new ApprenticeshipLearning(gridWorld, expertPolicy);
//        Vector weights = apprenticeshipLearning.solve();

//        GridWorld gridWorld = new GridWorld(10, 16);
//
//        // Row 0
//        gridWorld.setFeature(0,0, new double[] {0});
//        gridWorld.setFeature(0,1, new double[] {1});
//        gridWorld.setFeature(0,2, new double[] {1});
//        gridWorld.setFeature(0,3, new double[] {1});
//        gridWorld.setFeature(0,4, new double[] {1});
//        gridWorld.setFeature(0,5, new double[] {1});
//        gridWorld.setFeature(0,6, new double[] {1});
//        gridWorld.setFeature(0,7, new double[] {1});
//        gridWorld.setFeature(0,8, new double[] {1});
//        gridWorld.setFeature(0,9, new double[] {1});
//        gridWorld.setFeature(0,10, new double[] {1});
//        gridWorld.setFeature(0,11, new double[] {0});
//        gridWorld.setFeature(0,12, new double[] {1});
//        gridWorld.setFeature(0,13, new double[] {1});
//        gridWorld.setFeature(0,14, new double[] {1});
//        gridWorld.setFeature(0,15, new double[] {1});
//
//        // Row 1
//        gridWorld.setFeature(1,0, new double[] {0});
//        gridWorld.setFeature(1,1, new double[] {1});
//        gridWorld.setFeature(1,2, new double[] {1});
//        gridWorld.setFeature(1,3, new double[] {1});
//        gridWorld.setFeature(1,4, new double[] {1});
//        gridWorld.setFeature(1,5, new double[] {1});
//        gridWorld.setFeature(1,6, new double[] {1});
//        gridWorld.setFeature(1,7, new double[] {1});
//        gridWorld.setFeature(1,8, new double[] {1});
//        gridWorld.setFeature(1,9, new double[] {1});
//        gridWorld.setFeature(1,10, new double[] {1});
//        gridWorld.setFeature(1,11, new double[] {1});
//        gridWorld.setFeature(1,12, new double[] {1});
//        gridWorld.setFeature(1,13, new double[] {1});
//        gridWorld.setFeature(1,14, new double[] {1});
//        gridWorld.setFeature(1,15, new double[] {1});
//
//        // Row 2
//        gridWorld.setFeature(2,0, new double[] {0});
//        gridWorld.setFeature(2,1, new double[] {0});
//        gridWorld.setFeature(2,2, new double[] {0});
//        gridWorld.setFeature(2,3, new double[] {1});
//        gridWorld.setFeature(2,4, new double[] {0});
//        gridWorld.setFeature(2,5, new double[] {0});
//        gridWorld.setFeature(2,6, new double[] {0});
//        gridWorld.setFeature(2,7, new double[] {0});
//        gridWorld.setFeature(2,8, new double[] {0});
//        gridWorld.setFeature(2,9, new double[] {0});
//        gridWorld.setFeature(2,10, new double[] {1});
//        gridWorld.setFeature(2,11, new double[] {0});
//        gridWorld.setFeature(2,12, new double[] {0});
//        gridWorld.setFeature(2,13, new double[] {0});
//        gridWorld.setFeature(2,14, new double[] {0});
//        gridWorld.setFeature(2,15, new double[] {1});
//
//        // Row 3
//        gridWorld.setFeature(3,0, new double[] {1});
//        gridWorld.setFeature(3,1, new double[] {1});
//        gridWorld.setFeature(3,2, new double[] {1});
//        gridWorld.setFeature(3,3, new double[] {1});
//        gridWorld.setFeature(3,4, new double[] {0.6});
//        gridWorld.setFeature(3,5, new double[] {0.6});
//        gridWorld.setFeature(3,6, new double[] {0.6});
//        gridWorld.setFeature(3,7, new double[] {1});
//        gridWorld.setFeature(3,8, new double[] {1});
//        gridWorld.setFeature(3,9, new double[] {1});
//        gridWorld.setFeature(3,10, new double[] {0.2});
//        gridWorld.setFeature(3,11, new double[] {0.2});
//        gridWorld.setFeature(3,12, new double[] {1});
//        gridWorld.setFeature(3,13, new double[] {1});
//        gridWorld.setFeature(3,14, new double[] {1});
//        gridWorld.setFeature(3,15, new double[] {1});
//
//        // Row 4
//        gridWorld.setFeature(4,0, new double[] {0});
//        gridWorld.setFeature(4,1, new double[] {0});
//        gridWorld.setFeature(4,2, new double[] {1});
//        gridWorld.setFeature(4,3, new double[] {1});
//        gridWorld.setFeature(4,4, new double[] {0});
//        gridWorld.setFeature(4,5, new double[] {0});
//        gridWorld.setFeature(4,6, new double[] {0});
//        gridWorld.setFeature(4,7, new double[] {0});
//        gridWorld.setFeature(4,8, new double[] {0});
//        gridWorld.setFeature(4,9, new double[] {0});
//        gridWorld.setFeature(4,10, new double[] {0.2});
//        gridWorld.setFeature(4,11, new double[] {0.2});
//        gridWorld.setFeature(4,12, new double[] {0});
//        gridWorld.setFeature(4,13, new double[] {0});
//        gridWorld.setFeature(4,14, new double[] {0});
//        gridWorld.setFeature(4,15, new double[] {1});
//
//        // Row 5
//        gridWorld.setFeature(5,0, new double[] {1});
//        gridWorld.setFeature(5,1, new double[] {1});
//        gridWorld.setFeature(5,2, new double[] {1});
//        gridWorld.setFeature(5,3, new double[] {1});
//        gridWorld.setFeature(5,4, new double[] {1});
//        gridWorld.setFeature(5,5, new double[] {1});
//        gridWorld.setFeature(5,6, new double[] {1});
//        gridWorld.setFeature(5,7, new double[] {1});
//        gridWorld.setFeature(5,8, new double[] {0.4});
//        gridWorld.setFeature(5,9, new double[] {0.4});
//        gridWorld.setFeature(5,10, new double[] {0.4});
//        gridWorld.setFeature(5,11, new double[] {1});
//        gridWorld.setFeature(5,12, new double[] {1});
//        gridWorld.setFeature(5,13, new double[] {1});
//        gridWorld.setFeature(5,14, new double[] {1});
//        gridWorld.setFeature(5,15, new double[] {1});
//
//        // Row 6
//        gridWorld.setFeature(6,0, new double[] {1});
//        gridWorld.setFeature(6,1, new double[] {1});
//        gridWorld.setFeature(6,2, new double[] {1});
//        gridWorld.setFeature(6,3, new double[] {1});
//        gridWorld.setFeature(6,4, new double[] {1});
//        gridWorld.setFeature(6,5, new double[] {1});
//        gridWorld.setFeature(6,6, new double[] {1});
//        gridWorld.setFeature(6,7, new double[] {1});
//        gridWorld.setFeature(6,8, new double[] {0.2});
//        gridWorld.setFeature(6,9, new double[] {0.2});
//        gridWorld.setFeature(6,10, new double[] {0.2});
//        gridWorld.setFeature(6,11, new double[] {1});
//        gridWorld.setFeature(6,12, new double[] {1});
//        gridWorld.setFeature(6,13, new double[] {1});
//        gridWorld.setFeature(6,14, new double[] {1});
//        gridWorld.setFeature(6,15, new double[] {1});
//
//        // Row 7
//        gridWorld.setFeature(7,0, new double[] {0});
//        gridWorld.setFeature(7,1, new double[] {0});
//        gridWorld.setFeature(7,2, new double[] {0});
//        gridWorld.setFeature(7,3, new double[] {1});
//        gridWorld.setFeature(7,4, new double[] {0});
//        gridWorld.setFeature(7,5, new double[] {0});
//        gridWorld.setFeature(7,6, new double[] {0});
//        gridWorld.setFeature(7,7, new double[] {0});
//        gridWorld.setFeature(7,8, new double[] {0});
//        gridWorld.setFeature(7,9, new double[] {0});
//        gridWorld.setFeature(7,10, new double[] {1});
//        gridWorld.setFeature(7,11, new double[] {0});
//        gridWorld.setFeature(7,12, new double[] {0});
//        gridWorld.setFeature(7,13, new double[] {0});
//        gridWorld.setFeature(7,14, new double[] {0});
//        gridWorld.setFeature(7,15, new double[] {1});
//
//        // Row 8
//        gridWorld.setFeature(8,0, new double[] {1});
//        gridWorld.setFeature(8,1, new double[] {1});
//        gridWorld.setFeature(8,2, new double[] {1});
//        gridWorld.setFeature(8,3, new double[] {1});
//        gridWorld.setFeature(8,4, new double[] {1});
//        gridWorld.setFeature(8,5, new double[] {1});
//        gridWorld.setFeature(8,6, new double[] {1});
//        gridWorld.setFeature(8,7, new double[] {1});
//        gridWorld.setFeature(8,8, new double[] {1});
//        gridWorld.setFeature(8,9, new double[] {1});
//        gridWorld.setFeature(8,10, new double[] {1});
//        gridWorld.setFeature(8,11, new double[] {1});
//        gridWorld.setFeature(8,12, new double[] {1});
//        gridWorld.setFeature(8,13, new double[] {1});
//        gridWorld.setFeature(8,14, new double[] {1});
//        gridWorld.setFeature(8,15, new double[] {1});
//
//        // Row 9
//        gridWorld.setFeature(9,0, new double[] {0});
//        gridWorld.setFeature(9,1, new double[] {0});
//        gridWorld.setFeature(9,2, new double[] {0});
//        gridWorld.setFeature(9,3, new double[] {0});
//        gridWorld.setFeature(9,4, new double[] {0});
//        gridWorld.setFeature(9,5, new double[] {0});
//        gridWorld.setFeature(9,6, new double[] {0});
//        gridWorld.setFeature(9,7, new double[] {0});
//        gridWorld.setFeature(9,8, new double[] {0});
//        gridWorld.setFeature(9,9, new double[] {0});
//        gridWorld.setFeature(9,10, new double[] {0});
//        gridWorld.setFeature(9,11, new double[] {0});
//        gridWorld.setFeature(9,12, new double[] {0});
//        gridWorld.setFeature(9,13, new double[] {0});
//        gridWorld.setFeature(9,14, new double[] {0});
//        gridWorld.setFeature(9,15, new double[] {0});


//        GridWorld gridWorld = new GridWorld(rows, columns);
//
//        // Row 0
//        gridWorld.setFeature(0,0, new double[] {1.0, (double) 1/7});
//        gridWorld.setFeature(0,1, new double[] {0.9, (double) 1/6});
//        gridWorld.setFeature(0,2, new double[] {0.1, (double) 1/5});
//        gridWorld.setFeature(0,3, new double[] {0.9, (double) 1/4});
//
//        // Row 1
//        gridWorld.setFeature(1,0, new double[] {0.1, (double) 1/6});
//        gridWorld.setFeature(1,1, new double[] {0.9, (double) 1/5});
//        gridWorld.setFeature(1,2, new double[] {0.9, (double) 1/4});
//        gridWorld.setFeature(1,3, new double[] {0.9, (double) 1/3});
//
//        // Row 2
//        gridWorld.setFeature(2,0, new double[] {0.9, (double) 1/5});
//        gridWorld.setFeature(2,1, new double[] {1.0, (double) 1/4});
//        gridWorld.setFeature(2,2, new double[] {0.9, (double) 1/3});
//        gridWorld.setFeature(2,3, new double[] {0.1, (double) 1/2});
//
//        // Row 3
//        gridWorld.setFeature(3,0, new double[] {1.0, (double) 1/4});
//        gridWorld.setFeature(3,1, new double[] {1.0, (double) 1/3});
//        gridWorld.setFeature(3,2, new double[] {1.0, (double) 1/2});
//        gridWorld.setFeature(3,3, new double[] {1.0, (double) 1/1});
//
//        //gridWorld.getHeatMap(0);
//        //gridWorld.getHeatMap(1);
//
//        Policy expertPolicy = PolicyFactory.getRandomPolicy(gridWorld);
//        expertPolicy.setCell(0,0, new Vector(new double[] {0, 0.9, 0.1, 0}));
//        expertPolicy.setCell(0,1, new Vector(new double[] {0, 0.1, 0.8, 0.1}));
//        expertPolicy.setCell(1,1, new Vector(new double[] {0.1, 0.1, 0.7, 0.1}));
//        expertPolicy.setCell(2,1, new Vector(new double[] {0.1, 0.1, 0.7, 0.1}));
//        expertPolicy.setCell(3,1, new Vector(new double[] {0.1, 0.8, 0, 0.1}));
//        expertPolicy.setCell(3,2, new Vector(new double[] {0.1, 0.8, 0, 0.1}));


//        ApprenticeshipLearning apprenticeshipLearning = new ApprenticeshipLearning(gridWorld, expertPolicy);
//        Vector weights = apprenticeshipLearning.solve();



        GridWorld gridWorld = new GridWorld(rows, 6);

        // Row 0
        gridWorld.setFeature(0,0, new double[] {1.0, (double) (Math.pow(1/6,2))});
        gridWorld.setFeature(0,1, new double[] {0.1, (double) (Math.pow(1/5,2))});
        gridWorld.setFeature(0,2, new double[] {0.05, (double) (Math.pow(1/4,2))});
        gridWorld.setFeature(0,3, new double[] {0.05, (double) (Math.pow(1/3,2))});
        gridWorld.setFeature(0,4, new double[] {0.1, (double) (Math.pow(1/2,2))});
        gridWorld.setFeature(0,5, new double[] {1.0, (double) (Math.pow(1,2))});


        // Row 1
        gridWorld.setFeature(1,0, new double[] {1.0, (double) (Math.pow(1/7,2))});
        gridWorld.setFeature(1,1, new double[] {0.1, (double) (Math.pow(1/6,2))});
        gridWorld.setFeature(1,2, new double[] {0.05, (double) (Math.pow(1/5,2))});
        gridWorld.setFeature(1,3, new double[] {0.05, (double) (Math.pow(1/4,2))});
        gridWorld.setFeature(1,4, new double[] {0.1, (double) (Math.pow(1/3,2))});
        gridWorld.setFeature(1,5, new double[] {1.0, (double) (Math.pow(1/2,2))});

        // Row 2
        gridWorld.setFeature(2,0, new double[] {1.0, (double) (Math.pow(1/8,2))});
        gridWorld.setFeature(2,1, new double[] {1.0, (double) (Math.pow(1/7,2))});
        gridWorld.setFeature(2,2, new double[] {1.0, (double) (Math.pow(1/6,2))});
        gridWorld.setFeature(2,3, new double[] {1.0, (double) (Math.pow(1/5,2))});
        gridWorld.setFeature(2,4, new double[] {1.0, (double) (Math.pow(1/4,2))});
        gridWorld.setFeature(2,5, new double[] {1.0, (double) (Math.pow(1/3,2))});

        // Row 3
        gridWorld.setFeature(3,0, new double[] {1.0, (double) (Math.pow(1/9,2))});
        gridWorld.setFeature(3,1, new double[] {1.0, (double) (Math.pow(1/8,2))});
        gridWorld.setFeature(3,2, new double[] {1.0, (double) (Math.pow(1/7,2))});
        gridWorld.setFeature(3,3, new double[] {1.0, (double) (Math.pow(1/6,2))});
        gridWorld.setFeature(3,4, new double[] {1.0, (double) (Math.pow(1/5,2))});
        gridWorld.setFeature(3,5, new double[] {1.0, (double) (Math.pow(1/4,2))});

        gridWorld.setGoalPosition(0,5);

        QLearning qLearning;

        Vector weights = new Vector(new double[] {0.1, 10});

        qLearning = new QLearning(gridWorld);
        qLearning.computeQTable(weights, 100);
        System.out.println(qLearning.toString());
        Policy policy = qLearning.getPolicy();

//        w = new Vector(new double[] {0.9, 0.05});
//
//        qLearning = new QLearning(gridWorld);
//        qLearning.computeQTable( w, 1000);
//        System.out.println(qLearning.toString());


        //Policy optimalPolicy = qLearning.getPolicy();
        //LinkedList<Cell> path = optimalPolicy.getPath();
    }
}
