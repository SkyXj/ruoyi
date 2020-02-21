package com.ruoyi.mina.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.concurrent.ExecutionException;

/**
 * 类描述：socket服务器端处理类
 * @author Wang Haifeng
 * @date - 2018-12-14
 */
@Slf4j
public class ServerHandler extends IoHandlerAdapter {
	private int count=0;

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		log.error("出现异常 :" + session.getRemoteAddress().toString() + " : " + cause.toString());
		session.write("出现异常");
		session.closeNow();
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		log.info("连接创建 : " + session.getRemoteAddress().toString());
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		log.info("连接打开: " + session.getRemoteAddress().toString());
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String address = session.getLocalAddress().toString();
		log.info("服务器["+address+"]接受到数据 :" + String.valueOf(message));
		String text = String.valueOf(message);
//		if(Math.random() > 0.5){
//
//		}

		log.info("数据业务处理开始...... ");
		String result = dealWith(text, session);
		log.info("数据业务处理结束...... ");
		session.write(result);
//		if(count%2!=0){
//			log.info("数据业务处理开始...... ");
//			String result = dealWith(text, session);
//			log.info("数据业务处理结束...... ");
//			session.write(result);
//		}
//		count++;
	}

	private String dealWith(String message, IoSession session) throws InterruptedException, ExecutionException {
		String address = session.getLocalAddress().toString();
		message=message.replaceAll("<begin>","").replaceAll("<end>","");
		JSONObject jsonObject = JSON.parseObject(message);
		jsonObject.getJSONObject("data").put("status", 1);
		jsonObject.getJSONObject("data").put("msg", "处理成功");
		return "<begin>"+jsonObject+"<end>";
	}

	private String analyzeData(String text, IoSession session) throws InterruptedException, ExecutionException {
		String address = session.getLocalAddress().toString();
		String responseMessage = "test".equals(text) ? "1111" : "收到啦！";
		return responseMessage;
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		log.info("返回客户端消息 : "+message);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		if (status == IdleStatus.READER_IDLE) {
			log.info("进入读空闲状态");
			session.closeNow();
		} else if (status == IdleStatus.BOTH_IDLE) {
			log.info("BOTH空闲");
			session.closeNow();
		}
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		log.info("连接关闭 : " + session.getRemoteAddress().toString());
		int size = session.getService().getManagedSessions().values().size();
		log.info("连接关闭时session数量==》" + size);
	}

}
