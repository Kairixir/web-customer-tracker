package com.sevcikondrej.testdb;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@javax.servlet.annotation.WebServlet(name = "TestDbServlet")
public class TestDbServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String jdbcConection = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user="springstudent";
        String pass = "springstudent";

        String driver = "com.mysql.jdbc.Driver";

        try {
            PrintWriter out = response.getWriter();

            out.println("Connectin to database "+ jdbcConection);

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcConection,user,pass);

            out.println("Success");

            myConn.close();

        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
