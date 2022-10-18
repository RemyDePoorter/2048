package model;

/**
 * Class Game implements Facade contains the game move
 *
 * @author Rémy
 */
public class Game implements Facade {

    private Board board; // The board of game
    private int score; // The Score of player
    private boolean victory; //return true if the biggest value = 2048
    private int compteur; ////
    /**
     * Constructor of Game
     */
    public Game() {
        this.board = new Board();
        this.score = 0;
        this.victory = false;
        this.compteur = 0;
    }

    /**
     * Move of value on of the board
     *
     * @param direction to move
     */
    @Override
    public void move(Direction direction) {
        if (direction == Direction.UP || direction == Direction.LEFT) {
            moveUpLeft(direction);
        } else {
            this.moveDownRight(direction);
        }
        if (haveOneMove()) {
            this.board.addTile();
        }
        this.compteur();
    }

    /**
     * Move up and left
     *
     * @param direction Up or Left
     */
    private void moveUpLeft(Direction direction) {

        int[][] board = this.board.getBoard();
        boolean[][] booleanBoard = new boolean[board.length][board.length]; //test if there are a fusion or not
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                booleanBoard[i][j] = false;
            }
        }
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                int value = board[x][y];
                if (value != 0) { //if not 0 try move value in board
                    Position position = new Position(x,y);
                    Position next = position.next(direction);
                    while (this.board.isInside(next.getRow(), next.getColumn())) {
                        if (board[next.getRow()][next.getColumn()] != 0) {
                            if (board[next.getRow()][next.getColumn()] == value 
                                    &&!booleanBoard[next.getRow()][next.getColumn()]) {
                                booleanBoard[next.getRow()][next.getColumn()] = true;
                                value += value;
                                score += value;
                                if (value == 16) {
                                    victory = true;
                                }
                                board[next.getRow()][next.getColumn()] = value;
                                value = 0;
                            }
                            break;
                        } else {
                            position.setPosition(next);
                            next = position.next(direction);
                        }
                    }
                    board[x][y] = 0;
                    board[position.getRow()][position.getColumn()] = value;
                }
            }
        }
    }

    /**
     * Move down and right
     *
     * @param direction Down or Right
     */
    private void moveDownRight(Direction direction) {

        int[][] board = this.board.getBoard();
        boolean[][] booleanBoard = new boolean[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                booleanBoard[i][j] = false;
            }
        }
        for (int x = board.length - 1; x >= 0; x--) {
            for (int y = board.length - 1; y >= 0; y--) {
                int value = board[x][y];
                if (value != 0) {
                    Position position = new Position(x, y);
                    Position next = position.next(direction);
                    while (this.board.isInside(next.getRow(), next.getColumn())) {
                        if (board[next.getRow()][next.getColumn()] != 0) {
                            if (board[next.getRow()][next.getColumn()] == value 
                                    &&!booleanBoard[next.getRow()][next.getColumn()]) {
                                booleanBoard[next.getRow()][next.getColumn()] = true;
                                value += value;
                                score += value;
                                if (value == 16) {
                                    victory = true;
                                }
                                board[next.getRow()][next.getColumn()] = value;
                                value = 0;
                            }
                            break;
                        } else {
                            position.setPosition(next);
                            next = position.next(direction);
                        }
                    }
                    board[x][y] = 0;
                    board[position.getRow()][position.getColumn()] = value;
                }
            }
        }
    }

    /**
     * Check if one square of the board can move.
     *
     * @return true if one square can move if not false.
     */
    private boolean haveOneMove() {
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                if (!board.isFree(i, j)) {
                    Position actualPosition = new Position(i, j);
                    for (Direction direction : Direction.values()) {
                        Position nextPos = actualPosition.next(direction);
                        if (board.isInside(nextPos.getRow(), nextPos.getColumn())
                                && board.isFree(nextPos.getRow(), nextPos.getColumn())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Check if one square can fusion with another
     *
     * @return true if square can fusion with another if not false.
     */
    private boolean haveOneFusion() {
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < getBoard().length; j++) {
                if (!board.isFree(i, j)) {
                    Position actualPos = new Position(i, j);
                    for (Direction direction : Direction.values()) {
                        Position nextPos = actualPos.next(direction);
                        if (board.isInside(nextPos.getRow(), nextPos.getColumn())
                                && board.sameValue(actualPos.getRow(), actualPos.getColumn(),
                                nextPos.getRow(), nextPos.getColumn())) return true;
                    }
                }
            }
        }
        return false;
    }

    public void compteur() {
        int[][] board = this.board.getBoard();
        compteur = 0;
        for (int x = 0; x < getBoard().length; x++) {
            for (int y = 0; y < getBoard().length; y++) {
                int value = board[x][y];
                if (value != 0) {
                    compteur++;
                }
            }
        }
    }

    public int getCompteur() {
        return compteur;
    }

    /**
     * IsOver
     *
     * @return true if the game is lose if not false.
     */
    public boolean isOver() {
        return !(haveOneFusion() || haveOneMove());
    }

    /**
     * Give Board
     *
     * @return board
     */
    @Override
    public int[][] getBoard() {
        return board.getBoard();
    }

    /**
     * Setter for testMove
     *
     * @param board
     */
    public void setBoard(int[][] board) {
        this.board.setBoard(board);
    }

    /**
     * Give Score
     *
     * @return score
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * Simple getter of isVictory
     *
     * @return true if game is win
     */
    @Override
    public boolean isVictory() {
        return this.victory;
    }

}