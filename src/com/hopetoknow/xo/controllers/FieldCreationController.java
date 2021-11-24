package com.hopetoknow.xo.controllers;

import com.hopetoknow.xo.model.Field;

public class FieldCreationController {

    public Field createField(int size) {
        return new Field(size);
    }

}

