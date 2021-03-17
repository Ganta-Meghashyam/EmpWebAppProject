package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dto.Employee;


@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			
		int empId = Integer.parseInt(request.getParameter("empId"));

		EmployeeDAO empDAO = new EmployeeDAO();			
		int result = empDAO.getDeleteEmployee(empId);
		
        if(result > 0) {
			
        	RequestDispatcher rd = request.getRequestDispatcher("GetEmployees");
			rd.include(request, response);	
		} 
        else {
			
        	RequestDispatcher rd = request.getRequestDispatcher("HrHomePage.jsp");
			rd.include(request, response);
			
			out.print("<center>");
			out.print("<h3 style='color:red;'>The Employee Id which you are deleting Not Found!!!</h3>");
			out.print("</center>");
			}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
