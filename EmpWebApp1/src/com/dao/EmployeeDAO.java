package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.MyConnection;
import com.dto.Employee;

public class EmployeeDAO {

	public Employee getEmployee(String loginId, String password) {
		Connection con = null;
		String SELECT = "Select * from Employee where loginId=? and password=?";
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = MyConnection.getConnection();
		
		try {
			pst = con.prepareStatement(SELECT);
			pst.setString(1, loginId);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				//convert result set into employee object
				
				Employee employee = new Employee();
				
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setLoginId(rs.getString(4));
				employee.setPassword(rs.getString(5));
				
				return employee;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return null;
	}

	public int register(Employee employee) {
		int result = 0;
		Connection con = null;
		String INSERT = "Insert into Employee Values (?,?,?,?,?)";
		PreparedStatement pst = null;
		
		con = MyConnection.getConnection();
		
		try {
			pst = con.prepareStatement(INSERT);
			pst.setInt(1, employee.getEmpId());
			pst.setString(2, employee.getEmpName());
			pst.setDouble(3, employee.getSalary());
			pst.setString(4, employee.getLoginId());
			pst.setString(5, employee.getPassword());
			
			result = pst.executeUpdate();		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public List<Employee> getAllEmployees() {
		Connection con = null;
		String SELECT = "Select * from Employee";
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = MyConnection.getConnection();
		
		List<Employee> empList = new ArrayList<Employee>();
		
		try {
			pst = con.prepareStatement(SELECT);
			rs = pst.executeQuery();
			
			while(rs.next()) {
								
				Employee employee = new Employee();
				
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setLoginId(rs.getString(4));
				employee.setPassword(rs.getString(5));
				
				empList.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return empList;
	}

	public Employee getEmployeeById(int empId) {
		Connection con = null;
		String SELECT = "Select * from Employee where empId=?";
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = MyConnection.getConnection();
		
		try {
			pst = con.prepareStatement(SELECT);
			pst.setInt(1, empId);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				//convert result set into employee object
				
				Employee employee = new Employee();
				
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setLoginId(rs.getString(4));
				employee.setPassword(rs.getString(5));
				
				return employee;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return null;
	}

	public int getDeleteEmployee(int empId) {
		int result = 0;
		Connection con = null;
		String DELETE = "DELETE from Employee where empId=?";
		PreparedStatement pst = null;
		
		
		con = MyConnection.getConnection();
	
			try {
				pst = con.prepareStatement(DELETE);
				pst.setInt(1, empId);
				
				
				result = pst.executeUpdate();		
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			finally {
				try {
					pst.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return result;
		}

	public int getUpdateEmployee(Employee employee) {
		
		int result = 0;
		Connection con = null;
		String UPDATE = "UPDATE employee SET empName = ?, salary = ? where empId = ?";
				
		PreparedStatement pst = null;
		
		
		con = MyConnection.getConnection();
	
			try {
				pst = con.prepareStatement(UPDATE);
				pst.setString(1,employee.getEmpName());
				pst.setDouble(2, employee.getSalary());
				pst.setInt(3, employee.getEmpId());
				
				
				result = pst.executeUpdate();		
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			finally {
				try {
					pst.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return result;
		
	}

	
	
}







