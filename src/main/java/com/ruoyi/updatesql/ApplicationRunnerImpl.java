package com.ruoyi.updatesql;

import com.ruoyi.zh.mapper.UpdateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright © 广州禾信仪器股份有限公司. All rights reserved.
 *
 * @Author hxsdd-20
 * @Date 2020/5/20 9:49
 * @Version 1.0
 */
@Component
@Slf4j
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Autowired
    UpdateMapper updateMapper;

    @Value("${update.sqlfile}")
    private String sqlFileName;

    @Value("${update.isupdate}")
    private boolean isUpdate;


    @Override
    //@Transactional(rollbackFor=Exception.class) 建表语句无法回滚 无意义
    public void run(ApplicationArguments args){
        //检查数据库的更新
        try{
            if(isUpdate){
                StringBuffer stringBuffer= null;
                BufferedReader bf=null;
                String filename=System.getProperty("user.dir") + File.separator+"sql"+File.separator+sqlFileName;
                File file=new File(filename);
                bf=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
                stringBuffer = new StringBuffer();
                String temp=null;
                while ((temp=bf.readLine())!=null){
                    stringBuffer.append(temp);
                }
                bf.close();
                String[] split = stringBuffer.toString().split(";");
                for (String sql:split){
                    HashMap<String,String> map=new HashMap<>();
                    map.put("sql",sql);
                    updateMapper.updateSql(map);
                }
                log.info("------------------执行初始化脚本完毕----------------------");
                updateYml();
            }
        }catch (Exception e){
            //建表语句无法回滚 无意义
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
        }
    }

    public void updateYml(){
        String filename=System.getProperty("user.dir") + File.separator+"config"+File.separator+"application.yml";
        Yaml yaml = new Yaml();
        File file = new File(filename);
        try {
            Map m1 = (Map) yaml.load(new FileInputStream(file));
            Map update =(Map) m1.get("update");
            update.put("isupdate",false);

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(yaml.dump(m1));
            fileWriter.flush();
            fileWriter.close();
            log.info("------------------配置文件修改完毕----------------------");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
