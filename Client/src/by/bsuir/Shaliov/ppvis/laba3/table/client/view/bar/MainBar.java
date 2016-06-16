package by.bsuir.Shaliov.ppvis.laba3.table.client.view.bar;


import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.MainFrameController;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Andrey on 5/30/2016.
 */
public class MainBar extends JToolBar {
    private MainFrameController mainFrameController = MainFrameController.getInstance();

    public MainBar() {
        addBarMain();
    }

    private void addBarMain() {
        AbstractAction newEntry = new AbstractAction("new entry ", new ImageIcon("src\\resources\\add.png")) {
            public void actionPerformed(ActionEvent event) {
                mainFrameController.newAddDialog();
            }
        };
        AbstractAction deleteEntry = new AbstractAction("delete entry", new ImageIcon("src\\resources\\remove.png")) {
            public void actionPerformed(ActionEvent event) {
                mainFrameController.newDeleteDialog();
            }
        };
        AbstractAction findEntry = new AbstractAction("find entry", new ImageIcon("src\\resources\\search.png")) {
            public void actionPerformed(ActionEvent event) {
                mainFrameController.newFindDealog();
            }
        };
        add(newEntry);
        add(deleteEntry);
        add(findEntry);
    }
}
