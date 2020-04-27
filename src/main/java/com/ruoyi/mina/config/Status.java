package com.ruoyi.mina.config;

import com.ruoyi.mina.entity.StatusDetail;
import lombok.Data;

@Data
public class Status {
    //采集软件的采集状态
    private StatusDetail collectStatus;
    //采集软件的gps状态
    private StatusDetail gpsStatus;
    //采集软件的天气状态
    private StatusDetail weatherStatus;
    //采集软件校正状态
    private StatusDetail correctStatus;

    //后台与溯源之间的连接状态
    private boolean collectConnectStatus;

    private Long collectId;

    private boolean saveFatorCount;

    //敏感点名称
    private boolean pointname;
    //设备名称
    private String devicecode;

    private String devicename;

    public Status(){
        this.collectStatus=new StatusDetail();
        this.gpsStatus=new StatusDetail();
        this.weatherStatus=new StatusDetail();
        this.correctStatus=new StatusDetail();
        //与采集软件服务器连接状态
        this.collectConnectStatus=false;
    }
}
