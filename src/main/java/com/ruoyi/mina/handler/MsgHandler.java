package com.ruoyi.mina.handler;

import com.ruoyi.common.utils.ByteUtils;
import com.ruoyi.mina.entity.Cmd;
import com.ruoyi.mina.entity.Material;
import com.ruoyi.mina.entity.Msg;
import com.ruoyi.webSocket.WebSocketServer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;

//消息处理
public class MsgHandler {

    public static void dealWith(Object message){
        byte[] bytes=(byte[])message;
        //命令
        byte[] cmd= ByteUtils.subByte(bytes,5,1);
        //消息头
        String magic= new String(ByteUtils.subByte(bytes,0,5), Charset.defaultCharset());
        //数据长度
        int datalength=ByteUtils.Bytes2Int_LE(ByteUtils.subByte(bytes,12,4));

        Msg msg=new Msg();
        msg.setMagic(magic);
        msg.setCmd(cmd[0]);
        msg.setDataLen(datalength);
        byte[] msgbody=ByteUtils.subByte(bytes,16,datalength);
        //开始采集
        if(cmd[0]== Cmd.StartCollect.getValue()){
            msg.setBytes(msgbody);
            startCollect(msg);
        }else if(cmd[0]== Cmd.MIC_Collect.getCmd()){
            System.out.println("接收5命令");
            //时间
            byte[] times=ByteUtils.subByte(msgbody,0,16);
            String date = ByteUtils.getDate(times);
            System.out.println(date);
            //物质浓度
            int materialLength=24+128;
            int count=(datalength-16)/(materialLength);
            for (int i = 0; i < count; i++) {
                byte[] meterialBytes = ByteUtils.subByte(msgbody, 16 + i * materialLength, materialLength);
                Material meterial=new Material(meterialBytes);
                System.out.println(meterial.toString());
            }
        }else if(cmd[0]== Cmd.StopCollect.getCmd()){
            msg.setBytes(msgbody);
            stopCollect(msg);
        }else if(cmd[0]== Cmd.StartCorrect.getCmd()){
            msg.setBytes(msgbody);
            startCorrect(msg);
        }else if(cmd[0]== Cmd.StartCorrectStatus.getCmd()){
            msg.setBytes(msgbody);
            StartCorrectStatus(msg);
        }else if(cmd[0]== Cmd.StartWeather.getCmd()){
            System.out.println("天气");
        }else if(cmd[0]== Cmd.StopWeather.getCmd()){
            System.out.println("停止成功或者失败");
        }else if(cmd[0]== Cmd.GetWeather.getCmd()){
            System.out.println("天气数据xml");
        }else if(cmd[0]== Cmd.GetMethod.getCmd()){
            System.out.println("获取方法");
        }else if(cmd[0]== Cmd.StartGps.getCmd()){
            String gpsinfo=new String(ByteUtils.subByte(msgbody,17,datalength-17));
            System.out.println("开始获取GPS状态");
        }else if(cmd[0]== Cmd.StopGps.getCmd()){
            System.out.println("GPS停止状态");
        }
    }

    private static void StartCorrectStatus(Msg msg) {
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        if(status==1){
            System.out.println("校正成功");
        }else{
            System.out.println("校正失败");
        }
    }

    private static void startCorrect(Msg msg) {
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        if(status==1){
            System.out.println("开始校正成功");
        }else{
            System.out.println("开始校正失败");
        }
    }

    //开始采集消息返回的处理
    public static void startCollect(Msg msg){
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        String message="";
        if(status==1){
            System.out.println("开始采集成功");
            message="开始采集成功";
        }else{
            System.out.println("开始采集失败");
            message="开始采集失败";
        }
        try {
            WebSocketServer.sendInfo(message,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void stopCollect(Msg msg) {
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        //时间
        byte[] timebyte=ByteUtils.subByte(bytes,1,msg.getDataLen()-1);
        if(status==1){
            System.out.println("停止采集成功");
        }else{
            System.out.println("停止采集失败");
        }
    }
}
