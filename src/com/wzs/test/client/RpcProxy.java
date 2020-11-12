package com.wzs.test.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

import com.wzs.test.service.RpcObject;


/**
 * 
 * @ClassName: RpcProxy
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wzs
 * @date 2017年11月12日
 *
 */
public class RpcProxy implements InvocationHandler, Serializable{  
    private String ip;  
    private int port;  
    private Class c;  
      
    private static final long serialVersionUID = 1L;  
  
    public RpcProxy(String ip, int port, Class c) {  
        this.ip = ip;  
        this.port = port;  
        this.c = c;  
    }  
      
    
    /** 
     * 动态代理类，当调用接口方法的时候转为调用此方法 
     */  
    @Override  
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
        Object o = null;        // 用作返回值  
        // 通过socket调用远程服务  
        Socket s = new Socket(ip, port);
        // 组装为一个保留了要调用的类，方法名及参数的对象，然后序列化之后传给远程  
        RpcObject rpcObject = new RpcObject(c, method.getName(), args); 
        ObjectOutputStream os = null;  
        ObjectInputStream is = null;  
        try {  
            os = new ObjectOutputStream(s.getOutputStream());  
            os.writeObject(rpcObject);  
            os.flush();
            // 从远程得到返回结果  
            is = new ObjectInputStream(s.getInputStream());  
            o = is.readObject();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally{  
            os.close();  
            is.close();  
        }  
          
        return o;
    }  
      
}  