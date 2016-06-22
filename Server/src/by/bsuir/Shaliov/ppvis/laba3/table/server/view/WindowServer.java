package by.bsuir.Shaliov.ppvis.laba3.table.server.view;

import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;
import by.bsuir.Shaliov.ppvis.laba3.table.server.Connection;
import by.bsuir.Shaliov.ppvis.laba3.table.server.page.Page;
import by.bsuir.Shaliov.ppvis.laba3.table.server.storage.Storage;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Created by Andrey on 6/21/2016.
 */
public class WindowServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private Connection connection;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    private JTextArea textArea;
    private List<Teacher> teacherList;

    private Storage storage;
    private Page page;

    public WindowServer() {
        JFrame frame = new JFrame("Server");
        frame.setSize(250, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);

        storage = new Storage();
        teacherList = storage.getTeacherList();
        
        page = new Page(storage);

    }
    public void startRunningServer() {
        try  {
            serverSocket = new ServerSocket(5225);
            textArea.append("Server is Running");

            while (true) {
                socket = serverSocket.accept();
                textArea.append("\nClient "
                        + socket.getInetAddress().getCanonicalHostName()
                        + " connected");

                connection = new Connection(socket, page, storage, textArea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
