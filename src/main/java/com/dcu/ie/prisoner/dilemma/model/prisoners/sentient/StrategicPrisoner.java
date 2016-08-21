package com.dcu.ie.prisoner.dilemma.model.prisoners.sentient;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 18-08-2016.
 */
public abstract class StrategicPrisoner extends Prisoner {

    protected List<IteratedPrisonerDilemmaMove> futureMoves = new ArrayList<>();

    public StrategicPrisoner(String name, MovesAuditLog auditLog) {
        super(name, auditLog);
    }
}
