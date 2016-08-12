package com.dcu.ie.prisoner.dilemma.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 11-08-2016.
 */
public class LoginSceneController extends SceneController {
    private static Logger logger = LogManager.getLogger(LoginSceneController.class);

    @FXML
    private ComboBox numOfPlayers;

    @FXML
    private ComboBox numOfRounds;

    @FXML
    private ComboBox prisoner1Type;

    public void initialSetUp(ActionEvent actionEvent) {
        setGameScene((Integer) numOfPlayers.getValue(), (Integer) numOfRounds.getValue(), (String) prisoner1Type.getValue());
    }
}
