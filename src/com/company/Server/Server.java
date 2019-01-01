package com.company.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        while (true) {
            Socket redPlayer = null;
            ObjectOutputStream outRedPlayer = null;
            ObjectInputStream inRedPlayer = null;
            Socket bluePlayer = null;
            ObjectOutputStream outBluePlayer = null;
            ObjectInputStream inBluePlayer = null;
            ///////////////////////////////
            ServerSocket serverSocket = new ServerSocket(8888,2);
            redPlayer = serverSocket.accept();
            outRedPlayer = new ObjectOutputStream(redPlayer.getOutputStream());
            inRedPlayer = new ObjectInputStream(redPlayer.getInputStream());
            bluePlayer = serverSocket.accept();
            outBluePlayer = new ObjectOutputStream(bluePlayer.getOutputStream());
            inBluePlayer = new ObjectInputStream(bluePlayer.getInputStream());
        }
    }
}
