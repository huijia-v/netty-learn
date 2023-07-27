package com.huijia.day03;

import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.NettyRuntime;

/**
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/7/27 13:19
 */
public class TestEventLoop {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup(); // io事件，普通任务，定时任务
//        EventLoopGroup group1 = new DefaultEventLoop();// 普通人任务，定时任务
        System.out.println(NettyRuntime.availableProcessors());
    }
}
