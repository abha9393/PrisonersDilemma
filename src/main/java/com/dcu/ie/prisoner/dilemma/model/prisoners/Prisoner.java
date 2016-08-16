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
    protected MovesAuditLog auditLog;
    protected IteratedPrisonerDilemmaMove currentMove;
    protected int points;

    public Prisoner(String name, MovesAuditLog auditLog) {
        this.name = name;
        this.auditLog = auditLog;
    }

    public IteratedPrisonerDilemmaMove getCurrentMove() {
        return currentMove;
    }

    public int getPoints() {
        return points;
    }

    protected void makeCurrentMove(){
        currentMove = calculateMove();
        auditLog.addMoveToHistory(this, currentMove);
    }

    protected abstract IteratedPrisonerDilemmaMove calculateMove();

    public boolean isOpponent(Prisoner prisoner) {
        return !prisoner.equals(this);
    }
}
