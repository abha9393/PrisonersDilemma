package com.dcu.ie.prisoner.dilemma.controller;

import com.dcu.ie.prisoner.dilemma.SceneName;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class SceneController {
    private static Logger logger = LogManager.getLogger(SceneController.class);
    private static StackPane sceneNode = new StackPane();
    private Map<String, Node> scenes = new HashMap<>();

    public void addScene(String name, Node scene) {
        scenes.put(name, scene);
    }

    public void loadScene(String name) throws IOException {
        Parent scene = FXMLLoader.load(getClass().getClassLoader().getResource(name + ".fxml"));
        addScene(name, scene);
    }

    private Parent loadGameScene(Integer numOfPlayers, Integer numOfRounds, String prisoner1Type) throws IOException {
        //FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("LaunchGame.fxml"));
        //loader.setController(new GameController(numOfPlayers, numOfRounds, prisoner1Type));

        //return loader.load();
        return new GameController();
    }

    public void removeScene(SceneName name) {
        scenes.remove(name);
    }

    public void setGameScene(Integer numOfPlayers, Integer numOfRounds, String prisoner1Type) {
        final DoubleProperty opacity = sceneNode.opacityProperty();

        Timeline fade = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                new KeyFrame(new Duration(1000), t -> {
                    sceneNode.getChildren().remove(0);
                    try {
                        sceneNode.getChildren().add(0, loadGameScene(numOfPlayers, numOfRounds, prisoner1Type));
                    } catch (IOException e) {
                        logger.error(e.getMessage());
                    }
                    Timeline fadeIn = new Timeline(
                            new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                            new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                    fadeIn.play();
                }, new KeyValue(opacity, 0.0)));
        fade.play();
    }

    public boolean setScene(final SceneName name) {
        final DoubleProperty opacity = sceneNode.opacityProperty();

        if (!sceneNode.getChildren().isEmpty()) {
            Timeline fade = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                    new KeyFrame(new Duration(1000), t -> {
                        sceneNode.getChildren().remove(0);
                        sceneNode.getChildren().add(0, scenes.get(name.toString()));
                        Timeline fadeIn = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                        fadeIn.play();
                    }, new KeyValue(opacity, 0.0)));
            fade.play();

        } else {
            sceneNode.setOpacity(0.0);
            sceneNode.getChildren().add(scenes.get(name.toString()));
            Timeline fadeIn = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                    new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
            fadeIn.play();
        }
        return true;
    }

    public static StackPane getScene() {
        return sceneNode;
    }
}