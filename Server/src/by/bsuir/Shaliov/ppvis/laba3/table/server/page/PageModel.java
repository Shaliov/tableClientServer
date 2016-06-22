package by.bsuir.Shaliov.ppvis.laba3.table.server.page;

import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba3.table.server.storage.Storage;

import java.util.List;

/**
 * Created by Andrey on 6/21/2016.
 */
public class PageModel {
    private List<Teacher> teacherList;
    private int numberRecords;

    private int size;

    private int currentRecord = 0;
    private boolean left;
    private boolean right;

    public PageModel(Storage storage) {
        teacherList = storage.getTeacherList();
        size = teacherList.size();
    }

    public int getNumberRecords() {
        return numberRecords;
    }

    public void setNumberRecords(int size) {
        numberRecords = size;
    }


    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public int getCurrentRecord() {
        return currentRecord;
    }

    public void setCurrentRecord(int currentRecord) {
        this.currentRecord = currentRecord;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

