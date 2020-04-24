package com.ruoyi.mina.entity;

public enum Cmd {
    GetAllstatus("获取所有的状态", 0x1,(byte)0x1),
    GetMethod("获取方法", 0x2,(byte)0x2),
    SetMethod("设置方法", 0x3,(byte)0x3),
    StartCollect("开始采集", 0x4,(byte)0x4),
    MIC_Collect("返回开始采集MIC数据", 0x5,(byte)0x5),
    StopCollect("停止采集", 0x6,(byte)0x6),
    StartGps("开始gps", 0x13,(byte)0x13),
    StopGps("停止gps", 0x14,(byte)0x14),
    StartWeather("开始获取天气", 0x15,(byte)0x15),
    StopWeather("停止获取天气", 0x16,(byte)0x16),
    StartCorrect("开始校正", 0x22,(byte)0x22),
    StartCorrectStatus("校正状态", 0x23,(byte)0x23),
    StopCorrect("停止校正", 0x24,(byte)0x24),
    StopCorrectStatus("停止校正状态", 0x25,(byte)0x24),
    GetWeather("天气数据", 0x26,(byte)0x26);

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
