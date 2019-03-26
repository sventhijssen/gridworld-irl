package main;

public class Cell
{
    private int row;
    private int column;
    private GridWorld gridWorld;
    private GridWorldPolicy policy;
    private Object contents;

    public Cell(int row, int column, GridWorld gridWorld, GridWorldPolicy policy, Object contents)
    {
        this.setGridWorld(gridWorld);
        this.setRow(row);
        this.setColumn(column);
        this.setContents(contents);
        this.setPolicy(policy);
    }

    @Override
    public String toString()
    {
        return String.valueOf(new Position(row, column));
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        if(!this.isValidRow(row))
            throw new IllegalArgumentException("Row out of boundaries.");
        this.row = row;
    }

    private boolean isValidRow(int row)
    {
        return (row >= 0 && row < this.getGridWorld().getNumberOfRows());
    }

    public int getColumn()
    {
        return column;
    }

    public void setColumn(int column)
    {
        if(!this.isValidColumn(column))
            throw new IllegalArgumentException("Column out of boundaries.");
        this.column = column;
    }

    public GridWorld getGridWorld()
    {
        return gridWorld;
    }

    private boolean isValidColumn(int column)
    {
        return (column >= 0 && column < this.getGridWorld().getNumberOfColumns());
    }

    public void setGridWorld(GridWorld gridWorld)
    {
        if(gridWorld == null)
            throw new IllegalArgumentException("GridWorld cannot be null.");
        this.gridWorld = gridWorld;
    }

    public Object getContents()
    {
        return contents;
    }

    public void setContents(Object contents)
    {
        this.contents = contents;
    }

    public GridWorldPolicy getPolicy()
    {
        return policy;
    }

    public void setPolicy(GridWorldPolicy policy)
    {
        this.policy = policy;
    }
}
