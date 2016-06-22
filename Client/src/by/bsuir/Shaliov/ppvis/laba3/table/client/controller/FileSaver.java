package by.bsuir.Shaliov.ppvis.laba3.table.client.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import by.bsuir.Shaliov.ppvis.laba3.table.overall.constants.*;


/**
 * Created by Andrey on 6/22/2016.
 */
public class FileSaver implements ActionListener {
    public FileSaver() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Save");
        JTextField textField = new JTextField();

        dialog.add(textField);
        dialog.setSize(50, 50);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        try {
            ToServerController.getInstance().getOutputStream().writeObject(ClientServer.SAVE_AS);

        } catch (IOException e1) {
            e1.printStackTrace();
        }

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ToServerController.getInstance().getOutputStream().writeObject(textField.getText());
                    dialog.setVisible(false);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
