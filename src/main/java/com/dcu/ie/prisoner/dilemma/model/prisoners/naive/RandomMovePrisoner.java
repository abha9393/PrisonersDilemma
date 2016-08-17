package com.dcu.ie.prisoner.dilemma.model.prisoners.naive;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 17-08-2016.
 */
public class RandomMovePrisoner extends Prisoner {

    public RandomMovePrisoner(String name, MovesAuditLog auditLog) {
        super(name, auditLog);
    }

    @Override
    protected IteratedPrisonerDilemmaMove calculateMove() {
        return IteratedPrisonerDilemmaMove.randomMove();
    }
}
