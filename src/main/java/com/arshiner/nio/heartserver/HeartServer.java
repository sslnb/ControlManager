package com.arshiner.nio.heartserver;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

import org.springframework.stereotype.Component;
@Component
public class HeartServer{
    
    
    private int port;
 
    public HeartServer() {
        this.port = 9091;
    }
 
    public void start() {
        EventLoopGroup bossGroup = new NioEventLoopGroup(3);
        EventLoopGroup workerGroup = new NioEventLoopGroup(4);
        try {
            ServerBootstrap sbs = new ServerBootstrap().group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port)).childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                        	ch.pipeline().addLast(new ObjectEncoder());
                        	ch.pipeline().addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.weakCachingConcurrentResolver(null))); // 最大长度
                        	ch.pipeline().addLast(new HeartServerHandler());
                            ch.pipeline().addLast("decoder", new StringDecoder());
                            ch.pipeline().addLast("encoder", new StringEncoder());
                        };
                    }).option(ChannelOption.SO_BACKLOG, 256).childOption(ChannelOption.SO_KEEPALIVE, true);
            // 绑定端口，开始接收进来的连接
            ChannelFuture future = sbs.bind(port).sync();
            if (future.isSuccess()) {
            	System.out.println("HeartServer启动成功");
			}
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
 
	public static void run() throws Exception {
		// TODO Auto-generated method stub
		new HeartServer().start();
	}
 public static void main(String[] args) {
	try {
		run();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

