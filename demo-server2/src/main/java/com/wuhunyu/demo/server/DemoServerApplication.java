package com.wuhunyu.demo.server;

import com.wuhunyu.rpc.server.RpcServerApplication;

import java.util.concurrent.TimeoutException;

/**
 * 服务端主程序
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-06 10:28
 */

public class DemoServerApplication {

    public static void main(String[] args) throws TimeoutException {
        // 启动服务
        RpcServerApplication.of();
    }

}
