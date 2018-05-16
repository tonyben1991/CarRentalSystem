package com.tonyben1991.view;

import com.tonyben1991.bean.ClientThread;
import com.tonyben1991.bean.SocketMessage;
import com.tonyben1991.bean.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public class RegisterWindow extends Window {

    public RegisterWindow() {
    }

    public RegisterWindow(ClientThread clientThread) {
        super(clientThread);
        jFrame = new JFrame("Register");
        jFrame.setLocation(400, 200);
        jFrame.setSize(400, 450);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        passwordLab.setBounds(50, 80, 80, 20);
        jPanel.add(passwordLab);
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(180, 80, 150, 20);
        jPanel.add(passwordText);
        JLabel passwordLab1 = new JLabel("CONFIRM");
        passwordLab1.setBounds(50, 120, 80, 20);
        jPanel.add(passwordLab1);
        JPasswordField passwordText1 = new JPasswordField();
        passwordText1.setBounds(180, 120, 150, 20);
        jPanel.add(passwordText1);
        JLabel genderLab = new JLabel("GENDER");
        genderLab.setBounds(50, 160, 80, 20);
        jPanel.add(genderLab);
        JTextField genderText = new JTextField();
        genderText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                String s = genderText.getText();
                if (s.length() > 0) {
                    e.consume();
                }
                if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_1) {
                } else {
                    e.consume(); //关键，屏蔽掉非法输入
                }
            }
        });
        genderText.setBounds(180, 160, 150, 20);
        jPanel.add(genderText);
        JLabel idNumberLab = new JLabel("IDNUMBER");
        idNumberLab.setBounds(50, 200, 80, 20);
        jPanel.add(idNumberLab);
        JTextField idNumberText = new JTextField();
        idNumberText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                System.out.println(keyChar);
                String s = idNumberText.getText();
                if (s.length() >= 18) {
                    e.consume();
                }
                if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9 || keyChar == KeyEvent.VK_X || keyChar == KeyEvent.VK_F9) {
                } else {
                    e.consume(); //关键，屏蔽掉非法输入
                }
            }
        });
        idNumberText.setBounds(180, 200, 150, 20);
        jPanel.add(idNumberText);
        JLabel telephoneLab = new JLabel("TELEPHONE");
        telephoneLab.setBounds(50, 240, 80, 20);
        jPanel.add(telephoneLab);
        JTextField telephoneText = new JTextField();
        telephoneText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                String s = telephoneText.getText();
                if (s.length() >= 11) {
                    e.consume();
                }
                if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {
                } else {
                    e.consume(); //关键，屏蔽掉非法输入
                }
            }
        });
        telephoneText.setBounds(180, 240, 150, 20);
        jPanel.add(telephoneText);
        JLabel addressLab = new JLabel("ADDRESS");
        addressLab.setBounds(50, 280, 80, 20);
        jPanel.add(addressLab);
        JTextField addressText = new JTextField();
        addressText.setBounds(180, 280, 150, 20);
        jPanel.add(addressText);
        JButton registerBtn = new JButton("REGISTER");
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientThread.addMsg(new SocketMessage<>(2,
                        new User(userNameText.getText(),
                                new String(passwordText.getPassword()),
                                Integer.parseInt(genderText.getText()),
                                idNumberText.getText(),
                                telephoneText.getText(),
                                addressText.getText())));

                System.out.println(clientThread.getMsg().getMsg());
            }
        });
        registerBtn.setBounds(150, 350, 100, 30);
        jPanel.add(registerBtn);
    }
}
