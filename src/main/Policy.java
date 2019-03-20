package main;

import java.util.*;

public class Policy
{
    private GridWorld gridWorld;
    private Cell[][] policy;

    public Policy(GridWorld gridWorld)
    {
        this.gridWorld = gridWorld;
        this.policy =  new Cell[gridWorld.getRows()][gridWorld.getColumns()];
        for(int i = 0; i < gridWorld.getRows(); i++)
        {
            for(int j = 0; j < gridWorld.getColumns(); j++)
            {
                policy[i][j] = new Cell(i, j, gridWorld, this, new Vector(new double[] {0.25, 0.25, 0.25, 0.25}));
            }
        }
    }

    Cell getCell(int row, int column)
    {
        if(!this.isValidRow(row) || !this.isValidColumn(column))
            throw new ArrayIndexOutOfBoundsException("Row or column out of bounds.");
        return this.policy[row][column];
    }


    public void setCell(int row, int column, Vector transition)
    {
        this.policy[row][column].setContents(transition);
    }

    private Cell getNeighbouringCell(Position current, int direction)
    {
        if(direction == 0)
            return policy[current.getRow()-1][current.getColumn()];
        if(direction == 1)
            return policy[current.getRow()][current.getColumn()+1];
        if(direction == 2)
            return policy[current.getRow()+1][current.getColumn()];
        if(direction == 3)
            return policy[current.getRow()][current.getColumn()-1];
        throw new RuntimeException("Undefined direction");
    }


    //TODO SOFTMAX
    private Cell getNextCell(Position current)
    {
        Cell currentCell = policy[current.getRow()][current.getColumn()];
        Vector transitions = (Vector) currentCell.getContents();
        LinkedList<Integer> possibleDirections = getPossibleDirections(current.getRow(), current.getColumn());
        double[] probabilities = transitions.getData();
        double maxProbability = -Double.MAX_VALUE;
        int direction = 0;

        // Probability

        double rnd = Math.random();

        if (rnd < 0.3)
        {
            Random random = new Random();
            direction = possibleDirections.get(random.nextInt(possibleDirections.size()));
        }
        else
        {
            for(int i=0; i < probabilities.length; i++)
            {
                if(possibleDirections.contains(i) && probabilities[i] > maxProbability)
                {
                    maxProbability = probabilities[i];
                    direction = i;
                }
            }
        }
        return getNeighbouringCell(current, direction);
    }


    public LinkedList<Integer> getPossibleDirections(int row, int column)
    {
        LinkedList<Integer> neighbours = new LinkedList<>();
        if(row > 0)
            neighbours.add(0); // up
        if(column < gridWorld.getColumns()-1)
            neighbours.add(1); // right
        if(row < gridWorld.getRows()-1)
            neighbours.add(2); // down
        if(column > 0)
            neighbours.add(3); // left
        return neighbours;
    }

    public LinkedList<Cell> getPath()
    {
        LinkedList<Cell> path = new LinkedList<>();
        Position position = gridWorld.getStartPosition();

        path.add(getCell(position.getRow(), position.getColumn()));

        Cell next = getNextCell(position);
        position = new Position(next.getRow(), next.getColumn());
        path.add(next);

        int maxSteps = gridWorld.getSize()*4;

        while(!(next.getRow() == gridWorld.getGoalPosition().getRow() && next.getColumn() == gridWorld.getGoalPosition().getColumn()) && path.size() < maxSteps)
        {
            System.out.println(new Position(next.getRow(), next.getColumn()));
            next = this.getNextCell(position);
            position = new Position(next.getRow(), next.getColumn());
            // System.out.format("(%d, %d)\n", next.getRow(), next.getColumn());
            path.add(next);
        }
        return path;
    }

    public Vector getFeatureExpectations(double discountFactor)
    {
        LinkedList<Cell> path = getPath();
        System.out.println("PATH");
        System.out.println(path);
        Vector sum = new Vector(gridWorld.getState(0,0).getFeatures().length());
        for(int i=0; i < path.size(); i++)
        {
            Cell c = path.get(i);
            Vector f = gridWorld.getState(c.getRow(), c.getColumn()).getFeatures();
            sum = sum.plus(f.scale(Math.pow(discountFactor, i)));
        }
        return sum;
    }


    private boolean isValidRow(int row)
    {
        return (row >= 0 && row < gridWorld.getRows());
    }

    private boolean isValidColumn(int column)
    {
        return (column >= 0 && column < gridWorld.getColumns());
    }

}
