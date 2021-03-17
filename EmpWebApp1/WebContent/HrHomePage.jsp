<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HrHomePage</title>
</head>
<body bgcolor = lightgrey text = black>		

<form align="right">
   <a href = "Login.html" script = "right:10px; top:0px">Logout</a> &nbsp; &nbsp;
   <a href = "HrHomePage.jsp">Home</a> &nbsp;
</form>
		
	<% String loginId = (String) session.getAttribute("LoginId"); %>
			
	<h3>Welcome <%= loginId %>! </h3>		
	<center>
		<h1>Welcome to Hr Home Page</h1>
		<h3><a href='GetEmployees'>Get All Employees</a></h3>
		<h3><a href='EmployeeById.jsp'>Get Employee By ID</a></h3>
	</center>
</body>
</html>