package org.apilytic.signet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		ByteBuf in = (ByteBuf) msg;

		String payload = in.toString(CharsetUtil.UTF_8).replaceAll("\\s", "");
		System.out.println("Server received (" + payload.length() + "): " + payload);

		String json = "{\"userId\": \"" + payload + "\"}";

		if (!payload.isEmpty()) {
			ctx.write(Unpooled.copiedBuffer(json, CharsetUtil.UTF_8));
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
