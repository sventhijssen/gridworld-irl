package main;


class PolicyFactory
{
    /**
     * Returns a random policy for the given grid world with the given number of actions.
     * @param gridWorld     The given grid world.
     * @param nrActions     The given number of actions in each state.
     * @return              For each cell in the grid world, a probability distribution among the given actions.
     */
    static GridWorldPolicy getRandomPolicy(GridWorld gridWorld, int nrActions)
    {
        GridWorldPolicy randomPolicy = new GridWorldPolicy(gridWorld);
        for(int i = 0; i < gridWorld.getNumberOfRows(); i++)
        {
            for (int j = 0; j < gridWorld.getNumberOfColumns(); j++)
            {
                randomPolicy.setPolicy(i, j, new Vector(DistributionFactory.getProbabilityDistribution(nrActions)));
            }
        }
        return randomPolicy;
    }
}