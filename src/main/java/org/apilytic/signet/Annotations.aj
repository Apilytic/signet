package org.apilytic.signet;

import io.netty.annotation.SimpleChannelInbound;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.buffer.ByteBuf;

public aspect Annotations {
	declare parents : (@SimpleChannelInbound(ByteBuf.class) *) extends SimpleChannelInboundHandler<ByteBuf>;
	declare parents : (@SimpleChannelInbound(Object.class) *) extends SimpleChannelInboundHandler<Object>;
}

