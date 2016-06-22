package by.bsuir.Shaliov.ppvis.laba3.table.server.searchAndRemove;

import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba3.table.server.storage.Storage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrey on 6/21/2016.
 */
public class SearcherAndRemover {

    private List<Teacher> teacherList;
    private List<Teacher> searchTeachers = new ArrayList();
    private boolean remove;
    private Storage storage;

    public SearcherAndRemover(Storage storage) {
        this.storage = storage;
        teacherList = storage.getTeacherList();
    }

    public List<Teacher> searchDepartmentAcademic(String firstField, String secondField, Boolean remove) {
        this.remove = remove;
        searchTeachers.clear();
        for (Iterator<Teacher> teacherIterator = storage.getTeacherList().iterator(); teacherIterator.hasNext();) {
            Teacher teacher = teacherIterator.next();
            if (teacher.getDepartmentName().toString().equals(firstField)
                    && teacher.getAcademicTitle().toString().equals(secondField))  {
                searchTeachers.add(teacher);
            }
        }
        remove();
        return searchTeachers;
    }

    public List<Teacher> searchFioDepartment(String fio, String secondField, Boolean remove) {
        this.remove = remove;
        searchTeachers.clear();
        for (Iterator<Teacher> teacherIterator = storage.getTeacherList().iterator(); teacherIterator.hasNext(); ) {
            Teacher teacher = teacherIterator.next();
            if (teacher.getFio().equals(fio)
                    && teacher.getDepartmentName().toString().equals(secondField)) {
                searchTeachers.add(teacher);
            }
        }

        System.out.println(searchTeachers.size());
        remove();
        return searchTeachers;

    }

    public List<Teacher> searchFaculryDepartment(String firstField, String secondField, Boolean remove) {
        this.remove = remove;
        searchTeachers.clear();
        for (Iterator<Teacher> teacherIterator = storage.getTeacherList().iterator(); teacherIterator.hasNext();) {
            Teacher teacher = teacherIterator.next();
            if (teacher.getFaculty().toString().equals(firstField)
                    && teacher.getDepartmentName().toString().equals(secondField))  {
                searchTeachers.add(teacher);
            }
        }
        remove();
        return searchTeachers;

    }

    public List<Teacher> getSearchList() {
        return searchTeachers;
    }

    private void remove() {
        if (remove) {
            storage.deleteDate(searchTeachers);
        }
    }

}

