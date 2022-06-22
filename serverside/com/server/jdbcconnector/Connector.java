package com.server.jdbcconnector;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Connector {
    public boolean login(String id,String pwd) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_details","root","password");
        Statement stmt=con.createStatement();
        String str="select * from login_details where user_id='"+id+"' and passwords='"+pwd+"';";
        ResultSet rs=stmt.executeQuery(str);
        rs.next();
        System.out.println(rs.getString(1)+" "+rs.getString(2));
        if((rs.getString(1)).equals(id)&&rs.getString(2).equals(pwd)){
                return true;
            }else{
                return false;
            }
    }
    public boolean signup(String id,String pwd) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_details","root","password");
        Statement stmt=con.createStatement();
        ResultSet temp=stmt.executeQuery("select user_id from login_details where user_id='" + id + "';");
        if(temp.next()){
            return false;
        }else{

            String str = "insert into login_details\n" +
                    "values ('" + id + "','" + pwd + "');";
            stmt.execute(str);
            String str1 = "select * from login_details where user_id='" + id + "' and passwords='" + pwd + "';";
            ResultSet rs=stmt.executeQuery(str1);
            rs.next();
                System.out.println(rs.getString(1)+" "+rs.getString(2));
                if((rs.getString(1)).equals(id)&&rs.getString(2).equals(pwd)){
                    return true;
                }else{
                    return false;
            }
        }
    }
}
