package by.bsuir.Shaliov.ppvis.laba3.table.client.controller;


import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Andrey on 6/22/2016.
 */
public class ToServerController {
    private static ToServerController instance = null;
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    private ToServerController() {

    }

    public static ToServerController getInstance() {
        if(instance == null) {
            instance = new ToServerController();
        }
        return instance;
    }

    public void startRunningClient() {
        try {
            socket = new Socket(JOptionPane.showInputDialog("host: ").trim(), 5225);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream.flush();
        } catch (IOException e) {
            startRunningClient();
        }
    }

    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }



}
