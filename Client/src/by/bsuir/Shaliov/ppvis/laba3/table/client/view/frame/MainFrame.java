package by.bsuir.Shaliov.ppvis.laba3.table.client.view.frame;


import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.AddDialogController;
import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.MainFrameController;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.bar.MainBar;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.panel.TableComponent;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.bar.MenuBar;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Andrey on 5/30/2016.
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setTitle("Table");
        setSize(screenWidth / 2 + 10, screenHeight / 2 + 20);
        setLocation(screenWidth / 4, screenHeight / 4);

        MenuBar menuBar = new MenuBar();
        add(menuBar, "North");

        MainBar mainBar = new MainBar();
        mainBar.setOrientation(SwingConstants.VERTICAL);
        add(mainBar, "West");

        TableComponent tableComponent = new TableComponent();
        MainFrameController.getInstance().setTableComponent(tableComponent);
        add(tableComponent);

        MainFrameController mainFrameController = MainFrameController.getInstance();
        mainFrameController.setMainFrame(this);

        AddDialogController.getInstance().setMainFrame(this);

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
