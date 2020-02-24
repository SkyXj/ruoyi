package com.ruoyi.mina.config;

import lombok.Data;

@Data
public class Status {
    private boolean collectStatus;
    private boolean gpsStatus;
    private boolean weatherStatus;
    private boolean correctStatus;

    public Status(){
        this.collectStatus=false;
        this.gpsStatus=false;
        this.weatherStatus=false;
        this.correctStatus=false;
    }
}
