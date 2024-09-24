package com.capricon.web.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.capricon.web.model.Answer;
import com.capricon.web.model.Question;
import com.capricon.web.model.Student;

public class DatabaseHandler extends Configs{
	
	Connection dbConnection;
	
	public Connection connection() throws SQLException, ClassNotFoundException {
		String dbPath = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		dbConnection = DriverManager.getConnection(dbPath, dbUser, dbPass);
		
		
		return dbConnection;
	}
	
	//sign up  user
	public void signUpStudent(Student student) throws SQLException, ClassNotFoundException {
		
		String insertStudent = "insert into " + Constants.STUDENTS_TABLE_NAME + " ( " + Constants.FIRSTNAME + ", " + Constants.LASTNAME + ", " + 
								Constants.REGNO + ", " + Constants.EMAIL + ", " + Constants.PASSWORD + ", " + Constants.PHONE + ") "
								+ "values(?, ?, ?, ?, ?, ?)";
		
		//prepare statement
		PreparedStatement signUpState = connection().prepareStatement(insertStudent);
		signUpState.setString(1, student.getFirstName());
		signUpState.setString(2, student.getLastName());
		signUpState.setString(3, student.getRegNo());
		signUpState.setString(4, student.getEmail());
		signUpState.setString(5, student.getPassword());
		signUpState.setInt(6, student.getPhone());
		
		
		signUpState.executeUpdate();
	}
	
	
	//check if user exists in the system
	public ResultSet validateStudent(Student student) throws SQLException, ClassNotFoundException {
		ResultSet result = null;
		
		if(!student.getRegNo().isEmpty()) {
			
			String query = "select * from " + Constants.STUDENTS_TABLE_NAME + " where " + Constants.REGNO + " = ?";
			
			//prepare statement
			PreparedStatement getState = connection().prepareStatement(query);
			getState.setString(1, student.getRegNo());
			result = getState.executeQuery();
			
		}
			
		
		return result;
	}
	
	
	//login user
	public ResultSet getStudent(Student student) throws ClassNotFoundException, SQLException {
		ResultSet result = null;
		
		if(!student.getRegNo().isEmpty() || !student.getPassword().isEmpty()) {
			String getQuery = "select " + Constants.PASSWORD + " from " + Constants.STUDENTS_TABLE_NAME + " where " + Constants.REGNO + " = ? ";
			
			
			//prepare statement
			PreparedStatement getStudent = connection().prepareStatement(getQuery);
			getStudent.setString(1, student.getRegNo());
			
			result = getStudent.executeQuery();
			
		}
		
		return result;
		
	}
	
	
	
	//get question method
	public Question getQuestionById(Question question) throws ClassNotFoundException, SQLException {
		Question currentQuestion = null;
		
		String questionSql = "select q.QuestionID, q.Question, a.Answer, a.AnswerID, a.isCorrect from questions q join answers a on q.QuestionID = a.QuestionID where q.QuestionID = ?";
		
		//prepare statement
		PreparedStatement getQuestion = connection().prepareStatement(questionSql);
		getQuestion.setInt(1, question.getQuestionId());
		
		ResultSet result = getQuestion.executeQuery();
		if(result.next()) {
			currentQuestion = new Question();
			currentQuestion.setQuestionId(result.getInt("QuestionID"));
			currentQuestion.setQuestion(result.getString("Question"));
			
			List<Answer> answers = new ArrayList<>();
			do {
				Answer answer = new Answer();
				answer.setId(result.getInt("AnswerID"));
				answer.setAnswer(result.getString("Answer"));
				answer.setCorrect(result.getBoolean("isCorrect"));
				answers.add(answer);
			} while(result.next());
			
			currentQuestion.setAnswer(answers);
		}
		
		return currentQuestion;
	}
	
	//fetch questions from database
	/*public ResultSet getQuestions(int questionId) throws ClassNotFoundException, SQLException {
		ResultSet set = null;
		
	    //string to fetch question and respective answers
		
		
		//prepare statement
		PreparedStatement quizStatement = connection().prepareStatement(questionSql);
		quizStatement.setInt(1, questionId);
		
		set = quizStatement.executeQuery();
		
		
		return set;
	} */
	
	
	//fetch answers for each question
	public ResultSet getAnswers(int questionIndex) throws ClassNotFoundException, SQLException {
		ResultSet set = null;
		
		//string to fetch answers per question
		String answerSql = "select * from " + Constants.ANSWERS_TABLE + " where " + Constants.ANS_QUESTION_ID + " = ?";
		
		//prepare statement
		PreparedStatement ansStatement = connection().prepareStatement(answerSql);
		ansStatement.setInt(1, questionIndex);
		
		ansStatement.executeQuery();
		
		return set;
	}
	
	
	//validate answer
	public ResultSet validateAnswer(int questionIndex, String answer) throws ClassNotFoundException, SQLException {
		ResultSet set = null;
		
		//string to fetch answer for respective question
		String fetchSql = "select " + Constants.ISCORRECT + " from " + Constants.ANSWERS_TABLE + " where "
						+ Constants.QUESTIONID + " = ? " + " and " + Constants.ANSWER + " = ?";
		
		//prepare statement
		PreparedStatement fetchStatement = connection().prepareStatement(fetchSql);
		fetchStatement.setInt(1, questionIndex);
		fetchStatement.setString(2, answer);
		
		//execute query
		set = fetchStatement.executeQuery();
		
		return set;
	}
	
}

























