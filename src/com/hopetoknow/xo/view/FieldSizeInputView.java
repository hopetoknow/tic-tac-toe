package com.hopetoknow.xo.view;

import com.hopetoknow.xo.controllers.FieldCreationController;
import com.hopetoknow.xo.model.Field;

import java.util.Scanner;

public class FieldSizeInputView {

    private final FieldCreationController fieldCreationController;

    public FieldSizeInputView() {
        this.fieldCreationController = new FieldCreationController();
    }

    public Field getFieldSizeFromUser() {
        System.out.print("Enter the size of the field (its length): ");
        Scanner in = new Scanner(System.in);
        return fieldCreationController.createField(in.nextInt());
    }
}
