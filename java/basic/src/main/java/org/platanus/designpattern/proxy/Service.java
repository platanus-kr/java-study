package org.platanus.designpattern.proxy;

public class Service implements ServiceInterface {


    @Override
    public String doSomething() {
        return "Work something!";
    }
}
