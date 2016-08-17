package com.dcu.ie.prisoner.dilemma.model;

import com.dcu.ie.prisoner.dilemma.model.prisoners.Prisoner;
import com.dcu.ie.prisoner.dilemma.model.prisoners.TitForTat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.COOPERATE;
import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.DEFECT;
import static com.dcu.ie.prisoner.dilemma.IteratedPrisonerDilemmaMove.NOMOVE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Abha Aggarwal
 * @version 1.0
 * @since 16-08-2016.
 */
public class MovesAuditLogTest {
    MovesAuditLog auditLog;

    Prisoner firstPrisoner;
    Prisoner secondPrisoner;

    @Before
    public void setUp() {
        auditLog = new MovesAuditLog();
        firstPrisoner = new TitForTat("Charlie", auditLog);
        secondPrisoner = new TitForTat("Jack", auditLog);
    }

    @After
    public void tearDown() {
        auditLog = null;
        firstPrisoner = null;
        secondPrisoner = null;
    }

    @Test
    public void checkAuditLog_withOneMovePresent() {
        auditLog.addMoveToHistory(firstPrisoner, COOPERATE);
        auditLog.addMoveToHistory(secondPrisoner, DEFECT);

        assertThat(auditLog.getLastMoveOfOpponent(firstPrisoner), is(DEFECT));
    }

    @Test
    public void checkAuditLog_withNoMovePresent() {
        assertThat(auditLog.getLastMoveOfOpponent(firstPrisoner), is(NOMOVE));
    }
}