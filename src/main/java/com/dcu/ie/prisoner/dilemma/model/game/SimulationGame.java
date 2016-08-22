package com.dcu.ie.prisoner.dilemma.model.game;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 21-08-2016.
 */
public class SimulationGame extends IteratedPrisonersDilemmaGame {

    public SimulationGame(int numberOfPrisoners, int numberOfRounds) {
        super(numberOfPrisoners, false, numberOfRounds);
    }

    public void playRounds() {
        for (int i = 0; i < numberOfRounds; i++) {
            playRound();
        }
    }
}
