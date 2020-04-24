package com.ruoyi.zh.controller;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.mina.config.MinaClientConfig;
import com.ruoyi.mina.config.SessionManage;
import com.ruoyi.mina.config.Status;
import com.ruoyi.mina.entity.Cmd;
import com.ruoyi.mina.entity.Msg;
import com.ruoyi.mina.entity.StatusDetail;
import com.ruoyi.mina.socket.IoListener;
import com.ruoyi.zh.domain.ZhCollectRecord;
import com.ruoyi.zh.service.ICollectRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.util.ByteUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.Date;

@RestController
@RequestMapping("send")
@Api(tags = "发送消息")
@Slf4j
public class SendMessageController {
    //    @GetMapping("/test")
//    public AjaxResult test(@RequestParam(name="msg") String msg){
//        SessionManage.sendMsg(msg);
//    }
    private static final Logger logger = LogManager.getLogger(SendMessageController.class);

//    private NioSocketConnector connector;
//
//    @Autowired
//    public void setConnector(NioSocketConnector connector) {
//        this.connector = connector;
//    }

    @Autowired
    ICollectRecordService zhCollectRecordService;

    @GetMapping("start")
    @ApiOperation("开始 4")
    public AjaxResult start(
            @RequestParam(value = "pointname") String pointname,
            @RequestParam(value = "code") String code) {
        SessionManage.status.setDevicecode(code);

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

        //开启gps
        this.getGps();
        //关闭最近的走航记录
        zhCollectRecordService.closeRecord();

        ZhCollectRecord zhCollectRecord = new ZhCollectRecord();
        zhCollectRecord.setDeviceCode(code);
        zhCollectRecord.setPointName(pointname);
        zhCollectRecord.setStartTime(new Date());
        zhCollectRecordService.insertCollectRecord(zhCollectRecord);
        SessionManage.status.setCollectId(zhCollectRecord.getId());
        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    @GetMapping("/stop")
    @ApiOperation("停止6")
    public AjaxResult stop() {
        Msg msg = new Msg();
        msg.setBody("");
        msg.setCmd((byte) 6);
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);

        ZhCollectRecord zhCollectRecord = new ZhCollectRecord();
        zhCollectRecord.setEndTime(new Date());
        zhCollectRecord.setId(zhCollectRecordService.getMaxId());
        zhCollectRecordService.updateCollectRecord(zhCollectRecord);
        //采集状态未false
        StatusDetail statusDetail=new StatusDetail(false,false);
        SessionManage.status.setCollectStatus(statusDetail);

        this.stopGps();

        AjaxResult ajax = AjaxResult.success(SessionManage.status);
        return ajax;
    }

