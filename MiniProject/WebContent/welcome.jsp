
<%@page import="com.java.miniproject.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
User nuser=(User)session.getAttribute("user");%>
Welcome <%=nuser.getFname() %>
<br>
<a href="addHobby.jsp">Add-Hobby</a>
<br>
<a href="viewHobby.jsp">View-Hobby</a>
<br>
<a href="SignoutServlet">Sign-out</a>
</body>
</html>