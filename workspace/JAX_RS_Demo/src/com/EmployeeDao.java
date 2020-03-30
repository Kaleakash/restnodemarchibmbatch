package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDao {
	public List<Employee> getEmployeeDbInfo() {
		List<Employee> listOfEmp = new ArrayList<Employee>();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = 
		DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		PreparedStatement pstmt  = con.prepareStatement("select * from employee");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			//convert all query to employee objects. 
			Employee emp = new Employee();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setSalary(rs.getFloat(3));
			System.out.println(emp);
			listOfEmp.add(emp);
		}
		} catch (Exception e) {
		System.out.println("In Db "+e);
		}
		return listOfEmp;
	}
	
	public int storeEmployeeInfo(Employee emp) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			PreparedStatement pstmt = 
			con.prepareStatement("insert into employee values(?,?,?)");
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setFloat(3, emp.getSalary());
			int res = pstmt.executeUpdate();
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
}
