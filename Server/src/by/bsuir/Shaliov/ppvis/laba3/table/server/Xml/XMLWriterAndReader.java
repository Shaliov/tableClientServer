package by.bsuir.Shaliov.ppvis.laba3.table.server.Xml;

import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.constants.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andrey on 6/21/2016.
 */
public class XMLWriterAndReader {
    private List<Teacher> teacherList;
    private String nameFile;

    public XMLWriterAndReader(String nameFile, List<Teacher> studentList) {
        this.nameFile = nameFile;
        this.teacherList = studentList;
    }

    public void writeFile() throws IOException, TransformerException,
            ParserConfigurationException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element tableEl = doc.createElement(XmlTag.TEACHERS);
        doc.appendChild(tableEl);

        for (Teacher teachers : teacherList) {
            Element teacher = doc.createElement(XmlTag.TEACHER);
            tableEl.appendChild(teacher);

            Element name = doc.createElement(XmlTag.NAME);
            name.appendChild(doc.createTextNode(teachers.getName()));
            teacher.appendChild(name);

            Element subName = doc.createElement(XmlTag.SECONDARY_NAME);
            subName.appendChild(doc.createTextNode(teachers.getSecondaryName()));
            teacher.appendChild(subName);

            Element middleName = doc.createElement(XmlTag.MIDLE_NAME);
            middleName.appendChild(doc.createTextNode(teachers.getMiddleName()));
            teacher.appendChild(middleName);

            Element departmentName = doc.createElement(XmlTag.DEPARTMENT_NAME);
            departmentName.appendChild(doc.createTextNode(teachers.getDepartmentName().toString()));
            teacher.appendChild(departmentName);

            Element faculty = doc.createElement(XmlTag.FACULTY);
            faculty.appendChild(doc.createTextNode(teachers.getFaculty().toString()));
            teacher.appendChild(faculty);

            Element academicTitle = doc.createElement(XmlTag.ACADEMIC_TITLE);
            academicTitle.appendChild(doc.createTextNode(teachers.getAcademicTitle().toString()));
            teacher.appendChild(academicTitle);

            Element academicDegree = doc.createElement(XmlTag.ACADEMIC_DEGREE);
            academicDegree.appendChild(doc.createTextNode(teachers.getAcademicDegree().toString()));
            teacher.appendChild(academicDegree);
        }

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(nameFile));
        transformer.transform(source, result);
    }

    public void readFile() throws SAXException, IOException,
            ParserConfigurationException {
        File file = new File(nameFile);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxParserFactory.newSAXParser();

        parser.parse(file, new Handler(teacherList));

    }
}