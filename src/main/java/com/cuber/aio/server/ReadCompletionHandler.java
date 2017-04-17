package com.cuber.aio.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by cuber_q on 2017/4/14.
 */
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
    AsynchronousSocketChannel channel = null;
    public ReadCompletionHandler(AsynchronousSocketChannel result) {
        if (null != result) {
            this.channel = result;
        }
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        byte[] body = new byte[attachment.remaining()];
        try {
            String req = new String(body, "utf-8");
            System.out.println("recv msg: " + req + ", " + System.currentTimeMillis());
            doWrite(req);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(String req) {
        String resp = "got msg at " + System.currentTimeMillis();
        final ByteBuffer buffer = ByteBuffer.allocate(req.length());
        buffer.put(resp.getBytes());
        channel.write(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if (buffer.hasRemaining()) {
                    channel.write(buffer,buffer,this);
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
