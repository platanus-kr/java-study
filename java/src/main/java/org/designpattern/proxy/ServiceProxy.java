package org.designpattern.proxy;

public class ServiceProxy implements ServiceInterface {

    ServiceInterface service;

    @Override
    public String doSomething() {
        System.out.println("실행 되기 전");
        service = new Service();
        System.out.println("생성자 뒤");
        return service.doSomething();
    }
}
