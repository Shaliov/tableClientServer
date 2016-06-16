package by.bsuir.Shaliov.ppvis.laba3.table.client.controller;


import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Andrey on 5/26/2016.
 */
public class XMLRead extends DefaultHandler {
    List<Teacher> teachers;
    Teacher teacher;
    String thisElement = "";

    @Override
    public void startDocument() throws SAXException {
        teachers = new ArrayList<>();
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
        if (thisElement.equals("teacher")) {
            teacher = new Teacher();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = qName;
        if (thisElement.equals("teacher")) {
            teachers.add(teacher);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("name")) {
            teacher.setName(new String(ch, start, length));
        }
        if (thisElement.equals("secondaryName")) {
            teacher.setSecondaryName(new String(ch, start, length));
        }
        if (thisElement.equals("middleName")) {
            teacher.setMiddleName(new String(ch, start, length));
        }
        if (thisElement.equals("academicDegree")) {
            teacher.setAcademicTitle(new String(ch, start, length));
        }
        if (thisElement.equals("academicTitle")) {
            teacher.setAcademicDegree(new String(ch, start, length));
        }
        if (thisElement.equals("departmentName")) {
            teacher.setDepartmentName(new String(ch, start, length));
        }
        if (thisElement.equals("faculty")) {
            teacher.setFaculty(new String(ch, start, length));
        }

    }

    @Override
    public void endDocument() {
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public Teacher getResult() {
        return teacher;
    }
}