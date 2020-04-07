package com.ruoyi.mina;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Copyright © 广州禾信仪器股份有限公司. All rights reserved.
 *
 * @Author hxsdd-20
 * @Date 2019/11/19 9:22
 * @Version 1.0
 */
@Component
public class DataInit {
    private String jsonpath="data/zh_real.json";
//    @Bean
//    public List<DensityVo> getList(){
//        try {
//            // 根据resource文件路径，生成文件
//            File jsonFile=new File(jsonpath);
//            if(!jsonFile.exists()){
//                jsonFile=new File("../"+jsonpath);
//            }
////            File jsonFile = ResourceUtils.getFile("classpath:data/zh_real.json");
//
//            // 解析文件为指定编码的字符串
//            // 方法实现：先将文件转inPutStream，再调用下面的IOUtils.toString()方法；
//            String json = FileUtils.readFileToString(jsonFile,"UTF-8");
//            List<DensityVo> densityVos = JSON.parseArray(json, DensityVo.class);
//            return densityVos;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    private String strpath="data/test.txt";

//    @Bean(name = "testtext")
//    public String getTxt(){
//        try {
//            // 根据resource文件路径，生成文件
//            File jsonFile=new File(strpath);
//            if(!jsonFile.exists()){
//                jsonFile=new File("../"+strpath);
//            }
//            String json = FileUtils.readFileToString(jsonFile,"UTF-8");
//            return json;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }

    private static final String  BEGIN_HEX="3C626567696E3E";
    private static final String  END_HEX="3C656E643E";

    public static void main(String[] args) {
        try {
            String sdfsdf="{'head':{'id':'ss'},'data':{'dataid':'56'}}";
            Map<String,String> map=new HashMap<>();
            map.put("type","sdf");
            JSONObject jsonObject=JSONObject.parseObject(sdfsdf);
            JSONObject headdddd = jsonObject.getJSONObject("headdddd");
//            jsonObject.getJSONObject("headdddd").putAll(map);
            System.out.println(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

