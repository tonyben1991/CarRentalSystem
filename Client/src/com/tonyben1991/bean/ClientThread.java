package com.tonyben1991.bean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public class ClientThread extends Thread {
    private int port;
    private Socket socket = null;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private BlockingQueue<SocketMessage> msgQueueReceived;
    private BlockingQueue<SocketMessage> msgQueueToSend;


    public ClientThread() {
        this.port = 8989;
        msgQueueReceived = new LinkedBlockingQueue<>();
        msgQueueToSend = new LinkedBlockingQueue<>();
    }

    @Override
    public void run() {
        try {
            socket = new Socket("127.0.0.1", port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            while (true) {
                sendMsg();
                receiveMsg();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMsg() {
        try {
            while (0 == msgQueueToSend.size()) {
            }
            oos.writeObject(msgQueueToSend.take());
            oos.flush();
        } catch (Exception ex) {
        }
    }

    private void receiveMsg() {
        try {
            msgQueueReceived.put((SocketMessage) ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addMsg(SocketMessage msg) {
        try {
            msgQueueToSend.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public SocketMessage getMsg() {
        SocketMessage msg = null;
        try {
            while (0 == msgQueueReceived.size()) {
            }
            msg = msgQueueReceived.take();
            System.out.println(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
