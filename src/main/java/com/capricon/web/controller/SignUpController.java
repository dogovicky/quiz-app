package com.capricon.web.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capricon.web.database.DatabaseHandler;
import com.capricon.web.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpController extends HttpServlet{
	
	//validate password
	public boolean validatePassword(String password) {
		
		String pswRegEx = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		
		Pattern pattern = Pattern.compile(pswRegEx);
		
		
		Matcher matcher = pattern.matcher(password);
		
		if(matcher.matches()) {
			return true;
		}
		
		return false;
	}
	
	//validate email
	public boolean validateEmail(String email) {
		
		
		return false;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//database object
		DatabaseHandler handler = new DatabaseHandler();
		
		
		//getParameters
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String regNo = request.getParameter("regNo");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int phone = Integer.parseInt(request.getParameter("phone"));
		
		//validate password before signing user
		boolean validatePsw = validatePassword(password);
		
		if(validatePsw) {
			
			Student student = new Student();
			student.setRegNo(regNo);
					
			try {
				
				ResultSet result = handler.validateStudent(student);
				int counter = 0;
				
				while(result.next()) {
					counter++;
				}
				
				if(!(counter == 1)) {
					Student newStudent = new Student(firstName, lastName, regNo, email, password, phone);
					handler.signUpStudent(newStudent);
					
					RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
				} else {
					
					System.out.print("Student exists in our system! try logging in instead");
				}
					
				
			} catch(SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.print("Invalid password");
		}
		
		
		
	}
	

}
