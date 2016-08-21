package com.dcu.ie.prisoner.dilemma.model;

import com.dcu.ie.prisoner.dilemma.model.prisoners.HumanPrisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;

import java.util.ArrayList;
import java.util.List;

import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove.DEFECT;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 11-08-2016.
 */
public class IteratedPrisonersDilemmaGame {
    private List<Prisoner> prisoners;

    public IteratedPrisonersDilemmaGame(int numberOfPrisoners, boolean isFirstPrisonerHuman) {
        prisoners = new ArrayList<>(numberOfPrisoners);

        if(isFirstPrisonerHuman) {
            prisoners.add(new HumanPrisoner("Human"));
        }
    }

    public void makeMoveAndScoreRound() {
        prisoners.forEach(prisoner -> prisoner.makeMove());

        boolean atLeastOneDefect = checkIfThereIsAtLeastOneDefectMove();

        for (Prisoner prisoner : prisoners) {

        }
    }

    private boolean checkIfThereIsAtLeastOneDefectMove() {
         return prisoners.stream()
                .map(prisoner -> prisoner.getCurrentMove())
                .filter(move -> move.equals(DEFECT))
                .count() > 0;
    }

}