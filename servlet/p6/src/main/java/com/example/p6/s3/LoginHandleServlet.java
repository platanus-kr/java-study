package com.example.p6.s3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login_handle")
public class LoginHandleServlet extends HttpServlet {

    public void init() throws ServletException {
        System.out.println("Call init method");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("Call doGet method");
        doHandle(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("Call doPost method");
        doHandle(request, response);
    }


    private void doHandle(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("Calll doHandle method");
        request.setCharacterEncoding("UTF-8");
        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");
        System.out.println("ID: " + user_id);
        System.out.println("PW: " + user_pw);
    }
}
