import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

class QLearning
{
    /**
     * Variable registering the table with Q values.
     */
    private Double[][] qTable;

    /**
     * Variable registering the grid world of the environment.
     */
    private GridWorld gridWorld;

    /**
     * Variable registering the number of actions that can be taken in a two-dimensional grid world.
     */
    private final static int nrActions = 4;

    /**
     * Variable registering gamma (the discount factor) for this Q-learning algorithm.
     */
    private final double gamma;

    /**
     * Variable registering alpha (the learning rate) for this Q-learning algorithm.
     */
    private double[] alpha;

    /**
     * Variable registering epsilon (the threshold) for the greedy approach of this Q-learning algorithm.
     */
    private double epsilon = 0.8;

    /**
     * Constructs a new Q-learning algorithm for the given grid world.
     * The grid world determines the number of states and the number of actions in fixed to four.
     * @param gridWorld     The given grid world.
     * @param gamma         The given discount factor.
     * @param alpha         The given learning rate.
     */
    private QLearning(GridWorld gridWorld, double gamma, double alpha)
    {
        this.gridWorld = gridWorld;
        this.gamma = gamma;
        this.alpha = new double[gridWorld.getSize()];
        this.qTable = new Double[gridWorld.getSize()][nrActions];
        for(int i = 0; i < gridWorld.getSize(); i++)
        {
            for(int j = 0; j < nrActions; j++)
            {
                qTable[i][j] = 0.0;
            }
        }
    }

    /**
     * Constructs a new Q-learning algorithm for the given grid world with the given parameters.
     * @param gridWorld     The given grid world
     */
    QLearning(GridWorld gridWorld)
    {
        this(gridWorld, 0.1, 0.01);
    }

    /**
     * Computes the Q-table for this Q-Learning algorithm instance.
     * The Q-table is computed as follows:
     * For each episode:
     *  a. Select a random initial state.
     *  b. Do While the goal state hasn't been reached.
     *      i. Generate random number between 0 and 1. If the number is larger than the threshold e,
     *      select a random action, otherwise select the action with the highest possible reward,
     *      based on state and Q-table.
     *      ii. Using this possible action, consider going to the next state.
     *      iii. Get maximum Q value for this next state based on all possible actions.
     *      iv. Compute: Q(state, action) = R(state, action) + Gamma * Max[Q(next state, all actions)]
     *      v. Set the next state as the current state.
     *  c. End Do
     * End For
     * @param w             The weights for the respective features of a state in the grid world.
     * @param iterations    The maximum number of iterations to update the Q-table.
     */
    void computeQTable(Vector w, int iterations)
    {
        System.out.println("Started computing Q-table");

        double rnd, R, Q;
        Position next;
        int a, s;
        int c = gridWorld.getColumns();

        for(int i=0; i < iterations; i++)
        {
            System.out.println("ITERATION " + i);
            Position current = new Position(0,0);
            //alpha = new double[gridWorld.getSize()];
            int k = 0;
            while(!current.equals(gridWorld.getGoalPosition()))
            {
                System.out.println();
                System.out.println("Current: " + current);
                System.out.println("Goal: " + gridWorld.getGoalPosition());
                rnd = Math.random();

                // Select random action if rnd > epsilon, otherwise action with highest reward
                if (rnd < 0.5)
                    next = getRandomNeighbour(current);
                else
                    next = getMaxNeighbour(w, current);

                System.out.println("Next: " + next);

                R = getReward(w, next);
                System.out.println("R: " + R);
                a = getAction(current, next);
                System.out.println("a: " + a);
                s = current.getLinearization(c);
                System.out.println("s: " + s);

                Q = qTable[s][a]; // Q(s, a)
                alpha[s] += 1;
                qTable[s][a] = Q + (1/(1+alpha[s])) * (R + gamma * getMaxQ(next) - Q); // Q(s, a) = R(s, a) + gamma * max[Q(s', a')]

                current = next;
                k++;
            }
        }

        System.out.println("Stopped computing Q-table");
    }

