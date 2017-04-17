package com.cuber.aio.server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * Created by qupeng on 2017/4/14.
 */
public class AcceptCompleteHandler implements java.nio.channels.CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
        // 循环调用，保证server能一直接收请求
        attachment.asynchronousServerSocketChannel.accept(attachment,this);
        ByteBuffer byteBuffer =  ByteBuffer.allocate(1024);
        result.read(byteBuffer,byteBuffer,new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.countDownLatch.countDown();
    }
}
