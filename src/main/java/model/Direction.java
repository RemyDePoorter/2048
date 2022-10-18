package model;

/**
 * Enumeration Direction
 *
 * @author Rémy
 */
public enum Direction {
    /**
     * Move up
     */
    UP(-1, 0),
    /**
     * Move down
     */
    DOWN(1, 0),
    /**
     * Move left
     */
    LEFT(0, -1),
    /**
     * Move right
     */
    RIGHT(0, 1);

    private final int row; //a row of board
    private final int column; // a column of board

    /**
     * Constructor of Direction
     *
     * @param row
     * @param column
     */
    private Direction(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Give the row
     *
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * Give the Column
     *
     * @return column
     */
    public int getColumn() {
        return column;
    }
}
