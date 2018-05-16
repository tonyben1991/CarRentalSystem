package com.tonyben1991.view;

import com.tonyben1991.bean.ClientThread;

import javax.swing.*;

/**
 * @author oaec
 * @date 2018-05-15
 **/
public abstract class Dialog {
    ClientThread clientThread;
    JDialog jDialog;

    public Dialog() {
    }

    public Dialog(ClientThread clientThread) {
        this.clientThread = clientThread;
    }

    /**
     * 设置窗口的布局
     *
     * @param jPanel 传入的中间容器Panel
     */
    abstract void placeComponents(JPanel jPanel);
}
