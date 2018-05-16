package com.tonyben1991.view;

import com.tonyben1991.bean.ClientThread;
import com.tonyben1991.bean.SocketMessage;
import com.tonyben1991.bean.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author oaec
 * @date 2018-05-15
 **/
public class LoginWindow extends Window {

    public LoginWindow() {
    }

    public LoginWindow(ClientThread clientThread) {
        super(clientThread);
        jFrame = new JFrame("Login");
        jFrame.setLocation(400, 200);
        jFrame.setSize(400, 300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        placeComponents(jPanel);
        jFrame.setVisible(true);
    }

    @Override
    void placeComponents(JPanel jPanel) {
        jPanel.setLayout(null);
        JLabel userNameLab = new JLabel("USERNAME");
        userNameLab.setBounds(50, 40, 80, 20);
        jPanel.add(userNameLab);
        JTextField userNameText = new JTextField();
        userNameText.setBounds(180, 40, 150, 20);
        jPanel.add(userNameText);
        JLabel passwordLab = new JLabel("PASSWORD");
        passwordLab.setBounds(50, 100, 80, 20);
        jPanel.add(passwordLab);
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(180, 100, 150, 20);
        jPanel.add(passwordText);
        JButton loginBtn = new JButton("LOGIN");
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientThread.addMsg(new SocketMessage<>(1, new User(userNameText.getText(), new String(passwordText.getPassword()))));
                switch ((int) clientThread.getMsg().getMsg()) {
                    case 1:
                        System.out.println("success");
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null,
                                "密码错误，请检查后再试",
                                "登录失败",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case -1:
                        JOptionPane.showMessageDialog(null,
                                "用户名错误，请检查后再试",
                                "登录失败",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        break;
                }

            }
        });
        loginBtn.setBounds(90, 180, 100, 30);
        jPanel.add(loginBtn);
        JButton registerBtn = new JButton("REGISTER");
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterWindow(clientThread);
            }
        });
        registerBtn.setBounds(210, 180, 100, 30);
        jPanel.add(registerBtn);
    }
}
