package com.dcu.ie.prisoner.dilemma.view;

import com.dcu.ie.prisoner.dilemma.SceneName;
import com.dcu.ie.prisoner.dilemma.controller.GameController;
import com.dcu.ie.prisoner.dilemma.controller.LoginSceneController;
import com.dcu.ie.prisoner.dilemma.controller.SceneController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        SceneController sceneController = new LoginSceneController();
        sceneController.loadScene(SceneName.SetNumberOfPlayers.toString());
        sceneController.setScene(SceneName.SetNumberOfPlayers);

        Group root = new Group();
        root.getChildren().addAll(sceneController.getScene());

        primaryStage.setTitle("Prisoner's Dilemma");
        primaryStage.setScene(new Scene(new GameController(), 1000, 955));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
