package main;

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
    private final static int nrActions = 3;

    /**
     * Variable registering gamma (the discount factor) for this Q-learning algorithm.
     */
    private final double gamma;

    /**
     * Variable registering alpha (the learning rate) for this Q-learning algorithm.
     */
    private double[] alpha;

    /**
     * Constructs a new Q-learning algorithm for the given grid world.
     * The grid world determines the number of states and the number of actions in fixed to four.
     * @param gridWorld     The given grid world.
     * @param gamma         The given discount factor.
     */
    private QLearning(GridWorld gridWorld, double gamma)
    {
        this.gridWorld = gridWorld;
        this.gamma = gamma;
        this.alpha = new double[gridWorld.getSize()];
        this.qTable = new Double[gridWorld.getSize()][nrActions];
        for(int i = 0; i < gridWorld.getSize(); i++)
        {
            for(int j = 0; j < nrActions; j++)
            {
                    qTable[i][j] = Math.random();
            }
        }
    }

    /**
     * Constructs a new Q-learning algorithm for the given grid world with the given parameters.
     * @param gridWorld     The given grid world
     */
    QLearning(GridWorld gridWorld)
    {
        this(gridWorld, 0.9);
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

        double R, Q;
        Position next;
        int a, s;
        int c = gridWorld.getColumns();


        for(int i=0; i < iterations; i++)
        {
            System.out.println("ITERATION " + i);
            Position current = gridWorld.getStartPosition();

            alpha = new double[gridWorld.getSize()];

            while(current.getColumn() < gridWorld.getColumns()-2)
            {
                System.out.println();
                System.out.println("Current: " + current);

                next = getNextPosition(ActionSelectionMechanism.SOFTMAX, w, current);

                if(!gridWorld.isWithinBoundaries(next))
                    break; //next = getNextPosition(ActionSelectionMechanism.SOFTMAX, w, current);

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
            }
        }

        System.out.println("Stopped computing Q-table");
    }

    private Position getNextPosition(ActionSelectionMechanism mechanism, Vector w, Position current)
    {
        double rnd = Math.random();
        if(mechanism == ActionSelectionMechanism.GREEDY)
        {
            // Epsilon-greedy action selection mechanism
            // Select random action if rnd > epsilon, otherwise action with highest reward
            if (rnd <= 0.4)
                return getRandomNeighbour(current);
            else
                return getMaxNeighbour(w, current);
        } else {

            // Linearize the position of the current state
            int s = current.getLinearization(gridWorld.getColumns());

            // Convert Q-values into probabilities
            Double[] qValues = qTable[s];
            double[] probabilities = softMax(qValues);
            double[] cumProbabilities = getCumulativeProbabilities(probabilities);
            //System.out.println("Probabilities: " + Arrays.toString(probabilities));
            //System.out.println("Cumulative probabilities: " + Arrays.toString(cumProbabilities));
            //System.out.println("Random: "+ rnd);

            int i;
            for(i=0; i < cumProbabilities.length; i++)
            {
                if(rnd <= cumProbabilities[i])
                    break;
            }

            return getNeighbour(current, i);

        }
    }

    /**
     * Returns the cumulative distribution function.
     * @param probabilities     The given probabilities.
     * @return                  The cumulative probabilities (0 exclusive).
     */
    private double[] getCumulativeProbabilities(double[] probabilities)
    {
        double[] cumProbabilities = new double[probabilities.length];
        for(int i=0; i < probabilities.length; i++)
        {
            if(i > 0)
                cumProbabilities[i] = cumProbabilities[i-1];
            cumProbabilities[i] += probabilities[i];
        }
        return cumProbabilities;
    }

    private Position getNeighbour(Position current, int direction)
    {
            if(direction == 0)
                return new Position(current.getRow()-1, current.getColumn()+1);
            if(direction == 1)
                return new Position(current.getRow(), current.getColumn()+1);
            if(direction == 2)
                return new Position(current.getRow()+1, current.getColumn()+1);
            throw new RuntimeException("Undefined direction");
    }

    private double[] softMax(Double[] qs)
    {
        double[] ps = new double[qs.length];
        double temp = 0.4;

        double denominator = 0;
        for (Double q : qs)
        {
            denominator += Math.exp(q / temp);
        }

        for (int i=0; i < qs.length; i++)
        {
            ps[i] = Math.exp(qs[i]/temp) / denominator;
        }

        return ps;
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
            row = (int) Math.floor((double) i/gridWorld.getColumns());
            column = i % gridWorld.getColumns();
            policy.setCell(row, column, new Vector(softMax(qTable[i])));
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
        if(next.getRow() == current.getRow())
            return 1;
        if(next.getRow() == current.getRow()+1)
            return 2;
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
