package com.dcu.ie.prisoner.dilemma.model;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 15-08-2016.
 */
public class MovesAuditLog {

    private static List<ImmutablePair<Prisoner, IteratedPrisonerDilemmaMove>> historyOfMoves = new ArrayList<>();

    public List<ImmutablePair<Prisoner, IteratedPrisonerDilemmaMove>> getHistoryOfMoves() {
        return historyOfMoves;
    }

    public void addMoveToHistory(Prisoner prisoner, IteratedPrisonerDilemmaMove move) {
        MovesAuditLog.historyOfMoves.add(new ImmutablePair<>(prisoner, move));
    }

    public IteratedPrisonerDilemmaMove getLastMoveOfOpponent(Prisoner prisoner) {
        return MovesAuditLog.historyOfMoves.stream().filter(record -> record.getLeft().isOpponent(prisoner)).reduce((a, b) -> b).orElse(new ImmutablePair<>(prisoner, IteratedPrisonerDilemmaMove.NOMOVE)).getRight();
    }

    public List<ImmutablePair<Prisoner, IteratedPrisonerDilemmaMove>> getReverseMovesOfOpponent(Prisoner prisoner) {
        List<ImmutablePair<Prisoner, IteratedPrisonerDilemmaMove>> reverseMoves = new ArrayList<>();
        int i = historyOfMoves.size() - 1;
        for (ImmutablePair<Prisoner, IteratedPrisonerDilemmaMove> move : historyOfMoves) {
            if(!historyOfMoves.get(i).getLeft().equals(prisoner)) {
                reverseMoves.add(historyOfMoves.get(i--));
            }
        }
        return reverseMoves;
    }
}