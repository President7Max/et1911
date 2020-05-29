package com.etoak.service.impl;

import com.etoak.service.HelloService;

import javax.jws.WebService;

@WebService(serviceName = "HelloService",
        portName = "HelloServiceWSPort")
public class HelloServiceImpl implements HelloService {


    public String sayHello(String name) {
        System.out.println("服务端被调用了");
        return "Hello"+name;
    }
}
