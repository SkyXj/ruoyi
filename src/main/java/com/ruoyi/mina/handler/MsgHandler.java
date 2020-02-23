package com.ruoyi.mina.handler;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.ByteUtils;
import com.ruoyi.mina.DataInit;
import com.ruoyi.mina.DensityVo;
import com.ruoyi.mina.config.SessionManage;
import com.ruoyi.mina.entity.Cmd;
import com.ruoyi.mina.entity.Material;
import com.ruoyi.mina.entity.Msg;
import com.ruoyi.webSocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

//消息处理
@Component
public class MsgHandler {

    private static List<DensityVo> list;

    @Autowired
    public  void setOssConfMapper(List<DensityVo> list) {
        MsgHandler.list = list;
    }
    private static Integer index=0;

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
        msg.setBytes(msgbody);
        //开始采集
        if(cmd[0]== Cmd.StartCollect.getValue()){
//            msg.setBytes(msgbody);
            index=0;
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
            try {
                if(count<list.size()){
                    WebSocketServer.sendInfo(JSONObject.toJSONString(list.get(index)),"2");
                    index++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if(cmd[0]== Cmd.StopCollect.getCmd()){
            stopCollect(msg);
        }else if(cmd[0]== Cmd.StartCorrect.getCmd()){
//            msg.setBytes(msgbody);
            startCorrect(msg);
        }else if(cmd[0]== Cmd.StartCorrectStatus.getCmd()){
            msg.setBytes(msgbody);
            StartCorrectStatus(msg);
        }else if(cmd[0]== Cmd.StartWeather.getCmd()){
//            msg.setBytes(msgbody);
            StartWeather(msg);
        }else if(cmd[0]== Cmd.StopWeather.getCmd()){
            StopWeather(msg);
        }else if(cmd[0]== Cmd.GetWeather.getCmd()){
            System.out.println("天气数据xml");
        }else if(cmd[0]== Cmd.GetMethod.getCmd()){
            System.out.println("获取方法");
        }else if(cmd[0]== Cmd.StartGps.getCmd()){
            String gpsinfo=new String(ByteUtils.subByte(msgbody,17,datalength-17));
            StartGps(msg);
            System.out.println("开始获取GPS状态");
        }else if(cmd[0]== Cmd.StopGps.getCmd()){
            System.out.println("GPS停止状态");
            StopGps(msg);
        }
    }

    private static void StartWeather(Msg msg) {
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        String message="";
        if(status==1){
            message="获取天气成功";
        }else{
            message="获取天气成功";
        }
        sendInfo(status==1?"1":"0",message,Cmd.StartWeather);
    }

    private static void StopWeather(Msg msg) {
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        String message="";
        if(status==1){
            message="停止获取天气成功";
        }else{
            message="停止获取天气失败";
        }
        sendInfo(status==1?"0":"1",message,Cmd.StopWeather);
    }

    private static void StartGps(Msg msg) {
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        String message="";
        if(status==1){
            message="获取GPS成功";
        }else{
            message="获取GPS失败";
        }
        sendInfo(status==1?"1":"0",message,Cmd.StartGps);
    }

    private static void StopGps(Msg msg) {
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        String message="";
        if(status==1){
            message="停止GPS成功";
        }else{
            message="停止GPS成功";
        }
        sendInfo(status==1?"0":"1",message,Cmd.StopGps);
    }



    private static void StartCorrectStatus(Msg msg) {
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        String message="";
        if(status==1){
            message="校正成功";
        }else{
            message="校正失败";
        }
        sendInfo(status==1?"1":"0",message,Cmd.StartCorrectStatus);
    }

    private static void startCorrect(Msg msg) {
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        String message="";
        if(status==1){
            message="开始校正成功";
        }else{
            message="开始校正失败";
        }
        sendInfo(status==1?"1":"0",message,Cmd.StartCorrect);
    }

    private static void stopCorrect(Msg msg) {
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        String message="";
        if(status==1){
            message="停止校正成功";
        }else{
            message="停止校正失败";
        }
        sendInfo(status==1?"1":"0",message,Cmd.StopCorrect);
    }

    //开始采集消息返回的处理
    public static void startCollect(Msg msg){
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        String message="";
        if(status==1){
            SessionManage.statusMap.put(Cmd.StartCollect.getName(),true);
            System.out.println("开始采集成功");
            message="开始采集成功";
        }else{
            System.out.println("开始采集失败");
            SessionManage.statusMap.put(Cmd.StartCollect.getName(),true);
            message="开始采集失败";
        }
        //发送消息
        sendInfo(status==1?"1":"0",message,Cmd.StartCollect);
    }

    private static void stopCollect(Msg msg) {
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        //时间
        byte[] timebyte=ByteUtils.subByte(bytes,1,msg.getDataLen()-1);
        String message="";
        if(status==1){
            message="停止采集成功";
            System.out.println("停止采集成功");
        }else{
            message="停止采集失败";
            System.out.println("停止采集失败");
        }
        //发送消息
        sendInfo(status==1?"0":"1",message,Cmd.StopCollect);
    }

    private static void sendInfo(String data,String msg,Cmd cmd){
        try {
            JSONObject msgJson=new JSONObject();
            //返回前端代表开关状态
            msgJson.put("data",data);
            msgJson.put("msg",msg);
            msgJson.put("cmd",cmd.getCmd());
            WebSocketServer.sendInfo(msgJson.toJSONString(),"1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