    private Position getRandomInitialPosition()
    {
        Random r = new Random();
        return new Position(r.nextInt(gridWorld.getRows()-1), r.nextInt(gridWorld.getColumns()-1));
    }

    /**
     * Returns the optimal policy, based on the Q-table.
     * @return
     */
    Policy getPolicy()
    {
        System.out.println("Started computing optimal policy");
        Policy policy = new Policy(gridWorld);
        int row, column;
        // Iterate over all states
        for(int i=0; i < gridWorld.getSize(); i++)
        {
            row = (int) Math.floor((double) i/nrActions);
            column = i % nrActions;
            policy.setCell(row, column, new Vector(qTable[i]));
        }
        System.out.println("Stopped computing optimal policy");
        return policy;
    }

    /**
     * Returns the position of a random neighbouring states for the given position.
     * @param current       The given current position.
     * @return              The position of a random neighbouring state.
     */
    private Position getRandomNeighbour(Position current)
    {
        Random random = new Random();
        LinkedList<Position> neighbours = gridWorld.getNeighbours(current);
        return neighbours.get(random.nextInt(neighbours.size()));
    }

    /**
     * Returns the position of the neighbouring state with the maximum reward for the given position
     * and the given weights.
     * @param w         The given weights.
     * @param position  The given current position.
     * @return          The position of the neighbouring state with the maximum reward.
     */
    private Position getMaxNeighbour(Vector w, Position position)
    {
        LinkedList<Position> neighbours = gridWorld.getNeighbours(position);

        Position maxNeighbour = neighbours.get(0);
        double maxReward = getReward(w, maxNeighbour);
        for (Position neighbour : neighbours)
        {
            double reward = getReward(w, neighbour);
            if (reward > maxReward)
            {
                maxNeighbour = neighbour;
                maxReward = reward;
            }
        }
        return maxNeighbour;
    }

    /**
     * Returns the action, given the current position and the next position.
     * @param current       The current position.
     * @param next          The next position.
     * @return              Returns 0 if the next position lies one above the current position,
     *                      1 if the next position lies one to the right of the current position,
     *                      2 if the next position lies one beneath the current position,
     *                      3 if the next position lies one to the left of the current position;
     *                      otherwise and exception will be thrown.
     */
    private int getAction(Position current, Position next)
    {
        if(next.getRow() == current.getRow()-1)
            return 0;
        if(next.getColumn() == current.getColumn()+1)
            return 1;
        if(next.getRow() == current.getRow()+1)
            return 2;
        if(next.getColumn() == current.getColumn()-1)
            return 3;
        throw new RuntimeException("Positions are not neighbouring. Action undefined");
    }

    /**
     * Returns the reward of the state at the given position.
     * @param w         The given weights.
     * @param position  The given position of the state.
     * @return          R = w*phi
     */
    private double getReward(Vector w, Position position)
    {
        return w.dot(gridWorld.getState(position).getFeatures());
    }

    /**
     * Returns the maximum Q-value for the given position.
     * @param position
     * @return
     */
    private double getMaxQ(Position position)
    {
        LinkedList<Position> neighbours = gridWorld.getNeighbours(position);

        double maxQ = Double.MIN_VALUE;
        double qVal = Double.MIN_VALUE;
        int s, a;

        for(Position neighbour: neighbours)
        {
            s = neighbour.getLinearization(gridWorld.getColumns());
            a = getAction(position, neighbour);
            qVal = qTable[s][a];
            if(qVal > maxQ)
                maxQ = qVal;
        }
        return qVal;
    }

    @Override
    public String toString()
    {
        StringBuilder out = new StringBuilder();
        for(int i=0; i < qTable.length; i++)
        {
            out.append("State ").append(i).append(": ").append(Arrays.toString(qTable[i])).append("\n");
        }
        return out.toString();
    }
}
