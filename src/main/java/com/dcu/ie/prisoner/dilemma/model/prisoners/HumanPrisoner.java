package com.dcu.ie.prisoner.dilemma.model.prisoners;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 15-08-2016.
 */
public class HumanPrisoner extends Prisoner {

    public HumanPrisoner(String name, MovesAuditLog auditLog) {
        super(name, auditLog);
    }

    public void setHumanMove(IteratedPrisonerDilemmaMove move) {
        currentMove = move;
    }

    @Override
    protected IteratedPrisonerDilemmaMove calculateMove() {
        return currentMove;
    }
}