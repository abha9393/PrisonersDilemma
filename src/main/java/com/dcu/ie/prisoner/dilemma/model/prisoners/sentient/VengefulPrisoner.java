package com.dcu.ie.prisoner.dilemma.model.prisoners.sentient;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.MovesAuditLog;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;

import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.COOPERATE;
import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.DEFECT;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 18-08-2016.
 *
 * Vengeful when realises other strategy has spiralled into defects only. Otherwise, mimics last five moves.
 */
public class VengefulPrisoner extends StrategicPrisoner {

    private boolean turnUnforgiving = false;

    public VengefulPrisoner(String name) {
        super(name);
    }

    @Override
    protected IteratedPrisonerDilemmaMove calculateMove() {
        if(turnUnforgiving) {
            return DEFECT;
        }
        else if (futureMoves.isEmpty()) {
            if (MovesAuditLog.getLastMoveOfOpponent(this).equals(COOPERATE)) {
                return COOPERATE;
            } else {
                List<ImmutablePair<Prisoner, IteratedPrisonerDilemmaMove>> reverseOpponentMoves = MovesAuditLog.getReverseMovesOfOpponent(this);
                if(reverseOpponentMoves.size() > 5) {
                    for (int i = 0; i < 6; i++) {
                        if(!reverseOpponentMoves.get(i).equals(DEFECT)) {
                            mimicLastFiveMoves(reverseOpponentMoves);
                            break;
                        }
                        turnUnforgiving = true;
                        return DEFECT;
                     }
                }
            }
        }
        currentMove = futureMoves.remove(0);
        return currentMove;
    }

    private void mimicLastFiveMoves(List<ImmutablePair<Prisoner, IteratedPrisonerDilemmaMove>> reverseOpponentMoves) {
        for (int i = 0; i < 6; i++) {
            futureMoves.add(reverseOpponentMoves.get(i).getRight());
        }
    }
}
