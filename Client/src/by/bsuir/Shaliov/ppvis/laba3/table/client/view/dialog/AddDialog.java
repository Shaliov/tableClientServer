package by.bsuir.Shaliov.ppvis.laba3.table.client.view.dialog;

import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.AddDialogController;
import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.MainFrameController;
import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.TableController;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.field.Fields;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.AcademicDegrees;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.AcademicTitles;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.Departments;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.Facultyes;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.constants.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * Created by Andrey on 5/31/2016.
 */
public class AddDialog extends JFrame {

    private Fields fields;
    private java.util.List<Teacher> teacherList = new ArrayList();

    public AddDialog() {
        setName("Введите данные преподавателя");

        Box boxPanel = Box.createVerticalBox();
        fields = new Fields();

        fields.fio(boxPanel);
        fields.departmentName(boxPanel);
        fields.faculty(boxPanel);
        fields.academicTitle(boxPanel);
        fields.academicDegree(boxPanel);
        okCancle(boxPanel);

        boxPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(boxPanel);
        pack();
        setResizable(false);
        setPreferredSize(new Dimension(600, boxPanel.getHeight()));
        setSize(new Dimension(400, boxPanel.getHeight() + 20));

    }

    private void okCancle(Box boxPanel) {
        Box okBox = Box.createHorizontalBox();
        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(fields.getName().getText() + fields.getSecondaryName().getText() +
                        fields.getMiddleName().getText()).equals("")) {
                    Teacher teacher = new Teacher(Facultyes.valueOf(fields.getFacultyComboBox().getSelectedItem().toString()).getName(),
                            Departments.valueOf(fields.getDepartmentComboBox().getSelectedItem().toString()).getName(),
                            fields.getName().getText(),
                            fields.getSecondaryName().getText(),
                            fields.getMiddleName().getText(),
                            AcademicTitles.valueOf(fields.getAcademicTitleComboBox().getSelectedItem().toString()).getName(),
                            AcademicDegrees.valueOf(fields.getAcademicDegreeComboBox().getSelectedItem().toString()).getName());
                    AddDialogController.getInstance().addTeacherToServer(teacher);
                }

                fields.getName().setText("");
                fields.getSecondaryName().setText("");
                fields.getMiddleName().setText("");

            }
        });
        JButton cancelButton = new JButton("Закрыть");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fields.getName().setText("");
                fields.getSecondaryName().setText("");
                fields.getMiddleName().setText("");
                dispose();
            }
        });


        okBox.add(Box.createHorizontalGlue());
        okBox.add(okButton);
        okBox.add(Box.createHorizontalStrut(12));
        okBox.add(cancelButton);
        boxPanel.add(okBox);
        boxPanel.add(Box.createVerticalStrut(12));
        boxPanel.add(Box.createHorizontalStrut(24));
    }

    public Fields getFields() {
        return fields;
    }
}
