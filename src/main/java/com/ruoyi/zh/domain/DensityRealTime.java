package com.ruoyi.zh.domain;

import lombok.Data;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

@Data
@Measurement(name="DensityRealtime")
public class DensityRealTime{

    @Column(name="time")
    private String time;

    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    @Column(name="value")
    private double value;
}
