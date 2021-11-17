package com.hopetoknow.xo.controllers;

import com.hopetoknow.xo.model.Field;
import com.hopetoknow.xo.model.Figure;
import com.hopetoknow.xo.model.exceptions.InvalidPointException;
import com.hopetoknow.xo.model.exceptions.PointAlreadyOccupiedException;

import java.awt.*;

public class MoveController {

    public void applyFigure(Field field, Point point, Figure figure) throws InvalidPointException, PointAlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new PointAlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
