package com.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.emp.Employee;
import com.util.DBConnection;

public class EmployeeHandler {

	static Connection conn;
	
	public static int insertEmployee(Employee emp) throws SQLException {
		int status =0;
		conn = DBConnection.getConnection();
		PreparedStatement pstm = conn.prepareStatement("Insert Into Employee (name,password,email,country) Values (?,?,?,?)");
		pstm.setString(1, emp.getName());
		pstm.setString(2, emp.getPassword());
		pstm.setString(3, emp.getEmail());
		pstm.setString(4, emp.getCountry());
		status = pstm.executeUpdate();
		
		conn.close();
		return status;
	}
	
	/*
	 * public static void main(String args[]) { Employee e1= new Employee();
	 * e1.setName("Charith"); e1.setPassword("Password");
	 * e1.setEmail("abc@gmail.com"); e1.setCountry("Sri Lanka");
	 * 
	 * try { insertEmployee(e1); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * }
	 */
}
