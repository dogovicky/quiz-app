package com.capricon.web.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capricon.web.database.DatabaseHandler;
import com.capricon.web.model.Student;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DatabaseHandler handler = new DatabaseHandler();
		
		String regNo = request.getParameter("regNo");
		String password = request.getParameter("password");
		
		Student student = new Student();
		student.setRegNo(regNo);
		student.setPassword(password);
		
		if(!regNo.isEmpty() || !password.isEmpty()) {
			
			try {
				ResultSet set = handler.getStudent(student);
				
				
				if(set.next()) {
					String studentPass = set.getString(1);
					if(studentPass.equals(password)) {
						//RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
						//rd.forward(request, response);
						response.sendRedirect("Home.jsp");
					} else {
						System.out.print("Invalid Login");
					}
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.print("Fields must be filled in");
		}
		
	}

	
}
