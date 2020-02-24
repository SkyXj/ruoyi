package com.ruoyi.mina.handler;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.ByteUtils;
import com.ruoyi.framework.influxdb.BatchData;
import com.ruoyi.framework.influxdb.InfluxdbUtils;
import com.ruoyi.mina.DensityVo;
import com.ruoyi.mina.DensityVo.KV;
import com.ruoyi.mina.config.SessionManage;
import com.ruoyi.mina.entity.Cmd;
import com.ruoyi.mina.entity.Material;
import com.ruoyi.mina.entity.Msg;
import com.ruoyi.webSocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//消息处理
@Component
public class MsgHandler {

    public static List<DensityVo> list;

    public static InfluxdbUtils influxdbUtils;

    //经度和纬度
    public static double lng;
    public static double lat;

    @Autowired
    public  void setList(List<DensityVo> list)
    {
        MsgHandler.list = list;
    }

    @Autowired
//    @Qualifier(value = "influxdbUtils")
    public void setInfluxdbUtils(InfluxdbUtils influxdbUtils){
        MsgHandler.influxdbUtils=influxdbUtils;
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
            long datetime = ByteUtils.getDate(times);
            //物质浓度
            int materialLength=24+128;
            int count=(datalength-16)/(materialLength);
            List<BatchData> batchDatas=new ArrayList<>();
            DensityVo densityVo=new DensityVo();
            densityVo.setLng(MsgHandler.lng+"");
            densityVo.setLat(MsgHandler.lat+"");
            SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
            Date date=new Date(datetime);
            densityVo.setTime(sim.format(date));
            List<DensityVo.KV> values=new ArrayList<>();
            for (int i = 0; i < count; i++) {
                DensityVo.KV kv=densityVo.new KV();
                byte[] meterialBytes = ByteUtils.subByte(msgbody, 16 + i * materialLength, materialLength);
                Material meterial=new Material(meterialBytes);
                if(meterial.getSzMatName().equals("TVOC")){
                    densityVo.setTvoc(meterial.getdPotencyUgm3());
                }
                kv.setName(meterial.getSzMatName());
                kv.setValue(meterial.getdPotencyUgm3());

                values.add(kv);

                System.out.println(meterial.toString());
                BatchData batchData=new BatchData();
                Map<String, String> tags = new HashMap<>(5);
                tags.put("code", "spims");
                tags.put("name", meterial.getSzMatName());

                Map<String, Object> fileds = new HashMap<>(4);
                fileds.put("value",meterial.getdPotencyUgm3());

                batchData.setTags(tags);
                batchData.setFields(fileds);
                batchData.setTime(datetime);
                batchData.setTable("DensityRealtime");
                batchDatas.add(batchData);
            }
            densityVo.setValues(values);
            influxdbUtils.batchInsertAndTime(batchDatas);
            try {
                if(count<list.size()){
                    //模拟
                    WebSocketServer.sendInfo(JSONObject.toJSONString(list.get(index)),"2");
                    index++;
                    //实际
                    //WebSocketServer.sendInfo(JSONObject.toJSONString(densityVo),"2");
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
            saveWeather(msg);
        }else if(cmd[0]== Cmd.GetMethod.getCmd()){
            System.out.println("获取方法");
        }else if(cmd[0]== Cmd.SetMethod.getCmd()){
            System.out.println("获取方法");
        }else if(cmd[0]== Cmd.StartGps.getCmd()){
            byte enable = msgbody[0];
            byte[] times=ByteUtils.subByte(msgbody,1,16);
            long datetime = ByteUtils.getDate(times);
            if(enable==1){
                System.out.println("有效gps");
                String gpsinfo=new String(ByteUtils.subByte(msgbody,17,datalength-17));
                if(!gpsinfo.isEmpty()){
                    String[] split = gpsinfo.split(",");
                    String lngdirection=split[5];
                    String lngstr=lngdirection.equals("E")?split[4]:"-"+split[4];

                    String latdirection=split[3];
                    String latstr=latdirection.equals("N")?split[2]:"-"+split[2];

//                    long time=getGpsTime(split[2]);
                    //经度
                    double lng=Double.parseDouble(lngstr);
                    MsgHandler.lng=lng;

                    //纬度
                    double lat=Double.parseDouble(latstr);
                    MsgHandler.lat=lat;

                    Map<String, String> tags = new HashMap<>(5);
                    tags.put("code", "spims");

                    Map<String, Object> fileds = new HashMap<>(4);
                    fileds.put("lng",lng);
                    fileds.put("lat",lat);
                    influxdbUtils.insertAndTime(tags,"DensityLog", fileds,datetime);
                }

            }else{
                System.out.println("无效gps");
            }
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
            //发送消息获取天气数据
//            getWeather();
        }else{
            message="获取天气失败";
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
            SessionManage.status.setCollectStatus(true);
            System.out.println("开始采集成功");
            message="开始采集成功";
        }else{
            System.out.println("开始采集失败");
            message="开始采集失败";
            SessionManage.status.setCollectStatus(false);
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
            SessionManage.status.setCollectStatus(false);
        }else{
            message="停止采集失败";
            System.out.println("停止采集失败");
            SessionManage.status.setCollectStatus(true);
        }
        //发送消息
        sendInfo(status==1?"0":"1",message,Cmd.StopCollect);
    }


    private static void getWeather(){
        Msg msg=new Msg();
        msg.setBody("");
        msg.setCmd(Cmd.GetWeather.getCmd());
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);
    }

