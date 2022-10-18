package controller;

import model.Direction;
import model.Game;

/**
 * Controller of the application
 *
 * @author Rémy
 */
public final class Controller {

    private Game game;

    /**
     * Constructor of Controller
     */
    public Controller() {
        this.game = new Game();
    }

    /**
     * Move to direction
     * if game is over don't move
     *
     * @param dir direction to move
     */
    public void move(Direction dir) {
        if (!isOver()) {
            game.move(dir);
        }
    }

    /**
     * Build a new game
     */
    public void restart() {
        this.game = new Game();
    }

    /**
     * Getter of value of board
     *
     * @param row    of board
     * @param column of board
     * @return the value at the position asked in the board
     */
    public int getValue(int row, int column) {
        int[][] board = game.getBoard();
        return board[row][column];
    }

    /**
     * Getter of size of board
     *
     * @return size of board
     */
    public int getSize(){
        int[][] board = game.getBoard();
        return board.length;
    }

    /**
     * Getter victory status
     *
     * @return isVictory is biggest value = 2048
     */
    public boolean isVictory() {
        return this.game.isVictory();
    }

    /**
     * Simple getter of isOver
     *
     * @return isOver if the game is over (can't move)
     */
    public boolean isOver() {
        return this.game.isOver();
    }

    /**
     * Simple getter of score
     *
     * @return score of current game
     */
    public int getScore() {
        return this.game.getScore();
    }

    public int getCompteur() {
        return this.game.getCompteur() ;
    }
}
