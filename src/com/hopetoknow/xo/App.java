package com.hopetoknow.xo;

import com.hopetoknow.xo.model.Field;
import com.hopetoknow.xo.model.Figure;
import com.hopetoknow.xo.model.Game;
import com.hopetoknow.xo.model.Player;
import com.hopetoknow.xo.view.ConsoleView;
import com.hopetoknow.xo.view.FieldSizeInputView;

public class App {

    public static void main(String[] args) {
        String gameName = "Tic-tac-toe";
        System.out.format("\nGame name: %s\n\n", gameName);
        Player[] players = new Player[2];
        players[0] = new Player("Player1", Figure.X);
        players[1] = new Player("Player2", Figure.O);
        FieldSizeInputView fieldSizeInputView = new FieldSizeInputView();
        Field field = fieldSizeInputView.getFieldSizeFromUser();
        Game game = new Game(players, field, gameName);
        ConsoleView consoleView = new ConsoleView(game);
        consoleView.showField();
        while (consoleView.isMove()) {
            consoleView.showField();
        }
    }

}
