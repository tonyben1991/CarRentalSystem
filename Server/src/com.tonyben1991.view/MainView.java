package com.tonyben1991.view;

import com.tonyben1991.bean.Server;
import com.tonyben1991.bean.SocketMessage;

import java.util.concurrent.BlockingQueue;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public class MainView extends View {

    public MainView() {
    }

    public MainView(Server.ServerThread serverThread) {
        super(serverThread);
    }

    @Override
    public View operate() {
        SocketMessage msg = serverThread.getMsg(false);
        switch (msg.getMsgType()) {
            case 1:
                nextView = new LoginView(serverThread);
                break;
            case 2:
                nextView = new RegisterView(serverThread);
                break;
            default:
                break;
        }
        return nextView;
    }
}
