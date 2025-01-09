package com.example.p5s1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        System.out.println("Call doGet method");
    }

    @Override
    public void destroy() {
        System.out.println("Call destory method");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Call init method");
    }

}
