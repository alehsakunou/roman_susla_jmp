package com.epam.rs.decorator.impl;

import com.epam.rs.decorator.StyledButtonDecorator;

import javax.swing.*;
import java.awt.*;

public class GreenButton extends StyledButtonDecorator {

    public GreenButton(JComponent component) {
        super(component);
    }

    @Override
    protected void applyDefaultStyle() {
        component.setBackground(Color.GREEN);
    }
}
