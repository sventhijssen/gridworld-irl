package main;

import examples.Example_Bicycle_Hit_Walls;
import examples.Example_Bicycle_Miss_Walls;
import examples.IExample;

public class Main
{
    public static void main(String [ ] args)
    {

        // Load the data from the example
        IExample example = new Example_Bicycle_Miss_Walls();
        GridWorld learningWorld = example.getLearningWorld();
        GridWorld testingWorld = example.getTestingWorld();
        Policy expertPolicy = example.getExpertPolicy();

        // Apply apprenticeship learning
        ApprenticeshipLearning apprenticeshipLearning = new ApprenticeshipLearning(learningWorld, expertPolicy);
        Vector weights = apprenticeshipLearning.solve();

        // Create heat map of rewards with final weights
        testingWorld.getRewardHeatMap(0, weights);

        // Apply Q-learning to example to find path
        QLearning qLearning = new QLearning(testingWorld);
        qLearning.computeQTable(weights, 100);
        Policy policy = qLearning.getPolicy();
        System.out.println(qLearning.toString());
        System.out.println(weights);
        for(Cell cell: policy.getPath())
            System.out.println(new Position(cell.getRow(), cell.getColumn()));
    }
}
