package com.code.servlet;



import com.code.jdbc.StudentHomeworkJdbc;
import com.code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/add")
public class AddStudentHomeworkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        StudentHomework sh=new StudentHomework();
        /**
         * 赋值
         **/

        sh.setStuid(Integer.parseInt(req.getParameter("stuid")));
        sh.setHomeworkid(Integer.parseInt(req.getParameter("homeworkid")));
        sh.setHomeworktitle(req.getParameter("homeworktitle"));
        sh.setHomeworkContent(req.getParameter("homeworkContent"));
        List<StudentHomework> stu=null;
        StudentHomeworkJdbc.add(sh);
        resp.sendRedirect("list");
        System.out.println(Integer.parseInt(req.getParameter("stuid")));

    }
}
