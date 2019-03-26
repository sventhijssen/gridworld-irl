package main;

import org.tc33.jheatchart.HeatChart;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class GridWorld
{

    /**
     * Variable registering the features for this grid world.
     */
    private Vector[][] features;

    /**
     * Variable registering the number of rows.
     */
    private int numberOfRows;

    /**
     * Variable registering the number of columns.
     */
    private int numberOfColumns;

    /**
     * Variable registering the possible actions for this grid world.
     */
    private final ArrayList<Action> actions;

    /**
     * Variable registering the start position for this grid world.
     */
    private final Position startPosition;

    /**
     * Variable registering the goal positions for this grid world.
     */
    private final ArrayList<Position> goalPositions;

    /**
     * Creates a grid world with numberOfRows numberOfRows and numberOfColumns numberOfColumns.
     * @param numberOfRows      The given number of numberOfRows.
     * @param numberOfColumns   The given number of numberOfColumns.
     */
    public GridWorld(int numberOfRows, int numberOfColumns, ArrayList<Action> actions, Position startPosition, ArrayList<Position> goalPositions)
    {
        this.setNumberOfRows(numberOfRows);
        this.setNumberOfColumns(numberOfColumns);
        this.actions = actions;
        this.startPosition = startPosition;
        this.goalPositions = goalPositions;
        this.features =  new Vector[numberOfRows][numberOfColumns];
        for(int i = 0; i < numberOfRows; i++)
        {
            for(int j = 0; j < numberOfColumns; j++)
            {
                features[i][j] = new Vector(0);
            }
        }
    }

    /**
     * Returns the position of neighbouring cells.
     * @param position
     * @return
     */
    LinkedList<Position> getNeighbours(Position position)
    {
        return getNeighbours(position.getRow(), position.getColumn());
    }

    Position getNewPosition(Position current, Action action)
    {
        return new Position(current.getRow() + action.getDeltaRow(), current.getColumn() + action.getDeltaColumn());
    }


    private LinkedList<Position> getNeighbours(int row, int column)
    {
        LinkedList<Position> neighbours = new LinkedList<>();
        Position neighbour;
        for(Action action: actions)
        {
            neighbour = new Position(row + action.getDeltaRow(), column + action.getDeltaColumn());
            if(isWithinBoundaries(neighbour))
                neighbours.add(neighbour);
        }
        return neighbours;
    }

    public void setFeature(int row, int column, double[] features)
    {
        this.features[row][column] = new Vector(features);
    }

    public Vector getFeatures(int row, int column)
    {
        return features[row][column];
    }

    public Vector getFeatures(Position position)
    {
        return features[position.getRow()][position.getColumn()];
    }

    public int getNumberOfRows()
    {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows)
    {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColumns()
    {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns)
    {
        this.numberOfColumns = numberOfColumns;
    }

    /**
     * Returns the board size of this grid world.
     * @return  The board size of a grid world is equal to the number of features, i.e. numberOfRows*numberOfColumns.
     */
    int getSize()
    {
        return this.getNumberOfRows()*this.getNumberOfColumns();
    }

    public void getRewardHeatMap(int k, Vector weights)
    {
        double[][] m = new double[numberOfRows][numberOfColumns];
        for(int i = 0; i < numberOfRows; i++)
        {
            for(int j = 0; j < numberOfColumns; j++)
            {
                m[i][j] = weights.dot(this.getFeatures(i, j));;
            }
        }



        HeatChart map = new HeatChart(m);

        try
        {
            //String workingDirectory = System.getProperty("user.dir");
            new File("heatmaps").mkdirs();
            map.saveToFile(new File("heatmaps/heatmap_rewards_"+k+".png"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    boolean isWithinBoundaries(int row, int column)
    {
        return (row >= 0 && row < getNumberOfRows() && column >= 0 && column < getNumberOfColumns());
    }

    public boolean isWithinBoundaries(Position position)
    {
        return isWithinBoundaries(position.getRow(), position.getColumn());
    }

    public Position getPosition(int s)
    {
        int row = (int) Math.floor((double) s/ getNumberOfColumns());
        int column = s % getNumberOfColumns();
        return (new Position(row, column));
    }

    public Vector getFeatureExpectations(ArrayList<Position> trajectory)
    {
        Vector mu = new Vector(features[0][0].length());
        double discountFactor = 0.9;
        for(int t=0; t < trajectory.size(); t++)
        {
            mu = mu.plus(this.getFeatures(trajectory.get(t)).scale(Math.pow(discountFactor, t)));
        }
        return mu;
    }

    public Position getRandomInitialPosition()
    {
        Random random;
        random = new Random();
        int row = random.nextInt(getNumberOfRows());
        random = new Random();
        int column = random.nextInt(getNumberOfColumns());
        return new Position(row, column);
    }

    public ArrayList<Action> getActions()
    {
        return actions;
    }

    public ArrayList<Position> getGoalPositions()
    {
        return goalPositions;
    }

    public boolean hasReachedGoal(Position current)
    {
        return goalPositions.contains(current);
    }

    public Position getStartPosition()
    {
        return startPosition;
    }
}
