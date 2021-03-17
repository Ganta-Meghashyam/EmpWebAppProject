package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDAO;
import com.db.MyConnection;
import com.dto.Employee;


@WebServlet("/LoginServlet")//annotation

public class LoginServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//reading values from client
		String LoginId = request.getParameter("LoginId");
		String Password = request.getParameter("Password");
		
		//Adding LoginId to Session Object
		HttpSession session = request.getSession();
		session.setAttribute("LoginId", LoginId);
		
		out.print("<html>");
		
		if(LoginId.equalsIgnoreCase("HR")&Password.equalsIgnoreCase("HR")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("HrHomePage.jsp");
			rd.forward(request,response);
		}
		else {
			
			Connection con = MyConnection.getConnection();
			
			EmployeeDAO employeeDAO = new EmployeeDAO();
			Employee  employee = employeeDAO.getEmployee(LoginId,Password);
			
			if(employee != null) {
				session.setAttribute("employee", employee);
				
				RequestDispatcher rd = request.getRequestDispatcher("EmpHomePage.jsp");
				rd.forward(request,response);
			}
			else {
				out.print("<body bgcolor=lightgrey text=red>");
			    out.print("<h1><center>Invalid Credentials..</center></h1>");
			    out.print("</body>");
			}		
		
	}	
		    out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
