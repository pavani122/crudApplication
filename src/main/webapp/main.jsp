<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import=com.techouts.crudApplication.*;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>main.jsp</title>
</head>
<body>
<% 
String name=request.getParameter("userName");
String password=request.getParameter("userPassword");
PrintWriter pw=response.getWriter();
Employee e=new Employee();

<jsp:useBean id="e" class="com.techouts.crudApplication.Employee">
</jsp:useBean>
<h2>Welcome,<%=name %></h2>
</body>
</html>