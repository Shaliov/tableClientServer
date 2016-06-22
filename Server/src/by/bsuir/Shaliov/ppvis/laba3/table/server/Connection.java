package by.bsuir.Shaliov.ppvis.laba3.table.server;

import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba3.table.server.Xml.XMLWriterAndReader;
import by.bsuir.Shaliov.ppvis.laba3.table.server.page.Page;
import by.bsuir.Shaliov.ppvis.laba3.table.server.searchAndRemove.SearcherAndRemover;
import by.bsuir.Shaliov.ppvis.laba3.table.server.storage.Storage;
import org.xml.sax.SAXException;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.constants.*;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Created by Andrey on 6/21/2016.
 */
public class Connection extends Thread {
    private ServerSocket serverSocket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    private Storage storage;
    private Storage storageSearch;
    private Page page;
    private Page pageSearch;
    private JTextArea textArea;
    private JFileChooser jFileChooser;
    private SearcherAndRemover searcherAndRemover;


    private Boolean remove;
    private List<Teacher> searchList;

    public Connection(Socket connection, Page page, Storage storage, JTextArea textArea)
            throws IOException {
        this.page = page;
        this.storage = storage;
        this.textArea = textArea;
        searcherAndRemover = new SearcherAndRemover(storage);
        storageSearch = new Storage();
        storageSearch.setNumberRecords(storage.getNumberRecords());
        pageSearch = new Page(storageSearch);

        outputStream = new ObjectOutputStream(connection.getOutputStream());
        inputStream = new ObjectInputStream(connection.getInputStream());
        outputStream.flush();

        start();
    }

    public void run() {

        String message;
        String nameFile = "";
        String nameTable;
        try {
            while (true) {
                message = (String) inputStream.readObject();
                textArea.append("\n" + message);
                switch (message) {
                    case ClientServer.FIRST_PAGE:
                        nameTable = (String) inputStream.readObject();
                        if (nameTable.equals("teacherTable")) {
                            outputStream.writeObject(page.goLeftStart());
                        } else {
                            outputStream.writeObject(pageSearch.goLeftStart());
                        }
                        break;

                    case ClientServer.PREVIOUS_PAGE:
                        nameTable = (String) inputStream.readObject();
                        if (nameTable.equals("teacherTable")) {
                            outputStream.writeObject(page.goLeft());
                        } else {
                            outputStream.writeObject(pageSearch.goLeft());
                        }
                        break;

                    case ClientServer.NEXT_PAGE:
                        nameTable = (String) inputStream.readObject();
                        if (nameTable.equals("teacherTable")) {
                            outputStream.writeObject(page.goRight());
                        } else {
                            outputStream.writeObject(pageSearch.goRight());
                        }
                        break;

                    case ClientServer.LAST_PAGE:
                        nameTable = (String) inputStream.readObject();
                        if (nameTable.equals("teacherTable")) {
                            outputStream.writeObject(page.goRightEnd());
                        } else {
                            outputStream.writeObject(pageSearch.goRightEnd());
                        }
                        break;

                    case ClientServer.NUMBER_RECORDS:
                        nameTable = (String) inputStream.readObject();
                        if (nameTable.equals("teacherTable")) {
                            storage.setNumberRecords((Integer) inputStream
                                    .readObject());
                        } else {
                            storageSearch.setNumberRecords((Integer) inputStream
                                    .readObject());
                        }
                        break;

                    case ClientServer.ADD_TEACHER:
                        storage.addDate((Teacher) inputStream.readObject());
                        break;

                    case ClientServer.OPEN_FILE:
                        File myFolder = new File("D:\\TestXML");
                        File[] files = myFolder.listFiles();
                        outputStream.writeObject(files);
                        nameFile = (String) inputStream.readObject();
                        try {
                            new XMLWriterAndReader(nameFile,
                                    storage.getTeacherList()).readFile();
                        } catch (SAXException | IOException
                                | ParserConfigurationException e1) {
                            e1.printStackTrace();
                        }
                        break;

                    case ClientServer.SAVE_AS:
                        nameFile = (String) inputStream.readObject();
                        try {
                            new XMLWriterAndReader("D:\\TestXML\\" + nameFile,
                                    storage.getTeacherList()).writeFile();
                            System.out.println(nameFile);
                        } catch (IOException | ParserConfigurationException e1) {
                            e1.printStackTrace();
                        } catch (TransformerException e) {
                            e.printStackTrace();
                        }
                        break;

                    case ClientServer.FIO_DEPARTMENT:
                        String fio = (String) inputStream.readObject();
                        String departmentName = (String) inputStream.readObject();
                        remove = (Boolean) inputStream.readObject();
                        searchList = searcherAndRemover.searchFioDepartment(
                                fio, departmentName, remove);
                        if (remove == false) {
                            outputStream.writeObject(searchList);
                        } else {
                            outputStream.writeObject(searchList.size());
                        }
                        storageSearch.setTeacherList(searchList);
                        break;

                    case ClientServer.DEPARTMENT_ACADEMIC_TITLE:
                        String departmentNamee = (String) inputStream.readObject();
                        String academicTitle = (String) inputStream.readObject();
                        remove = (Boolean) inputStream.readObject();
                        searchList = searcherAndRemover.searchDepartmentAcademic(
                                departmentNamee, academicTitle, remove);
                        if (remove == false) {
                            outputStream.writeObject(searchList);
                        } else {
                            outputStream.writeObject(searchList.size());
                        }
                        storageSearch.setTeacherList(searchList);
                        break;
                    case ClientServer.FACULTU_DEPARTMENT:

                        String faculty = (String) inputStream.readObject();
                        String department1 = (String) inputStream.readObject();
                        remove = (Boolean) inputStream.readObject();
                        searchList = searcherAndRemover.searchFaculryDepartment(faculty,
                                department1, remove);
                        if (remove == false) {
                            outputStream.writeObject(searchList);
                        } else {
                            outputStream.writeObject(searchList.size());
                        }
                        storageSearch.setTeacherList(searchList);
                        break;
                    default:
                        break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            textArea.append("\nClient disconnected");
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}