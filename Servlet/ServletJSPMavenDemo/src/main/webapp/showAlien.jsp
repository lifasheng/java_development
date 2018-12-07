<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.fashengli.model.Alien" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">

	<% 
		/*
		// this is used when it is forwarded from controller to here.
		Alien a1 = (Alien)request.getAttribute("alien");
		out.println(a1); 
		*/
		
		// this is used when it is redirected to here.
		Alien a1 = (Alien)session.getAttribute("alien");
		out.println("redirected:" + a1); 
	%>

</body>
</html>