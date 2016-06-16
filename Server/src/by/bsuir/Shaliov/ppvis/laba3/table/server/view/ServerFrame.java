package by.bsuir.Shaliov.ppvis.laba3.table.server.view;



import by.bsuir.Shaliov.ppvis.laba3.table.server.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrey on 6/15/2016.
 */
public class ServerFrame extends JFrame {
    private Server server;

    public ServerFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setTitle("Server");
        setSize(screenWidth / 2 + 10, screenHeight / 2 + 20);
        setLocation(screenWidth / 4, screenHeight / 4);

        Box box = Box.createVerticalBox();

        server = new Server();

        Button run = new Button("Run");
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == run) {
                    server.createServer(9999);
                    server.read();
                }
            }
        });
        box.add(run);

        Button close = new Button("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == close) {
                    server.close();
                }
            }
        });
        box.add(close);
        box.revalidate();
        add(box);


        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
