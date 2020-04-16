package com.ruoyi.zh.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.framework.influxdb.BatchData;
import com.ruoyi.framework.influxdb.InfluxdbUtils;
import com.ruoyi.zh.domain.ZhCollectRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Copyright © 广州禾信仪器股份有限公司. All rights reserved.
 *
 * @Author hxsdd-20
 * @Date 2020/4/15 19:09
 * @Version 1.0
 */
@RestController
@RequestMapping("/testxj")
public class TestXjController {

    @Autowired
    public InfluxdbUtils influxdbUtils;

    @GetMapping("/correct")
    public void correct(){
        File file=new File("E:\\hexin\\second-error.2020-04-15.5.log");
        SimpleDateFormat sdf=new SimpleDateFormat("");
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String temp = null;
            int index = 1;
            // 按行读取字符串
            String[] names = null;
            List<BatchData> batchDatas = new ArrayList<>();
            List<BatchData> logBatchDatas = new ArrayList<>();
            while ((temp = bf.readLine()) != null) {
                if(temp.isEmpty()){
                    continue;
                }
                if(temp.contains("DT100-0003-传输浓度数据异常:")){
                    temp=temp.replace("DT100-0003-传输浓度数据异常:","");
                    JSONObject jsonObject= JSON.parseObject(temp);
                    Double lon=jsonObject.getDouble("longitude");
                    Double lat=jsonObject.getDouble("latitude");
                    Long time=jsonObject.getLong("time");
                    if(time<1586936700000L){
                        continue;
                    }
//                    System.out.println(time+";"+lon+";"+lat+";");
                    JSONArray array=jsonObject.getJSONArray("values");
                    for (int i = 0; i < array.size(); i++) {
                        BatchData batchData=new BatchData();
                        JSONObject arrayJSONObject = array.getJSONObject(i);
                        Map<String, String> tags = new HashMap<>(4);
                        tags.put("deviceCode", "DT100-0003");
                        tags.put("name", arrayJSONObject.getString("name"));
                        tags.put("channel", "-1");

                        Map<String, Object> fileds = new HashMap<>(4);
                        fileds.put("value", arrayJSONObject.getDouble("value"));
                        batchData.setFields(fileds);
                        batchData.setTable("DensityRealtime");
                        batchData.setTags(tags);
                        batchData.setTime(time);
                        batchDatas.add(batchData);
                    }
                    BatchData batchDataLog=new BatchData();
                    //浓度数据记录表，用于记录浓度数据生成时对应的相关信息
                    Map<String, String> densityLogTags = new HashMap<>(4);
                    densityLogTags.put("deviceCode", "DT100-0003");
                    densityLogTags.put("gridArea", "椒江区");
                    densityLogTags.put("pointName", "九州点药业");
                    densityLogTags.put("pointType", "1");
//            densityLogTags.put("strTime", strTime);
                    Map<String, Object> densityLogFileds = new HashMap<>(4);
                    densityLogFileds.put("longitude", lon);
                    densityLogFileds.put("latitude", lat);
                    densityLogFileds.put("gpsValid", 1);
                    batchDataLog.setTime(time);
                    batchDataLog.setTags(densityLogTags);
                    batchDataLog.setFields(densityLogFileds);
                    batchDataLog.setTable("DensityLog");
                    logBatchDatas.add(batchDataLog);
                    index++;
                }
            }
            System.out.println(index);
            influxdbUtils.batchInsertAndTime(batchDatas);
            influxdbUtils.batchInsertAndTime(logBatchDatas);
            bf.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
