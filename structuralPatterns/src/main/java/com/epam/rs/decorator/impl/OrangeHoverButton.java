package com.epam.rs.decorator.impl;

import com.epam.rs.decorator.HoverButtonDecorator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by catmo_000 on 12/20/2015.
 */
public class OrangeHoverButton extends HoverButtonDecorator {
    public OrangeHoverButton(JComponent component) {
        super(component);
    }

    @Override
    protected void applyStyle() {
        component.setBackground(Color.ORANGE);
    }
}
