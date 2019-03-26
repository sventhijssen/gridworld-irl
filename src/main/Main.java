package main;

import environments.CarEnvironment;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main
{
    public static void main(String [ ] args) throws Exception
    {
        // Create an environment and learn a (nearly) optimal demonstration
        CarEnvironment environment = new CarEnvironment();
        ArrayList<Position> trajectory = environment.learn();

        // Given the environment and the (nearly) optimal demonstration
        ApprenticeshipLearning apprenticeshipLearning = new ApprenticeshipLearning(environment.getGridWorld(), trajectory);
        Vector w = apprenticeshipLearning.solve();

        // Draw the evolution of t and w
        apprenticeshipLearning.drawEvolutionT();
        apprenticeshipLearning.drawEvolutionW();
        System.out.println("w: " + w);

//        GridWorld world = bicycleExample.getWorld();
//        world.setStartPosition(8,7);
//
//        QLearning qLearning = new QLearning(environment.getGridWorld());
//        qLearning.computeQTable(w, 100);
//        world.getRewardHeatMap(0, w);
//        GridWorldPolicy policy = qLearning.getPolicy();
//        System.out.println(qLearning.toString());
//        LinkedList<Cell> path = policy.getPath();
//        for(Cell c: path)
//            System.out.println(new Position(c.getRow(), c.getColumn()));
    }
}
