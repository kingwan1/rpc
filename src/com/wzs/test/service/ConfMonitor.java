package com.wzs.test.service;

import java.util.HashMap;
import java.util.Map;

import com.wzs.test.HelloImpl;

/**
 *  
 * @ClassName: ConfMonitor
 * @Description: ����ע����ӳ��
 * @author wzs
 * @date 2017��11��12��
 *
 */
public class ConfMonitor {  
    public static Map<String, Class> conf = new HashMap<String, Class>();  
      
    static {  
        conf.put("com.prince.rpc.service.IHello", HelloImpl.class);  
    }  
}  