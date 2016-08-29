package com.dcu.ie.prisoner.dilemma.model.prisoners;

import com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.IteratedPrisonersDilemmaOutcome;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;

import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove.NOMOVE;
import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonersDilemmaOutcome.NIL;
import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonersDilemmaOutcome.PUNISHMENT;
import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonersDilemmaOutcome.REWARD;
import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonersDilemmaOutcome.SUCKER_PAYOFF;
import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonersDilemmaOutcome.TEMPTATION;

/**
 * @author Abha Aggarwal
 * @version 2.0
 * @since 15-08-2016.
 */
public abstract class Prisoner {

    protected String name;
    private String type;
    protected IteratedPrisonerDilemmaMove currentMove;
    private IteratedPrisonersDilemmaOutcome currentOutcome;
    private int averagePoints;

    public Prisoner(String name) {
        this.name = name;
        this.type = this.getClass().getSimpleName();
        averagePoints = 0;
        currentMove = NOMOVE;
        currentOutcome = NIL;
    }

    public IteratedPrisonersDilemmaOutcome getCurrentOutcome() {
        return currentOutcome;
    }

    public IteratedPrisonerDilemmaMove getCurrentMove() {
        return currentMove;
    }

    public int getAveragePoints() {
        return averagePoints;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLengthOfSentenceInYears() {
        return currentOutcome.getLengthOfSentenceInYears();
    }

    public void makeMove() {
        currentMove = calculateMove();
        MovesAuditLog.addMoveToHistory(this, currentMove);
    }

    protected abstract IteratedPrisonerDilemmaMove calculateMove();

    public boolean isOpponent(Prisoner prisoner) {
        return !prisoner.equals(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void scorePoints(int defected, int cooperated, int numberOfPrisoners) {
        int currentPoints = 0;
        switch (currentMove) {
            case COOPERATE:
                currentPoints = cooperated * REWARD.getPoints();
                currentPoints += cooperated * SUCKER_PAYOFF.getPoints();
                break;
            case DEFECT:
                currentPoints = cooperated * TEMPTATION.getPoints();
                currentPoints += cooperated * PUNISHMENT.getPoints();
                break;
        }
        currentPoints /= numberOfPrisoners;
        averagePoints += currentPoints;
        currentOutcome = IteratedPrisonersDilemmaOutcome.getNearestRoundedOutcomeGivenPoints(Math.round(currentPoints));
    }
}