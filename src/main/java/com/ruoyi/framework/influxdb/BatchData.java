package com.ruoyi.framework.influxdb;

import lombok.Data;

import java.util.Map;

@Data
public class BatchData {
    private Map<String, String> tags;
    private String table;
    private Map<String, Object> fields;
    private long time;
}
