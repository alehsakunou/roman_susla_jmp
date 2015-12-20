package com.epam.rs.patterns.decorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public abstract class BaseDecorator extends JComponent {
    protected JComponent component;

    public BaseDecorator(JComponent component) {
        setLayout(new BorderLayout());
        add(component);
        this.component = component;
    }

    @Override
    public void addMouseListener(MouseListener listener) {
        component.addMouseListener(listener);
    }

    public void setBackground(Color color) {
        component.setBackground(color);
    }
}
