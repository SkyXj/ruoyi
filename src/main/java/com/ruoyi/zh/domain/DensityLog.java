package com.ruoyi.zh.domain;

import lombok.Data;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

@Data
@Measurement(name="DensityLog")
public class DensityLog {
    @Column(name="time")
    private String time;

    @Column(name="code")
    private String code;

    @Column(name="lat")
    private String lat;

    @Column(name="lng")
    private String lng;

}
