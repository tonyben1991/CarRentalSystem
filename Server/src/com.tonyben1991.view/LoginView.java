package com.tonyben1991.view;

import com.tonyben1991.bean.Server;
import com.tonyben1991.bean.SocketMessage;
import com.tonyben1991.bean.User;
import com.tonyben1991.biz.UserBiz;
import com.tonyben1991.bizimpl.UserBizImpl;


/**
 * @author oaec
 * @date 2018-05-15
 **/
public class LoginView extends View {
    UserBiz userBiz;


    public LoginView() {
    }

    public LoginView(Server.ServerThread serverThread) {
        super(serverThread);
        userBiz = new UserBizImpl();
    }

    @Override
    public View operate() {
        SocketMessage msg = serverThread.getMsg(true);
        serverThread.setMsg(new SocketMessage<>(1, userBiz.login((User) msg.getMsg())));
        return new MainView(serverThread);
    }
}
