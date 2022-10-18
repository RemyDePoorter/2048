package view;

import DesignPattern.Observable;
import DesignPattern.Observer;
import controller.Controller;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Direction;

import java.util.ArrayList;

/**
 * GraphicViewApp extends Application implements Observable
 */
public class GraphicViewApp extends Application implements Observable {
    private EventHandler<KeyEvent> keyListener;
    private Controller controller;
    private BoardView board;
    private ArrayList<Observer> observers;
    private ListView listView;
    private Score displayScore;

    /**
     * Main, launch the project
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initialize the game
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        this.controller = new Controller();
        this.observers = new ArrayList<>();
        this.listView = new ListView(controller);
        this.displayScore = new Score(controller);
        this.board = new BoardView(this.controller);
        //add objects to observersList
        this.observers.add(this.board);
        this.observers.add(displayScore);
        this.observers.add(listView);

        //primaryStage
        primaryStage.setTitle("2048");

        //initialize VBOX ROOT
        VBox root = new VBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setStyle("-fx-background-color: #ac9f94 ");

        //initialize box contains board, and listview
        HBox box = new HBox();
        box.setPadding(new Insets(10, 10, 10, 10));
        box.setSpacing(10);

        //initialize box2 contains restartButton and displayScore
        HBox box2 = new HBox();
        box2.setPadding(new Insets(0, 10, 10, 10));
        box2.setSpacing(39);

        this.listView.addMessage("Bienvenue au 2048 !");
        RestartButton restartButton = new RestartButton(this);

        box.getChildren().addAll(board, listView);
        box2.getChildren().addAll(restartButton, displayScore);
        root.getChildren().addAll(box, box2);

        //checkMovement with keyboard
        keyListener = event -> {
            switch (event.getCode()) {
                case UP:
                    this.controller.move(Direction.UP);
                    break;
                case DOWN:
                    this.controller.move(Direction.DOWN);
                    break;
                case RIGHT:
                    this.controller.move(Direction.RIGHT);
                    break;
                case LEFT:
                    this.controller.move(Direction.LEFT);
                    break;
            }
            this.listView.endView(this.controller);
            this.notifyObservers();
            event.consume();
        };
        root.addEventFilter(KeyEvent.KEY_PRESSED, keyListener);
        //initialise scene
        Scene scene = new Scene(root, 500, 300, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        //display the board
        primaryStage.show();
    }

    /**
     * Restart a game
     */
    public void restart() {
        controller.restart();
        board.show();
        displayScore.setText("SCORE : 0");
        this.listView.addMessage("Nouvelle partie");
    }

    /**
     * Adds an observer that observes the subject.
     *
     * @param obs an observer.
     */
    @Override
    public void registerObserver(java.util.Observer obs) {

    }

    /**
     * Removes an observer that observes the subject.
     *
     * @param obs an observer
     */
    @Override
    public void removeObserver(java.util.Observer obs) {

    }

    /**
     * Notifies all observers of a change.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
