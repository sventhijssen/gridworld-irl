package main;

import examples.BicycleExample;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main
{
    public static void main(String [ ] args) throws IOException
    {

        BicycleExample bicycleExample = new BicycleExample();
        while(!bicycleExample.hasReachedGoal())
        {
            System.out.println(bicycleExample);
            System.out.println(bicycleExample.getPosition());
            Scanner scanner = new Scanner(System.in);
            char c = scanner.next().charAt(0);
            bicycleExample.setNextPosition(c);
            System.out.println();
        }

        Vector muExpert = bicycleExample.getFeatureExpectations();
        System.out.println("Feature expectations: ");
        System.out.println(muExpert);

        //Vector muExpert = new Vector(new double[] {7.7123207545039, 0.0, 0.0, 0.9087641100000001});

        ApprenticeshipLearning apprenticeshipLearning = new ApprenticeshipLearning(bicycleExample.getWorld(), muExpert);
        Vector w = apprenticeshipLearning.solve();
        apprenticeshipLearning.drawEvolutionT();
        apprenticeshipLearning.drawEvolutionW();
        System.out.println(w);

        GridWorld world = bicycleExample.getWorld();
        world.setStartPosition(8,7);

        QLearning qLearning = new QLearning(bicycleExample.getWorld());
        qLearning.computeQTable(w, 100);
        world.getRewardHeatMap(0, w);
        Policy policy = qLearning.getPolicy();
        System.out.println(qLearning.toString());
        LinkedList<Cell> path = policy.getPath();
        for(Cell c: path)
            System.out.println(new Position(c.getRow(), c.getColumn()));
    }
}
