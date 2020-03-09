<%@ page import="java.util.List" %>
<%@ page import="com.code.model.StudentHomework" %>
<%@ page import="com.code.jdbc.StudentHomeworkJdbc" %>
<%@ page import="com.code.model.Student" %>
<%@ page import="com.code.jdbc.StudentJdbc" %>
<%@ page import="com.code.model.Homework" %>
<%@ page import="com.code.jdbc.HomeworkJdbc" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/8
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>主页面</title>
<%--
  Created by IntelliJ IDEA.
  User: ZHENGZHIQIANG
  Date: 2019/3/2
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
  </head>


<body>
<table align="center" width="300" border="1"
       bgcolor="#5f9ea0" cellpadding="1" cellspacing="1" style="margin-top: 100px">

  <tr align="center" height="100" bgcolor="#5f9ea0">
    <td colspan="6" style="text-align: center">
      <a href="teacher.jsp" target="_blank">教师入口</a>
    </td>
  </tr>

  <tr align="center" height="100" bgcolor="#5f9ea0">
    <td colspan="6" style="text-align: center">
      <a href="student.jsp" target="_blank">学生入口</a>
    </td>
  </tr>
</table>


  </body>
  </html>
