package main;

import org.tc33.jheatchart.HeatChart;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class GridWorld
{

    private State[][] states;

    private int rows;

    private int columns;

    private Position startPosition;

    private Position goalPosition;

    public GridWorld(int rows, int columns)
    {
        this.setRows(rows);
        this.setColumns(columns);
        this.states =  new State[rows][columns];
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                states[i][j] = new State();
            }
        }
    }

    LinkedList<Position> getNeighbours(Position position)
    {
        return this.getNeighbours(position.getRow(), position.getColumn());
    }


    LinkedList<Position> getNeighbours(int row, int column)
    {
        LinkedList<Position> neighbours = new LinkedList<>();
        if(row > 0)
            neighbours.add(new Position(row-1, column));
        if(column < this.getColumns()-1)
            neighbours.add(new Position(row, column+1));
        if(row < this.getRows()-1)
            neighbours.add(new Position(row+1, column));
        if(column > 0)
            neighbours.add(new Position(row, column-1));
        return neighbours;
    }

    public void setFeature(int row, int column, double[] features)
    {
        this.states[row][column].setFeatures(features);
    }

    public State getState(int row, int column)
    {
        return states[row][column];
    }

    public State getState(Position position)
    {
        return states[position.getRow()][position.getColumn()];
    }

    public int getRows()
    {
        return rows;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }

    public int getColumns()
    {
        return columns;
    }

    public void setColumns(int columns)
    {
        this.columns = columns;
    }

    /**
     * Returns the board size of this grid world.
     * @return  The board size of a grid world is equal to the number of states, i.e. rows*columns.
     */
    int getSize()
    {
        return this.getRows()*this.getColumns();
    }

    public void getHeatMap(int feature)
    {
        double[][] m = new double[rows][columns];
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                m[i][j] = states[i][j].getFeatures().getData()[feature];
            }
        }



        HeatChart map = new HeatChart(m);

        try
        {
            System.out.println("Heat");
            map.saveToFile(new File("heatmap_feature_"+feature+".png"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void getRewardHeatMap(int k, Vector weights)
    {
        double[][] m = new double[rows][columns];
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                m[i][j] = weights.dot(this.getState(i, j).getFeatures());;
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

    public void setStartPosition(int row, int column)
    {
        this.startPosition = new Position(row, column);
    }


    public void getStartPosition(int row, int column)
    {
        this.startPosition = new Position(row, column);
    }

    public Position getStartPosition()
    {
        return startPosition;
    }

    public boolean isWithinBoundaries(Position position)
    {
        return (position.getRow() >= 0 && position.getRow() <= getRows()-1 && position.getColumn() >= 0 && position.getColumn() <= getColumns()-1);
    }

    public Position getPosition(int s)
    {
        int row = (int) Math.floor((double) s/getColumns());
        int column = s % getColumns();
        return (new Position(row, column));
    }

    public Position getGoalPosition()
    {
        return goalPosition;
    }

    public void setGoalPosition(int row, int column)
    {
        this.goalPosition = new Position(row, column);
    }

    public void setGoalPosition(Position goalPosition)
    {
        this.goalPosition = goalPosition;
    }

    public Vector getFeatureExpectations(ArrayList<Position> trajectory)
    {
        Vector mu = new Vector(4);
        double discountFactor = 0.9;
        for(int t=0; t < trajectory.size(); t++)
        {
            mu = mu.plus(this.getState(trajectory.get(t)).getFeatures().scale(Math.pow(discountFactor, t)));
        }
        return mu;
    }

    public Position getRandomInitialPosition()
    {
        Random random;
        random = new Random();
        int row = random.nextInt(getRows());
        random = new Random();
        int column = random.nextInt(getColumns());
        return new Position(row, column);
    }
}
