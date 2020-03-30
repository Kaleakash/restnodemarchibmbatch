package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
	PreparedStatement pstmt = con.prepareStatement("select * from employee");
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()) {
		System.out.println("id is "+rs.getInt(1));
		System.out.println("id is "+rs.getString(2));
		System.out.println("id is "+rs.getFloat(3));
	}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
