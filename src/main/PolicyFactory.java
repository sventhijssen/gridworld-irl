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
//                if(i == j) // go right
//                    randomPolicy.setCell(i, j, new Vector(new double[] {0, 1, 0, 0}));
//                else if(i == j-5) // go down
//                    randomPolicy.setCell(i, j, new Vector(new double[] {0, 0, 1, 0}));
//                else
//                double[] prob = new double[4];
//                if(i == 0) // border top
//                    prob[0] = -5;
//                if(j == gridWorld.getColumns()-1) // border right
//                    prob[1] = -5;
//                if(i == gridWorld.getRows()-1) // border bottom
//                    prob[2] = -5;
//                if(j == 0) // border left
//                    prob[3] = -5;

//                int c = 0;
//                for(int k=0; k < prob.length; k++)
//                {
//                    if (prob[k] != -5)
//                        c++;
//                }
//
//                for(int k=0; k < prob.length; k++)
//                {
//                    if (prob[k] != -5)
//                        prob[k] = (double) 1/c;
//                }
                randomPolicy.setCell(i, j, new Vector(DistributionFactory.getProbabilityDistribution(4)));
            }
        }
        return randomPolicy;
    }
}