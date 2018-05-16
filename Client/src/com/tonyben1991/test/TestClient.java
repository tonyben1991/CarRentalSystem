package com.tonyben1991.test;

import com.tonyben1991.bean.ClientThread;
import com.tonyben1991.view.LoginWindow;
import com.tonyben1991.view.MainWindow;

/**
 * @author oaec
 * @date 2018-05-15
 **/
public class TestClient {
    public static void main(String[] args) {
        ClientThread clientThread = new ClientThread();
        clientThread.start();
        new MainWindow(clientThread);
    }
}
