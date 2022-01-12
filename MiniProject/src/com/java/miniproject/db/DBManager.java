package com.java.miniproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.miniproject.pojo.Hobby;
import com.java.miniproject.pojo.User;

public class DBManager {
	private Connection connect=null;
public DBManager() {
	
}
public Connection getConnect() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mini_project_db";
		 connect=DriverManager.getConnection(url,"root","rohan");
		 System.out.println("DB connection Success!!");
	} catch (ClassNotFoundException e) {
		
		System.err.println(e.getMessage());
	}
	 catch (SQLException e) {
		 System.err.println(e.getMessage());
	}
	return connect;
	
}
public void openConnection() {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mini_project_db";
		 connect=DriverManager.getConnection(url,"root","rohan");
		 System.out.println("DB connection Success!!");
	} catch (ClassNotFoundException e) {
		
		System.err.println(e.getMessage());
	}
	 catch (SQLException e) {
		 System.err.println(e.getMessage());
	}

	
}
public void closeConnection() {
	
	try {
		connect.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
public boolean validateUser(User nuser)
{
	//connectdb
	openConnection();
	//fire query;
	
	
	Statement stmt;
	try {
		String sql="SELECT * from user_info_tbl WHERE user_username='"+nuser.getUname()+"' AND  user_password='"+nuser.getPass()+"'";
		stmt = connect.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		//validate output
		//insert into user_info_tbl values(1,"Anil","Patil","a@gmail.com","998812930","anil","anil@123")
		if(rs.next())
		{
			nuser.setId(rs.getInt(1));
			nuser.setFname(rs.getString(2));
			nuser.setLname(rs.getString(3));
			nuser.setEmail(rs.getString(4));
			nuser.setMobile(rs.getString(5));
			
			return true;
		}
			
		else
			return false;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
		e.printStackTrace();
	}
	finally {
		// close connection
		closeConnection();
	}
	return false;
	
}
// public static void main(String[] args) {
//	DBManager db=new DBManager();
//	boolean res=db.validateUser("Anil", "anil@123");
//	System.out.println(res);
//}
public void addUser(User nuser) {
	Connection connect=this.getConnect();
	
	//insert into user_info_tbl values(1,"Anil","Patil","a@gmail.com","998812930","anil","anil@123")
	String sql="insert into user_info_tbl values(default,?,?,?,?,?,?)";
	try {
		PreparedStatement ptsmt=connect.prepareStatement(sql);
		ptsmt.setString(1, nuser.getFname());
		ptsmt.setString(2, nuser.getLname());
		ptsmt.setString(3, nuser.getEmail());
		ptsmt.setString(4, nuser.getMobile());
		ptsmt.setString(5, nuser.getUname());
		ptsmt.setString(6, nuser.getPass());
		ptsmt.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void addHobby(Hobby hb) {
	openConnection();
	String sql="INSERT INTO hobby_tbl values(default,?,?)";
	try {
		PreparedStatement ptsmt=connect.prepareStatement(sql);
		ptsmt.setInt(1, hb.getUserId());
		ptsmt.setString(2, hb.getHobby());
		ptsmt.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		closeConnection();
		System.out.println("connection closed!!");
	}
	
}
public ArrayList<Hobby> showHobbies(User currentuser) {
	openConnection();
	
	  int usid=currentuser.getId();
	String sql="select * from hobby_tbl where hobby_userid=?";
	try {
		
		PreparedStatement ptsmt=connect.prepareStatement(sql);
		ptsmt.setInt(1, usid);
		ResultSet rs=ptsmt.executeQuery();
		ArrayList<Hobby> hbylist=new ArrayList<>();
		while(rs.next())
		{  
			Hobby hb=new Hobby();
			hb.setId(rs.getInt(1));
			hb.setUserId(rs.getInt(2));
			hb.setHobby(rs.getString(3));
			hbylist.add(hb);
		}
		
		return hbylist;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		closeConnection();
		System.out.println("connection closed!!");
	}
	return null;
}
}