    //保存天气数据
    private static void saveWeather(Msg msg){
        byte enable = msg.get2MsgByte()[0];

        byte[] times=ByteUtils.subByte(msg.get2MsgByte(),1,16);
        long datetime = ByteUtils.getDate(times);
        Map<String, String> tags = new HashMap<>(5);
        tags.put("code", "spims");

        Map<String, Object> fileds = new HashMap<>(4);
        double temperature=ByteUtils.bytes2Double(ByteUtils.subByte(msg.get2MsgByte(),17,8));
        double humidity=ByteUtils.bytes2Double(ByteUtils.subByte(msg.get2MsgByte(),17,8));
        double pressure=ByteUtils.bytes2Double(ByteUtils.subByte(msg.get2MsgByte(),17,8));
        double speed=ByteUtils.bytes2Double(ByteUtils.subByte(msg.get2MsgByte(),17,8));
        double direction=ByteUtils.bytes2Double(ByteUtils.subByte(msg.get2MsgByte(),17,8));
        fileds.put("temperature",temperature);
        fileds.put("humidity",humidity);
        fileds.put("pressure",pressure);
        fileds.put("speed",speed);
        fileds.put("direction",direction);
        influxdbUtils.insertAndTime(tags,"weather", fileds,datetime);
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

    public static long getGpsTime(String str){
        SimpleDateFormat sim1=new SimpleDateFormat("yyyyMMdd");
        Date date=new Date();
        String format = sim1.format(date);
        String time = format + " " + str;
        SimpleDateFormat sim2=new SimpleDateFormat("yyyyMMdd HHmmss.sss");
        SimpleDateFormat sim3=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        long result=0;
        try {
//            result=sim3.format(sim2.parse(time));
            result=sim2.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getGpsTime("151430.154"));
//        SimpleDateFormat sim1=new SimpleDateFormat("yyyyMMdd HHmmss.sss");
//        SimpleDateFormat sim1=new SimpleDateFormat("yyyyMMdd");
//
//        SimpleDateFormat sim2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
//
//        String timestr="2020-02-24 15:14:30.154";
//        Date date=new Date();
//        String format = sim1.format(date);
//        System.out.println(format);
//        try {
//            Date parse = sim2.parse(timestr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }
}
