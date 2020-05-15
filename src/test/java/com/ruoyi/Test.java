package com.ruoyi;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.redis.RedisLock;
import com.ruoyi.redis.RedisPool;
import com.ruoyi.webSocket.WebSocketConfig;
import com.ruoyi.zh.domain.ZhCollectRecord;
import com.ruoyi.zh.service.ICollectRecordService;
import javafx.print.Collation;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Copyright © 广州禾信仪器股份有限公司. All rights reserved.
 *
 * @Author hxsdd-20
 * @Date 2020/4/23 20:20
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes ={RuoYiApplication.class,WebSocketConfig.class},webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Test {
//    @Autowired
//    ICollectRecordService collectRecordService;
//
//    /**
//     * 高并发重复插入
//     */
//    @org.junit.Test
//    public void TestRepeat(){
//        CountDownLatch countDownLatch=new CountDownLatch(3);
//        ZhCollectRecord collectRecord=new ZhCollectRecord();
//        collectRecord.setDeviceCode("SPIMS001");
//        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        collectRecord.setStartTime(new Date());
//        for (int i = 0; i < 3; i++) {
//            Thread thread=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    countDownLatch.countDown();
//                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
//                    List<ZhCollectRecord> collectRecords = collectRecordService.selectCollectRecordList(collectRecord);
//                    int size = collectRecords.size();
//                    //说明数据库已经存在
//                    if(size<=0){
//                        try {
//                            int i1 = collectRecordService.insertCollectRecord(collectRecord);
//                            System.out.println(i1>0?"插入成功":"插入失败");
//                        } catch (Exception e) {
//                            System.out.println("插入失败");
//                        }
//                    }
//                }
//            });
//            thread.start();
//        }
//
//    }
//
//    /**
//     * redis 分布式锁
//     */
//    @org.junit.Test
//    public void RedisSuo(){
//        CountDownLatch countDownLatch=new CountDownLatch(3);
//        ZhCollectRecord collectRecord=new ZhCollectRecord();
//        collectRecord.setDeviceCode("SPIMS001");
//        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        collectRecord.setStartTime(new Date());
//        RedisLock redisLock=new RedisLock();
//        for (int i = 0; i < 3; i++) {
//            Thread thread=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    countDownLatch.countDown();
//                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
//                    String uuid = UUID.randomUUID().toString();
//                    boolean lock = redisLock.lock(uuid);
//                    if(lock){
//                        List<ZhCollectRecord> collectRecords = collectRecordService.selectCollectRecordList(collectRecord);
//                        int size = collectRecords.size();
//                        //说明数据库已经存在
//                        if(size<=0){
//                            try {
//                                int i1 = collectRecordService.insertCollectRecord(collectRecord);
//                                System.out.println(i1>0?"插入成功":"插入失败");
//                            } catch (Exception e) {
//                                System.out.println("插入失败");
//                            }
//                        }
//                        redisLock.unlock(uuid);
//                    }
//
//                }
//            });
//            thread.start();
//        }
//    }
//
//    @org.junit.Test
//    public void TestPath(){
//
//    }
//
//    public static void main(String[] args) {
//        List<String> list=new ArrayList<>();
//        list.add("2019-07-20 10:58:17;120.3738883333333;31.542595;327.8912048339844;0;0;22.98514127731323;5.209419599601201;0;0;0;0;1.713252440094948;11.49814265114921;7.926881845508303;0;0;0.9513992789600577;6.938355692795345;20.24393498897553;0;2.862323756728854;0;22.77265821184431;8.11756432056427;0;25.04565238952637;12.84657970070839;9.08359353031431;3.502897620201111;0;0;2.068439147302083;10.17048258866583;6.406993791460992;20.20313024520874;0;0;2.04845148271748;6.088982948235103;1.156600377123271;13.98934773036412;0;41.63156083651952;13.99837921772684;11.06064988034112;0;6.384902894496918;0;2.678564923948475;9.854480624198914;0;9.982304604990142;8.47013980150223;0;0;0;0;0;0");
//        list.add(0,"2019-07-20 09:58:17;120.3738883333333;31.542595;327.8912048339844;0;0;22.98514127731323;5.209419599601201;0;0;0;0;1.713252440094948;11.49814265114921;7.926881845508303;0;0;0.9513992789600577;6.938355692795345;20.24393498897553;0;2.862323756728854;0;22.77265821184431;8.11756432056427;0;25.04565238952637;12.84657970070839;9.08359353031431;3.502897620201111;0;0;2.068439147302083;10.17048258866583;6.406993791460992;20.20313024520874;0;0;2.04845148271748;6.088982948235103;1.156600377123271;13.98934773036412;0;41.63156083651952;13.99837921772684;11.06064988034112;0;6.384902894496918;0;2.678564923948475;9.854480624198914;0;9.982304604990142;8.47013980150223;0;0;0;0;0;0");
////        Collections.sort(list);
//        for (String temp:list){
//            System.out.println(temp.split(";")[0]);
//        }
//        System.out.println(RuoYiConfig.getProfile().replace("file:",""));
//    }
}
