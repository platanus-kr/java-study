package com.example.p6.s1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    public void init() throws ServletException {
        System.out.println("Call init method");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");
        System.out.println("ID: " + user_id);
        System.out.println("PW: " + user_pw);
    }
}
