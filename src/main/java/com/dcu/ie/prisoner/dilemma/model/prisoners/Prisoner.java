package com.dcu.ie.prisoner.dilemma.model.prisoners;

import com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.IteratedPrisonersDilemmaPoints;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;

import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonersDilemmaPoints.PUNISHMENT;
import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonersDilemmaPoints.REWARD;
import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonersDilemmaPoints.SUCKER_PAYOFF;
import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonersDilemmaPoints.TEMPTATION;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 15-08-2016.
 */
public abstract class Prisoner {

    protected String name;
    private String type;
    protected IteratedPrisonerDilemmaMove currentMove;
    private int points;
    private int lengthOfSentenceInYears;

    public Prisoner(String name) {
        this.name = name;
        this.type = this.getClass().getSimpleName();
        points = 0;
        lengthOfSentenceInYears = 0;
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
                    setPoints(SUCKER_PAYOFF);
                }
                else {
                    setPoints(REWARD);
                }
                break;
            case DEFECT:
                if (allDefected) {
                    setPoints(PUNISHMENT);
                }
                else {
                    setPoints(TEMPTATION);
                }
                break;
        }
    }

    private void setPoints(IteratedPrisonersDilemmaPoints points) {
        this.points += points.getPoints();
        lengthOfSentenceInYears += points.getLengthOfSentenceInYears();
    }
}
