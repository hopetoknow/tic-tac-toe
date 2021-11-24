package com.hopetoknow.xo;

import com.hopetoknow.xo.model.Field;
import com.hopetoknow.xo.model.Figure;
import com.hopetoknow.xo.model.Game;
import com.hopetoknow.xo.model.Player;
import com.hopetoknow.xo.view.ConsoleView;

public class App {

    public static void main(String[] args) {
        Player[] players = new Player[2];
        players[0] = new Player("Player1", Figure.X);
        players[1] = new Player("Player2", Figure.O);
        Field field = new Field(3);
        Game game = new Game(players, field, "Tic-tac-toe");
        System.out.format("Game name: %s\n", game.getName());
        ConsoleView consoleView = new ConsoleView(game);
        consoleView.showField();
        while (consoleView.isMove()) {
            consoleView.showField();
        }
    }

}
