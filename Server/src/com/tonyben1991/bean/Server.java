package com.tonyben1991.bean;

import com.tonyben1991.view.LoginView;
import com.tonyben1991.view.MainView;
import com.tonyben1991.view.View;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author oaec
 * @date 2018-05-15
 **/
public class Server {
    int port;
    List<Socket> clients;
    ServerSocket serverSocket;

    public Server() {
        try {

            port = 8989;
            clients = new ArrayList<Socket>();
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                clients.add(socket);
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }
        } catch (Exception ex) {
        }
    }

    public class ServerThread extends Thread {
        Socket socket;
        private ObjectInputStream ois;
        private ObjectOutputStream oos;
        BlockingQueue<SocketMessage> msgQueueReceived;
        BlockingQueue<SocketMessage> msgQueueToSend;

        public ServerThread(Socket socket) {
            this.socket = socket;
            msgQueueReceived = new LinkedBlockingQueue<>();
            msgQueueToSend = new LinkedBlockingQueue<>();
        }

        @Override
        public void run() {
            try {
                ois = new ObjectInputStream(socket.getInputStream());
                oos = new ObjectOutputStream(socket.getOutputStream());
                new MsgThread().start();
                View view = new MainView(this);
                while (null != view) {
                    System.out.println("121213");
                    view = view.operate();
                }
            } catch (Exception ex) {

            }
        }

        class HeartBeatThread extends Thread{
            @Override
            public void run() {
                while (true){

                }
            }
        }

        class MsgThread extends Thread {
            @Override
            public void run() {
                while (true) {
                    receiveMsg();
                    sendMsg();
                }
            }
        }

        private void sendMsg() {
            try {
                while (0 == msgQueueToSend.size()) {
                    System.out.println(socket);
                }
                oos.writeObject(msgQueueToSend.take());
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void receiveMsg() {
            try {
                msgQueueReceived.put((SocketMessage) ois.readObject());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public SocketMessage getMsg(Boolean remove) {
            SocketMessage msg = null;
            while (0 == msgQueueReceived.size()) {
            }
            try {
                msg = msgQueueReceived.take();
                if (!remove) {
                    msgQueueReceived.put(msg);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return msg;
        }

        public void setMsg(SocketMessage msg) {
            try {
                msgQueueToSend.put(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
