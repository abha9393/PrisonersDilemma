package com.dcu.ie.prisoner.dilemma.model.prisoners.sentient;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;

import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.COOPERATE;
import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.DEFECT;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 17-08-2016.
 */
public class ForgivingSpitefulPrisoner extends StrategicPrisoner {
    protected int numberOfDefections = 0;

    public ForgivingSpitefulPrisoner(String name, MovesAuditLog auditLog) {
        super(name, auditLog);
    }

    @Override
    protected IteratedPrisonerDilemmaMove calculateMove() {
        if (futureMoves.isEmpty()) {
            if (auditLog.getLastMoveOfOpponent(this).equals(COOPERATE)) {
                return COOPERATE;
            }
            else {
                numberOfDefections++;
                addSpitefulMoves();
            }
        }
        currentMove = futureMoves.remove(0);
        return currentMove;
    }

    protected void addSpitefulMoves() {
        futureMoves.add(DEFECT);
        futureMoves.add(DEFECT);
        futureMoves.add(DEFECT);
        futureMoves.add(DEFECT);
        futureMoves.add(DEFECT);
        futureMoves.add(COOPERATE);
        futureMoves.add(COOPERATE);
    }
}
