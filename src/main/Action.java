package main;

public class Action
{
    /**
     * Variable registering the difference in row for this action.
     */
    private final int deltaRow;

    /**
     * Variable registering the difference in column for this action.
     */
    private final int deltaColumn;

    /**
     * Creates a new action for the given difference in row and difference in column.
     * @param deltaRow          The given difference in row.
     * @param deltaColumn       The given difference in column.
     */
    public Action(int deltaRow, int deltaColumn)
    {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }

    /**
     * Returns the difference in row for this action.
     * @return          The difference in row.
     */
    int getDeltaRow()
    {
        return deltaRow;
    }

    /**
     * Returns the difference in column for this action.
     * @return          The difference in column.
     */
    int getDeltaColumn()
    {
        return deltaColumn;
    }

    /**
     * Returns the new position for this action given the current position.
     * @param current           The given position.
     * @return                  The new position after applying this action to it.
     */
    public Position getNewPosition(Position current)
    {
        return new Position(current.getRow() + getDeltaRow(), current.getColumn() + getDeltaColumn());
    }
}
