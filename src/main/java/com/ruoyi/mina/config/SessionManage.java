package com.ruoyi.mina.config;

import com.ruoyi.mina.entity.Cmd;
import com.ruoyi.mina.entity.Msg;
import org.apache.mina.core.session.IoSession;
import org.springframework.data.redis.util.ByteUtils;

import java.util.HashMap;
import java.util.Map;

public class SessionManage {
    public static IoSession session;

    public static Status status=new Status();

    public static String host;

    public static int port;

    public static void sendMsg(Msg msg){
        session.write(msg.get2MsgByte());
    }


    public static void startMic(){
        if(SessionManage.session!=null){
            Msg msg = new Msg();
            //经纬度
            msg.setBody("");
            msg.setCmd((byte) 4);
            msg.setMagic("SPIMS");
            //经度
            byte[] lng_bytes = new byte[10];
            //纬度
            byte[] lat_bytes = new byte[10];
            msg.setBytes(ByteUtils.concat(lng_bytes, lat_bytes));
            SessionManage.sendMsg(msg);
        }
    }

    public static void startGps(){
        if(SessionManage.session!=null){
            Msg msg = new Msg();
            msg.setBody("");
            msg.setCmd((byte) Cmd.StartGps.getCmd());
            msg.setMagic("SPIMS");
            msg.setBytes(null);
            SessionManage.sendMsg(msg);
        }
    }
}