    @GetMapping("/startCorrect")
    @ApiOperation("开始校正22")
    public AjaxResult startCorrect() {
        Msg msg = new Msg();
        msg.setBody("");
        msg.setCmd((byte) 22);
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    @GetMapping("/stopCorrect")
    @ApiOperation("停止校正22")
    public AjaxResult stopCorrect() {
        Msg msg = new Msg();
        msg.setBody("");
        msg.setCmd((byte) 24);
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    @GetMapping("/startWeather")
    @ApiOperation("开始获取天气")
    public AjaxResult startWeather() {
        Msg msg = new Msg();
        msg.setBody("");
        msg.setCmd((byte) Cmd.StartWeather.getCmd());
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    @GetMapping("/stopWeather")
    @ApiOperation("停止获取天气")
    public AjaxResult stopWeather() {
        Msg msg = new Msg();
        msg.setBody("");
        msg.setCmd((byte) Cmd.StopWeather.getCmd());
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    @GetMapping("/getWeather")
    @ApiOperation("获取天气")
    public AjaxResult getWeather() {
        Msg msg = new Msg();
        msg.setBody("");
        msg.setCmd(Cmd.GetWeather.getCmd());
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }


    @GetMapping("/getMethod")
    @ApiOperation("获取方法")
    public AjaxResult getMethod() {
        Msg msg = new Msg();
        msg.setBody("");
        msg.setCmd((byte) Cmd.GetMethod.getCmd());
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    @GetMapping("/setMethod")
    @ApiOperation("设置方法")
    public AjaxResult setMethod(@RequestParam(value = "name") String name) {
        Msg msg = new Msg();
        msg.setBody("");
        msg.setCmd(Cmd.SetMethod.getCmd());
        msg.setMagic("SPIMS");
        try {
            msg.setBytes(name.getBytes("GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SessionManage.sendMsg(msg);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    @GetMapping("/startGps")
    @ApiOperation("获取Gps")
    public AjaxResult getGps() {
        Msg msg = new Msg();
        msg.setBody("");
        msg.setCmd((byte) Cmd.StartGps.getCmd());
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    @GetMapping("/stopGps")
    @ApiOperation("停止获取Gps")
    public AjaxResult stopGps() {
        Msg msg = new Msg();
        msg.setBody("");
        msg.setCmd((byte) Cmd.StopGps.getCmd());
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    @GetMapping("getStatus")
    @ApiOperation("获取状态")
    public AjaxResult getStatus() {
        AjaxResult ajax = AjaxResult.success(SessionManage.status);
        return ajax;
    }

    @GetMapping("connectCollect")
    @ApiOperation("连接采集软件")
    public AjaxResult connectCollect(
            @RequestParam(value="host") String host,
            @RequestParam(value="port") int port
    ) {
        AjaxResult ajax = AjaxResult.success();
        logger.info(">>>>>>>>>>>>>>>>>>正在连接远程服务器>>>>>>>>>>>>>>>>>>>>");
        try {
            // 设置服务器地址，端口号
            InetSocketAddress address = new InetSocketAddress(host, port);

            ConnectFuture future = MinaClientConfig.connectorall.connect(address);
            // 获取session执行绑定方法
            future.awaitUninterruptibly();

            MinaClientConfig.isBreakNormal=false;

            IoSession session = future.getSession();
            SessionManage.status.setCollectConnectStatus(true);
            SessionManage.host=host;
            SessionManage.port=port;
            ajax = AjaxResult.success(SessionManage.status);
            SessionManage.session=session;
//            bind(session, account, msg);
            logger.info("<<<<<<<<<<<<<<<<<<与远程服务器连接成功<<<<<<<<<<<<<<<<<<");
        } catch (Exception e) {
            logger.error("<<<<<<<<<<<<<<<<<<与远程服务器连接失败<<<<<<<<<<<<<<<<<<" + e.getMessage());
            SessionManage.status.setCollectConnectStatus(false);
            ajax = AjaxResult.success(SessionManage.status);
            return ajax;
        }
        return ajax;
    }

    @GetMapping("disConnect")
    @ApiOperation("断开连接")
    public AjaxResult disConnect(){
        AjaxResult ajax = null;
        logger.info(">>>>>>>>>>>>>>>>>>正在断开远程服务器>>>>>>>>>>>>>>>>>>>>");
        try{
            if (SessionManage.session != null && SessionManage.session.isConnected()) {
                MinaClientConfig.isBreakNormal=true;
                SessionManage.session.closeNow();
                SessionManage.status=new Status();
                //SessionManage.status.setCollectConnectStatus(false);
                ajax=AjaxResult.success(SessionManage.status);
//                SessionManage.session.getCloseFuture().awaitUninterruptibly();// 等待连接断开
                logger.info(">>>>>>>>>>>>>>>>>>与远程服务器断开成功>>>>>>>>>>>>>>>>>>>>");
            }
        }catch (Exception e){
//            logger.info(e.getMessage());
            logger.info(">>>>>>>>>>>>>>>>>>与远程服务器断开成功>>>>>>>>>>>>>>>>>>>>");
            ajax=AjaxResult.success(SessionManage.status);
        }
        return ajax;
    }
}
