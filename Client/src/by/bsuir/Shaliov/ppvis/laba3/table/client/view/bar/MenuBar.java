package by.bsuir.Shaliov.ppvis.laba3.table.client.view.bar;

import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;


/**
 * Created by Andrey on 5/30/2016.
 */
public class MenuBar extends JMenuBar {

    public MenuBar() {
        JMenu fileMenu = new JMenu("File");
        addFileMenu(fileMenu);
        add(fileMenu);
    }

    private void addFileMenu(JMenu fileMenu) {

        fileMenu.setMnemonic('F');
        JMenuItem saveFile = new JMenuItem("Save");
        saveFile.addActionListener(new FileSaver());
        fileMenu.add(saveFile);
        JMenuItem openFile = new JMenuItem("Open file");
        openFile.addActionListener(new FileChooserListener());
        fileMenu.add(openFile);
    }

}
