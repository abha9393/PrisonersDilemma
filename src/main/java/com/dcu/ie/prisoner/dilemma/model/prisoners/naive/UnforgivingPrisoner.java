package com.dcu.ie.prisoner.dilemma.model.prisoners.naive;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;

import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.*;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 17-08-2016.
 *
 * No second chances.
 */
public class UnforgivingPrisoner extends Prisoner {
    private boolean cooperate = true;

    public UnforgivingPrisoner(String name) {
        super(name);
    }

    @Override
    protected IteratedPrisonerDilemmaMove calculateMove() {
        if(MovesAuditLog.getLastMoveOfOpponent(this).equals(DEFECT)) {
            cooperate = false;
        }
        return cooperate ? COOPERATE : DEFECT;
    }
}
