package com.dcu.ie.prisoner.dilemma.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 11-08-2016.
 */
public class GameController {

    @FXML
    private GridPane prisoner1GridPane;

    public void cooperate(ActionEvent actionEvent) {

    }

    public void addShadowEffect(MouseEvent mouseEvent) {
        ((Button)mouseEvent.getSource()).setEffect(new DropShadow());
    }

    public void removeShadowEffect(MouseEvent mouseEvent) {
        ((Button)mouseEvent.getSource()).setEffect(null);
    }

    public void closeWindow(ActionEvent actionEvent) {
        Platform.exit();
    }
}
