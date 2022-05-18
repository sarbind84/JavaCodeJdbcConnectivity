package com.test;

import java.sql.*;

public class PrepareCa {

	public static void main(String[] args) throws Exception
	{


		Class.forName("com.mysql.cj.jdbc.Driver");
	
		// Getting the connection
		Connection con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/coffeebreak1","root","1234");
		

		System.out.println("connection success");
	
		String sql_string = "insert into students values(?,?,?)";
	
		// Preparing a CallableStateement
		CallableStatement cs = con.prepareCall(sql_string);
	
		cs.setInt(1, 26);
		cs.setString(2, "bing");
		cs.setInt(3, 21);
		cs.execute();
		System.out.print("Inserted successfully\n");
		
		
		
		ResultSet rs=cs.executeQuery("select * from students");
		while(rs.next())

		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		con.close();
		
	}
}

