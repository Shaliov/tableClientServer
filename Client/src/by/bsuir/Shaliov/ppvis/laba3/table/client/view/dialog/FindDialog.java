package by.bsuir.Shaliov.ppvis.laba3.table.client.view.dialog;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.constants.*;

import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.TableController;
import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.ToServerController;
import by.bsuir.Shaliov.ppvis.laba3.table.client.model.TableModel;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.field.Fields;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.panel.TableComponent;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.AcademicTitles;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.Departments;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.Facultyes;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 5/31/2016.
 */
public class FindDialog extends JFrame {
    private TableComponent tableComponent;
    private List<Teacher> teachers;
    private Fields fields;
    private TableController tableController = TableController.getInstance();
    private TableModel tableModel;
    private TableModel tempModel;

    public FindDialog() {
        tempModel = TableController.getInstance().getTableModel();
        setName("Введите данные преподавателя");
        Box boxPanel = Box.createVerticalBox();
        fields = new Fields();

        fields.fio(boxPanel);
        fields.departmentName(boxPanel);
        fields.faculty(boxPanel);
        fields.academicTitle(boxPanel);
        fields.academicDegree(boxPanel);


        teachers = new ArrayList<>();
        tableComponent = new TableComponent(teachers);
        tableModel = tableComponent.getTableModel();
        TableController.getInstance().setTableModel(tableModel);
        tableController.setTableModel(tableModel);

        add(tableComponent);

        JToolBar fieldBar = new JToolBar();
        fieldBar.setOrientation(SwingConstants.VERTICAL);
        boxPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
        add(boxPanel, "West");

        JToolBar findBar = new JToolBar();
        findBar.setOrientation(SwingConstants.VERTICAL);
        add(findBar, "East");
        findButtons(findBar);

        setSize(1200, 350);
     //   setUndecorated(true);
        setVisible(true);
    }

    private void findButtons(JToolBar secondBar) {
        AbstractAction findFioDepartmentName = new AbstractAction("ФИО + кафедра") {
            public void actionPerformed(ActionEvent e) {
                teachers.clear();
                String fio = fields.getName().getText() + " " + fields.getSecondaryName().getText() + " " + fields.getMiddleName().getText();
                try {
                    ToServerController.getInstance().getOutputStream().writeObject(ClientServer.FIO_DEPARTMENT);
                    ToServerController.getInstance().getOutputStream().writeObject(fio);
                    ToServerController.getInstance().getOutputStream().writeObject(Departments.valueOf(fields.getDepartmentComboBox().getSelectedItem().toString()).getName());
                    ToServerController.getInstance().getOutputStream().writeObject(false);

                    tableModel.setTeacherList((List<Teacher>) ToServerController.getInstance().getInputStream().readObject());

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                TableController.getInstance().firstPage();
                repaint();

            }
        };
        secondBar.add(findFioDepartmentName);
        secondBar.addSeparator();
        AbstractAction findAcademicTitleDepartmentName = new AbstractAction("кафедра + учёное звание") {
            public void actionPerformed(ActionEvent event) {
                teachers.clear();
                try {
                    ToServerController.getInstance().getOutputStream().writeObject(ClientServer.DEPARTMENT_ACADEMIC_TITLE);
                    ToServerController.getInstance().getOutputStream().writeObject(Departments.valueOf(fields.getDepartmentComboBox().getSelectedItem().toString()).getName());
                    ToServerController.getInstance().getOutputStream().writeObject(AcademicTitles.valueOf(fields.getAcademicTitleComboBox().getSelectedItem().toString()).getName());
                    ToServerController.getInstance().getOutputStream().writeObject(false);

                    tableModel.setTeacherList((List<Teacher>) ToServerController.getInstance().getInputStream().readObject());

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                TableController.getInstance().firstPage();
                repaint();

            }
        };
        secondBar.add(findAcademicTitleDepartmentName);
        secondBar.addSeparator();
        AbstractAction findFacultyDepartmentName = new AbstractAction("факультет + кафедра") {
            public void actionPerformed(ActionEvent event) {
                teachers.clear();
                repaint();
                try {
                    ToServerController.getInstance().getOutputStream().writeObject(ClientServer.FACULTU_DEPARTMENT);
                    ToServerController.getInstance().getOutputStream().writeObject(Facultyes.valueOf(fields.getFacultyComboBox().getSelectedItem().toString()).getName());
                    ToServerController.getInstance().getOutputStream().writeObject(Departments.valueOf(fields.getDepartmentComboBox().getSelectedItem().toString()).getName());
                    ToServerController.getInstance().getOutputStream().writeObject(false);

                    tableModel.setTeacherList((List<Teacher>) ToServerController.getInstance().getInputStream().readObject());

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                TableController.getInstance().firstPage();
                repaint();

            }
        };
        secondBar.add(findFacultyDepartmentName);
        JButton cancelButton = new JButton("Закрыть");
        cancelButton.addActionListener(e -> {
            TableController.getInstance().setTableModel(tempModel);
            TableController.getInstance().getTableModel().setName("teacherTable");
            dispose();
        });
        secondBar.addSeparator(new Dimension(5, 100));
        secondBar.add(cancelButton);
    }

}
