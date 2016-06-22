package by.bsuir.Shaliov.ppvis.laba3.table.client.controller;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.constants.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Andrey on 6/22/2016.
 */
public class FileChooserListener implements ActionListener {
    public FileChooserListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog();
        dialog.setTitle("File chooser");
        dialog.setLocationRelativeTo(null);
        dialog.setSize(200, 60);
        dialog.setResizable(false);
        try {
            Vector<String> vectorFiles = new Vector();
            ToServerController.getInstance().getOutputStream().writeObject(ClientServer.OPEN_FILE);
            File[] listFiles = (File[]) ToServerController.getInstance().getInputStream().readObject();
            for (File file : listFiles) {
                vectorFiles.add(file.getPath());
            }
            JComboBox<String> comboBox = new JComboBox(vectorFiles);
            dialog.add(comboBox, BorderLayout.NORTH);
            comboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ToServerController.getInstance().getOutputStream().writeObject(comboBox.getSelectedItem());
                        TableController.getInstance().firstPage();
                        dialog.setVisible(false);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });

        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        dialog.setVisible(true);

    }
}
