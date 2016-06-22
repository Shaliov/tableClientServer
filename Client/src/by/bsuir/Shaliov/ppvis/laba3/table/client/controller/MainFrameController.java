package by.bsuir.Shaliov.ppvis.laba3.table.client.controller;


import by.bsuir.Shaliov.ppvis.laba3.table.client.view.dialog.AddDialog;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.dialog.DeleteDialog;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.dialog.FindDialog;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.frame.MainFrame;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.panel.TableComponent;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Andrey on 5/31/2016.
 */
public class MainFrameController {
    private static MainFrameController instance = null;
    private MainFrame mainFrame;
    private AddDialog addDialog;
    private DeleteDialog deleteDialog;
    private FindDialog findDialog;
    private TableComponent tableComponent;


    private MainFrameController() {
    }

    public void newAddDialog() {
        if (addDialog == null) {
            addDialog = new AddDialog();
        }
        addDialog.setVisible(true);
    }

    public void newFindDealog() {
        if(findDialog == null) {
            findDialog = new FindDialog();
        }
        findDialog.setVisible(true);
    }

    public void newDeleteDialog() {
        if(deleteDialog == null) {
            deleteDialog = new DeleteDialog();
        }
        deleteDialog.setTableComponent(tableComponent);
        deleteDialog.setVisible(true);
    }

    public void refresh(TableComponent tableComponent) {
        tableComponent.getScrollPane().repaint();
        tableComponent.revalidate();
        mainFrame.repaint();
    }

    public void refresh() {
        mainFrame.revalidate();
    }

    public static MainFrameController getInstance() {
        if (instance == null) {
            instance = new MainFrameController();
        }
        return instance;
    }
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setTableComponent(TableComponent tableComponent) {
        this.tableComponent = tableComponent;
    }
}
