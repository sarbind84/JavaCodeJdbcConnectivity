package com.test;
 
import java.sql.*;



class Data_conn{
public static void main(String args[])
{
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");



Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/coffeebreak1","root","1234");



System.out.println("connection success");


Statement stmt=con.createStatement();


stmt.executeUpdate("insert into emp1 values(5,'vi',8)");

ResultSet rs=stmt.executeQuery("select * from emp1");



while(rs.next())

System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

con.close();
}
catch(Exception e){ System.out.println(e);}
}
}