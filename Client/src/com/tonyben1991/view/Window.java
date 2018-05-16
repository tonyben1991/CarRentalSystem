package com.tonyben1991.view;

import com.tonyben1991.bean.ClientThread;
import com.tonyben1991.bean.SocketMessage;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author oaec
 * @date 2018-05-15
 **/
public abstract class Window {
    ClientThread clientThread;
    JFrame jFrame;

    public Window() {
    }

    public Window(ClientThread clientThread) {
        this.clientThread = clientThread;
    }

    /**
     * 设置窗口的布局
     *
     * @param jPanel 传入的中间容器Panel
     */
    abstract void placeComponents(JPanel jPanel);
}
