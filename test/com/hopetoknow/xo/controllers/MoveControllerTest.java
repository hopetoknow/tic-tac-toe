package com.hopetoknow.xo.controllers;

import com.hopetoknow.xo.model.Field;
import com.hopetoknow.xo.model.Figure;
import com.hopetoknow.xo.model.exceptions.PointAlreadyOccupiedException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MoveControllerTest {

    private Field field = new Field(3);

    private Point point = new Point(0, 0);

    private MoveController moveController = new MoveController();

    @Test
    void applyFigure() throws Exception{
        Figure testFigure = Figure.O;

        moveController.applyFigure(field, point, testFigure);

        try {
            moveController.applyFigure(field, point, testFigure);
            fail();
        } catch (PointAlreadyOccupiedException e) {}
    }

}