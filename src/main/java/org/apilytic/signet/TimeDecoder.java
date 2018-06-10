package org.apilytic.signet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class TimeDecoder extends ByteToMessageDecoder {
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { // (2)
		if (in.readableBytes() < 4) {
			return; // (3)
		}

		out.add(in.readBytes(4)); // (4)
	}
}
