package com.huijia.day01;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Bytebuffer学习
 *
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/7/21 10:47
 */
public class TestByteBuffer {
    public static void main(String[] args) {
        // 获得channel
        try (FileChannel channel = new FileInputStream("test.txt").getChannel()) {
            //  获得缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            int hasNext = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while ((hasNext = channel.read(byteBuffer)) > 0) {
                //切换读模式
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    stringBuilder.append((char) byteBuffer.get());
                }
                // 切换到写模式
                byteBuffer.clear();
            }
            System.out.println(stringBuilder.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
