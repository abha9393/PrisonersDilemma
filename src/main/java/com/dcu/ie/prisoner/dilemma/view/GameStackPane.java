package com.dcu.ie.prisoner.dilemma.view;

import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 11-08-2016.
 */
public class GameStackPane extends GridPane {
    private int numberOfPlayers;

    public GameStackPane(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        initialize();
    }

    private void initialize() {
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);

        for (int i = 0; i < numberOfPlayers; i++) {
            VBox player = new VBox();
            player.getChildren().addAll(new Separator());
        }
    }

}