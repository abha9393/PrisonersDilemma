package com.dcu.ie.prisoner.dilemma.model.prisoners.sentient;

import com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;

import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove.COOPERATE;
import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove.DEFECT;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 17-08-2016.
 *
 * Punishes and then forgives.
 */
public class ForgivingRetaliatingPrisoner extends StrategicPrisoner {
    protected int numberOfDefections = 0;

    public ForgivingRetaliatingPrisoner(String name) {
        super(name);
    }

    @Override
    protected IteratedPrisonerDilemmaMove calculateMove() {
        if (futureMoves.isEmpty()) {
            if (MovesAuditLog.getLastMoveOfOpponent(this).equals(COOPERATE)) {
                return COOPERATE;
            }
            else {
                numberOfDefections++;
                addPunishingMoves();
            }
        }
        currentMove = futureMoves.remove(0);
        return currentMove;
    }

    protected void addPunishingMoves() {
        futureMoves.add(DEFECT);
        futureMoves.add(DEFECT);
        futureMoves.add(DEFECT);
        futureMoves.add(DEFECT);
        futureMoves.add(DEFECT);
        futureMoves.add(COOPERATE);
        futureMoves.add(COOPERATE);
    }
}
