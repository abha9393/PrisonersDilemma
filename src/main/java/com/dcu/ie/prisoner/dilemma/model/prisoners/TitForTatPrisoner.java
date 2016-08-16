package com.dcu.ie.prisoner.dilemma.model.prisoners;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 16-08-2016.
 */
public class TitForTatPrisoner extends Prisoner {

    public TitForTatPrisoner(String name, MovesAuditLog auditLog) {
        super(name, auditLog);
    }

    @Override
    protected IteratedPrisonerDilemmaMove calculateMove() {
        IteratedPrisonerDilemmaMove lastMoveOfOpponent = auditLog.getLastMoveOfOpponent(this);
        if (!lastMoveOfOpponent.equals(IteratedPrisonerDilemmaMove.NOMOVE)) {
            return lastMoveOfOpponent;
        } else {
            return IteratedPrisonerDilemmaMove.COOPERATE;
        }
    }
}