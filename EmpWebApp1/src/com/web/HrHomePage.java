package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.MyConnection;

@WebServlet("/HrHomePage") // annotation
public class HrHomePage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//String LoginId = request.getParameter("LoginId");
		
		HttpSession session = request.getSession();
		String LoginId = (String)session.getAttribute("LoginId");
		
		out.print("<body bgcolor=powderblue text=black>");
		out.print("<h3> Welcome " + LoginId + "</h3>");
		out.print("<center>");
		out.print("<h1>Welcome to Hr Home Page</h1>");
		out.print("<h3><a href = 'GetEmployees'>Get All Employees</a></h3>");
		out.print("<h3><a href = 'EmployeeById.jsp'>Get Employee By Id</a></h3>");
		out.print("</center></body>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doGet(request, response);
	}

}
