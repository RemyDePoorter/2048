package model;

/**
 * Facade of Game
 *
 * @author Rémy
 */
public interface Facade {

    /**
     * Give Board
     *
     * @return board
     */
    int[][] getBoard();

    /**
     * Give Score
     *
     * @return score
     */
    int getScore();

    /**
     * Move of value in the board
     *
     * @param direction to move
     */
    void move(Direction direction);

    /**
     * IsVictory
     *
     * @return isVictory if the game is win
     */
    boolean isVictory();

    /**
     * IsOver
     *
     * @return true if the game is lose if not false.
     */
    boolean isOver();
}
