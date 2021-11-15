package com.hopetoknow.xo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        String testName = "Bobby";
        String expectedName = testName;

        Player player = new Player(testName, null);
        String actualName = player.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    void getFigure() {
        Figure testFigure = Figure.X;
        Figure expectedFigure = testFigure;

        Player player = new Player(null, testFigure);
        Figure actualFigure = player.getFigure();

        assertEquals(expectedFigure, actualFigure);
    }
}