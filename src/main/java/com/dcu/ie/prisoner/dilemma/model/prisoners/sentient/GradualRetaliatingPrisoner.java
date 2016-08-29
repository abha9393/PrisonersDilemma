package com.dcu.ie.prisoner.dilemma.model.prisoners.sentient;

import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove.COOPERATE;
import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove.DEFECT;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 17-08-2016.
 *
 * Punishes increases with number of defects.
 */
public class GradualRetaliatingPrisoner extends ForgivingRetaliatingPrisoner {

    public GradualRetaliatingPrisoner(String name) {
        super(name);
    }

    @Override
    protected void addPunishingMoves() {
        for (int i = 0; i < numberOfDefections; i++) {
            futureMoves.add(DEFECT);
        }
        futureMoves.add(COOPERATE);
        futureMoves.add(COOPERATE);
    }
}
