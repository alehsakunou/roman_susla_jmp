package com.epam.rs.patterns.adapter;

import com.epam.rs.data.Record;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by catmo_000 on 12/21/2015.
 */
public class MoveSupportedList extends JPanel{
    private JList list;
    protected List<Record> records;
    private ListAdapter adapter;

    public MoveSupportedList(List<Record> records) {
        this.records = records;
        list = new JList();
        list.setListData(records.toArray());
        this.setSize(200, 200);
        this.add(list);

    }

    public void setAdapter(ListAdapter adapter) {
        if(adapter==null)return;
        this.adapter = adapter;
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    adapter.moveTo(records.get(index));
                    records.remove(index);
                    list.setListData(records.toArray());
                }
            }
        });
    }

    public void addRecord(Record record)
    {
        records.add(record);
        list.setListData(records.toArray());
    }



}