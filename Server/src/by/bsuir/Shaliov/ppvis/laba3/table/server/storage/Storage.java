package by.bsuir.Shaliov.ppvis.laba3.table.server.storage;

import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 6/21/2016.
 */

public class Storage {
    private List<Teacher> teacherList;
    private int numberRecords = 2;

    public Storage() {
        teacherList = new ArrayList();
    }

    public void addDate(Teacher teacher) {
        teacherList.add(teacher);
    }


    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public int getNumberRecords() {
        return numberRecords;
    }

    public void setNumberRecords(int numberRecords) {
        this.numberRecords = numberRecords;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public void deleteDate(List<Teacher> list) {
        teacherList.removeAll(list);
    }

}
