package model;

/**
 * Class Position, a position in board
 *
 * @author Rémy
 */
public class Position {

    private int row; //a row of board
    private int column;//a column of board

    /**
     * Constructor of Position
     *
     * @param row
     * @param column
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Give row
     *
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * Give Column
     *
     * @return column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Set a position
     *
     * @param position
     */
    public void setPosition(Position position) {
        this.row = position.getRow();
        this.column = position.getColumn();
    }

    /**
     * Next position
     *
     * @param direction
     * @return the next position of the piece
     */
    public Position next(Direction direction) {
        Position next = new Position(
                this.row + direction.getRow(),
                this.column + direction.getColumn());
        return next;
    }

    /**
     * Simple equals, test if position A = position B
     *
     * @param o
     * @return true if it's the same position
     */
    @Override
    public boolean equals(Object o) {
        return (this.row == ((Position) o).row 
                && this.column == ((Position) o).column);
    }

    /**
     * Hash code
     *
     * @return hash of row and column of board
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.row;
        hash = 71 * hash + this.column;
        return hash;
    }
}
