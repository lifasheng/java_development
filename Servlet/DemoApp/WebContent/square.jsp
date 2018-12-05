<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>square of number</title>
</head>
<body>

Use getAttribute: <br />
Square of <%= (int)request.getAttribute("k") %> is: <%= request.getAttribute("square") %> <br />
(<%= (request.getParameter("num1")) %> + <%= (request.getParameter("num2")) %>) ^ 2 = <%= request.getAttribute("square") %> <br />

Use expression language: <br /> 
Square of ${k} is: ${square} <br />
(${param.num1} + ${param.num2})^2 = ${square } <br />

There are some students: ${students }

</body>
</html>