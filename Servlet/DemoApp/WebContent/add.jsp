<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Date" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add two numbers</title>
</head>
<body bgcolor='cyan'>

<%
Date d = new Date();
out.println("Now:" + d.toString() + "<br/>");
%>

<%! int value = 1; %>
<%
int i = Integer.parseInt(request.getParameter("num1"));
int j = Integer.parseInt(request.getParameter("num2"));

int k = i + j;
out.println("" + i + " + " + j + " = " + k);
%>

<h1> result = <%= k  %>, value = <%= value %></h1>

<%
out.println("you can find the generated java code for this jsp in path: <br/>");
out.println("apache-tomcat-8.5.35/work/Catalina/localhost/DemoApp/org/apache/jsp");
%>

</body>
</html>