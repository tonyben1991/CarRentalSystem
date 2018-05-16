package com.tonyben1991.view;

import com.tonyben1991.bean.Server;
import com.tonyben1991.bean.SocketMessage;
import com.tonyben1991.bean.User;
import com.tonyben1991.biz.UserBiz;
import com.tonyben1991.bizimpl.UserBizImpl;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public class RegisterView extends View {
    UserBiz userBiz;


    public RegisterView(Server.ServerThread serverThread) {
        super(serverThread);
        userBiz = new UserBizImpl();
    }

    @Override
    public View operate() {
        SocketMessage msg = serverThread.getMsg(true);
        serverThread.setMsg(new SocketMessage<>(2, userBiz.register((User) msg.getMsg())));
        return new MainView(serverThread);
    }
}
