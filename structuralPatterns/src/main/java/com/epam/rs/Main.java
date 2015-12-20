package com.epam.rs;


import com.epam.rs.patterns.adapter.ListAdapter;
import com.epam.rs.patterns.adapter.MoveSupportedList;
import com.epam.rs.patterns.bridge.ListBoxRenderer;
import com.epam.rs.patterns.bridge.Renderer;
import com.epam.rs.patterns.bridge.TableRenderer;
import com.epam.rs.data.Record;
import com.epam.rs.patterns.facade.Facade;
import com.epam.rs.patterns.decorator.impl.GreenButton;
import com.epam.rs.patterns.decorator.impl.OrangeHoverButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by catmo_000 on 12/20/2015.
 */
public class Main extends JFrame implements ActionListener {
    public static final String QUIT = "Quit";
    public static final String STRUCT_PATTERNS = "Struct. patterns";
    JButton quitButton;

    public Main() {
        super(STRUCT_PATTERNS);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        //facade and bridge
        java.util.List recordsXml = Facade.getAllRecords(Facade.ConnectionType.XML);
        java.util.List recordsMem = Facade.getAllRecords(Facade.ConnectionType.MEMORY);
        Renderer<Record>[] renderers = new Renderer[]{new ListBoxRenderer(recordsXml), new TableRenderer(recordsXml)};
        panel.add(renderers[0]);
        panel.add(renderers[1]);

        //decorator
        quitButton = new JButton(QUIT);
        panel.add(new OrangeHoverButton(new GreenButton(quitButton)));
        quitButton.addActionListener(this);

        //adapter

        MoveSupportedList firstList = new MoveSupportedList(recordsXml);
        MoveSupportedList secondList = new MoveSupportedList(recordsMem);
        ListAdapter firstAdapter= new ListAdapter(firstList);
        ListAdapter secondAdapter= new ListAdapter(secondList);
        firstList.setAdapter(secondAdapter);
        secondList.setAdapter(firstAdapter);
        panel.add(firstList);
        panel.add(secondList);


        setSize(new Dimension(500, 500));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    static public void main(String argv[]) {
        new Main();
    }
}

