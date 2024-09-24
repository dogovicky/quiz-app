package com.capricon.web.model;

public class Answer {

	private int AnswerId;
	

	private int questionId;
	private String Answer;
	private boolean isCorrect;
	
	public Answer() {
		
	}
	
	
	public Answer(int AnswerId, int questionId, String Answer, boolean isCorrect) {
		super();
		this.AnswerId = AnswerId;
		this.questionId = questionId;
		this.Answer = Answer;
		this.isCorrect = isCorrect;
	}
	
	public int getAnswerId() {
		return AnswerId;
	}


	public void setAnswerId(int answerId) {
		AnswerId = answerId;
	}



	public int getQuestionId() {
		return questionId;
	}


	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}


	public void setId(int id) {
		this.AnswerId = id;
	}


	public void setAnswer(String answer) {
		this.Answer = answer;
	}


	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}


	public int getId() {
		return AnswerId;
	}


	public String getAnswer() {
		return Answer;
	}


	public boolean isCorrect() {
		return isCorrect;
	}
	
	
	
	
}
