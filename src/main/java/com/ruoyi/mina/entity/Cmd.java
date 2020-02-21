package com.ruoyi.mina.entity;

public enum Cmd {
    GetMethod("获取方法", 2,(byte)2),
    StartCollect("开始采集", 4,(byte)4),
    MIC_Collect("返回开始采集MIC数据", 5,(byte)5),
    StopCollect("停止采集", 6,(byte)6),
    StartGps("开始gps", 13,(byte)13),
    StopGps("停止gps", 14,(byte)14),
    StartWeather("开始获取天气", 15,(byte)15),
    StopWeather("停止获取天气", 16,(byte)16),
    StartCorrect("开始校正", 22,(byte)22),
    StartCorrectStatus("校正状态", 23,(byte)23),
    GetWeather("天气数据", 26,(byte)26);

    private String name;
    private int value;
    private byte cmd;

    private Cmd(String name,int value,byte cmd){
        this.name=name;
        this.value=value;
        this.cmd=cmd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public byte getCmd() {
        return cmd;
    }

    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }
}
