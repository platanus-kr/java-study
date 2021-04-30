package com.example.p8.s4.e1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "SecondServlet", value = "/second")
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        String name = request.getParameter("name");
        String address = (String) request.getAttribute("address");
        out.println("<html><body>");
        out.println("Binding use to redirect: " + address);
        out.println("</body></html>");
    }

}
