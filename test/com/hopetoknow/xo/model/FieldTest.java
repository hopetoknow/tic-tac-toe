package com.hopetoknow.xo.model;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getSize() {
        final int expectedSize = 3;

        final Field field = new Field();
        final int actualSize = field.getSize();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void setFigure() {
        final Field field = new Field();
        final Point point = new Point(0, 0);
        final Figure testFigure = Figure.O;
        final Figure expectedFigure = testFigure;

        field.setFigure(point, testFigure);
        final Figure actualFigure = field.getFigure(point);

        assertEquals(expectedFigure, actualFigure);
    }
}