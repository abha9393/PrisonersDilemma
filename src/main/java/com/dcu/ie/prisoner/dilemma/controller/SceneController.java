package com.dcu.ie.prisoner.dilemma.controller;

import com.dcu.ie.prisoner.dilemma.SceneName;
import com.dcu.ie.prisoner.dilemma.view.GameStackPane;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class SceneController implements Initializable {
    private static Logger logger = LogManager.getLogger(SceneController.class);
    private static StackPane sceneLayout = new StackPane();
    private Map<String, Node> scenes = new HashMap<>();


    public void addScene(String name, Node scene) {
        scenes.put(name, scene);
    }

    public void loadScene(String name) {
        try {
            Parent scene = FXMLLoader.load(getClass().getClassLoader().getResource(name + ".fxml"));
            addScene(name, scene);
        } catch (IOException e) {
            logger.error("Error occurred whilst loading scene\n" + e.getMessage());
        }
    }

    public void removeScene(SceneName name) {
        scenes.remove(name);
    }

    public void setGameScene(int numberOfPlayers) {
        final DoubleProperty opacity = sceneLayout.opacityProperty();

        Timeline fade = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                new KeyFrame(new Duration(1000), t -> {
                    sceneLayout.getChildren().remove(0);
                    sceneLayout.getChildren().add(0, new GameStackPane(numberOfPlayers));
                    Timeline fadeIn = new Timeline(
                            new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                            new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                    fadeIn.play();
                }, new KeyValue(opacity, 0.0)));
        fade.play();
    }

    public boolean setScene(final SceneName name) {
            final DoubleProperty opacity = sceneLayout.opacityProperty();

            if (!sceneLayout.getChildren().isEmpty()) {
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(1000), t -> {
                            sceneLayout.getChildren().remove(0);
                            sceneLayout.getChildren().add(0, scenes.get(name.toString()));
                            Timeline fadeIn = new Timeline(
                                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                    new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                            fadeIn.play();
                        }, new KeyValue(opacity, 0.0)));
                fade.play();

            } else {
                sceneLayout.setOpacity(0.0);
                sceneLayout.getChildren().add(scenes.get(name.toString()));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
    }

    public static StackPane getSceneLayout() {
        return sceneLayout;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}