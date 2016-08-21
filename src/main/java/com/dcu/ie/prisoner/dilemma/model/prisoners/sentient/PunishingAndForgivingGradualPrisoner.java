package com.dcu.ie.prisoner.dilemma.model.prisoners.sentient;

import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.COOPERATE;
import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.DEFECT;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 17-08-2016.
 *
 * Punishes increases with number of defects.
 */
public class PunishingAndForgivingGradualPrisoner extends PunishingAndForgivingPrisoner {

    public PunishingAndForgivingGradualPrisoner(String name) {
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
