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
        for (int i = 0; i < field.getSize(); i++) {
            if (i != 0) {
                printLineSeparator(field.getSize());
            }
            printLine(field, i);
        }
    }

    public boolean isMove() {
        Figure winner = winnerController.getWinner(field);
        if (winner != null ) {
            System.out.printf("\nWinner is %s.", winner);
            return false;
        }
        Figure currentFigure = currentMoveController.getCurrentMove(field);
        if (currentFigure == null) {
            System.out.println("\nIt's a tie.");
            return false;
        }
        System.out.format("It's %s's turn to move.\n", currentFigure);
        try {
            moveController.applyFigure(field, getPointFromUser(), currentFigure);
        } catch (InvalidPointException e) {
            System.out.println("\nERROR! Please enter valid point coordinates.\n");
        } catch (PointAlreadyOccupiedException e) {
            System.out.println("\nERROR! Point is already occupied. Please enter another coordinates.\n");
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

    private void printLine(Field field, int i) {
        for (int j = 0; j < field.getSize(); j++) {
            if (j != 0) {
                System.out.print("|");
            }
            System.out.print(" ");
            Figure figure;
            try {
                figure = field.getFigure(new Point(j, i));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printLineSeparator(int fieldSize) {
        for (int i = 0; i < fieldSize * 3 + fieldSize - 1; i++) {
            System.out.print("_");
        }
        System.out.println();
    }

}
