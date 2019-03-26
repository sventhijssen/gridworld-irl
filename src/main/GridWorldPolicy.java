package main;

import java.util.*;

class GridWorldPolicy
{
    /**
     * Variable registering the grid world of this policies.
     */
    private GridWorld gridWorld;

    /**
     * Variable registering the policies.
     */
    private Vector[][] policies;

    /**
     * Creates a policies for the given grid world.
     * @param gridWorld     The given grid world.
     */
    GridWorldPolicy(GridWorld gridWorld)
    {
        this.gridWorld = gridWorld;
        this.policies =  new Vector[gridWorld.getNumberOfRows()][gridWorld.getNumberOfColumns()];
    }

    /**
     * Returns the policy for the given position.
     * @param position      The given position.
     * @return              The policy for the given position.
     */
    private Vector getPolicy(Position position)
    {
        return getPolicy(position.getRow(), position.getColumn());
    }

    /**
     * Returns the policy for the position at the given row and column.
     * @param row           The given row.
     * @param column        The given column.
     * @return              The policy of the position at the given row and column.
     */
    private Vector getPolicy(int row, int column)
    {
        if(!gridWorld.isWithinBoundaries(row, column))
            throw new ArrayIndexOutOfBoundsException("Row or column out of bounds.");
        return this.policies[row][column];
    }


    /**
     * Sets the policy for the position at the given row and column.
     * @param row           The given row.
     * @param column        The given column.
     * @param policy        The policy of the position at the given row and column.
     */
    public void setPolicy(int row, int column, Vector policy)
    {
        if(!gridWorld.isWithinBoundaries(row, column))
            throw new ArrayIndexOutOfBoundsException("Row or column out of bounds.");
        this.policies[row][column] = policy;
    }


    /**
     * Returns the next position given the current position based on this policy.
     * @param current       The current position.
     * @return              The next position based on this policy.
     */
    private Position getNextPosition(Position current)
    {
        ArrayList<Action> actions = gridWorld.getActions();

        double[] probabilities = getPolicy(current).getValues();
        double maxProbability = -Double.MAX_VALUE;

        Position next = null;
        Position position;

        for(int i=0; i < probabilities.length; i++)
        {
            position = gridWorld.getNewPosition(current, actions.get(i));
            if(gridWorld.isWithinBoundaries(position) && probabilities[i] > maxProbability)
            {
                maxProbability = probabilities[i];
                next = position;
            }
        }
        return next;
    }

    /**
     * Returns a trajectory for the given policy.
     * @param current       The given start position.
     * @return              The trajectory.
     */
    ArrayList<Position> getTrajectory(Position current)
    {
        ArrayList<Position> trajectory = new ArrayList<>();
        trajectory.add(current);

        while(!gridWorld.hasReachedGoal(current))
        {
            current = getNextPosition(current);
        }
        return trajectory;
    }
}
