package com.dcu.ie.prisoner.dilemma.model.prisoners.sentient;

import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;

import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.COOPERATE;
import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.DEFECT;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 17-08-2016.
 */
public class ForgivingGradualPrisoner extends ForgivingSpitefulPrisoner {

    public ForgivingGradualPrisoner(String name, MovesAuditLog auditLog) {
        super(name, auditLog);
    }

    @Override
    protected void addSpitefulMoves() {
        for (int i = 0; i < numberOfDefections; i++) {
            futureMoves.add(DEFECT);
        }
        futureMoves.add(COOPERATE);
        futureMoves.add(COOPERATE);
    }
}
