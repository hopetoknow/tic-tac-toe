package com.hopetoknow.xo.view;

import com.hopetoknow.xo.controllers.CurrentMoveController;
import com.hopetoknow.xo.controllers.MoveController;
import com.hopetoknow.xo.controllers.WinnerController;
import com.hopetoknow.xo.model.Field;
import com.hopetoknow.xo.model.Figure;
import com.hopetoknow.xo.model.Game;
import com.hopetoknow.xo.model.exceptions.InvalidPointException;
import com.hopetoknow.xo.model.exceptions.PointAlreadyOccupiedException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final Field field;
    
    private final WinnerController winnerController;

    private final CurrentMoveController currentMoveController;

    private final MoveController moveController;

    public ConsoleView(Game game) {
        this.field = game.getField();
        this.winnerController = new WinnerController();
        this.currentMoveController = new CurrentMoveController();
        this.moveController =  new MoveController();
    }

    public void showField() {
        StringBuilder stringBuilder = new StringBuilder();
        int fieldSize = field.getSize();
        for (int i = 0; i < fieldSize; i++) {
            if (i == 0) {
                stringBuilder.append(System.getProperty("line.separator"));
            }
            if (i != 0) {
                printLineSeparator(field.getSize(), stringBuilder);
            }
            printLine(field, i, stringBuilder);
        }
        stringBuilder.append(System.getProperty("line.separator"));
        System.out.print(stringBuilder);
    }

    public boolean isMove() {
        Figure winner = winnerController.getWinner(field);
        if (winner != null ) {
            System.out.printf("Winner is %s.\n", winner);
            return false;
        }
        Figure currentFigure = currentMoveController.getCurrentMove(field);
        if (currentFigure == null) {
            System.out.println("It's a tie.");
            return false;
        }
        System.out.format("It's %s's turn to move.\n", currentFigure);
        try {
            moveController.applyFigure(field, getPointFromUser(), currentFigure);
        } catch (InvalidPointException e) {
            System.out.println("\nERROR! Please enter valid point coordinates.");
        } catch (PointAlreadyOccupiedException e) {
            System.out.println("\nERROR! Point is already occupied. Please enter another coordinates.");
        }
        return true;
    }

    private Point getPointFromUser() {
        return new Point(getCoordinateFromUser("X") - 1, getCoordinateFromUser("Y") - 1);
    }

    private int getCoordinateFromUser(final String coordinateName) {
        if ("X".equals(coordinateName)) {
            System.out.printf("Enter the X coordinate (where X is from 1 to %d horizontally): ", field.getSize());
        } else if ("Y".equals(coordinateName)) {
            System.out.printf("Enter the Y coordinate (where Y is from 1 to %d vertically): ", field.getSize());
        }
        try {
            Scanner in = new Scanner(System.in);
            return in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nThat is not a number, my friend. Try again.\n");
            return getCoordinateFromUser(coordinateName);
        }
    }

    private void printLine(Field field, int i, StringBuilder stringBuilder) {
        for (int j = 0; j < field.getSize(); j++) {
            if (j != 0) {
                stringBuilder.append("|");
            }
            stringBuilder.append(" ");
            Figure figure;
            try {
                figure = field.getFigure(new Point(j, i));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            stringBuilder.append(figure != null ? figure : " ");
            stringBuilder.append(" ");
        }
        stringBuilder.append(System.getProperty("line.separator"));
    }

    private void printLineSeparator(int fieldSize, StringBuilder stringBuilder) {
        stringBuilder.append("_".repeat(fieldSize * 3 + fieldSize - 1));
        stringBuilder.append(System.getProperty("line.separator"));
    }

}
