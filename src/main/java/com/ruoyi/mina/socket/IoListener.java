package com.ruoyi.mina.socket;

/**
 * Copyright © 广州禾信仪器股份有限公司. All rights reserved.
 *
 * @Author hxsdd-20
 * @Date 2020/4/15 16:42
 * @Version 1.0
 */
import org.apache.mina.core.service.IoService;
import org.apache.mina.core.service.IoServiceListener;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class IoListener implements IoServiceListener{

    @Override
    public void serviceActivated(IoService arg0) throws Exception {
        // TODO Auto-generated method stub
    }
    @Override
    public void serviceDeactivated(IoService arg0) throws Exception {
        // TODO Auto-generated method stub
    }
    @Override
    public void serviceIdle(IoService arg0, IdleStatus arg1) throws Exception {
        // TODO Auto-generated method stub
    }
    @Override
    public void sessionCreated(IoSession arg0) throws Exception {
        // TODO Auto-generated method stub
    }
    @Override
    public void sessionClosed(IoSession ioSession) throws Exception {

    }
    @Override
    public void sessionDestroyed(IoSession arg0) throws Exception {
        // TODO Auto-generated method stub
    }
}

