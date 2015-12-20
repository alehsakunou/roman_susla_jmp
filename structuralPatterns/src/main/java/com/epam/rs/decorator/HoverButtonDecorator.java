package com.epam.rs.decorator;

import javax.swing.*;
import java.awt.event.MouseAdapter;

/**
 * Created by catmo_000 on 12/20/2015.
 */
public abstract class HoverButtonDecorator extends BaseDecorator {
    public final MouseAdapter hoverAdapter = new MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            applyStyle();
        }
    };

    public HoverButtonDecorator(JComponent component) {
        super(component);
        addMouseListener(hoverAdapter);
    }

    protected abstract void applyStyle();
}
