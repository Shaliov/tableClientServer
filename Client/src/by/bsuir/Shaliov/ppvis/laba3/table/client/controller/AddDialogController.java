package by.bsuir.Shaliov.ppvis.laba3.table.client.controller;

import by.bsuir.Shaliov.ppvis.laba3.table.overall.constants.*;

import by.bsuir.Shaliov.ppvis.laba3.table.client.view.frame.MainFrame;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;


import java.io.IOException;

/**
 * Created by Andrey on 5/31/2016.
 */
public class AddDialogController {
    private static AddDialogController instance = null;
    private MainFrame mainFrame;

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    private AddDialogController() {

    }

    public void addTeacherToServer(Teacher teacher) {
        try {

            ToServerController.getInstance().getOutputStream().writeObject(ClientServer.ADD_TEACHER);
            ToServerController.getInstance().getOutputStream().flush();
            ToServerController.getInstance().getOutputStream().writeObject(teacher);
            ToServerController.getInstance().getOutputStream().flush();
            TableController.getInstance().firstPage();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    public static AddDialogController getInstance() {
        if (instance == null) {
            instance = new AddDialogController();
        }
        return instance;
    }

}
