package by.bsuir.Shaliov.ppvis.laba3.table.server.Xml;

import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.constants.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

/**
 * Created by Andrey on 6/21/2016.
 */
public class Handler extends DefaultHandler {

    List<Teacher> teachers;
    Teacher teacher;
    String thisElement = "";

    public Handler(List<Teacher> teacherList) {
        teachers = teacherList;
    }


    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
        if (thisElement.equals(XmlTag.TEACHER)) {
            teacher = new Teacher();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = qName;
        if (thisElement.equals(XmlTag.TEACHER)) {
            teachers.add(teacher);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals(XmlTag.NAME)) {
            teacher.setName(new String(ch, start, length));
        }
        if (thisElement.equals(XmlTag.SECONDARY_NAME)) {
            teacher.setSecondaryName(new String(ch, start, length));
        }
        if (thisElement.equals(XmlTag.MIDLE_NAME)) {
            teacher.setMiddleName(new String(ch, start, length));
        }
        if (thisElement.equals(XmlTag.ACADEMIC_DEGREE)) {
            teacher.setAcademicTitle(new String(ch, start, length));
        }
        if (thisElement.equals(XmlTag.ACADEMIC_TITLE)) {
            teacher.setAcademicDegree(new String(ch, start, length));
        }
        if (thisElement.equals(XmlTag.DEPARTMENT_NAME)) {
            teacher.setDepartmentName(new String(ch, start, length));
        }
        if (thisElement.equals(XmlTag.FACULTY)) {
            teacher.setFaculty(new String(ch, start, length));
        }

    }


    public List<Teacher> getTeachers() {
        return teachers;
    }

    public Teacher getResult() {
        return teacher;
    }
}