package com.epam.rs.bridge;

import com.epam.rs.data.Record;

import javax.swing.*;
import java.util.List;

/**
 * Created by catmo_000 on 12/21/2015.
 */
public class ListBoxRenderer extends Renderer<Record> {
    private JList list;

    public ListBoxRenderer(List<Record> records) {
        super(records);
        list = new JList();
        this.setSize(200, 200);
        this.add(list);
        render();
    }

    @Override
    public void render() {
        list.setListData(records.toArray());
    }



}
