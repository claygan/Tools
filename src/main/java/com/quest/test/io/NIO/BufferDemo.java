package com.quest.test.io.NIO;

import com.google.common.primitives.Bytes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Quest on 2018/3/27.
 */
public class BufferDemo {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("F:\\Desktop\\家电统计.txt", "r");
            FileChannel channel = file.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            System.out.println("position:" + readBuffer.position() + "---limit:" + readBuffer.limit() + "---capacity:" + readBuffer.capacity());
            channel.read(readBuffer);
            System.out.println("position:" + readBuffer.position() + "---limit:" + readBuffer.limit() + "---capacity:" + readBuffer.capacity());
            readBuffer.flip();
            System.out.println("position:" + readBuffer.position() + "---limit:" + readBuffer.limit() + "---capacity:" + readBuffer.capacity());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
