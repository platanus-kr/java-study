package com.example.p5s1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("Call third doGet");

    }

    @Override
    public void init() throws ServletException {
        System.out.println("Call third init");
    }
}
