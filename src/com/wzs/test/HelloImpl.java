package com.wzs.test;
/**
 * 
 * @ClassName: HelloImpl
 * @Description: 测试接口类  提供客户端
 * @author wzs
 * @date 2017年11月12日
 *
 */
public class HelloImpl implements IHello {  
    @Override  
    public String sayHello(String name) {  
        return "hello:" + name;  
    }  
}  

