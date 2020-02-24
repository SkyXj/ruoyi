package com.ruoyi.mina.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

//@Component
//@ConfigurationProperties(prefix="mina.client")
//public class MinaRun implements CommandLineRunner {
public class MinaRun  {

//    private static final Logger logger = LogManager.getLogger(MinaRun.class);
//
//
//    private String host;
//    private int port;
//
//    private NioSocketConnector connector;
//
//    @Autowired
//    public MinaRun(NioSocketConnector connector) {
//        this.connector = connector;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        logger.info(">>>>>>>>>>>>>>>>>>正在连接远程服务器>>>>>>>>>>>>>>>>>>>>");
//        try {
//            // 设置服务器地址，端口号
//            InetSocketAddress address = new InetSocketAddress(host, port);
//            ConnectFuture future = connector.connect(address);
//            // 获取session执行绑定方法
//            future.awaitUninterruptibly();
//            IoSession session = future.getSession();
//            SessionManage.session=session;
////            bind(session, account, msg);
//            logger.info("<<<<<<<<<<<<<<<<<<与远程服务器连接成功<<<<<<<<<<<<<<<<<<");
//        } catch (Exception e) {
//            logger.error("<<<<<<<<<<<<<<<<<<与远程服务器连接失败<<<<<<<<<<<<<<<<<<" + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    public String getHost() {
//        return host;
//    }
//
//    public void setHost(String host) {
//        this.host = host;
//    }
//
//    public int getPort() {
//        return port;
//    }
//
//    public void setPort(int port) {
//        this.port = port;
//    }
}
