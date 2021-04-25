package com.example.p6.s2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login_response")
public class LoginResponseServlet extends HttpServlet {


    public void init() throws ServletException {
        System.out.println("Call init method");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");

        System.out.println("ID: " + user_id);
        System.out.println("PW: " + user_pw);

        String data = "<html><body>";
        data += "아이디: " + user_id + "<br/>";
        data += "비밀번호: " + user_pw + "<br/>";
        data += "</body></html>";
        out.print(data);
    }
}
