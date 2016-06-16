package by.bsuir.Shaliov.ppvis.laba3.table.client.controller;


import by.bsuir.Shaliov.ppvis.laba3.table.client.Client;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.frame.MainFrame;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;

import java.util.List;

/**
 * Created by Andrey on 5/31/2016.
 */
public class AddDialogController {
    private static AddDialogController instance = null;
    private MainFrame mainFrame;
    private Client client;

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    private AddDialogController() {
        client = new Client();
    }

    public void addTeacherListToServer(String name,List<Teacher> teacherList) {
        client.connect("localhost", 9999);
        client.read(teacherList);

    }


    public static AddDialogController getInstance() {
        if (instance == null) {
            instance = new AddDialogController();
        }
        return instance;
    }

}
