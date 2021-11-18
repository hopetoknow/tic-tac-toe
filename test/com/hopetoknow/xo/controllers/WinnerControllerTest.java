package com.hopetoknow.xo.controllers;

import com.hopetoknow.xo.model.Field;
import com.hopetoknow.xo.model.Figure;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {

    WinnerController winnerController = new WinnerController();

    Field field = new Field(6);

    @Test
    void getColumnWinner() throws Exception {
        Figure testFigure = Figure.X;
        Figure expectedFigure = testFigure;
        for (int i = 0; i < field.getSize(); i++) {
            field.setFigure(new Point(1, i), testFigure);
        }

        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    void getNoColumnWinner() throws Exception {
        Figure testFigureX = Figure.X;
        Figure testFigureO = Figure.O;
        for (int i = 0; i < field.getSize() - 1; i++) {
            field.setFigure(new Point(1, i), testFigureX);
        }
        field.setFigure(new Point(1, field.getSize() - 1), testFigureO);

        Figure actualFigure = winnerController.getWinner(field);

        assertNull(actualFigure);
    }

    @Test
    void getRowWinner() throws Exception {
        Figure testFigure = Figure.X;
        Figure expectedFigure = testFigure;
        for (int i = 0; i < field.getSize(); i++) {
            field.setFigure(new Point(i, 1), testFigure);
        }

        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    void getNoRowWinner() throws Exception {
        Figure testFigureX = Figure.X;
        Figure testFigureO = Figure.O;
        for (int i = 0; i < field.getSize() - 1; i++) {
            field.setFigure(new Point(i, 1), testFigureX);
        }
        field.setFigure(new Point(field.getSize() - 1, 1), testFigureO);

        Figure actualFigure = winnerController.getWinner(field);

        assertNull(actualFigure);
    }

    @Test
    void getFirstDiagonalWinner() throws Exception {
        Figure testFigure = Figure.X;
        Figure expectedFigure = testFigure;
        for (int i = 0; i < field.getSize(); i++) {
            field.setFigure(new Point(i, i), testFigure);
        }

        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    void getNoFirstDiagonalWinner() throws Exception {
        Figure testFigureX = Figure.X;
        Figure testFigureO = Figure.O;
        for (int i = 0; i < field.getSize() - 1; i++) {
            field.setFigure(new Point(i, i), testFigureX);
        }
        field.setFigure(new Point(field.getSize() - 1, field.getSize() - 1), testFigureO);

        Figure actualFigure = winnerController.getWinner(field);

        assertNull(actualFigure);
    }

    @Test
    void getSecondDiagonalWinner() throws Exception {
        Figure testFigure = Figure.X;
        Figure expectedFigure = testFigure;
        for (int i = 0, j = field.getSize() - 1; i < field.getSize(); i++, j--) {
            field.setFigure(new Point(i, j), testFigure);
        }

        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    void getNoSecondDiagonalWinner() throws Exception {
        Figure testFigureX = Figure.X;
        Figure testFigureO = Figure.O;
        for (int i = 0, j = field.getSize() - 1; i < field.getSize() - 1; i++, j--) {
            field.setFigure(new Point(i, j), testFigureX);
        }
        field.setFigure(new Point(field.getSize() - 1, 0), testFigureO);

        Figure actualFigure = winnerController.getWinner(field);

        assertNull(actualFigure);
    }

}