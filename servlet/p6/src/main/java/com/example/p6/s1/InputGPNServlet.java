package com.example.p6.s1;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input_gpn")
public class InputGPNServlet extends HttpServlet {

    public void init() throws ServletException {
        System.out.println("Call init method");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Enumeration enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String name = (String) enums.nextElement();
            String[] values = request.getParameterValues(name);
            for (String value : values) {
                System.out.println("name: " + name + " value: " + value);
            }
        }

    }

    public void destroy() {
        System.out.println("Call destroy method");
    }
}
