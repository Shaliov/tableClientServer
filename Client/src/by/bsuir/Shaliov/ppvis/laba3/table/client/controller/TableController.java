package by.bsuir.Shaliov.ppvis.laba3.table.client.controller;


import by.bsuir.Shaliov.ppvis.laba3.table.client.model.TableModel;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;

import javax.swing.*;
import javax.swing.event.ChangeListener;
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
    private int numberOfPage = 1;
    private int lastPage;
    private TableModel tableModel;

    private TableController() {

    }

    public ChangeListener addSlideListener() {
        return e -> {
            slider = (JSlider) e.getSource();
            if (!slider.getValueIsAdjusting()) {
                rowOnPage = slider.getValue();
                sliderMark.setText(String.valueOf(rowOnPage));
                setNumberOfPage(1);
                firstPage();
            }
        };
    }

    public void changeNumberOfPage() {
//        if (rowOnPage < DBStorage.getInstance().getTeacherList().size()) {
//            tableModel.setTeacherList(DBStorage.getInstance().getTeacherList(0, rowOnPage));
//        } else {
//            tableModel.setTeacherList(DBStorage.getInstance().getTeacherList());
//        }
        refresh();
    }

    public void changeNumberOfPage(List<Teacher> teachers) {
        tableModel.setTeacherList(teachers);
        refresh();
    }


    public void refresh() {
        tableModel.fireTableDataChanged();
    }


    public void firstPage() {
        setNumberOfPage(1);
        changeNumberOfPage();
    }

    public void lastPage() {

        int rowOnPage = getRowOnPage();
        int lastPage = getLastPage();

        if (tableModel.getTempList().size() % rowOnPage == 0) {
            setLastPage((int) Math.round((double) (tableModel.getTempList().size() / rowOnPage)));
            setNumberOfPage(getLastPage());
            changeNumberOfPage(tableModel.getTempList((rowOnPage * getLastPage()) - rowOnPage,
                    tableModel.getTempList().size()));
        } else {
            setLastPage((int) Math.round((double) (tableModel.getTempList().size() / rowOnPage) + 1));
            setNumberOfPage(getLastPage());
            changeNumberOfPage(tableModel.getTempList(rowOnPage * (getLastPage() - 1),
                    tableModel.getTempList().size()));
        }
    }

    public void prev() {
        if (getNumberOfPage() > 1) {
            setNumberOfPage(getNumberOfPage() - 1);
            int numberOfPage = getNumberOfPage();
            int rowOnPage = getRowOnPage();
            changeNumberOfPage(tableModel.getTempList(rowOnPage * numberOfPage - rowOnPage,
                    rowOnPage * numberOfPage));
        }
    }

    public void next() {
        int numberOfPage = getNumberOfPage();
        int rowOnPage = getRowOnPage();

//        if (DBStorage.getInstance().getTeacherList().size() % rowOnPage == 0) {
//            setLastPage((int) Math.round((double) (tableModel.getTempList().size() / rowOnPage)));
//        } else {
//            setLastPage((int) Math.round((double) (tableModel.getTempList().size() / rowOnPage) + 1));
//        }
//        int lastPage = getLastPage();
//        if (numberOfPage != lastPage) {
//            setNumberOfPage(numberOfPage + 1);
//            if (tableModel.getTempList().size() % rowOnPage != 0 && numberOfPage + 1 == lastPage) {
//                changeNumberOfPage(tableModel.getTempList(rowOnPage * numberOfPage,
//                        tableModel.getTempList().size()));
//            } else {
//                changeNumberOfPage(tableModel.getTempList(rowOnPage * numberOfPage,
//                        rowOnPage * (numberOfPage + 1)));
//            }
//        } else if (numberOfPage == lastPage) {
//            setNumberOfPage(lastPage);
//            lastPage();
//        }
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

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }


}
