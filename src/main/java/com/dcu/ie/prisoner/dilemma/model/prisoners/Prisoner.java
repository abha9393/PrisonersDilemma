package com.dcu.ie.prisoner.dilemma.model.prisoners;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 15-08-2016.
 */
public abstract class Prisoner {

    protected String name;
    protected String type;
    protected IteratedPrisonerDilemmaMove currentMove;
    protected int points;

    public Prisoner(String name) {
        this.name = name;
        this.type = this.getClass().getSimpleName();
    }

    public IteratedPrisonerDilemmaMove getCurrentMove() {
        return currentMove;
    }

    public int getPoints() {
        return points;
    }

    protected void makeCurrentMove(){
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
}
