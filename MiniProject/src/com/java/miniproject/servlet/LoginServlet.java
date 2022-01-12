package com.java.miniproject.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.miniproject.db.DBManager;
import com.java.miniproject.pojo.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		User nuser=new User();
		nuser.setUname(uname);
		nuser.setPass(pass);
		DBManager dbManager=new DBManager();
		if(dbManager.validateUser(nuser))
		{
			// valid user redirect to 
			//request.setAttribute("user", uname);
			HttpSession session=request.getSession();
			session.setAttribute("user", nuser);
			ServletContext context=super.getServletContext();
			System.out.println(nuser);
			RequestDispatcher rd=context.getRequestDispatcher("/welcome.jsp");
			rd.forward(request, response);
		}
		else {
			// invalid user redirect to error.jsp
			ServletContext context=super.getServletContext();
			RequestDispatcher rd=context.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
