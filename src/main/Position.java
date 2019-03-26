package main;

public class Position
{
    /**
     * Variable registering the row of this position.
     */
    private final int row;

    /**
     * variable registering the column of this position.
     */
    private final int column;

    /**
     * Creates a new position for the given row and column.
     * @param row           The given row.
     * @param column        The given column.
     */
    public Position(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    /**
     * Returns the row of this position.
     * @return      The row.
     */
    public int getRow()
    {
        return row;
    }

    /**
     * Returns the column of this position.
     * @return      The column.
     */
    public int getColumn()
    {
        return column;
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
