package com.dcu.ie.prisoner.dilemma.model.prisoners.sentient;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;

import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.*;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 17-08-2016.
 */
public class UnforgivingPrisoner extends Prisoner {
    private boolean cooperate = true;

    public UnforgivingPrisoner(String name, MovesAuditLog auditLog) {
        super(name, auditLog);
    }

    @Override
    protected IteratedPrisonerDilemmaMove calculateMove() {
        if(auditLog.getLastMoveOfOpponent(this).equals(DEFECT)) {
            cooperate = false;
        }
        return cooperate ? COOPERATE : DEFECT;
    }
}
