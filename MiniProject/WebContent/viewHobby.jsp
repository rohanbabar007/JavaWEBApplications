<%@page import="com.java.miniproject.pojo.Hobby"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.java.miniproject.pojo.User"%>
<%@page import="com.java.miniproject.db.DBManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: cyan">Hobbies list</h1>
<br>
<ol>
<%
User nuser=(User)session.getAttribute("user");

DBManager dbmanager=new DBManager();

ArrayList<Hobby> hobbylist=dbmanager.showHobbies(nuser);

if(hobbylist!=null)
{ 
	for(Hobby hb:hobbylist)
	{
		%>
		<li> <%=hb.getHobby().toUpperCase() %></li>
		<% 
	}
}
%>
</ol>
<br>
<a href="welcome.jsp">Back</a>
</body>
</html>