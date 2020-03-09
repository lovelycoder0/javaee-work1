package com.code.jdbc;



import com.code.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {
    public static List<StudentHomework> selectAll() {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        //URL指向要访问的数据库名mysql（此处的test是你所use的那个database）
        String url = "jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码,此处为自己设置的密码
        String password = "000000";
        //要执行的SQL语句
        String sql = "select * from studenthomework";

        List<StudentHomework> list = new ArrayList<>();
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();


            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            int id=0;
            int stuid=0;
            int homeid=0;

            while (rs.next()) {
                StudentHomework sh = new StudentHomework();
                sh.setId(rs.getInt("id"));
                sh.setStuid(rs.getInt("stuid"));
                sh.setHomeworkid(rs.getInt("homeworkid"));
                sh.setHomeworktitle(rs.getString("homeworktitle"));
                sh.setHomeworkContent(rs.getString("homeworkContent"));
                sh.setCreatetime(rs.getTimestamp("createtime"));
                //sh.setUpdatetime(rs.getTime("updatetime"))
                list.add(sh);

            }

        } catch (ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }


        return list;
    }

    public static void add(StudentHomework sh){
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        //URL指向要访问的数据库名mysql（此处的test是你所use的那个database）
        String url = "jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码,此处为自己设置的密码
        String password = "000000";
        //要执行的SQL语句
        String sql = "insert into studenthomework(stuid,homeworkid,homeworktitle,homeworkContent) values(?,?,?,?) ";



        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");

            //创建statement类对象，用来执行SQL语句！！
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,sh.getStuid());
            pst.setInt(2,sh.getHomeworkid());
            pst.setString(3,sh.getHomeworktitle());
            pst.setString(4,sh.getHomeworkContent());

            int count = pst.executeUpdate();
            pst.close();

        } catch (ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }

    }

   public static void main(String[] args) {
        List<StudentHomework> list=selectAll();
        for (StudentHomework sh:list){
            System.out.println(sh.getHomeworkContent());
        }
    }
}





