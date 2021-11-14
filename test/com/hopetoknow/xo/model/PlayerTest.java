package com.hopetoknow.xo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        final String testName = "Bobby";
        final String expectedName = testName;

        final Player player = new Player(testName, null);
        final String actualName = player.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    void getFigure() {
        final Figure testFigure = Figure.X;
        final Figure expectedFigure = testFigure;

        final Player player = new Player(null, testFigure);
        final Figure actualFigure = player.getFigure();

        assertEquals(expectedFigure, actualFigure);
    }
}