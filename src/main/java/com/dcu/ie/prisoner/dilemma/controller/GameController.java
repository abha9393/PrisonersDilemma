package com.dcu.ie.prisoner.dilemma.controller;

import com.dcu.ie.prisoner.dilemma.model.game.IteratedPrisonersDilemmaGame;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.naive.AlwaysCooperatePrisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.naive.AlwaysDefectPrisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.naive.ContinuousSwitchingPrisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.naive.RandomMovePrisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.naive.TitForTatPrisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.naive.UnforgivingPrisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.sentient.ForgivingRetaliatingPrisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.sentient.GradualRetaliatingPrisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.sentient.OptimisticProbabilisticPrisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.sentient.VengefulPrisoner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonersDilemmaOutcome.REWARD;
import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonersDilemmaOutcome.TEMPTATION;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 11-08-2016.
 */
public class GameController extends BorderPane {
    private static Logger logger = LogManager.getLogger(GameController.class);

    @FXML
    private ComboBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    @FXML
    private FlowPane f1, f2, f3, f4, f5, f6, f7, f8, f9, f10;
    @FXML
    private TextArea t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    @FXML
    private RadioMenuItem round10, round100, round500, round1000;

    private List<ComboBox> comboBoxes = new ArrayList<>(10);
    private ToggleGroup toggleGroup;
    private int numberOfRounds = 1000;

    private List<Prisoner> prisoners = new ArrayList<>(10);
    private List<FlowPane> flowPanes = new ArrayList<>(10);
    private List<TextArea> texts = new ArrayList<>(10);
    private IteratedPrisonersDilemmaGame game;

    public GameController() {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("LaunchGame.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        toggleGroup = new ToggleGroup();
        round10.setToggleGroup(toggleGroup);
        round100.setToggleGroup(toggleGroup);
        round500.setToggleGroup(toggleGroup);
        round1000.setToggleGroup(toggleGroup);

        comboBoxes.add(c1);
        comboBoxes.add(c2);
        comboBoxes.add(c3);
        comboBoxes.add(c4);
        comboBoxes.add(c5);
        comboBoxes.add(c6);
        comboBoxes.add(c7);
        comboBoxes.add(c8);
        comboBoxes.add(c9);
        comboBoxes.add(c10);

        flowPanes.add(f1);
        flowPanes.add(f2);
        flowPanes.add(f3);
        flowPanes.add(f4);
        flowPanes.add(f5);
        flowPanes.add(f6);
        flowPanes.add(f7);
        flowPanes.add(f8);
        flowPanes.add(f9);
        flowPanes.add(f10);

        texts.add(t1);
        texts.add(t2);
        texts.add(t3);
        texts.add(t4);
        texts.add(t5);
        texts.add(t6);
        texts.add(t7);
        texts.add(t8);
        texts.add(t9);
        texts.add(t10);
    }

    public void cooperate(ActionEvent actionEvent) {

    }

    public void addShadowEffect(MouseEvent mouseEvent) {
        ((Button) mouseEvent.getSource()).setEffect(new DropShadow());
    }

    public void removeShadowEffect(MouseEvent mouseEvent) {
        ((Button) mouseEvent.getSource()).setEffect(null);
    }

    public void closeWindow(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void switchPrisonerType(ActionEvent actionEvent) {

    }

    public void setUpGame(ActionEvent actionEvent) {
        assignPrisoners();
        game = new IteratedPrisonersDilemmaGame(prisoners, numberOfRounds);
    }

    public void runSimulation(ActionEvent actionEvent) throws InterruptedException {
        for (int i = 0; i < numberOfRounds; i++) {
            runRound(actionEvent);
            Thread.sleep(2000);
        }
    }

    public void runRound(ActionEvent actionEvent) {
        game.playRound();
        for (int j = 0; j < texts.size(); j++) {
            Prisoner prisoner = prisoners.get(j);

            texts.get(j).setText("              Score: " + prisoner.getPoints());

            Button button = new Button(prisoner.getCurrentMove().getInitial());

            flowPanes.get(j).getChildren().add(button);

            if (prisoner.getCurrentOutcome().equals(REWARD)) {
                button.setStyle("-fx-background-color: linear-gradient(#68228B, #9A32CD);");
            }
            else if (prisoner.getCurrentOutcome().equals(TEMPTATION)) {
                button.setStyle("-fx-background-color: linear-gradient(#0000cc, #0000b2);");
            }
        }
    }

    private void assignPrisoners() {
        prisoners = new ArrayList<>(10);
        for (ComboBox comboBox : comboBoxes) {
            String value = (String) comboBox.getSelectionModel().getSelectedItem();
            if (value == null) {
                comboBox.getSelectionModel().clearAndSelect(0);
                prisoners.add(new AlwaysCooperatePrisoner("Prisoner" + prisoners.size() + 1));
            }
            else if (value.equals("Always Cooperate")) {
                prisoners.add(new AlwaysCooperatePrisoner("Prisoner" + prisoners.size() + 1));
            }
            else if (value.equals("Always Defect")) {
                prisoners.add(new AlwaysDefectPrisoner("Prisoner" + prisoners.size() + 1));
            }
            else if (value.equals("Tit-for-Tat")) {
                prisoners.add(new TitForTatPrisoner("Prisoner" + prisoners.size() + 1));
            }
            else if (value.equals("Continuous Switching")) {
                prisoners.add(new ContinuousSwitchingPrisoner("Prisoner" + prisoners.size() + 1));
            }
            else if (value.equals("Gradual")) {
                prisoners.add(new GradualRetaliatingPrisoner("Prisoner" + prisoners.size() + 1));
            }
            else if (value.equals("Forgiving - Retaliating")) {
                prisoners.add(new ForgivingRetaliatingPrisoner("Prisoner" + prisoners.size() + 1));
            }
            else if (value.equals("Unforgiving")) {
                prisoners.add(new UnforgivingPrisoner("Prisoner" + prisoners.size() + 1));
            }
            else if (value.equals("Probabilistic")) {
                prisoners.add(new OptimisticProbabilisticPrisoner("Prisoner" + prisoners.size() + 1));
            }
            else if (value.equals("Prober")) {
                prisoners.add(new VengefulPrisoner("Prisoner" + prisoners.size() + 1));
            }
            else if (value.equals("Random")) {
                prisoners.add(new RandomMovePrisoner("Prisoner" + prisoners.size() + 1));
            }
        }
    }

    public void selectRounds(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(round10)) {
            numberOfRounds = 10;
        }
        else if (actionEvent.getSource().equals(round100)) {
            numberOfRounds = 100;
        }
        else if (actionEvent.getSource().equals(round500)) {
            numberOfRounds = 500;
        }
        else {
            numberOfRounds = 1000;
        }
    }
}
