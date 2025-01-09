package org.fundamental.designpattern.proxy;

public class ClientWithProxy {

    public static void main(String[] args) {
        ServiceInterface proxy = new ServiceProxy();
        System.out.println(proxy.doSomething());
    }

}
