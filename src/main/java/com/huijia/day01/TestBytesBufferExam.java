package com.huijia.day01;

import java.nio.ByteBuffer;

/**
 * 模拟粘包和半包的问题，并尝试去解决
 *
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/7/21 15:33
 */
import static com.huijia.day01.ByteBufferUtil.debugAll;

public class TestBytesBufferExam {
    /**
     * Hello,world\n
     * I’m Nyima\n
     * How are you?\n
     * <p>
     * 当出现粘包和半包的情况
     * Hello,world\nI’m Nyima\nHo
     * w are you?\n
     */
    public static void main(String[] args) {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI’m Nyima\nHo".getBytes());
        split(source);
        source.put("w are you?\n".getBytes());
        split(source);
    }

    public static void split(ByteBuffer source) {
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            if (source.get(i) == '\n') {
                int length = i + 1 - source.position();
                ByteBuffer target = ByteBuffer.allocate(length);
                for (int j = 0; j < length; j++) {
                    target.put(source.get());
                }
                debugAll(target);
            }
        }
        source.compact();
    }
}
