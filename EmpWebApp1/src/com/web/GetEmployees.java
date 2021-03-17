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
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDAO;
import com.dto.Employee;


@WebServlet("/GetEmployees")
public class GetEmployees extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		EmployeeDAO employeeDAO = new EmployeeDAO();			
		List<Employee> empList = employeeDAO.getAllEmployees();

		if(!empList.isEmpty()) {		
			request.setAttribute("empList", empList);
			RequestDispatcher rd = request.getRequestDispatcher("GetEmployees.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("HrHomePage.jsp");
			rd.include(request, response);
			
			out.print("<center>");
			out.print("<h3 style='color:red;'>Employee Record(s) Not Found!!!</h3>");
			out.print("</center>");
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
