package com.dcu.ie.prisoner.dilemma.model.prisoners.naive;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;

import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.*;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 16-08-2016.
 *
 * Tit for Tat.
 */
public class TitForTatPrisoner extends Prisoner {

    public TitForTatPrisoner(String name) {
        super(name);
    }

    @Override
    protected IteratedPrisonerDilemmaMove calculateMove() {
        IteratedPrisonerDilemmaMove lastMoveOfOpponent = MovesAuditLog.getLastMoveOfOpponent(this);
        if (!lastMoveOfOpponent.equals(NOMOVE)) {
            return lastMoveOfOpponent;
        } else {
            return COOPERATE;
        }
    }
}