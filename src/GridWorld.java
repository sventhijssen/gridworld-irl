import java.util.LinkedList;

class GridWorld
{

    private State[][] states;

    private int rows;

    private int columns;

    GridWorld(int rows, int columns)
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
        if(row < this.getRows()-1)
            neighbours.add(new Position(row+1, column));
        if(column > 0)
            neighbours.add(new Position(row, column-1));
        if(column < this.getColumns()-1)
            neighbours.add(new Position(row, column+1));
        return neighbours;
    }

    void setFeature(int row, int column, double[] features)
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
}
