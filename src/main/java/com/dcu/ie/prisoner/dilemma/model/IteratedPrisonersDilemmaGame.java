package com.dcu.ie.prisoner.dilemma.model;

import com.dcu.ie.prisoner.dilemma.model.prisoners.HumanPrisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 11-08-2016.
 */
public class IteratedPrisonersDilemmaGame {
    private List<Prisoner> prisoners;
    private MovesAuditLog movesAuditLog;

    public IteratedPrisonersDilemmaGame(int numberOfPrisoners, boolean isFirstPrisonerHuman) {
        prisoners = new ArrayList<>(numberOfPrisoners);
        movesAuditLog = new MovesAuditLog();

        if(isFirstPrisonerHuman) {
            prisoners.add(new HumanPrisoner("Human"));
        }
    }

    public void scoreRound() {

    }

}