package by.bsuir.Shaliov.ppvis.laba3.table.client.view.dialog;


import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.TableController;
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
//                for (Teacher teacher : dbStorage.getTeacherList()) {
//                    if (teacher.getFio().equals(fio)
//                            && teacher.getDepartmentName() == Departments.valueOf(fields.getDepartmentComboBox().getSelectedItem().toString()).getName()) {
//                        teachers.add(teacher);
//                    }
//                }
                tableController.refresh();
                repaint();

            }
        };
        secondBar.add(findFioDepartmentName);
        secondBar.addSeparator();
        AbstractAction findAcademicTitleDepartmentName = new AbstractAction("кафедра + учёное звание") {
            public void actionPerformed(ActionEvent event) {
                teachers.clear();
//                for (Teacher teacher : dbStorage.getTeacherList()) {
//                    if (teacher.getDepartmentName() == Departments.valueOf(fields.getDepartmentComboBox().getSelectedItem().toString()).getName()
//                            && teacher.getAcademicTitle() == AcademicTitles.valueOf(fields.getAcademicTitleComboBox().getSelectedItem().toString()).getName()) {
//                        teachers.add(teacher);
//                    }
//                }
                tableController.refresh();
                repaint();

            }
        };
        secondBar.add(findAcademicTitleDepartmentName);
        secondBar.addSeparator();
        AbstractAction findFacultyDepartmentName = new AbstractAction("факультет + кафедра") {
            public void actionPerformed(ActionEvent event) {
                teachers.clear();
//                for (Teacher teacher : dbStorage.getTeacherList()) {
//                    JComboBox faculty = fields.getFacultyComboBox();
//                    String name = faculty.getSelectedItem().toString();
//                    if (teacher.getFaculty() == Facultyes.valueOf(name).getName()
//                            && teacher.getDepartmentName() == Departments.valueOf(fields.getDepartmentComboBox().getSelectedItem().toString()).getName()) {
//                        teachers.add(teacher);
//                    }
//                }
                tableController.refresh();
                repaint();

            }
        };
        secondBar.add(findFacultyDepartmentName);
        JButton cancelButton = new JButton("Закрыть");
        cancelButton.addActionListener(e -> {
            TableController.getInstance().setTableModel(tempModel);
            TableController.getInstance().setTableModel(tempModel);
            dispose();
        });
        secondBar.addSeparator(new Dimension(5, 100));
        secondBar.add(cancelButton);
    }

}
