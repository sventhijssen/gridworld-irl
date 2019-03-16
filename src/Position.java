import javafx.geometry.Pos;

public class Position
{
    private int row;
    private int column;
    public Position(int row, int column)
    {
        this.setRow(row);
        this.setColumn(column);
    }

    public int getColumn()
    {
        return column;
    }

    public void setColumn(int column)
    {
        this.column = column;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    /**
     * Returns the linearization of a position in a matrix with m columns.
     * @param m     The number of columns.
     * @return      The linearization l = r*m+c.
     */
    int getLinearization(int m)
    {
        return this.getRow()*m + this.getColumn();
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Position))
            throw new IllegalArgumentException("Must be position");
        return this.getRow() == ((Position) obj).getRow() && this.getColumn() == ((Position) obj).getColumn();
    }

    @Override
    public String toString()
    {
        return String.format("(%d, %d)", this.getRow(), this.getColumn());
    }
}
