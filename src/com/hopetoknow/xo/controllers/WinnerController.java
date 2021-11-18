package com.hopetoknow.xo.controllers;

import com.hopetoknow.xo.model.Field;
import com.hopetoknow.xo.model.Figure;
import com.hopetoknow.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(Field field) {
        try {
            if (getColumnWinner(field) != null) {
                return getColumnWinner(field);
            }
            if (getRowWinner(field) != null) {
                return getRowWinner(field);
            }
            if (getFirstDiagonalWinner(field) != null) {
                return getFirstDiagonalWinner(field);
            }
            if (getSecondDiagonalWinner(field) != null) {
                return getSecondDiagonalWinner(field);
            }
        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isFilledWithIdenticalFigures(Field field, Point currentPoint, IPointGenerator generator) {
        Figure currentFigure;
        Figure nextFigure;
        Point nextPoint = generator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);
            if (currentFigure == null) {
                return false;
            }
            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }
        if (currentFigure != nextFigure) {
            return false;
        }
        return isFilledWithIdenticalFigures(field, nextPoint, generator);
    }

    private interface IPointGenerator {
        Point next(Point point);
    }

    private Figure getColumnWinner(Field field) throws InvalidPointException {
        for (int i = 0; i < field.getSize(); i++) {
            if (isFilledWithIdenticalFigures(field, new Point(i, 0), p -> new Point(p.x, p.y + 1))) {
                return field.getFigure(new Point(i, 0));
            }
        }
        return null;
    }

    private Figure getRowWinner(Field field) throws InvalidPointException {
        for (int i = 0; i < field.getSize(); i++) {
            if (isFilledWithIdenticalFigures(field, new Point(0, i), p -> new Point(p.x + 1, p.y))) {
                return field.getFigure(new Point(0, i));
            }
        }
        return null;
    }

    private Figure getFirstDiagonalWinner(Field field) throws InvalidPointException {
        if (isFilledWithIdenticalFigures(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1))) {
            return field.getFigure(new Point(0, 0));
        }
        return null;
    }

    private Figure getSecondDiagonalWinner(Field field) throws InvalidPointException {
        if (isFilledWithIdenticalFigures(field, new Point(0, field.getSize() - 1), p -> new Point(p.x + 1, p.y - 1)))
            return field.getFigure(new Point(0, field.getSize() - 1));

        return null;
    }
}
