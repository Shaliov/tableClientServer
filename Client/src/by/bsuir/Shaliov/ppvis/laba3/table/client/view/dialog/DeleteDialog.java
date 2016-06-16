package by.bsuir.Shaliov.ppvis.laba3.table.client.view.dialog;


import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.MainFrameController;
import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.TableController;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.field.Fields;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.panel.TableComponent;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.AcademicTitles;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.Departments;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.Facultyes;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by Andrey on 5/31/2016.
 */
public class DeleteDialog extends JFrame {
    private Fields fields;
    private TableController tableController = TableController.getInstance();
    private TableComponent tableComponent;

    public void setTableComponent(TableComponent tableComponent) {
        this.tableComponent = tableComponent;
    }

    public DeleteDialog() {
        setName("Введите данные преподавателя");
        fields = new Fields();

        Box boxPanel = Box.createVerticalBox();

        fields.fio(boxPanel);
        fields.departmentName(boxPanel);
        fields.faculty(boxPanel);
        fields.academicTitle(boxPanel);
        fields.academicDegree(boxPanel);

        okCancle(boxPanel);
        findButtons(boxPanel);


        setContentPane(boxPanel);
        pack();
        setResizable(false);
        setPreferredSize(new Dimension(800, boxPanel.getHeight()));
        setSize(new Dimension(520, boxPanel.getHeight() + 30));
    }

    private void okCancle(Box boxPanel) {
        Box delete = Box.createHorizontalBox();
        JButton deleteButton = new JButton("удалить все");
        deleteButton.addActionListener(e -> {
//            int numberOfnoted = dbStorage.getTeacherList().size();
//            dbStorage.clear();
//            tableController.refresh();
//            MainFrameController.getInstance().refresh(tableComponent);
//            JOptionPane.showMessageDialog(null, "удалено записей = " + numberOfnoted,
//                    null, JOptionPane.INFORMATION_MESSAGE | JOptionPane.OK_OPTION);
        });
        JButton cancelButton = new JButton("Закрыть");
        cancelButton.addActionListener(e -> {
            fields.getName().setText("");
            fields.getSecondaryName().setText("");
            fields.getMiddleName().setText("");
            tableController.refresh();
            TableController.getInstance().changeNumberOfPage();
            MainFrameController.getInstance().refresh(tableComponent);
            dispose();
        });

        boxPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
        delete.add(Box.createHorizontalGlue());
        delete.add(deleteButton);
        delete.add(Box.createHorizontalStrut(12));
        delete.add(cancelButton);
        delete.add(Box.createHorizontalStrut(12));
        boxPanel.add(delete);
        boxPanel.add(Box.createVerticalStrut(12));
    }

    private void findButtons(Box boxPanel) {
        Box deleteFioDepartmentNameBox = Box.createHorizontalBox();
        JButton findFioDepartmentName = new JButton("ФИО + кафедра");
        findFioDepartmentName.addActionListener(e -> {
            int numberOfnoted = 0;
            String fio = fields.getName().getText() + " " + fields.getSecondaryName().getText() + " " + fields.getMiddleName().getText();
//            for (Iterator<Teacher> teacherIterator = dbStorage.getTeacherList().iterator(); teacherIterator.hasNext();) {
//                Teacher teacher = teacherIterator.next();
//                if (teacher.getFio().equals(fio)
//                        && teacher.getDepartmentName() == Departments.valueOf(fields.getDepartmentComboBox().getSelectedItem().toString()).getName())  {
//                    teacherIterator.remove();
//                    numberOfnoted++;
//                }
//            }
            TableController.getInstance().changeNumberOfPage();
            JOptionPane.showMessageDialog(null, "удалено записей = " + numberOfnoted,
                    null, JOptionPane.INFORMATION_MESSAGE | JOptionPane.OK_OPTION);

        });
        deleteFioDepartmentNameBox.add(Box.createHorizontalGlue());
        deleteFioDepartmentNameBox.add(findFioDepartmentName);
        deleteFioDepartmentNameBox.add(Box.createHorizontalStrut(6));
        boxPanel.add(deleteFioDepartmentNameBox);

        JButton deleteAcademicTitleDepartmentName = new JButton("кафедра + учёное звание");
        deleteAcademicTitleDepartmentName.addActionListener(e -> {
            int numberOfnoted = 0;
//            for (Iterator<Teacher> teacherIterator = dbStorage.getTeacherList().iterator(); teacherIterator.hasNext();) {
//                Teacher teacher = teacherIterator.next();
//                if (teacher.getDepartmentName() == Departments.valueOf(fields.getDepartmentComboBox().getSelectedItem().toString()).getName()
//                        && teacher.getAcademicTitle() == AcademicTitles.valueOf(fields.getAcademicTitleComboBox().getSelectedItem().toString()).getName())  {
//                    teacherIterator.remove();
//                    numberOfnoted++;
//                }
//            }
            TableController.getInstance().changeNumberOfPage();
            JOptionPane.showMessageDialog(null, "удалено записей = " + numberOfnoted,
                    null, JOptionPane.INFORMATION_MESSAGE | JOptionPane.OK_OPTION);

        });

        JButton deleteFacultyDepartmentName = new JButton("факультет + кафедра");
        deleteFacultyDepartmentName.addActionListener(e -> {
            int numberOfnoted = 0;
//            for (Iterator<Teacher> teacherIterator = dbStorage.getTeacherList().iterator(); teacherIterator.hasNext();) {
//                Teacher teacher = teacherIterator.next();
//                if (teacher.getFaculty() == Facultyes.valueOf(fields.getFacultyComboBox().getSelectedItem().toString()).getName()
//                        && teacher.getDepartmentName() == Departments.valueOf(fields.getDepartmentComboBox().getSelectedItem().toString()).getName())  {
//                    teacherIterator.remove();
//                    numberOfnoted++;
//                }
//            }
            TableController.getInstance().changeNumberOfPage();
            JOptionPane.showMessageDialog(null, "удалено записей = " + numberOfnoted,
                    null, JOptionPane.INFORMATION_MESSAGE | JOptionPane.OK_OPTION);

        });
        deleteFioDepartmentNameBox.add(deleteAcademicTitleDepartmentName);
        deleteFioDepartmentNameBox.add(Box.createHorizontalStrut(6));
        deleteFioDepartmentNameBox.add(deleteFacultyDepartmentName);
    }

}
