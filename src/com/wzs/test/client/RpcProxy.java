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
 * @Description: TODO(������һ�仰��������������)
 * @author wzs
 * @date 2017��11��12��
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
     * ��̬�����࣬�����ýӿڷ�����ʱ��תΪ���ô˷��� 
     */  
    @Override  
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
        Object o = null;        // ��������ֵ  
        // ͨ��socket����Զ�̷���  
        Socket s = new Socket(ip, port);
        // ��װΪһ��������Ҫ���õ��࣬�������������Ķ���Ȼ�����л�֮�󴫸�Զ��  
        RpcObject rpcObject = new RpcObject(c, method.getName(), args); 
        ObjectOutputStream os = null;  
        ObjectInputStream is = null;  
        try {  
            os = new ObjectOutputStream(s.getOutputStream());  
            os.writeObject(rpcObject);  
            os.flush();
            // ��Զ�̵õ����ؽ��  
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