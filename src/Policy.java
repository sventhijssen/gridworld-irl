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

    //TODO: Check if you have already been here. If you have, ignore state and pick second highest
    // UGLY CODE :o
    private Cell getNextCell(Cell current, LinkedList<Cell> path)
    {
        LinkedList<Position> neighbourPositions = this.getNeighbours(current.getRow(), current.getColumn());
        LinkedList<Position> visitedPositions = new LinkedList<>();
        for(Cell cell: path)
        {
            visitedPositions.add(new Position(cell.getRow(), cell.getColumn()));
        }
        neighbourPositions.removeAll(visitedPositions);

        Set<Integer> directions = new HashSet<>();

        for(Position position: neighbourPositions)
        {
            if(position.getRow() == current.getRow()-1 && position.getColumn() == current.getColumn())
                directions.add(0);
            if(position.getRow() == current.getRow() && position.getColumn() == current.getColumn()+1)
                directions.add(1);
            if(position.getRow() == current.getRow()+1 && position.getColumn() == current.getColumn())
                directions.add(2);
            if(position.getRow() == current.getRow() && position.getColumn() == current.getColumn()-1)
                directions.add(3);
        }

        double[] prob = ((Vector) current.getContents()).getData();
        double m = prob[0];
        int index = 0;
        for(int i=0; i < prob.length; i++)
        {
            if(directions.contains(i) && prob[i] > m)
            {
                m = prob[i];
                index = i;
            }
        }

        return current.getNeighbour(index);
    }

    public LinkedList<Position> getNeighbours(int row, int column)
    {
        LinkedList<Position> neighbours = new LinkedList<>();
        if(row > 0)
            neighbours.add(new Position(row-1, column));
        if(row < gridWorld.getRows()-1)
            neighbours.add(new Position(row+1, column));
        if(column > 0)
            neighbours.add(new Position(row, column-1));
        if(column < gridWorld.getColumns()-1)
            neighbours.add(new Position(row, column+1));
        return neighbours;
    }

    public LinkedList<Cell> getPath()
    {
        LinkedList<Cell> path = new LinkedList<>();
        int row = 0;
        int column = 0;

        Cell start = this.getCell(row, column);
        path.add(start);

        Cell next = this.getNextCell(start, path);
        path.add(next);

        while(next.getRow() != gridWorld.getRows()-1 && next.getColumn() != gridWorld.getColumns()-1)
        {
            next = this.getNextCell(next, path);
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
