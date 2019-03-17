public class PolicyFactory
{
    public static Policy getRandomPolicy(GridWorld gridWorld)
    {
        Policy randomPolicy = new Policy(gridWorld);
        for(int i = 0; i < gridWorld.getRows(); i++)
        {
            for (int j = 0; j < gridWorld.getColumns(); j++)
            {
//                if(i == j) // go right
//                    randomPolicy.setCell(i, j, new Vector(new double[] {0, 1, 0, 0}));
//                else if(i == j-1) // go down
//                    randomPolicy.setCell(i, j, new Vector(new double[] {0, 0, 1, 0}));
//                else
                    randomPolicy.setCell(i, j, new Vector(DistributionFactory.getProbabilityDistribution(4)));
            }
        }
        return randomPolicy;
    }
}