package com.capricon.web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capricon.web.database.Constants;
import com.capricon.web.database.DatabaseHandler;
import com.capricon.web.model.Answer;
import com.capricon.web.model.Question;

//@WebServlet("/quizServlet")
public class QuizController extends HttpServlet {
	
	
	
	DatabaseHandler handler = new DatabaseHandler();
	
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        try {
        	
        	HttpSession session = request.getSession();
        	Question question = new Question();
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            question.setQuestionId(questionId);
            
           
        	
			Question currentQuestion = handler.getQuestionById(question);
			session.setAttribute("currentQuestion", currentQuestion);
			request.getRequestDispatcher("Question.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
        
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    	
    	
    	try {
    		
    		HttpSession session = request.getSession();
            
            Question currentQuestion = (Question) session.getAttribute("currentQuestion");
            
           
            int selectedAnswerId = Integer.parseInt(request.getParameter("answer"));
            
            
         // Check if the selected answer is correct
            boolean isCorrect = currentQuestion.getAnswer().stream()
                    .anyMatch(answer -> answer.getAnswerId() == selectedAnswerId && answer.isCorrect());
            
            int score = (int) session.getAttribute("score");
            if(isCorrect) {
            	score ++;
            }
            
            session.setAttribute("score", score);
            
            //get the next question
            int nextQuestionId = getNextQuestionId(currentQuestion.getQuestionId());
            if(nextQuestionId != -1) {
            	response.sendRedirect("quizServlet?QuestionID=" + nextQuestionId);
            } else {
            	response.sendRedirect("Result.jsp");
            }

    	} catch(IOException e) {
    		
    		System.out.print(e.getMessage());
    		
    	}
    	
        
    }
	
    
    public int getNextQuestionId(int questionId) {
    	
    	return questionId++;
    	
    }
    
    
	

	
	

}

























