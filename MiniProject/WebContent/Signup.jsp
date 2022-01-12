<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
 <form action="AddUserServlet" method="post">
 <pre>
        Create A Account
        
     <input type="text" name="fname"  placeholder="First Name" class="form-control" style="width: 50%;border-color: black;">
 
    <input type="text" name="lname"  placeholder="Last Name" class="form-control" style="width: 50%;border-color: black;">
    
    <input type="text" name="email"  placeholder="Email" class="form-control" style="width: 50%;border-color: black;">
    
     <input type="text" name="mobile"  placeholder="Mobile Number" class="form-control" style="width: 50%;border-color: black;">
 
    <input type="text" name="uname"  placeholder="Username" class="form-control" style="width: 50%;border-color: black;">
  
    <input type="password" name="pass" class="form-control" style="width: 50%;border-color: black;" placeholder="Password">
    
     <input class="btn btn-info btn-lg btn-block" type="submit" value="Log In" style="width: 50%;">
    
    
 </pre>
 </form>
</body>
</html>