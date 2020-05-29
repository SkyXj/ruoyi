package com.ruoyi.mina.handler;

import com.ruoyi.common.utils.ByteUtils;
import com.ruoyi.mina.config.SessionManage;
import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderException;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * <p>
 *  客户端Handler
 * </p>
 *
 * @author: Haifeng
 * @date: 2018-12-14
 */
@Slf4j
public class ClientHandler extends IoHandlerAdapter {

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
//        String address = session.getRemoteAddress().toString();
//        log.warn("客户端收到["+address+"]消息：" + message);
        MsgHandler.dealWith(message);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        super.sessionIdle(session, status);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }

    /**
     * 来处理一些异常情况，否则异常信息将无法捕捉，简单地打印了错误的堆栈跟
     * 对于大多数程序，这将是标准的做法，除非处理程序可以从异常状态中恢复。
     * @param session
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        super.exceptionCaught(session, cause);
        String clientIP = ((InetSocketAddress) session.getRemoteAddress()).getAddress().getHostAddress();
        if (cause instanceof IOException) {
            log.error("服务端 IP: " + clientIP + ",处理请求出现IO异常");
            session.closeNow();
        }else if (cause instanceof ProtocolDecoderException) {
            log.error("服务端 IP: " + clientIP + ",出现编码与解码异常");
        } else {
            log.error("服务端 IP: " + clientIP + ",出现其它异常");
        }
    }
}
