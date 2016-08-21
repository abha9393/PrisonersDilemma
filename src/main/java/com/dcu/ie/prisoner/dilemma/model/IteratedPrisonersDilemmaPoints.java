package com.dcu.ie.prisoner.dilemma.model;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 21-08-2016.
 */
public enum IteratedPrisonersDilemmaPoints {
    REWARD(1, 3), TEMPTATION(0, 5), PUNISHMENT(1, 2), SUCKER_PAYOFF(3, 0);

    int lengthOfSentenceInYears;
    int points;

    IteratedPrisonersDilemmaPoints(int years, int points) {
        lengthOfSentenceInYears = years;
        this.points = points;
    }

    public int getLengthOfSentenceInYears() {
        return lengthOfSentenceInYears;
    }

    public int getPoints() {
        return points;
    }
}
