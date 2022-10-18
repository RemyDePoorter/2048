package view;

import model.Direction;

/**
 * Interface of View
 *
 * @author Rémy
 */
public interface InterfaceView {

    /**
     * Display board
     */
    public void displayBoard();

    /**
     * Print message
     *
     * @param message
     */
    public void displayMessage(String message);

    /**
     * Print message error in red
     *
     * @param message
     */
    public void displayError(String message);

    /**
     * Ask to user one direction If the direction aren't ok, ask again one
     * direction
     *
     * @return the direction
     */
    public Direction askDirection();

    /**
     * show welcome message
     */
    public void startView();

    /**
     * Display the Score
     *
     * @param score
     */
    public void displayScore(int score);
}
