package by.bsuir.Shaliov.ppvis.laba3.table.client.model;



import by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration.ColumnNames;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 5/30/2016.
 */
public class TableModel extends AbstractTableModel {

    private List<Teacher> teacherList;
    private List<Teacher> tempList;
    public static final int column = 5;


    public TableModel() {
        teacherList = new ArrayList();
    }

    public TableModel(List<Teacher> teachers) {
        tempList = teachers;
    }

    public static final String columnNames[] = {
            ColumnNames.FACULTY.getName(),
            ColumnNames.DEPARTMENT_NAME.getName(),
            ColumnNames.FIO.getName(),
            ColumnNames.ACADEMIC_TITLE.getName(),
            ColumnNames.ACADEMIC_DEGREE.getName()
    };


    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return teacherList.size();
    }

    @Override
    public int getColumnCount() {
        return column;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Teacher teacher = teacherList.get(rowIndex);
        return teacher.get(columnIndex);
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public List<Teacher> getTempList(int startIndex, int endIndex) {
        List<Teacher> result = new ArrayList<>();
        for (int i = startIndex; i < endIndex; i++) {
            result.add(tempList.get(i));
        }
        return result;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Teacher> getTempList() {
        return tempList;
    }

    public void setTempList(List<Teacher> tempList) {
        this.tempList = tempList;
    }
}