package com.cuber.aio.client;

import java.nio.channels.CompletionHandler;

/**
 * Created by Administrator on 2017/4/17.
 */
public class AsyncTimeClientHandler implements Runnable, CompletionHandler<Void,AsyncTimeClientHandler> {

    public AsyncTimeClientHandler(String host, int port) {

    }

    @Override
    public void run() {

    }

    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {

    }

    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {

    }
}
