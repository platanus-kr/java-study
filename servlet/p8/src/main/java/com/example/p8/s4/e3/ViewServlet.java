package com.example.p8.s4.e3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ViewServlet", value = "/viewMembers")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        List memberList = (List) request.getAttribute("memberList");
        
        out.print("<html><body>");
        out.print("<table border=1><tr>");
        out.print(
            "<td>ID</td><td>PW</td><td>Name</td><td>E-Mail</td><td>joindate</td><td>Delete</td></tr>");

        for (int i = 0; i < memberList.size(); i++) {
            MemberVO memberVO = (MemberVO) memberList.get(i);
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
                joinDate + "</td><td>" +
                "<a href='/p7_war_exploded/member3?command=delMember&id=" +
                id + "'>회원 삭제</a></td></tr>");

        }
        out.print("</table><a href='/p7_war_exploded/memberForm.html'>새 회원 등록하기</a></body></html>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }
}
