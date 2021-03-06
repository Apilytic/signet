package org.apilytic.signet;

import io.netty.annotation.SimpleChannelInbound;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.UUID;

@Sharable
@SimpleChannelInbound
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(Unpooled.copiedBuffer(UUID.randomUUID().toString(),
				CharsetUtil.UTF_8));
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
		System.out.println(
				"Client received: " + in.toString(CharsetUtil.UTF_8));

		in.clear();
		in.release();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,
								Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}