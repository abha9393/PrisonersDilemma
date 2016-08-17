package com.dcu.ie.prisoner.dilemma.model.prisoners;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 17-08-2016.
 */
public class AlwaysDefect extends Prisoner {

    public AlwaysDefect(String name, MovesAuditLog auditLog) {
        super(name, auditLog);
    }

    @Override
    protected IteratedPrisonerDilemmaMove calculateMove() {
        return IteratedPrisonerDilemmaMove.DEFECT;
    }
}