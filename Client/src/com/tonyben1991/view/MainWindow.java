package com.tonyben1991.view;

import com.tonyben1991.bean.ClientThread;
import com.tonyben1991.bean.SocketMessage;
import com.tonyben1991.bean.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public class MainWindow extends Window {

    public MainWindow(ClientThread clientThread) {
        super(clientThread);
        jFrame = new JFrame("Main");
        jFrame.setLocation(400, 200);
        jFrame.setSize(800, 600);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        placeComponents(jPanel);
        jFrame.setVisible(true);
        new LoginWindow(clientThread);
    }

    @Override
    void placeComponents(JPanel jPanel) {
        JButton loginBtn = new JButton("LOGIN");
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginWindow(clientThread);
            }
        });
        loginBtn.setBounds(100, 180, 80, 30);
        jPanel.add(loginBtn);
    }
}
