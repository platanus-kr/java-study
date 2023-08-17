package com.example.p7.s2.e1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member2")
public class MemberServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MemberDAO dao = new MemberDAO();
        List<MemberVO> list = dao.listMembers();

        out.print("<html><body>");
        out.print("<table border=1><tr>");
        out.print("<td>ID</td><td>PW</td><td>Name</td><td>E-Mail</td><td>joindate</td></tr>");

        for (int i = 0; i < list.size(); i++){
            MemberVO memberVO = list.get(i);
            String id = memberVO.getId();
            String pwd = memberVO.getPwd();
            String name = memberVO.getName();
            String email = memberVO.getEmail();
            Date joinDate = memberVO.getJoinDate();

            out.print("<tr><td>" +
                id + "</td><td>" +
                pwd + "</td><td>" +
                name + "</td><td>" +
                email + "</td><td>" +
                joinDate + "</td></tr>");

        }
        out.print("</table></body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }
}
