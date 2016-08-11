package com.dcu.ie.prisoner.dilemma.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class SceneManager {
    private static Logger logger = LogManager.getRootLogger();
    private static StackPane sceneLayout = new StackPane();
    private Map<String, Node> scenes = new HashMap<>();

    public void addScene(String name, Node scene) {
        scenes.put(name, scene);
    }

    public Node getScreen(String name) {
        return scenes.get(name);
    }

    public void loadScene(String name) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(name + ".fxml"));
            addScene(name, root);
        } catch (IOException e) {
            logger.error("Error occurred whilst loading scene\n" + e.getMessage());
        }
    }

    public void removeScene(SceneName name) {
        scenes.remove(name);
    }

    public boolean setScene(final SceneName name) {
            final DoubleProperty opacity = sceneLayout.opacityProperty();

            if (!sceneLayout.getChildren().isEmpty()) {
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                sceneLayout.getChildren().remove(0);
                                sceneLayout.getChildren().add(0, scenes.get(name.toString()));
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                                fadeIn.play();
                            }
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
}