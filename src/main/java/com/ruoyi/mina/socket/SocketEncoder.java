package com.ruoyi.mina.socket;

import com.ruoyi.common.utils.ByteUtils;
import com.ruoyi.mina.entity.Msg;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * 编码器
 */
public class SocketEncoder extends ProtocolEncoderAdapter {
    private final Charset charset;

    public SocketEncoder(Charset charset) {
        this.charset = charset;
    }

    /**
     * 直接将数据发出去,数据格式，包头+消息长度（int）+消息内容（json字符串）+包尾 包头包尾是十六进制字符串00 aa bb cc,转化成字节数组0,
     * -86, -69, -52四个字节
     *
     * @param session
     * @param message
     * @param out
     * @throws Exception
     */
    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        byte[] bytes=(byte[])message;
        // 仿项目，解决断包，粘包问题
        IoBuffer buf = IoBuffer.allocate(bytes.length).setAutoExpand(true);// 缓冲区容量大小38字节加上字符长度
        buf.put(bytes);// 消息内容
        buf.flip();
        out.write(buf);// 写入
    }


    //    @Override
//    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
//        // 仿项目，解决断包，粘包问题
//        String value = (message == null ? "" : message.toString());// 消息值
//        byte[] content = value.getBytes(charset);// 消息内容,字节数组
//        IoBuffer buf = IoBuffer.allocate(38 + content.length).setAutoExpand(true);// 缓冲区容量大小38字节加上字符长度
//        buf.put(new byte[] { 0, -86, -69, -52 });// 输入包开头固定值十六进制00 aa bb cc,转化成字节数组
//        buf.putUnsignedInt(content.length);// int为4字节，一个字节等于2个16进制字符，所以有八位 00 00 00 0c，内容长度。
//        buf.put(content);// 消息内容
//        buf.put(new byte[] { 0, -86, -69, -52 });// 包尾
//        buf.flip();
//        out.write(buf);// 写入
//    }
    public static void main(String[] args) {
//        byte[] bytes = intToByteArray(0x2);
////        ByteBuffer buf = ByteBuffer.allocate(16);
////        buf.mark();
////        buf.putInt(0x02);
////        byte[] bytes = new byte[16];
////        buf.reset();
////        buf.get(bytes);
//        System.out.println(bytes.length);

        byte[] bytes=new byte[]{0,0,0,20};

        int i = ByteUtils.byteArrayToInt(bytes);
        System.out.println(i);

//        Msg msg=new Msg();
//        //经纬度
//        msg.setCmd((byte)2);
//        msg.setMagic("SPIMS");
//        //经度
//        byte[] lng_bytes=new byte[1000];
//        //纬度
//        byte[] lat_bytes=new byte[1000];
//        msg.setBytes(ByteUtils.concat(lng_bytes,lat_bytes));
//        for (byte bt: msg.get2MsgByte()) {
//            System.out.println(bt);
//        }
    }

}

