package com.dcu.ie.prisoner.dilemma.model.prisoners.naive;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;

import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.COOPERATE;
import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.DEFECT;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 17-08-2016.
 *
 * Unstable decision maker.
 */
public class ContinuousSwitchingPrisoner extends Prisoner {

    public ContinuousSwitchingPrisoner(String name) {
        super(name);
    }

    @Override
    protected IteratedPrisonerDilemmaMove calculateMove() {
        return currentMove.equals(COOPERATE)? DEFECT : COOPERATE;
    }
}
