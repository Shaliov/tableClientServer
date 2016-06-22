package by.bsuir.Shaliov.ppvis.laba3.table.client.view.panel;


import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.TableController;
import by.bsuir.Shaliov.ppvis.laba3.table.client.model.TableModel;
import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrey on 5/30/2016.
 */
public class TableComponent extends JPanel {

    private JScrollPane scrollPane;
    private TableModel tableModel;
    private JLabel sliderMark;
    private JSlider slider;
    private TableController tableController = TableController.getInstance();

    public TableComponent() {
        tableModel = new TableModel();
        tableController.setTableModel(tableModel);
        tableModel.setName("teacherTable");
        TableController.getInstance().setTableModel(tableModel);


        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);


        JTable table = new JTable(tableModel);
        Dimension dimension = new Dimension(screenWidth / 2, screenHeight / 2);
        table.setPreferredSize(dimension);
        scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(screenWidth / 2 - 90, screenHeight / 2 - 100));
        scrollPane.revalidate();


        Box box = Box.createHorizontalBox();
        addBarPage(box);
        addSlider(box);


        add(scrollPane, "Center");
        add(box, "South");
        setVisible(true);
    }

    public TableComponent(java.util.List<Teacher> teacherList) {
        tableModel = new TableModel();
        tableModel.setTeacherList(teacherList);
        tableController.setTableModel(tableModel);
        tableModel.setName(" ");
        TableController.getInstance().setTableModel(tableModel);


        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2 - 100, screenHeight / 2 - 100);

        JTable table = new JTable(tableModel);
        Dimension dimension = new Dimension(screenWidth / 2, screenHeight / 2);
        table.setPreferredSize(dimension);
        scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(screenWidth / 2 - 90, screenHeight / 2 - 100));
        scrollPane.revalidate();


        Box box = Box.createHorizontalBox();
        addBarPage(box);
        addSlider(box);


        add(scrollPane, "Center");
        add(box, "South");
        setVisible(true);
    }

    public void addBarPage(Box box) {
        JButton first = new JButton("first", new ImageIcon("src\\resources\\first.png"));
        first.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableController.getInstance().firstPage();
            }
        });

        JButton prev = new JButton("prev", new ImageIcon("src\\resources\\prev.png"));
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableController.getInstance().prev();
            }
        });


        JButton next = new JButton("next", new ImageIcon("src\\resources\\next.png"));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableController.getInstance().next();
            }
        });

        JButton last = new JButton("last", new ImageIcon("src\\resources\\last.png"));
        last.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableController.getInstance().lastPage();
            }
        });


        box.add(first);
        box.add(prev);
        box.add(next);
        box.add(last);
    }

    private void addSlider(Box box) {
        slider = new JSlider(0, 20, 2);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        sliderMark = new JLabel(String.valueOf(2));
        slider.addChangeListener(tableController.addSlideListener());

        tableController.setSlider(slider);
        tableController.setSliderMark(sliderMark);
        tableController.setRowOnPage(2);
        box.add(slider);
        box.add(Box.createHorizontalStrut(12));
        box.add(sliderMark);
    }


    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

}
