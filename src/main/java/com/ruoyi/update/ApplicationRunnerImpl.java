package com.ruoyi.update;

import com.ruoyi.zh.mapper.UpdateMapper;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright © 广州禾信仪器股份有限公司. All rights reserved.
 *
 * @Author hxsdd-20
 * @Date 2020/5/20 9:49
 * @Version 1.0
 */
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Autowired
    UpdateMapper updateMapper;
    @Override
    public void run(ApplicationArguments args){
        //检查数据库的更新
        if(false){
            StringBuffer stringBuffer= null;
            BufferedReader bf=null;
            try {
                URL url = getClass().getClassLoader().getResource("test.sql");
                // 通过url获取File的绝对路径
                File f = new File(url.getFile());
                bf=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
                stringBuffer = new StringBuffer();
                String temp=null;
                while ((temp=bf.readLine())!=null){
                    stringBuffer.append(temp);
                }
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(stringBuffer.toString());
            HashMap<String,String> map=new HashMap<>();
            map.put("sql",stringBuffer.toString());
            updateMapper.updateSql(map);
        }
    }

    public static void main(String[] args) {
        File file=new File("C:\\Users\\hxsdd-20\\Desktop\\2020-04-23\\test.txt");
        BufferedReader bf=null;
        try {
            bf=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String temp=null;
            while ((temp=bf.readLine())!=null){
                if(!isStartWithNumber(temp)){
                    System.out.println(temp);
                }
            }
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //判断字符串是不是以数字开头
    public static boolean isStartWithNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str.charAt(0)+"");
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
