package org.apilytic.signet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class DiscardServerHandler extends SimpleChannelInboundHandler<Object> {
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf in = (ByteBuf) msg;
		while (in.isReadable()) { // (1)
			System.out.print((char) in.readByte());
			System.out.flush();
		}
	}
}
