package com.huijia.day01;

import java.nio.ByteBuffer;

/**
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/7/21 14:39
 */
public class TestByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'});
        buffer.flip();

        buffer.get(new byte[5]);
        ByteBufferUtil.debugAll(buffer);
        buffer.rewind(); //可以让position回到开始为止0处
        System.out.println((char) buffer.get());

        //mark做一个标记，记录position位置， reset是将position重置到mark的位置
    }
}
