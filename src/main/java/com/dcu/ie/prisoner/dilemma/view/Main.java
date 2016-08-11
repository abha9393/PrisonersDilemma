package com.dcu.ie.prisoner.dilemma.view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        SceneManager sceneManager = new SceneManager();

        sceneManager.loadScene(SceneName.SetNumberOfPlayers.toString());
        sceneManager.loadScene(SceneName.LaunchGame.name());

        sceneManager.setScene(SceneName.SetNumberOfPlayers);

        Group root = new Group();
        root.getChildren().addAll(sceneManager.getSceneLayout());

        primaryStage.setTitle("Prisoner's Dilemma");
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
