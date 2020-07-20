package com.ruoyi.mina.handler;

import com.alibaba.fastjson.JSON;
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
import com.ruoyi.mina.entity.StatusDetail;
import com.ruoyi.webSocket.WebSocketServer;
import com.ruoyi.zh.domain.ZhCollectRecord;
import com.ruoyi.zh.service.ICollectRecordService;
import com.ruoyi.zh.tool.DrawUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//消息处理
@Component
public class MsgHandler {

    private static final Logger logger = LogManager.getLogger(MsgHandler.class);

    public static List<DensityVo> list;

    public static String testTxt;

    public static InfluxdbUtils influxdbUtils;


    public static List<DensityVo> records=new ArrayList<>();

    //经度和纬度
    public static double lng=0.0;
    public static double lat=0.0;

    public static boolean gpsAvailability=false;

    public static ICollectRecordService collectRecordService;

    private static Integer startIndex=190;

    private static Integer endIndex=210;

    @Autowired
    public  void setList(List<DensityVo> list)
    {
        MsgHandler.list = list;
    }

    @Autowired
    public  void setCollectRecordService(ICollectRecordService collectRecordService)
    {
        MsgHandler.collectRecordService = collectRecordService;
    }

    //是否测试环境
    public static String env;

    //是否本地模拟gps信号缺失
    public static boolean gpsSimulate;

    @Value("${voyage.env}")
    public void setEnv(String env){
        MsgHandler.env = env;
    }

    @Value("${voyage.gpsSimulate}")
    public void setGpsSimulate(boolean gpsSimulate){
        MsgHandler.gpsSimulate = gpsSimulate;
    }

    @Autowired
    @Qualifier(value = "testtext")
    public  void setTestTxt(String txt)
    {
        MsgHandler.testTxt = txt;
    }

