package com.wzs.test.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 
 * @ClassName: Server
 * @Description: ����˹���
 * @author wzs
 * @date 2017��11��12��
 *
 */
public class Server {  
    public static final int port = 8080;  
      
    public static void main(String[] args) {  
            exportRpc();  
    }  
      
    /** 
     * ����RPC�ӿ� 
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


