package com.ruoyi.mina.config;

import com.ruoyi.mina.entity.Msg;
import org.apache.mina.core.session.IoSession;

import java.util.HashMap;
import java.util.Map;

public class SessionManage {
    public static IoSession session;

    public static Status status=new Status();

    public static void sendMsg(Msg msg){
        session.write(msg.get2MsgByte());
    }
}
