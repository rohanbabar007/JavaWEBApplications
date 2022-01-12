package com.java.miniproject.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;

import com.java.miniproject.db.DBManager;
import com.java.miniproject.pojo.User;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		User nuser=new User();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		nuser.setFname(fname);
		nuser.setLname(lname);
		nuser.setEmail(email);
		nuser.setMobile(mobile);
		nuser.setEmail(email);
		nuser.setUname(uname);
		nuser.setPass(pass);
		DBManager dbManager=new DBManager();
		dbManager.addUser(nuser);
		System.out.println("Data inserted successfully!!");
		response.setContentType("text/html");
		response.getWriter().append("Account Created Successfully!!");
		response.getWriter().append("<br><br>");
		response.getWriter().append("<a href=\"index.jsp\">Back to Home page</a>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
