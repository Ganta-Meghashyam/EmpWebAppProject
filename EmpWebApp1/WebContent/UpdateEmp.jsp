<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="HrHomePage.jsp"></jsp:include>

<form action="UpdateEmployee" method = "post">

Enter EmpId  : <input type = "text" name = "empId" value = "${emp.empId}" readonly><br/>
Enter EmpName  : <input type = "text" name = "empName" value = "${emp.empName}"><br/>
Enter Salary  : <input type = "text" name = "salary" value = "${emp.salary}"><br/>
Enter LoginId  : <input type = "text" name = "LoginId" value = "${emp.loginId}" readonly><br/>
Enter Password  : <input type = "text" name = "password" value = "${emp.password}" readonly><br/>

<input type = "submit" value = "Update Employee">
</form>
</body>
</html>