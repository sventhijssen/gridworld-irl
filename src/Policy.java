import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Policy
{
    private GridWorld gridWorld;
    private Cell[][] policy;

    Policy(GridWorld gridWorld)
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
        System.out.println(current);
        System.out.println(direction);
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

    private Cell getNextCell(Position current)
    {
        Cell currentCell = policy[current.getRow()][current.getColumn()];
        Vector transitions = (Vector) currentCell.getContents();
        LinkedList<Integer> possibleDirections = getPossibleDirections(current.getRow(), current.getColumn());
        double[] probabilities = transitions.getData();
        System.out.println("NEXT CELL");
        System.out.println(current);
        System.out.println(possibleDirections);
        System.out.println(Arrays.toString(probabilities));

        double maxProbability = Double.MIN_VALUE;
        int direction = 0;

        for(int i=0; i < probabilities.length; i++)
        {
            if(possibleDirections.contains(i) && probabilities[i] > maxProbability)
            {
                maxProbability = probabilities[i];
                direction = i;
            }
        }
        System.out.println(direction);
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

        int maxSteps = 24;

        while(!(next.getRow() == gridWorld.getGoalPosition().getRow() && next.getColumn() == gridWorld.getGoalPosition().getColumn()) && path.size() < maxSteps)
        {
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
        Vector sum = new Vector(2);// TODO: Make adaptable
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
