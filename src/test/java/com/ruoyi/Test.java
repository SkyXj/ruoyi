package com.ruoyi;

import com.ruoyi.redis.RedisLock;
import com.ruoyi.redis.RedisPool;
import com.ruoyi.webSocket.WebSocketConfig;
import com.ruoyi.zh.domain.ZhCollectRecord;
import com.ruoyi.zh.service.ICollectRecordService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
    @Autowired
    ICollectRecordService collectRecordService;

    /**
     * 高并发重复插入
     */
    @org.junit.Test
    public void TestRepeat(){
        CountDownLatch countDownLatch=new CountDownLatch(3);
        ZhCollectRecord collectRecord=new ZhCollectRecord();
        collectRecord.setDeviceCode("SPIMS001");
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        collectRecord.setStartTime(new Date());
        for (int i = 0; i < 3; i++) {
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    countDownLatch.countDown();
                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                    List<ZhCollectRecord> collectRecords = collectRecordService.selectCollectRecordList(collectRecord);
                    int size = collectRecords.size();
                    //说明数据库已经存在
                    if(size<=0){
                        try {
                            int i1 = collectRecordService.insertCollectRecord(collectRecord);
                            System.out.println(i1>0?"插入成功":"插入失败");
                        } catch (Exception e) {
                            System.out.println("插入失败");
                        }
                    }
                }
            });
            thread.start();
        }

    }

    /**
     * redis 分布式锁
     */
    @org.junit.Test
    public void RedisSuo(){
        CountDownLatch countDownLatch=new CountDownLatch(3);
        ZhCollectRecord collectRecord=new ZhCollectRecord();
        collectRecord.setDeviceCode("SPIMS001");
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        collectRecord.setStartTime(new Date());
        RedisLock redisLock=new RedisLock();
        for (int i = 0; i < 3; i++) {
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    countDownLatch.countDown();
                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                    String uuid = UUID.randomUUID().toString();
                    boolean lock = redisLock.lock(uuid);
                    if(lock){
                        List<ZhCollectRecord> collectRecords = collectRecordService.selectCollectRecordList(collectRecord);
                        int size = collectRecords.size();
                        //说明数据库已经存在
                        if(size<=0){
                            try {
                                int i1 = collectRecordService.insertCollectRecord(collectRecord);
                                System.out.println(i1>0?"插入成功":"插入失败");
                            } catch (Exception e) {
                                System.out.println("插入失败");
                            }
                        }
                        redisLock.unlock(uuid);
                    }

                }
            });
            thread.start();
        }
    }
}
