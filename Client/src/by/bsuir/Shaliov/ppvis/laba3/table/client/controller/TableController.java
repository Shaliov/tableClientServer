package by.bsuir.Shaliov.ppvis.laba3.table.client.controller;

import by.bsuir.Shaliov.ppvis.laba3.table.overall.constants.*;

import by.bsuir.Shaliov.ppvis.laba3.table.client.model.TableModel;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 5/31/2016.
 */
public class TableController {
    private static TableController instance = null;
    private JSlider slider;
    private JLabel sliderMark;
    private int rowOnPage;
    private TableModel tableModel;

    private TableController() {

    }

    public ChangeListener addSlideListener() {
        return e -> {
            slider = (JSlider) e.getSource();
            if (!slider.getValueIsAdjusting()) {
                try {
                    ToServerController.getInstance().getOutputStream().writeObject(ClientServer.NUMBER_RECORDS);
                    ToServerController.getInstance().getOutputStream().writeObject(tableModel.getName());
                    ToServerController.getInstance().getOutputStream().writeObject(slider.getValue());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                firstPage();
            }
        };
    }


    public void refresh() {
        tableModel.fireTableDataChanged();
    }


    public void firstPage() {
            try {
                ToServerController.getInstance().getOutputStream().writeObject(ClientServer.ALL_RECORD);
                rowOnPage = (int) ToServerController.getInstance().getInputStream().readObject();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            sliderMark.setText(String.valueOf(rowOnPage));
            try {
                ToServerController.getInstance().getOutputStream().writeObject(ClientServer.FIRST_PAGE);
                ToServerController.getInstance().getOutputStream().writeObject(tableModel.getName());
                tableModel.setTeacherList((List<Teacher>) ToServerController.getInstance().getInputStream().readObject());

            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "Server disconnected");

            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            refresh();
    }


    public void lastPage() {
        try {
            ToServerController.getInstance().getOutputStream().writeObject(ClientServer.LAST_PAGE);
            ToServerController.getInstance().getOutputStream().writeObject(tableModel.getName());
            tableModel.setTeacherList((List<Teacher>) ToServerController.getInstance().getInputStream().readObject());
            refresh();

        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "Server disconnected");

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public void prev() {
            try {
                ToServerController.getInstance().getOutputStream().writeObject(ClientServer.PREVIOUS_PAGE);
                ToServerController.getInstance().getOutputStream().writeObject(tableModel.getName());
                tableModel.setTeacherList((List<Teacher>) ToServerController.getInstance().getInputStream().readObject());
                refresh();
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "Server disconnected");

            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
    }

    public void next() {
            try {
                ToServerController.getInstance().getOutputStream().writeObject(ClientServer.NEXT_PAGE);
                ToServerController.getInstance().getOutputStream().writeObject(tableModel.getName());
                tableModel.setTeacherList((List<Teacher>) ToServerController.getInstance().getInputStream().readObject());
                refresh();

            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "Server disconnected");

            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
    }

    public void clear() {
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.clear();
        tableModel.setTeacherList(teacherList);
        refresh();
    }

    public static TableController getInstance() {
        if (instance == null) {
            instance = new TableController();
        }
        return instance;
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JSlider getSlider() {
        return slider;
    }

    public JLabel getSliderMark() {
        return sliderMark;
    }

    public int getRowOnPage() {
        return rowOnPage;
    }

    public void setSlider(JSlider slider) {
        this.slider = slider;
    }

    public void setSliderMark(JLabel sliderMark) {
        this.sliderMark = sliderMark;
    }

    public void setRowOnPage(int rowOnPage) {
        this.rowOnPage = rowOnPage;
    }

}
