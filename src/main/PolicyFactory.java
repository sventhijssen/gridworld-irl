package main;

public class PolicyFactory
{
    public static Policy getRandomPolicy(GridWorld gridWorld)
    {
        Policy randomPolicy = new Policy(gridWorld);
        for(int i = 0; i < gridWorld.getRows(); i++)
        {
            for (int j = 0; j < gridWorld.getColumns(); j++)
            {
                randomPolicy.setCell(i, j, new Vector(DistributionFactory.getProbabilityDistribution(3)));
            }
        }
        return randomPolicy;
    }
}