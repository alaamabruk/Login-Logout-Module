package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.BoldAction;

import jdk.nashorn.internal.ir.ForNode;

@WebServlet("/CheckDao")
public class CheckDao extends HttpServlet {
	
	
	public boolean check(String name , String pass) {
		
		String username="root";
        String password="3122";
        String url="jdbc:mysql://localhost/alpha";
        String sql = " select * from alien where name =? and pass =? ";
        Connection conn;
        
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(url,username,password);
	    	PreparedStatement pre = conn.prepareStatement(sql);
		    pre.setString(1, name);
		    pre.setString(2, pass);
		    ResultSet res = pre.executeQuery();
		  
		    if(res.next())
			 return true;
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}

}
