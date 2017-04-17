package com.cuber.aio;

/**
 * Created by Administrator on 2017/4/14.
 */
public class TimeServer {
    public static void main(String[] args) {
        new Thread(new AsyncTimeServerHandler(12345),"aio-AsyncTimeServerHandler-01").start();
    }
}
