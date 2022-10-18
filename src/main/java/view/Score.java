package view;

import DesignPattern.Observer;
import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Score extends Label implements Observer {
    private Controller controller;

    /**
     * Constructor of score
     */
    public Score(Controller controller) {
        this.controller = controller;

        setStyle("-fx-background-color: #b04812;-fx-font-size: 1em ;"
                + "-fx-font-weight: bold;");
        setTextFill(Color.web("#f9f6f2"));
        setPadding(new Insets(10, 10, 10, 10));
        setText("Score : 0");
    }

    /**
     * Updates the observer when the subject has changed.
     */
    @Override
    public void update() {
        setText("SCORE : " + controller.getScore());
    }
}
