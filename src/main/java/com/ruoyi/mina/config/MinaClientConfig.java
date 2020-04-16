package com.ruoyi.mina.config;



import com.ruoyi.mina.handler.ClientHandler;
import com.ruoyi.mina.socket.IoListener;
import com.ruoyi.mina.socket.SocketFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.logging.MdcInjectionFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyEditor;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 *
 * describe mina客户端配置
 * @author xmc
 * @date 2018/7/25 10:48
 * @param  * @param null
 * @return
 */
@Configuration
@Slf4j
public class MinaClientConfig {

    public static NioSocketConnector connectorall;

    /**
     * 设置I/O接收器
     * @return
     */
    private Map<Class<?>, Class<? extends PropertyEditor>> customEditors = new HashMap<>();

//    @Bean
//    public CustomEditorConfigurer customEditorConfigurer() {
//        customEditors.put(SocketAddress.class, InetSocketAddressEditor.class);
//        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
//        configurer.setCustomEditors(customEditors);
//        return configurer;
//    }


    @Bean
    public ClientHandler clientHandler(){
        return new ClientHandler();
    }

    /**
     * 线程池filter
     */
    @Bean
    public ExecutorFilter executorFilter() {
        return new ExecutorFilter();
    }
    @Bean
    public MdcInjectionFilter mdcInjectionFilter() {
        return new MdcInjectionFilter(MdcInjectionFilter.MdcKey.remoteAddress);
    }

    /**
     * 编码器filter
     */
    @Bean
    public ProtocolCodecFilter protocolCodecFilter() {
        return new ProtocolCodecFilter(new SocketFactory());
    }

    /**
     * 日志filter
     */
    @Bean
    public LoggingFilter loggingFilter() {
        LoggingFilter filter = new LoggingFilter();
        return filter;
    }

//    /**
//     * 心跳filter
//     */
//    @Bean
//    public KeepAliveFilter keepAliveFilter() {
//        // 客户端不需要发送心跳
//        KeepAliveFactoryImpl keepAliveFactory = new KeepAliveFactoryImpl(false);
//        // 注入心跳工厂，读写空闲
//        KeepAliveFilter filter = new KeepAliveFilter(keepAliveFactory);
//        return filter;
//    }

    /**
     * 过滤器链
     */
    @Bean
    public DefaultIoFilterChainBuilder defaultIoFilterChainBuilder(ExecutorFilter executorFilter,
                                                                   MdcInjectionFilter mdcInjectionFilter,
                                                                   ProtocolCodecFilter protocolCodecFilter,
                                                                   LoggingFilter loggingFilter) {
        DefaultIoFilterChainBuilder filterChainBuilder = new DefaultIoFilterChainBuilder();
        Map<String, IoFilter> filters = new LinkedHashMap<>();
        filters.put("executor", executorFilter);
        filters.put("mdcInjectionFilter", mdcInjectionFilter);
        filters.put("protocolCodecFilter", protocolCodecFilter);
        // filters.put("loggingFilter", loggingFilter); 不注入日志filter
//        filters.put("keepAliveFilter", keepAliveFilter);
        filterChainBuilder.setFilters(filters);
        return filterChainBuilder;
    }


    /**
     * 创建连接
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public NioSocketConnector nioSocketConnector(ClientHandler clientHandler,
                                                 DefaultIoFilterChainBuilder defaultIoFilterChainBuilder) {
        NioSocketConnector connector = new NioSocketConnector();
        // 设置连接超时时间
        connector.setConnectTimeoutMillis(30000);
        // 设置处理handler
        connector.setHandler(clientHandler);
        // 绑定过滤器链
        connector.setFilterChainBuilder(defaultIoFilterChainBuilder);

//        connector.getFilterChain().addFirst("reconnection", new IoFilterAdapter() {
//            @Override
//            public void sessionClosed(NextFilter nextFilter, IoSession ioSession) throws Exception {
//                for(;;){
//                    try{
//                        Thread.sleep(3000);
//                        ConnectFuture future = connector.connect();
//                        future.awaitUninterruptibly();// 等待连接创建成功
//                        SessionManage.session = future.getSession();// 获取会话
//                        if(SessionManage.session.isConnected()){
//                            log.info("断线重连["+ connector.getDefaultRemoteAddress().getHostName() +":"+ connector.getDefaultRemoteAddress().getPort()+"]成功");
//                            break;
//                        }
//                    }catch(Exception ex){
//                        log.info("重连服务器登录失败,3秒再连接一次:" + ex.getMessage());
//                    }
//                }
//            }
//        });

        // 添加重连监听
//        connector.addListener(new IoListener() {
//            @Override
//            public void sessionDestroyed(IoSession arg0) throws Exception {
//                for (;;) {
//                    try {
//                        Thread.sleep(3000);
//                        connector.setDefaultRemoteAddress(new InetSocketAddress(SessionManage.host,SessionManage.port));
//                        ConnectFuture future = connector.connect();
//                        future.awaitUninterruptibly();// 等待连接创建成功
//                        SessionManage.session = future.getSession();// 获取会话
//                        if (SessionManage.session.isConnected()) {
//                            log.info("断线重连[" + connector.getDefaultRemoteAddress().getHostName() + ":" + connector.getDefaultRemoteAddress().getPort() + "]成功");
//                            break;
//                        }
//                    } catch (Exception ex) {
//                        log.info("重连服务器登录失败,3秒再连接一次:" + ex.getMessage());
//                    }
//                }
//            }
//        });
        MinaClientConfig.connectorall=connector;
        return connector;
    }

}

