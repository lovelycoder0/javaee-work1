package com.code.servlet;

import com.code.jdbc.HomeworkJdbc;
import com.code.jdbc.StudentJdbc;
import com.code.model.Homework;
import com.code.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/homework")
public class HomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Homework> list= HomeworkJdbc.selectAll();

        req.setAttribute("list",list);
        req.getRequestDispatcher("teacher.jsp").forward(req,resp);
    }
}
