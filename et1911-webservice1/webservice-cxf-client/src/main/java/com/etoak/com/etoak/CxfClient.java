package com.etoak.com.etoak;

import com.etoak.service.HelloService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class CxfClient {
    public static void main(String args[]){
        //创建
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        //设置地址
        factory.setAddress("http://localhost:8000/hello?wsdl");
        //设置接口服务
        factory.setServiceClass(HelloService.class);
        //创建远程服务代理
        HelloService service = (HelloService)factory.create();
        //调用远程方法
        System.out.println(service.sayHello("CXF"));

    }
}
