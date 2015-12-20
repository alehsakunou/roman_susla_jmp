package com.epam.rs.patterns.bridge;

import com.epam.rs.data.Record;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Created by catmo_000 on 12/21/2015.
 */
public class TableRenderer extends Renderer<Record> {
    private JTable table;

    public TableRenderer(List<Record> records) {
        super(records);
        table = new JTable();
        this.setSize(200, 200);
        this.add(table);
        this.setBackground(Color.black);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addColumn("Id");
        model.addColumn("Uid");
        render();
        table.setSize(200, 200);
        this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.add(table);

    }

    @Override
    public void render() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0, length = records.size(); i < length; i++) {
            final Record record = records.get(i);
            model.addRow(new Object[]{record.getId(), record.getUid()});
        }
    }


}
