package com.hopetoknow.xo.model;

import com.hopetoknow.xo.model.exceptions.InvalidPointException;
import com.hopetoknow.xo.model.exceptions.PointAlreadyOccupiedException;

import java.awt.*;

public class Field {

    public static final int FIELD_SIZE = 3;

    public static final int MIN_COORDINATE = 0;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(Point point) throws InvalidPointException {
        if (!isPointValid(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(Point point, Figure figure) throws InvalidPointException, PointAlreadyOccupiedException {
        if (!isPointValid(point)) {
            throw new InvalidPointException();
        }
        if (field[point.x][point.y] != null) {
            throw new PointAlreadyOccupiedException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean isPointValid(Point point) {
        return isCoordinateValid(point.x) && isCoordinateValid(point.y);
    }

    private boolean isCoordinateValid(int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < FIELD_SIZE;
    }
}
