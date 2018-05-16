package com.tonyben1991.view;

import com.tonyben1991.bean.Server;
import com.tonyben1991.bean.SocketMessage;
import com.tonyben1991.biz.UserBiz;
import com.tonyben1991.bizimpl.UserBizImpl;

import java.util.concurrent.BlockingQueue;

/**
 * @author oaec
 * @date 2018-05-15
 **/
public abstract class View {
    Server.ServerThread serverThread;
    View nextView;

    public View() {
    }

    public View(Server.ServerThread serverThread) {
        this.serverThread = serverThread;
        nextView = null;
    }

    /**
     * 对客户端的请求进行操作
     *
     * @return 返回下一个视图
     */
    public abstract View operate();
}
