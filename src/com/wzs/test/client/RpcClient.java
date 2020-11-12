package com.wzs.test.client;

import com.wzs.test.IHello;
/**
 * 
 * @ClassName: RpcClient
 * @Description: 客户端测试，通过接口代理，获取远程实现类，根据请求返还
 * @author wzs
 * @date 2017年11月12日
 *
 */
public class RpcClient {  
    public static void main(String[] args) {  
        String ip = "localhost";  
        int port = 9001;  
        IHello hello = ProxyFactory.create(IHello.class, ip, port);  
        System.out.println(hello.sayHello("wzj"));  
    }  
}  