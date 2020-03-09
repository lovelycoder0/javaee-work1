package com.code.servlet;

import com.code.jdbc.StudentJdbc;
import com.code.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addstu")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Student sh=new Student();
        /**
         * 赋值
         **/

        sh.setStuid(Integer.parseInt(req.getParameter("stuid")));
        sh.setStuname(req.getParameter("stuname"));
        List<Student> stu=null;
        StudentJdbc.add(sh);
        resp.sendRedirect("list");
        System.out.println(Integer.parseInt(req.getParameter("stuid")));
    }
}
