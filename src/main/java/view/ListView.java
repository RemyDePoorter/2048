package view;

import DesignPattern.Observer;
import controller.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListView extends javafx.scene.control.ListView implements Observer {
    private Controller controller;
    /**
     * Constructor of ListView
     */
    public ListView(Controller controller) {
        this.setStyle("-fx-background-insets: 0 ;");
        this.setFocusTraversable(false);
        this.controller=controller;
    }

    /**
     * Display message at format :
     * hour minute PM/AM - message
     *
     * @param message
     */
    public void addMessage(String message) {
        SimpleDateFormat formater = null;
        Date moment = new Date();
        formater = new SimpleDateFormat("h:mm a");
        this.getItems().add(formater.format(moment) + " - " + message);
    }

    /**
     * Display message when game is end
     *
     * @param controller
     */
    public void endView(Controller controller) {
        //lose
        if (controller.isOver()) {
            this.addMessage("Dommage vous avez perdu");
        }
        //win
        if (controller.isVictory()) {
            this.addMessage("Bravo ! Vous avez gagné !");
        }
        //lose after win
        if (controller.isOver() && controller.isVictory()) {
            this.addMessage("Partie terminée");
        }
    }
    /**
     * Updates the observer when the subject has changed.
     */
    @Override
    public void update() {
        addMessage("Il y a "+controller.getCompteur()+" cases non vide");
    }
}
