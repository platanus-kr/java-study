package org.designpattern.proxy;

public class Service implements ServiceInterface {


    @Override
    public String doSomething() {
        return "Work something!";
    }
}
