package com.wzs.test.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/**
 * 
 * @ClassName: ProxyFactory
 * @Description: 代理工厂
 * @author wzs
 * @date 2017年11月12日
 *
 */
public class ProxyFactory {  
	  
    public static <T> T create(Class<T> c, String ip, int port) {  
         InvocationHandler handler = new RpcProxy(ip, port, c);  
          
        return (T) Proxy.newProxyInstance(c.getClassLoader(),  
                new Class[] {c },  
                handler);  
    }  
}  
