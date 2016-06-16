package by.bsuir.Shaliov.ppvis.laba3.table.client;


import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by Andrey on 6/15/2016.
 */
public class Client {
    private Socket socket;

    public Client() {
        socket = null;
    }

    public void connect(String host, int port) {
        if (socket == null)
            try {
                socket = new Socket(host, port);
            } catch (UnknownHostException e) {
                System.out.println("Неизвестный хост: " + host);
                System.exit(-1);
            } catch (IOException e) {
                System.out.println("Ошибка ввода/вывода при создании сокета " + host + ":" + port);
                System.exit(-1);
            }
    }

    public void read(List<Teacher> teacherList) {
        try {
            BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
            ObjectOutputStream objectOutput = new ObjectOutputStream(out);
            objectOutput.writeObject(teacherList);
            objectOutput.flush();
            socket.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи сообщения.");
        }

    }

}