    @Autowired
    public void setInfluxdbUtils(InfluxdbUtils influxdbUtils){
        MsgHandler.influxdbUtils=influxdbUtils;
    }
    //测试数据记录下标
    private static Integer index=170;

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
            index=170;
            startCollect(msg);
        }else if(cmd[0]== Cmd.MIC_Collect.getCmd()){
            //接收浓度数据
            new Thread(new Runnable() {
                @Override
                public void run() {
                    saveAndSendMicData(msg);
                }
            }).start();
        }else if(cmd[0]== Cmd.StopCollect.getCmd()){
            stopCollect(msg);
        }else if(cmd[0]== Cmd.StartCorrect.getCmd()){
            startCorrect(msg);
        }else if(cmd[0]== Cmd.StartCorrectStatus.getCmd()){
            StartCorrectStatus(msg);
        }else if(cmd[0]== Cmd.StartWeather.getCmd()){
            StartWeather(msg);
        }else if(cmd[0]== Cmd.StopWeather.getCmd()){
            StopWeather(msg);
        }else if(cmd[0]== Cmd.GetWeather.getCmd()){
            System.out.println("天气数据xml");
            saveWeather(msg);
        }else if(cmd[0]== Cmd.GetMethod.getCmd()){
            System.out.println("获取方法");
        }else if(cmd[0]== Cmd.SetMethod.getCmd()){
            System.out.println("设置方法");
        }else if(cmd[0]== Cmd.StartGps.getCmd()){
//            changeGps(msg);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    logger.info("gps传输时间");
                    changeGps(msg);
                }
            }).start();
        }else if(cmd[0]== Cmd.StopGps.getCmd()){
            StopGps(msg);
        }
    }


    public static void saveAndSendMicData(Msg msg){
        //浓度数据
        byte[] msgbody=msg.getBytes();
        int datalength=msg.getDataLen();
        //时间
        byte[] times=ByteUtils.subByte(msgbody,0,16);
        long datetime = ByteUtils.getDate(times);
        //每一个物质浓度长度
        int materialLength=24+128;
        //物质个数
        int count=(datalength-16)/(materialLength);

        List<BatchData> batchDatas=new ArrayList<>();

        DensityVo densityVo=new DensityVo();
        densityVo.setCollectId(SessionManage.status.getCollectId());
        densityVo.setLng(MsgHandler.lng+"");
        densityVo.setLat(MsgHandler.lat+"");
        densityVo.setCollectId(SessionManage.status.getCollectId());
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        Date date=new Date(datetime);
        densityVo.setTime(sim.format(date));
        densityVo.setDateTime(datetime);
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
//                System.out.println(meterial.toString());
            BatchData batchData=new BatchData();
            Map<String, String> tags = new HashMap<>(5);
            tags.put("code", SessionManage.status.getDevicecode());
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
        densityVo.setThisDatas();
//        densityVo.setBatchDatas(batchDatas);
        boolean isValid;
        if(env.equals("localtest")){
            isValid=MsgHandler.gpsAvailability==true||gpsSimulate;
        }else{
            isValid=MsgHandler.gpsAvailability==true;
        }
        //插入浓度数据
        influxdbUtils.batchInsertAndTime(batchDatas);
        //如果gps有效或者是本地测试
//        if(isValid){
//            influxdbUtils.batchInsertAndTime(batchDatas);
//        }
        //是否更新因子数目
        if(!SessionManage.status.isSaveFatorCount()){
            ZhCollectRecord zhCollectRecord=new ZhCollectRecord();
            zhCollectRecord.setId(SessionManage.status.getCollectId());
            zhCollectRecord.setFactorCount(values.size());
            List<String> datas = densityVo.getDatas();
            if(datas!=null&&datas.size()>0){
                String names = datas.get(0);
                zhCollectRecord.setRemark(names);
            }
            collectRecordService.updateCollectRecord(zhCollectRecord);
            SessionManage.status.setSaveFatorCount(true);
        }
        if(isValid){
            //插入定位点
            Map<String, String> logTags = new HashMap<>(5);
            logTags.put("code", SessionManage.status.getDevicecode());
            Map<String, Object> logFileds = new HashMap<>(4);
            logFileds.put("lng", MsgHandler.lng);
            logFileds.put("lat", MsgHandler.lat);
            influxdbUtils.insertAndTime(logTags, "DensityLog", logFileds, datetime);
        }
        try {
            if(isValid){
                MsgHandler.records.add(densityVo);
                if(MsgHandler.records.size()==1){
                    densityVo.setCode(200);
                    WebSocketServer.sendInfo(JSONObject.toJSONString(densityVo),"2");
                }else if(MsgHandler.records.size()==2){
                    densityVo.setCode(200);
                    MsgHandler.records.remove(records.size()-2);
                    WebSocketServer.sendInfo(JSONObject.toJSONString(densityVo),"2");
                }else if(MsgHandler.records.size()>2){
                    //插值
                    DensityVo densityVo1 = MsgHandler.records.get(0);
                    DensityVo densityVo2 = MsgHandler.records.get(MsgHandler.records.size() - 1);

                    DensityVo densityVoSend = MsgHandler.records.get(1);
                    List<String> datas=new ArrayList<>();
                    double y1=Double.parseDouble(densityVo1.getLng());
                    double x1=Double.parseDouble(densityVo1.getLat());
                    double y2=Double.parseDouble(densityVo2.getLng());
                    double x2=Double.parseDouble(densityVo2.getLat());
                    double k=DrawUtil.getK(x1,y1,x2,y2);
                    double b=DrawUtil.getB(x1,y1,x2,y2);
                    double d=(x2-x1)/(MsgHandler.records.size()-1);
                    for (int i = 1; i < MsgHandler.records.size()-1; i++) {
                        double x=x1+i*d;
                        double y=DrawUtil.getYByX(k,b,x);
                        List<String> datas1 = MsgHandler.records.get(i).getDatas();
                        if(i==1){
                            datas.add(datas1.get(0));
                        }
                        String str = datas1.get(1);
                        String[] split = str.split(";");
                        split[1]=y+"";
                        split[2]=x+"";
                        datas.add(String.join(";",split));
                        //插入插值后的定位点
                        Map<String, String> logTags = new HashMap<>(5);
                        logTags.put("code", SessionManage.status.getDevicecode());
                        Map<String, Object> logFileds = new HashMap<>(4);
                        logFileds.put("lng", y);
                        logFileds.put("lat", x);
                        logger.info("补全"+x+";"+y+";"+MsgHandler.records.get(i).getTvoc());
                        influxdbUtils.insertAndTime(logTags, "DensityLog", logFileds, MsgHandler.records.get(i).getDateTime());
                    }
                    densityVoSend.setDatas(datas);
                    //拟合的数据
                    densityVoSend.setCode(201);
                    WebSocketServer.sendInfo(JSONObject.toJSONString(densityVoSend),"2");
                    MsgHandler.records=new ArrayList<>();
                    //保留最近一次的有效gps
                    MsgHandler.records.add(densityVoSend);
                }
            }else{
                //前一个点必须有数据
                if(MsgHandler.records.size()>0){
                    MsgHandler.records.add(densityVo);
                }
                DensityVo densityVotemp=new DensityVo();
                densityVotemp.setCode(401);
                //主要是为了发送401给前端,通知gps此时开始缺失
                WebSocketServer.sendInfo(JSONObject.toJSONString(densityVotemp),"2");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeGps(Msg msg){
        byte[] msgbody=msg.getBytes();
        int datalength=msg.getDataLen();
        byte enable = msgbody[0];
        byte[] times=ByteUtils.subByte(msgbody,1,16);
        long datetime = ByteUtils.getDate(times);
        //gps 状态
        StatusDetail statusDetail=null;
        if(enable==1){
            statusDetail=new StatusDetail(true,true);
            String gpsinfo=new String(ByteUtils.subByte(msgbody,17,datalength-17));
            logger.info("原始gps"+gpsinfo);
            if(!gpsinfo.isEmpty()){
                String[] split = gpsinfo.split(",");
                String lngdirection=split[5];
                String lngstr=lngdirection.equals("E")?split[4]:"-"+split[4];

                String latdirection=split[3];
                String latstr=latdirection.equals("N")?split[2]:"-"+split[2];
                //经度
                double lng=Double.parseDouble(lngstr.substring(0,3))+Double.parseDouble(lngstr.substring(3,lngstr.length()))/60;
                MsgHandler.lng=lng;
                //纬度
                double lat=Double.parseDouble(latstr.substring(0,2))+Double.parseDouble(latstr.substring(2,latstr.length()))/60;
                MsgHandler.lat=lat;
                MsgHandler.gpsAvailability=true;
                logger.info("有效GPS,lng:"+MsgHandler.lng+",lat:"+MsgHandler.lat);
            }
        }else{

            MsgHandler.gpsAvailability=false;
            //本地测试用
            if(MsgHandler.env.equals("localtest")){
                if(index<list.size()-1){
                    index++;
                }else{
                    index=0;
                }
                //模拟拟合
                if(index>startIndex&&index<endIndex){
                    MsgHandler.gpsSimulate=false;
                    MsgHandler.lng=0.0;
                    MsgHandler.lat=0.0;
                    logger.info("GPS信号中断");
                }else{
                    MsgHandler.gpsSimulate=true;
                    MsgHandler.lng=Double.parseDouble(list.get(index).getLng());
                    MsgHandler.lat=Double.parseDouble(list.get(index).getLat());
                }
//                MsgHandler.gpsSimulate=true;
//                MsgHandler.lng=Double.parseDouble(list.get(index).getLng());
//                MsgHandler.lat=Double.parseDouble(list.get(index).getLat());

                statusDetail=new StatusDetail(true,false);
            }else{
                MsgHandler.lng=0.0;
                MsgHandler.lat=0.0;
                statusDetail=new StatusDetail(false,false);
            }
        }
        logger.info("GPS------------------------------"+MsgHandler.lng+":"+MsgHandler.lat);
        SessionManage.status.setGpsStatus(statusDetail);
        //通知前端
        StartGps(msg);
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

        sendInfo(JSON.toJSONString(SessionManage.status.getGpsStatus()),message,Cmd.StartGps);
    }

    private static void StopGps(Msg msg) {
        byte[] bytes = msg.getBytes();
        byte status=bytes[0];
        String message="";
        StatusDetail statusDetail=null;
        if(status==1){
            message="停止GPS成功";
            statusDetail=new StatusDetail(false,false);
            SessionManage.status.setGpsStatus(statusDetail);
        }else{
            message="停止GPS失败";
            statusDetail=SessionManage.status.getGpsStatus();
        }
        sendInfo(JSON.toJSONString(statusDetail),message,Cmd.StopGps);
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
        StatusDetail statusDetail=null;
        if(status==1){
            statusDetail=new StatusDetail(true,true);
            SessionManage.status.setCollectStatus(statusDetail);
            message="开始采集成功";
        }else{
            message="开始采集失败";
            statusDetail= SessionManage.status.getGpsStatus();
        }
        //发送消息
        sendInfo(JSON.toJSONString(statusDetail),message,Cmd.StartCollect);
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
            StatusDetail statusDetail=new StatusDetail(false,false);
            SessionManage.status.setCollectStatus(statusDetail);
        }else{
            message="停止采集失败";
            System.out.println("停止采集失败");
//            SessionManage.status.setCollectStatus(true);
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
        tags.put("code", SessionManage.status.getDevicecode());

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

    public static void sendInfo(String data,String msg,Cmd cmd){
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
        String lngstr="11329.332827";
        double lng=Double.parseDouble(lngstr.substring(0,3))+Double.parseDouble(lngstr.substring(3,lngstr.length()))/60;
        System.out.println(lng);

//        String gpsinfo="$GNGGA,081649.000,2309.244790,N,11329.332827,E,1,16,0.963,22.613,M,0,M,,*52";
//        System.out.println("gps信息："+gpsinfo);
//        if(!gpsinfo.isEmpty()){
//            String[] split = gpsinfo.split(",");
//            String lngdirection=split[5];
//            String lngstr=lngdirection.equals("E")?split[4]:"-"+split[4];
//
//            String latdirection=split[3];
//            String latstr=latdirection.equals("N")?split[2]:"-"+split[2];
//            //经度
//            double lng=Double.parseDouble(lngstr);
//            //纬度
//            double lat=Double.parseDouble(latstr);
//        }


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
