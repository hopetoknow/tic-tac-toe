package com.hopetoknow.xo.model;

import com.hopetoknow.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    public static final int MIN_COORDINATE = 0;

    private final int fieldSize;

    private final Figure[][] field;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

    public int getSize() {
        return fieldSize;
    }

    public Figure getFigure(Point point) throws InvalidPointException {
        if (!isPointValid(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(Point point, Figure figure) throws InvalidPointException {
        if (!isPointValid(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean isPointValid(Point point) {
        return isCoordinateValid(point.x) && isCoordinateValid(point.y);
    }

    private boolean isCoordinateValid(int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < fieldSize;
    }

}
