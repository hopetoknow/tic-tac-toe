package com.hopetoknow.xo.controllers;

import com.hopetoknow.xo.model.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldCreationControllerTest {

    @Test
    void createField() {
        Field testField = new Field(3);
        int expectedFieldSize = testField.getSize();

        FieldCreationController fieldCreationController = new FieldCreationController();
        Field actualField = fieldCreationController.createField(3);
        int actualFieldSize = actualField.getSize();

        assertEquals(expectedFieldSize, actualFieldSize);
    }
}