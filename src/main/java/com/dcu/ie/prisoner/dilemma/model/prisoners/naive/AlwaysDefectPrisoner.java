package com.dcu.ie.prisoner.dilemma.model.prisoners.naive;

import com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove;
import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;

import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.DEFECT;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 17-08-2016.
 *
 * Always Unfaithful.
 */
public class AlwaysDefectPrisoner extends Prisoner {

    public AlwaysDefectPrisoner(String name) {
        super(name);
    }

    @Override
    protected IteratedPrisonerDilemmaMove calculateMove() {
        return DEFECT;
    }
}
