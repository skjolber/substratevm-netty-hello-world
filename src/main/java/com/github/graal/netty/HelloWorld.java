package com.github.graal.netty;

import java.nio.charset.StandardCharsets;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;



/**
 * An HTTP server that sends back the content of the received HTTP request
 * in a pretty plaintext form.
 */
public final class HelloWorld {

	static final int PORT = 8081;

	public static void main(String[] args) throws Exception {
		
		byte[] content = "Hello World\n".getBytes(StandardCharsets.UTF_8);
		// Configure the server.
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.option(ChannelOption.SO_BACKLOG, 1024);
			b.group(bossGroup, workerGroup)
			.channelFactory(new ChannelFactory<ServerChannel>() {
				@Override
				public ServerChannel newChannel() {
					return new NioServerSocketChannel();
				}
			})
			.childHandler(new HttpHelloWorldServerInitializer(content));

			Channel ch = b.bind(PORT).sync().channel();

			System.err.println("Open your web browser and navigate to " +
					("http") + "://127.0.0.1:" + PORT + '/');

			ch.closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}