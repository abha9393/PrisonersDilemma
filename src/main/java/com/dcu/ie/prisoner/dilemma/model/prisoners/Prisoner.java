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
    private int points;
    private int lengthOfSentenceInYears;

    public Prisoner(String name) {
        this.name = name;
        this.type = this.getClass().getSimpleName();
        points = 0;
        lengthOfSentenceInYears = 0;
        currentMove = NOMOVE;
        currentOutcome = NIL;
    }

    public IteratedPrisonersDilemmaOutcome getCurrentOutcome() {
        return currentOutcome;
    }

    public IteratedPrisonerDilemmaMove getCurrentMove() {
        return currentMove;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLengthOfSentenceInYears() {
        return lengthOfSentenceInYears;
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

    public void scorePoints(boolean atLeastOneDefected, boolean allDefected) {
        switch (currentMove) {
            case COOPERATE:
                if (atLeastOneDefected) {
                    currentOutcome = SUCKER_PAYOFF;
                }
                else {
                    currentOutcome = REWARD;
                }
                break;
            case DEFECT:
                if (allDefected) {
                    currentOutcome = PUNISHMENT;
                }
                else {
                    currentOutcome = TEMPTATION;
                }
                break;
        }
        setPoints();
    }

    private void setPoints() {
        points += currentOutcome.getPoints();
        lengthOfSentenceInYears += currentOutcome.getLengthOfSentenceInYears();
    }
}
