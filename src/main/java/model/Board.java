package model;

/**
 * Class Board represent a board 4*4 with square and value
 *
 * @author Rémy
 */
public final class Board {

    private final int size; //size of board 4x4
    private int[][] board; //board of the game

    /**
     * Constructor of Board Initialize a board 4*4 with 2 new Tiles
     */
    public Board() {
        this.size = 4;
        this.board = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = 0;
            }
        }
        addTile();
        addTile();
    }

    /**
     * Add a tile to the board to a random position
     * 90% of time value = 2 and 10% of time value = 4;
     */
    public void addTile() {
        int tempX, tempY, value;
        //take a random position in board and assign value 2 or 4
        //If the same position of tile is generated 2x, we generate a new
        do {
            tempX = (int) (Math.random() * 4);
            tempY = (int) (Math.random() * 4);
        } while (this.board[tempX][tempY] != 0);
        //90% of time value = 2 and 10% of time value = 4;
        if (Math.random() > 0.9) {
            value = 4;
        } else {
            value = 2;
        }
        this.board[tempX][tempY] = value;
    }

    /**
     * Test if the position is in the board
     *
     * @param row of board
     * @param column of board
     * @return true if position(row, column) is inside the board.
     */
    public boolean isInside(int row, int column) {
        return row < this.size && row >= 0
                && column < this.size && column >= 0;
    }

    /**
     * Test if the square is free (board [i][j] == 0)
     * if square is outside of board, return an exception
     *
     * @param row
     * @param column
     * @return true if the square is free
     */
    public boolean isFree(int row, int column) {
        if (!isInside(row, column)) {
            throw new IllegalArgumentException("error is outside " + column + " " + row);
        } else {
            return board[row][column] == 0;
        }
    }

    /**
     * Test if 2 squares have the same value
     *
     * @param row     of first square
     * @param column  of first square
     * @param row2    of second square
     * @param column2 of second square
     * @return true if square are equals
     */
    public boolean sameValue(int row, int column, int row2, int column2) {
        return this.board[row][column] == board[row2][column2];
    }

    /**
     * Give the board
     *
     * @return board
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Set the size of board
     *
     * @param board
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }
}
