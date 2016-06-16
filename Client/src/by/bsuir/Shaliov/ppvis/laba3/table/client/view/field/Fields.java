package by.bsuir.Shaliov.ppvis.laba3.table.client.view.field;


import javax.swing.*;

import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.AcademicDegrees;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.AcademicTitles;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.Departments;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.Facultyes;

import java.awt.*;

/**
 * Created by Andrey on 5/31/2016.
 */
public class Fields {

    private JTextField name;
    private JTextField secondaryName;
    private JTextField middleName;
    private JComboBox<Departments> departmentComboBox;
    private JComboBox<Facultyes> facultyComboBox;
    private JComboBox<AcademicTitles> academicTitleComboBox;
    private JComboBox<AcademicDegrees> academicDegreeComboBox;
    private Departments nameOfDepartment;
    private Facultyes facultyes;
    private AcademicTitles academicTitles;
    private AcademicDegrees academicDegrees;

    public Fields() {

    }

    public void fio(Box boxPanel) {
        Box nameBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("имя преподавателя:");
        nameLabel.setPreferredSize(new Dimension(130, nameLabel.getHeight()));
        name = new JTextField(20);

        nameBox.add(nameLabel);
        nameBox.add(Box.createHorizontalStrut(6));
        nameBox.add(name);
        boxPanel.add(nameBox);
        boxPanel.add(Box.createVerticalStrut(12));

        Box secondaryBox = Box.createHorizontalBox();
        JLabel secondaryLabel = new JLabel("фамилия преподавателя:");
        secondaryLabel.setPreferredSize(new Dimension(130, secondaryLabel.getHeight()));
        secondaryName = new JTextField(20);

        secondaryBox.add(secondaryLabel);
        secondaryBox.add(Box.createHorizontalStrut(6));
        secondaryBox.add(secondaryName);
        boxPanel.add(secondaryBox);
        boxPanel.add(Box.createVerticalStrut(12));

        Box middleNameBox = Box.createHorizontalBox();
        JLabel middleNameLabel = new JLabel("отчество преподавателя:");
        middleNameLabel.setPreferredSize(new Dimension(130, middleNameLabel.getHeight()));
        middleName = new JTextField(20);

        middleNameBox.add(middleNameLabel);
        middleNameBox.add(Box.createHorizontalStrut(6));
        middleNameBox.add(middleName);
        boxPanel.add(middleNameBox);
        boxPanel.add(Box.createVerticalStrut(12));


    }

    public void departmentName(Box boxPanel) {
        Box departmentNameBox = Box.createHorizontalBox();
        JLabel departmentNameLabel = new JLabel("Название кафедры:");
        departmentNameLabel.setPreferredSize(new Dimension(130, departmentNameLabel.getHeight()));
        departmentComboBox = new JComboBox<>(nameOfDepartment.values());

        departmentNameBox.add(departmentNameLabel);
        departmentNameBox.add(Box.createHorizontalStrut(6));
        departmentNameBox.add(departmentComboBox);
        boxPanel.add(departmentNameBox);
        boxPanel.add(Box.createVerticalStrut(12));
    }

    public void faculty(Box boxPanel) {
        Box facultyBox = Box.createHorizontalBox();
        JLabel facultyLabel = new JLabel("Факультет:");
        facultyLabel.setPreferredSize(new Dimension(130, facultyLabel.getHeight()));
        facultyComboBox = new JComboBox(facultyes.values());

        facultyBox.add(facultyLabel);
        facultyBox.add(Box.createHorizontalStrut(6));
        facultyBox.add(facultyComboBox);
        boxPanel.add(facultyBox);
        boxPanel.add(Box.createVerticalStrut(12));
    }

    public void academicTitle(Box boxPanel) {
        Box academicTitleBox = Box.createHorizontalBox();
        JLabel academicTitleLabel = new JLabel("ученое звание:");
        academicTitleLabel.setPreferredSize(new Dimension(130, academicTitleLabel.getHeight()));
        academicTitleComboBox = new JComboBox(academicTitles.values());

        academicTitleBox.add(academicTitleLabel);
        academicTitleBox.add(Box.createHorizontalStrut(6));
        academicTitleBox.add(academicTitleComboBox);
        boxPanel.add(academicTitleBox);
        boxPanel.add(Box.createVerticalStrut(12));
    }

    public void academicDegree(Box boxPanel) {
        Box academicDegreeBox = Box.createHorizontalBox();
        JLabel academicDegreeLabel = new JLabel("ученая степень:");
        academicDegreeLabel.setPreferredSize(new Dimension(130, academicDegreeLabel.getHeight()));
        academicDegreeComboBox = new JComboBox(academicDegrees.values());

        academicDegreeBox.add(academicDegreeLabel);
        academicDegreeBox.add(Box.createHorizontalStrut(6));
        academicDegreeBox.add(academicDegreeComboBox);
        boxPanel.add(academicDegreeBox);
        boxPanel.add(Box.createVerticalStrut(12));
    }


    public JTextField getName() {
        return name;
    }

    public JTextField getSecondaryName() {
        return secondaryName;
    }

    public JTextField getMiddleName() {
        return middleName;
    }

    public JComboBox<Departments> getDepartmentComboBox() {
        return departmentComboBox;
    }

    public JComboBox getFacultyComboBox() {
        return facultyComboBox;
    }

    public JComboBox getAcademicTitleComboBox() {
        return academicTitleComboBox;
    }

    public JComboBox getAcademicDegreeComboBox() {
        return academicDegreeComboBox;
    }

    public Departments getNameOfDepartment() {
        return nameOfDepartment;
    }

    public Facultyes getFacultyes() {
        return facultyes;
    }

    public AcademicTitles getAcademicTitles() {
        return academicTitles;
    }

    public AcademicDegrees getAcademicDegrees() {
        return academicDegrees;
    }

}
