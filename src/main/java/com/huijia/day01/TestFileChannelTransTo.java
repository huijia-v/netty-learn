package com.huijia.day01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 文件传输测试
 *
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/7/21 16:19
 */
public class TestFileChannelTransTo {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("stu.txt");
             FileOutputStream fos = new FileOutputStream("student.txt");
             FileChannel inputChannel = fis.getChannel();
             FileChannel outputChannel = fos.getChannel()) {
            // 参数：inputChannel的起始位置，传输数据的大小，目的channel
            // 返回值为传输的数据的字节数
            // transferTo一次只能传输2G的数据
            inputChannel.transferTo(0, inputChannel.size(), outputChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        public  void test(String[] args){
            try (FileInputStream fis = new FileInputStream("stu.txt");
                 FileOutputStream fos = new FileOutputStream("student.txt");
                 FileChannel inputChannel = fis.getChannel();
                 FileChannel outputChannel = fos.getChannel()) {
                long size = inputChannel.size();
                long capacity = inputChannel.size();
                // 分多次传输
                while (capacity > 0) {
                    // transferTo返回值为传输了的字节数      这里是每次传输的起始位置   这是传输的容量大小
                    capacity -= inputChannel.transferTo(size-capacity,     capacity,    outputChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public void test2() {
        File file = new File("/");
        File[] files = file.listFiles();

        Path source = Paths.get("/");
        Path target = Paths.get("/");
        try {
            Files.copy(source, target);
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
