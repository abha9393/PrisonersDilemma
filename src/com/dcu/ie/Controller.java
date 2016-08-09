package com.dcu.ie;

import javafx.scene.Node;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Map<String, Node> scenes = new HashMap<>();

    public void addScene(String name, Node scene) {
        scenes.put(name, scene);
    }

}
