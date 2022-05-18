package com.test;
 

import java.sql.*;



class Data_connbyprepare{
public static void main(String args[])
{
try
{
Class.forName("com.mysql.cj.jdbc.Driver");



Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/coffeebreak1","root","1234");
// create database kahniya;
// use kahniya;



System.out.println("connection success");
//
//Statement stmt=con.createStatement();
//statements, prepared statements, stored procedures.
//stmt.executeUpdate("insert into emp1 values(12,'Sparsh',21)");
PreparedStatement stmt=con.prepareStatement("insert into Emp values(?,?,?)");
stmt.setInt(1,4);//1 specifies the first parameter in the query
stmt.setString(2,"ravi");
stmt.setInt(3, 28);

int i=stmt.executeUpdate();
System.out.println(i+" records inserted");
//ResultSet rs=stmt.executeQuery("select * from emp1");
ResultSet rs=stmt.executeQuery("select * from emp");
while(rs.next())

//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
con.close();
}
catch(Exception e){ System.out.println(e);}
}
}