package by.bsuir.Shaliov.ppvis.laba3.table.server;


import by.bsuir.Shaliov.ppvis.laba3.table.overall.model.Teacher;
import com.sun.deploy.trace.SocketTraceListener;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 6/15/2016.
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public Server() {
        serverSocket = null;
        clientSocket = null;
    }

    public void createServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Порт занят " + port);
            System.exit(-1);
        }
    }

    public void read() {
        try {
            clientSocket = serverSocket.accept();
            try {
                BufferedInputStream bis = new BufferedInputStream(clientSocket.getInputStream());
                ObjectInputStream ois = new ObjectInputStream(bis);
                try {

                    List<Teacher> obj2 = (List<Teacher>) ois.readObject();
                    System.out.println("value: " + obj2.get(0).getFio());
                } catch (Exception e) {
                }


            } catch (IOException e) {
                System.out.println("Ошибка при подключению к порту ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void close() {

        try {
            serverSocket.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("сервера нету");
        }

    }

}
