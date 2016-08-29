package com.dcu.ie.prisoner.dilemma.model.game;

import com.dcu.ie.prisoner.dilemma.model.prisoners.HumanPrisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;

import java.util.ArrayList;
import java.util.List;

import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove.DEFECT;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 11-08-2016.
 */
public class IteratedPrisonersDilemmaGame {
    private List<Prisoner> prisoners;
    protected int numberOfRounds;
    private int currentRound;
    private int numberOfPrisoners;

    public IteratedPrisonersDilemmaGame(List<Prisoner> prisoners, int numberOfRounds) {
        this.prisoners = prisoners;
        numberOfPrisoners = prisoners.size();
        this.numberOfRounds = numberOfRounds;
        currentRound = 0;
    }

    public IteratedPrisonersDilemmaGame(int numberOfPrisoners, boolean isFirstPrisonerHuman, int numberOfRounds) {
        prisoners = new ArrayList<>(numberOfPrisoners);
        this.numberOfRounds = numberOfRounds;
        currentRound = 0;

        if(isFirstPrisonerHuman) {
            prisoners.add(new HumanPrisoner("Human"));
        }
    }

    public void playRound() {
        if(currentRound < numberOfRounds) {
            makeAllPrisonersMoveInTheRound();
            scorePointsForAllPrisonersInTheRound();
            currentRound++;
        }
    }

    protected void makeAllPrisonersMoveInTheRound() {
        prisoners.forEach(prisoner -> prisoner.makeMove());
    }

    protected void scorePointsForAllPrisonersInTheRound() {
        int numberOfDefects = getNumberOfDefectedPrisoners();

        prisoners.forEach(prisoner -> prisoner.scorePoints(numberOfDefects, numberOfPrisoners - numberOfDefects, numberOfPrisoners));
    }

    private int getNumberOfDefectedPrisoners() {
         return (int) prisoners.stream()
                .map(prisoner -> prisoner.getCurrentMove())
                .filter(move -> move.equals(DEFECT))
                .count();
    }
}