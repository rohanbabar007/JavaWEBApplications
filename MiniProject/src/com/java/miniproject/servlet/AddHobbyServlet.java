package com.java.miniproject.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.miniproject.db.DBManager;
import com.java.miniproject.pojo.Hobby;
import com.java.miniproject.pojo.User;

/**
 * Servlet implementation class AddHobbyServlet
 */
@WebServlet("/AddHobbyServlet")
public class AddHobbyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User currentuser=(User)session.getAttribute("user");
		Hobby hb=new Hobby();
		hb.setUserId(currentuser.getId());
		hb.setHobby(request.getParameter("hobby"));
		DBManager dbmanager=new DBManager();
		dbmanager.addHobby(hb);
		response.sendRedirect("welcome.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
