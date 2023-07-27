package com.huijia.day01;

import java.nio.ByteBuffer;

/**
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/7/21 14:29
 */
public class TestByteBufferAllocate {

    public static void main(String[] args) {
        System.out.println(ByteBuffer.allocate(11).getClass());
        System.out.println(ByteBuffer.allocateDirect(11).getClass());

        /**
         *
         */
    }
}
