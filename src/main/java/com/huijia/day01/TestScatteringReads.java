package com.huijia.day01;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/7/21 15:05
 */

import static com.huijia.day01.ByteBufferUtil.debugAll;
public class TestScatteringReads {
    public static void main(String[] args) {
        try (FileChannel channel = new RandomAccessFile("test.txt", "r").getChannel()) {
            ByteBuffer b1 = ByteBuffer.allocate(3);
            ByteBuffer b2 = ByteBuffer.allocate(3);
            ByteBuffer b3 = ByteBuffer.allocate(6);
            channel.read(new ByteBuffer[]{b1, b2, b3});
            debugAll(b1);
            debugAll(b2);
            debugAll(b3);

        } catch (IOException e) {
        }
    }
}
