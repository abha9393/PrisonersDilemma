package com.dcu.ie.prisoner.dilemma.view;

import com.dcu.ie.prisoner.dilemma.controller.LoginSceneController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        root.getChildren().addAll(new LoginSceneController().getScene());

        primaryStage.setTitle("Prisoner's Dilemma");
        primaryStage.setScene(new Scene(root, 600, 575));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
