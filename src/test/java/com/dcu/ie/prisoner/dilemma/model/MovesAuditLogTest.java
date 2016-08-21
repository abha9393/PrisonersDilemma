package com.dcu.ie.prisoner.dilemma.model;

import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.naive.TitForTatPrisoner;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove.COOPERATE;
import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove.DEFECT;
import static com.dcu.ie.prisoner.dilemma.model.IteratedPrisonerDilemmaMove.NOMOVE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 16-08-2016.
 */
public class MovesAuditLogTest {
    Prisoner firstPrisoner;
    Prisoner secondPrisoner;

    @Before
    public void setUp() {
        firstPrisoner = new TitForTatPrisoner("Charlie");
        secondPrisoner = new TitForTatPrisoner("Jack");
    }

    @After
    public void tearDown() {
        firstPrisoner = null;
        secondPrisoner = null;
    }

    @Test
    public void checkAuditLog_withNoMovePresent() throws IllegalAccessException {
        FieldUtils.writeStaticField(MovesAuditLog.class, "historyOfMoves", new ArrayList<>(), true);
        assertThat(MovesAuditLog.getLastMoveOfOpponent(firstPrisoner), is(NOMOVE));
    }

    @Test
    public void checkAuditLog_withOneMovePresent() {
        MovesAuditLog.addMoveToHistory(firstPrisoner, COOPERATE);
        MovesAuditLog.addMoveToHistory(secondPrisoner, DEFECT);

        assertThat(MovesAuditLog.getLastMoveOfOpponent(firstPrisoner), is(DEFECT));
    }
}