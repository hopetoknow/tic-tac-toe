package com.hopetoknow.xo.model;

import com.hopetoknow.xo.model.exceptions.InvalidPointException;
import com.hopetoknow.xo.model.exceptions.PointAlreadyOccupiedException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    private Field field = new Field();

    private Point point = new Point(0, 0);

    @Test
    void getSize() {
        int expectedSize = 3;

        int actualSize = field.getSize();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void setFigure() throws Exception {
        Figure testFigure = Figure.O;
        Figure expectedFigure = testFigure;

        field.setFigure(point, testFigure);
        Figure actualFigure = field.getFigure(point);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    void setFigureWhenPointAlreadyOccupied() throws Exception {
        Figure testFigure = Figure.O;

        field.setFigure(point, testFigure);

        try {
            field.setFigure(point, testFigure);
            fail();
        } catch (PointAlreadyOccupiedException e) {}
    }


    @Test
    void getFigureWhenFigureIsNotSet() throws Exception {
        Figure actualFigure = field.getFigure(point);

        assertNull(actualFigure);
    }

    @Test
    void getFigureWhenXCoordinateIsLessThanZero() {
        point = new Point(-1 ,0);
        try {
            field.getFigure(point);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    void getFigureWhenYCoordinateIsLessThanZero() {
        point = new Point(0 ,-1);
        try {
            field.getFigure(point);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    void getFigureWhenXCoordinateIsMoreThanFieldSize() {
        point = new Point(field.getSize(), 0);
        try {
            field.getFigure(point);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    void getFigureWhenYCoordinateIsMoreThanFieldSize() {
        point = new Point(0,field.getSize());
        try {
            field.getFigure(point);
            fail();
        } catch (InvalidPointException e) {}
    }

}