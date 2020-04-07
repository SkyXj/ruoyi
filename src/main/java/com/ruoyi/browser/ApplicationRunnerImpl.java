//package com.ruoyi.browser;
//
//import com.teamdev.jxbrowser.chromium.Browser;
//import com.teamdev.jxbrowser.chromium.swing.BrowserView;
//
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import com.teamdev.jxbrowser.chromium.ba;
//
//import java.awt.*;
//import java.lang.reflect.Modifier;
//
//import javax.swing.*;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.lang.reflect.Field;
//import java.math.BigInteger;
//
///**
// * @author 鲁达
// * createTime 2019-12-29 20:51
// **/
////@Component
//public class ApplicationRunnerImpl implements ApplicationRunner {
//    static {
//        try {
//            Field e = ba.class.getDeclaredField("e");
//            e.setAccessible(true);
//            Field f = ba.class.getDeclaredField("f");
//            f.setAccessible(true);
//            Field modifersField = Field.class.getDeclaredField("modifiers");
//            modifersField.setAccessible(true);
//            modifersField.setInt(e, e.getModifiers() & ~Modifier.FINAL);
//            modifersField.setInt(f, f.getModifiers() & ~Modifier.FINAL);
//            e.set(null, new BigInteger("1"));
//            f.set(null, new BigInteger("1"));
//            modifersField.setAccessible(false);
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
////        final String url = " http://localhost:81/";
////        final String title = "baidu";
////        Browser browser = new Browser();
////        BrowserView view = new BrowserView(browser);
////
////        JFrame frame = new JFrame();
////        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
////        frame.setSize(400, 600);
////        frame.add(view, BorderLayout.CENTER);
////        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
////        frame.setLocationByPlatform(true);
////        frame.setVisible(true);
////        browser.loadURL(url);
//
//        String url = "https://www.baidu.com/";
//        JFrame frame = new JFrame();
//        // 谷歌内核浏览器
//        Browser browser = new Browser();
//        BrowserView view = new BrowserView(browser);
//        //禁用close功能
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //隐藏任务栏图标
////        frame.setType(JFrame.Type.UTILITY);
////        //不显示标题栏,最大化,最小化,退出按钮
////        frame.setUndecorated(true);
//        //尺寸
////        frame.setSize(500, 500);
//        //坐标
//        frame.setLocation(0, 0);
//        frame.add(view);
//        //全屏显示
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        // 是否显示
//        frame.setVisible(true);
//        //是否在屏幕最上层显示
//        frame.setAlwaysOnTop(true);
//        //加载地址
//        browser.loadURL(url);
////        System.out.println(frame.getX());
////        System.out.println(frame.getY());
////        list.add(frame);
//        frame.addWindowListener(new WindowAdapter() {
//            // 窗口关闭时间监听
//            @Override
//            public void windowClosing(WindowEvent e){
//                System.out.println("窗口关闭...");
//            }
//        });
//    }
//}
