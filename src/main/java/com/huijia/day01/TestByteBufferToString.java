package com.huijia.day01;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * ByteBuffer转String
 *
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/7/21 14:48
 */

import static com.huijia.day01.ByteBufferUtil.debugAll;
public class TestByteBufferToString {
    public static void main(String[] args) {
        //字符串转ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(11);
        buffer.put("hello".getBytes());
        debugAll(buffer);

        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("helwewewlo");
        debugAll(buffer1);

        ByteBuffer buffer2 = ByteBuffer.wrap("hello,Netty".getBytes());
        debugAll(buffer2);

        //转为字符串
        String s = StandardCharsets.UTF_8.decode(buffer1).toString();
        System.out.println(s);
    }
}
