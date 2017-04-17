package com.cuber.aio.client;

/**
 * Created by cuber_q on 2017/4/17.
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 0;
        port = Integer.valueOf(args[0]);
        new Thread(new AsyncTimeClientHandler("127.0.0.1",port),"asyncTimeClientHandler");
    }
}
