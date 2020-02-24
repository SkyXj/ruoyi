package com.ruoyi.framework.influxdb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanFactory {
    @Value("${influxdb.host}")
    private String host;
    @Value("${influxdb.port}")
    private String port;
    @Value("${influxdb.database}")
    private String database;
    @Value("${influxdb.username}")
    private String username;
    @Value("${influxdb.password}")
    private String password;

    @Bean(name = "influxdbUtils")
    public InfluxdbUtils influxdbUtils() {
        return new InfluxdbUtils(host,port,username,password,database);
    }
}
