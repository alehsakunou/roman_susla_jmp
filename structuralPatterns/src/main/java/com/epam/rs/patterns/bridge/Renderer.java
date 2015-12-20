package com.epam.rs.patterns.bridge;

import javax.swing.*;
import java.util.List;

/**
 * Created by catmo_000 on 12/21/2015.
 */
public abstract class Renderer<T>  extends JPanel{
    protected List<T> records;
    public Renderer(List<T> records)
    {
        this.records = records;
    }

    public  abstract void render();

}
