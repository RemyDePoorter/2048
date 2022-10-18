package view;

import DesignPattern.Observer;
import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardView extends GridPane implements Observer {

    private final Controller controller;

    /**
     * Constructor of board
     *
     * @param controller
     */
    public BoardView(Controller controller) {
        this.controller = controller;
        setHgap(5); //horizontal space between tile
        setVgap(5); //vertical space between tile
        setPadding(new Insets(5, 5, 5, 5));
        show();
    }

    /**
     * Display the board
     */
    public void show() {
        int size = controller.getSize(); //length of board
        setStyle("-fx-background-color: #bbada0 "); //board background
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = this.controller.getValue(i, j);
                Rectangle rec = new Rectangle(); //square of board
                rec.setWidth(50);
                rec.setHeight(50);
                rec.setFill(Color.web("#cdc1b4")); //color if square value = 0
                add(rec, j, i);
                //if square value != 0 use method setStyle
                if (value != 0) {

                    Label labelValue = new Label(Integer.toString(value));
                    add(labelValue, j, i);
                    this.setStyle(labelValue, rec, value);
                }
            }
        }
    }

    /**
     * Set the style, set the color, set the font and align number
     *
     * @param labelValue //display value in a case
     * @param rec        //case of the board
     * @param value      //value on the case
     */
    private void setStyle(Label labelValue, Rectangle rec, int value) {

        labelValue.setStyle("-fx-font-size: 2em ;-fx-font-weight: bold;");
        //align center
        labelValue.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(labelValue, 0.0);
        AnchorPane.setRightAnchor(labelValue, 0.0);
        labelValue.setAlignment(Pos.CENTER);

        switch (value) {
            case 2:
                rec.setFill(Color.web("#eee4da"));
                labelValue.setTextFill(Color.web("#776e65"));
                break;
            case 4:
                rec.setFill(Color.web("#ede0c8"));
                labelValue.setTextFill(Color.web("#776e65"));
                break;
            case 8:
                rec.setFill(Color.web("#f2b179"));
                labelValue.setTextFill(Color.web("#f9f6f2"));
                break;
            case 16:
                rec.setFill(Color.web("#f59563"));
                labelValue.setTextFill(Color.web("#f9f6f2"));
                break;
            case 32:
                rec.setFill(Color.web("#f67c5f"));
                labelValue.setTextFill(Color.web("#f9f6f2"));
                break;
            case 64:
                rec.setFill(Color.web("#f65e3b"));
                labelValue.setTextFill(Color.web("#f9f6f2"));
                break;
            case 128:
                rec.setFill(Color.web("#edcf72"));
                labelValue.setTextFill(Color.web("#f9f6f2"));
                break;
            case 256:
                rec.setFill(Color.web("#edcc61"));
                labelValue.setTextFill(Color.web("#f9f6f2"));
                break;
            case 512:
                rec.setFill(Color.web("#edc850"));
                labelValue.setTextFill(Color.web("#f9f6f2"));
                break;
            case 1024:
                rec.setFill(Color.web("#edc53f"));
                labelValue.setTextFill(Color.web("#f9f6f2"));
                break;
            default:
                rec.setFill(Color.web("#edc22e"));
                labelValue.setTextFill(Color.web("#f9f6f2"));
                break;
        }
    }

    /**
     * Updates the observer when the subject has changed.
     */
    @Override
    public void update() {
        show();
    }
}
