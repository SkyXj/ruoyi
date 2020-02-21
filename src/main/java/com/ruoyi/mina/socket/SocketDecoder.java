package com.ruoyi.mina.socket;

import com.ruoyi.common.utils.ByteUtils;
import lombok.val;
import org.apache.mina.core.buffer.BufferDataException;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.*;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 类描述：自定义编码器
 * @author Wang Haifeng
 * @date - 2018-12-14
 */
public class SocketDecoder extends CumulativeProtocolDecoder {
	private final Charset charset;

	public SocketDecoder(Charset charset) {
		this.charset = charset;

	}

	@Override
	protected boolean doDecode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput)
			throws Exception {
		// 丢包，断包处理
		if (ioBuffer.remaining() > 16)// 有包头，包头足够
		{
			ioBuffer.mark();// 标记当前position的快照标记mark，以便后继的reset操作能恢复position位置，开始是0
			byte[] l = new byte[16];
			ioBuffer.get(l);// 读取包头，占16个字节

			int datalenth = ByteUtils.Bytes2Int_LE(ByteUtils.subByte(l, 12, 4));
			if (ioBuffer.remaining() < datalenth)// 内容长度的4个字节不够，断包
			{
				ioBuffer.reset();
				return false;//
			}// 内容长度的字节数组足够
			else {
				ioBuffer.reset();
				// 内容长度
				byte[] bytesLegth = new byte[datalenth+16];
				ioBuffer.get(bytesLegth, 0, datalenth+16);
				// 读取内容，并且发送
				protocolDecoderOutput.write(bytesLegth);
//				protocolDecoderOutput.write(new String(bytesLegth, charset));
				// 最后如果粘了包，会再次调用doDeocde()方法，把剩余数据给doDeocde()方法处理
				if (ioBuffer.remaining() > 0)
				{
					return true;
				}
			}
		}
		// 断包，或者执行完
		return false;
	}

	public static void main(String[] args) {
		byte b=4;
		int a=4;
		System.out.println(a==4);
//		System.out.println(getChars(new byte[]{1}));
	}

	private static char[] getChars (byte[] bytes) {
		Charset cs = Charset.forName ("UTF-8");
		ByteBuffer bb = ByteBuffer.allocate (bytes.length);
		bb.put (bytes);
		bb.flip ();
		CharBuffer cb = cs.decode (bb);
		return cb.array();
	}
}
