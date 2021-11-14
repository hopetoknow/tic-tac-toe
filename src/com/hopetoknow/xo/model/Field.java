package com.hopetoknow.xo.model;

import java.awt.*;

public class Field {

    public static final int FIELD_SIZE = 3;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(Point point) {
        return field[point.x][point.y];
    }

    public void setFigure(Point point, Figure figure) {
        field[point.x][point.y] = figure;
    }
}
