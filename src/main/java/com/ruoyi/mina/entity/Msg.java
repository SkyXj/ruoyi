package com.ruoyi.mina.entity;


import org.apache.mina.core.buffer.IoBuffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class Msg {
    private String magic;
    private byte cmd;
    private String headLen;
    private String sessionId;
    private int dataLen;
    //xml
    private String body;
    //2进制
    private byte[] bytes;

    public byte[] getXMLMsgByte(){
        String value = (body == null ? "" : body.toString());// 消息值
        byte[] content = value.getBytes(Charset.defaultCharset());// 消息内容,字节数组
        byte[] result=new byte[16 + content.length];
        ByteBuffer buf = ByteBuffer.allocate(16 + content.length);// 缓冲区容量大小38字节加上字符长度
        // 输入包开头固定值十六进制00 aa bb cc,转化成字节数组
        buf.put(magic.getBytes(Charset.defaultCharset()));
        //cmd命令
        buf.put(cmd);
        //headlength
        buf.put(new byte[2]);
        //sessionid 扩展字段无用
        buf.put(new byte[4]);
        // int为4字节，一个字节等于2个16进制字符，所以有八位 00 00 00 0c，内容长度。
        buf.putInt(content.length);
        buf.put(content);// 消息内容
        buf.flip();
        buf.get(result);
        return result;
    }
    //二进制消息
    public byte[] get2MsgByte(){
        int datalength=bytes==null?0:bytes.length;
        byte[] result=new byte[16 + datalength];
        // 缓冲区容量大小38字节加上字符长度
        ByteBuffer buf = ByteBuffer.allocate(16 + datalength);
        // 输入包开头固定值十六进制00 aa bb cc,转化成字节数组
        buf.put(magic.getBytes(Charset.defaultCharset()));
        //cmd命令
        buf.put(cmd);
        //headlength
        buf.put(new byte[]{16,0});
        //sessionid 扩展字段无用
        buf.put(new byte[4]);
        // int为4字节，一个字节等于2个16进制字符，所以有八位 00 00 00 0c，内容长度。
        buf.putInt(datalength);
        // 消息内容
        if(bytes!=null){
            buf.put(bytes);
        }
        buf.flip();
        buf.get(result);
        return result;

    }


    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public byte getCmd() {
        return cmd;
    }

    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }

    public String getHeadLen() {
        return headLen;
    }

    public void setHeadLen(String headLen) {
        this.headLen = headLen;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getDataLen() {
        return dataLen;
    }

    public void setDataLen(int dataLen) {
        this.dataLen = dataLen;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
