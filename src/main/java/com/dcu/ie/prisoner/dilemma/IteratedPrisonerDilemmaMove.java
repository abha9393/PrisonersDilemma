package com.dcu.ie.prisoner.dilemma;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Abha Aggarwal
 * @version 2.0
 * @since 15-08-2016.
 */
public enum IteratedPrisonerDilemmaMove {
    COOPERATE, DEFECT, NOMOVE;

    private static final List<IteratedPrisonerDilemmaMove> MOVES = Collections.unmodifiableList(Arrays.asList(new IteratedPrisonerDilemmaMove[]{COOPERATE, DEFECT}));
    private static final int SIZE = MOVES.size();
    private static final Random RANDOM = new Random();

    public static IteratedPrisonerDilemmaMove randomMove()  {
        return MOVES.get(RANDOM.nextInt(SIZE));
    }
}