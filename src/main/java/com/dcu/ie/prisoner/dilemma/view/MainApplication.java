package com.dcu.ie.prisoner.dilemma.view;

import com.dcu.ie.prisoner.dilemma.SceneName;
import com.dcu.ie.prisoner.dilemma.controller.SceneController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        SceneController sceneController = new SceneController();

        sceneController.loadScene(SceneName.SetNumberOfPlayers.toString());
        sceneController.loadScene(SceneName.LaunchGame.name());

        sceneController.setScene(SceneName.SetNumberOfPlayers);

        Group root = new Group();
        root.getChildren().addAll(sceneController.getSceneLayout());

        primaryStage.setTitle("Prisoner's Dilemma");
        primaryStage.setScene(new Scene(root, 600, 575));
        //primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
