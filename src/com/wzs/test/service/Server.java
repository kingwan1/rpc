package com.wzs.test.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 
 * @ClassName: Server
 * @Description: 服务端管理
 * @author wzs
 * @date 2017年11月12日
 *
 */
public class Server {  
    public static final int port = 8080;  
      
    public static void main(String[] args) {  
            exportRpc();  
    }  
      
    /** 
     * 导出RPC接口 
     */  
    private static void exportRpc() {  
        try {  
            ServerSocket ss = new ServerSocket(9001);  
            while(true){  
                Socket s = ss.accept();  
                new RpcThread(s).start();  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  


