package com.tonyben1991.bean;

import java.io.Serializable;

/**
 * @author oaec
 * @date 2018-05-15
 **/
public class SocketMessage<T> implements Serializable {
    private int msgType;
    private T msg;

    public SocketMessage(int msgType, T msg) {
        this.msgType = msgType;
        this.msg = msg;
    }

    public int getMsgType() {
        return msgType;
    }

    public T getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "SocketMessage{" +
                "msgType=" + msgType +
                ", msg=" + msg +
                '}';
    }
}
