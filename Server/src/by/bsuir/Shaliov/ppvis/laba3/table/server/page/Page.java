package by.bsuir.Shaliov.ppvis.laba3.table.server.page;

import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba3.table.server.storage.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 6/21/2016.
 */
public class Page {
    private List<Teacher> studentList;
    private int numberRecords;
    private int currentRecord;
    private List<Teacher> newList = null;
    private boolean left;
    private boolean right;
    private int size;
    private Storage storage;
    private int endPage;

    public Page(Storage storage) {
        this.storage = storage;
    }

    public List<Teacher> goLeftStart() {
        endPage();

        if (numberRecords >= size) {
            newList = new ArrayList(studentList);
            return newList;
        }

        newList = new ArrayList(studentList.subList(0, numberRecords));
        currentRecord = 0;
        left = right = false;

        return newList;
    }

    public List<Teacher> goLeft() {
        endPage();
        if (numberRecords >= size) {
            newList = studentList;
            return newList;
        }

        if (left) {
            currentRecord += numberRecords;
            left = !left;
        }
        right = true;
        currentRecord -= numberRecords;
        if (currentRecord - numberRecords < 0) {
            currentRecord = numberRecords;
            newList = new ArrayList<Teacher>(studentList.subList(0,
                    currentRecord));
        } else {
            newList = new ArrayList<Teacher>(studentList.subList(currentRecord
                    - numberRecords, currentRecord));
        }

        return newList;
    }

    public List<Teacher> goRight() {
        endPage();

        if (numberRecords >= size) {
            newList = studentList;

            return newList;
        }
        if (right) {
            currentRecord -= numberRecords;
            right = !right;
        }
        left = true;
        currentRecord += numberRecords;
        if (currentRecord + numberRecords >= size) {
            currentRecord = size - numberRecords;
            newList = new ArrayList(studentList.subList(
                    size - endPage, size));
        } else {
            newList = new ArrayList(studentList.subList(currentRecord,
                    currentRecord + numberRecords));
        }

        return newList;
    }

    public List<Teacher> goRightEnd() {
        endPage();

        if (numberRecords >= size) {
            newList = studentList;
            return newList;
        }

        newList = new ArrayList(studentList.subList(size - endPage,
                size));
        currentRecord = size;
        left = right = false;

        return newList;
    }

    public void endPage() {
        studentList = storage.getTeacherList();
        size = studentList.size();

        numberRecords = storage.getNumberRecords();

        endPage = size % numberRecords;
        if (endPage == 0) {
            endPage = numberRecords;
        }
    }

    public int getEndPage() {
        return endPage;
    }
}