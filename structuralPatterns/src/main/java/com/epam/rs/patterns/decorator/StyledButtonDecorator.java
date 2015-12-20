package com.epam.rs.patterns.decorator;

import javax.swing.*;
import java.awt.event.MouseAdapter;

/**
 * Created by catmo_000 on 12/20/2015.
 */
public abstract class StyledButtonDecorator extends BaseDecorator {
    public final MouseAdapter hoverAdapter = new MouseAdapter() {
        public void mouseExited(java.awt.event.MouseEvent evt) {
            applyDefaultStyle();
        }
    };

    public StyledButtonDecorator(JComponent component) {
        super(component);
        applyDefaultStyle();
        addMouseListener(hoverAdapter);
    }

    protected abstract void applyDefaultStyle();


}
