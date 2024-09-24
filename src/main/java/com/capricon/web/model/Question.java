package com.capricon.web.model;

import java.util.List;

public class Question {
	
	private int questionId;
	private String Question;
	List<Answer> answers;
	private int Mark;
	
	
	public Question() {
		
	}
	
	
	
	public Question(int questionId, String question, List<Answer> answers) {
		super();
		this.questionId = questionId;
		Question = question;
		this.answers = answers;
	}
	
	
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public List<Answer> getAnswer() {
		return answers;
	}
	public void setAnswer(List<Answer> answers) {
		this.answers = answers;
	}
	public int getMark() {
		return Mark;
	}
	public void setMark(int mark) {
		Mark = mark;
	}


	public int getQuestionId() {
		return questionId;
	}


	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	

}
