package com.dcu.ie.prisoner.dilemma.model.prisoners.sentient;

import com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;

import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove.*;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 17-08-2016.
 *
 * Cooperates based on historic moves.
 */
public class OptimisticPrisoner extends Prisoner {
    private static final int COOPERATION_REWARD = 1;
    private static final int DEFECTION_PUNISHMENT = -1;
    private double score = 0.0;
    private int numberOfMoves = 0;

    public OptimisticPrisoner(String name) {
        super(name);
    }

    @Override
    protected IteratedPrisonerDilemmaMove calculateMove() {
        score += MovesAuditLog.getLastMoveOfOpponent(this).equals(COOPERATE)? COOPERATION_REWARD : DEFECTION_PUNISHMENT;
        return (score/++numberOfMoves) > 0 ? COOPERATE : DEFECT;
    }
}
