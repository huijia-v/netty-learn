package com.huijia.day01;

import java.nio.ByteBuffer;

/**
 * 测试
 *
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/7/21 13:16
 */
public class TestByteBufferReadWrite {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        buffer.put((byte) 0x61);
        buffer.put((byte) 0x62);
        buffer.put(new byte[]{0x63, 0x64, 0x69});

        ByteBufferUtil.debugAll(buffer);

        buffer.get();


    }
}
