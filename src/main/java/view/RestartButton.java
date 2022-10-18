package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class RestartButton extends Button {
    private GraphicViewApp app;

    public RestartButton(GraphicViewApp app) {
        this.app = app;
        //style
        this.setStyle("-fx-background-color: #b04812;-fx-font-size: 1em ;"
                + "-fx-font-weight: bold;");
        this.setTextFill(Color.web("#f9f6f2"));
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setText("RECOMMENCER");
        //action
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                app.restart();
            }
        });
    }
}