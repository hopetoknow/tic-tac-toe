package com.hopetoknow.xo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private final Player[] testPlayers = new Player[2];

    private final Field testField = new Field(3);

    private final String testName = "tic-tac-toe";

    private final Game game = new Game(testPlayers, testField, testName);

    @Test
    void getPlayers() {
        Player[] expectedPlayers = testPlayers;

        Player[] actualPlayers = game.getPlayers();

        assertEquals(expectedPlayers, actualPlayers);
    }

    @Test
    void getField() {
        Field expectedField = testField;

        Field actualField = game.getField();

        assertEquals(expectedField, actualField);

    }

    @Test
    void getName() {
        String expectedName = testName;

        String actualName = game.getName();

        assertEquals(expectedName, actualName);
    }

}
