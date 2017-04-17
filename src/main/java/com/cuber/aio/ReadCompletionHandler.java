package com.cuber.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by Administrator on 2017/4/14.
 */
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
    public ReadCompletionHandler(AsynchronousSocketChannel result) {
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {

    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {

    }
}
