package com.dcu.ie.prisoner.dilemma.model;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 21-08-2016.
 */
public enum IteratedPrisonersDilemmaOutcome {
    REWARD("R", 1, 3), TEMPTATION("T", 0, 5), PUNISHMENT("P", 1, 2), SUCKER_PAYOFF("S", 3, 0), NIL("N", -1, -1);

    String initial;
    int lengthOfSentenceInYears;
    int points;

    IteratedPrisonersDilemmaOutcome(String initial, int years, int points) {
        this.initial = initial;
        lengthOfSentenceInYears = years;
        this.points = points;
    }

    public int getLengthOfSentenceInYears() {
        return lengthOfSentenceInYears;
    }

    public int getPoints() {
        return points;
    }

    public static IteratedPrisonersDilemmaOutcome getNearestRoundedOutcomeGivenPoints(int points) {
        if (points > 3 && points <= 5) {
            return TEMPTATION;
        }
        else if (points > 2 && points <= 3) {
            return REWARD;
        }
        else if (points > 0 && points <= 2) {
            return REWARD;
        }
        else return SUCKER_PAYOFF;
    }
}
