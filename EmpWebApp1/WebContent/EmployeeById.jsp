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

<center>
      <form action="GetEmpById" method="post">
       Enter Employee Id :<input type="text" name="empId"><br/>
      <input type="submit" value="Get Employee">
      </form>
</center>
</body>
</html>