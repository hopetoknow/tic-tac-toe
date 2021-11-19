package com.hopetoknow.xo.controllers;

import com.hopetoknow.xo.model.Field;
import com.hopetoknow.xo.model.Figure;
import com.hopetoknow.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(Field field) {
        int figureCounter = 0;
        for (int i = 0; i < field.getSize(); i++) {
            figureCounter += countFiguresInRow(field, i);
        }

        if (figureCounter == field.getSize() * field.getSize()) {
            return null;
        }

        if (figureCounter % 2 != 0) {
            return Figure.O;
        }
        return Figure.X;
    }

    private int countFiguresInRow(Field field, int row) {
        int figureCounter = 0;

        for (int i = 0; i < field.getSize(); i++) {
            try {
                if (field.getFigure(new Point(i, row)) != null) {
                    figureCounter++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return figureCounter;
    }

}
