package com.hopetoknow.xo.controllers;

import com.hopetoknow.xo.model.Field;
import com.hopetoknow.xo.model.Figure;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CurrentMoveControllerTest {

    CurrentMoveController currentMoveController = new CurrentMoveController();

    Field field = new Field(6);

    @Test
    void currentMoveWithEmptyField() {
        Figure testFigure = Figure.X;
        Figure expectedFigure = testFigure;

        Figure actualFigure = currentMoveController.getCurrentMove(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    void currentMoveWithFilledField() throws Exception {
        Figure testFigureX = Figure.X;
        Figure testFigureO = Figure.O;
        int countFigure = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++){
                if (countFigure % 2 == 0) {
                    field.setFigure(new Point(i, j), testFigureX);
                } else {
                    field.setFigure(new Point(i, j), testFigureO);
                }
                countFigure++;
            }
        }

        Figure actualFigure = currentMoveController.getCurrentMove(field);

        assertNull(actualFigure);
    }

    @Test
    void currentMoveWhenOShouldMove() throws Exception {
        Figure testFigure = Figure.X;
        Figure expectedFigure = Figure.O;
        field.setFigure(new Point(0, 0), testFigure);

        Figure actualFigure = currentMoveController.getCurrentMove(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    void currentMoveWhenXShouldMove() throws Exception {
        Figure testFigureX = Figure.X;
        Figure testFigureO = Figure.O;
        Figure expectedFigure = testFigureX;
        field.setFigure(new Point(0, 0), testFigureX);
        field.setFigure(new Point(0, 1), testFigureO);

        Figure actualFigure = currentMoveController.getCurrentMove(field);

        assertEquals(expectedFigure, actualFigure);
    }

}