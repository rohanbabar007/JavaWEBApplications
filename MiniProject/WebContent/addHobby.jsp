
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
User nuser=(User)session.getAttribute("user");
   String user_name=nuser.getFname()+"  "+nuser.getLname();%>
Welcome <%=user_name%>
<br>
<br>
<br>ADD Hobby
<form action="AddHobbyServlet">
<br>
<br>
Enter Hobby:<input type="text" name="hobby" id="hobby">
<br>
<br>
<input type="submit" value="Add Hobby">

</form>

</body>
</html>