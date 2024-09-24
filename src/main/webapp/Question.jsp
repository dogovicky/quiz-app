<%@page import="com.capricon.web.model.Answer"%>
<%@page import="com.capricon.web.model.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz Task</title>
<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>

	<div>
			
			
			<c:if test="${currentQuestion != null}">
		        <h4>${currentQuestion.question}</h4>
		        <form id="quizForm" action="quizServlet" method="post">
		            <input type="hidden" name="questionId" value="${currentQuestion.questionId}">
		            <c:forEach var="answer" items="${currentQuestion.answers}">
		            
		                <input type="radio" name="answer" value="${answer.AnswerId}"> ${answer.Answer}<br>
		                
		            </c:forEach>
		            <button type="submit">Next</button>
		        </form>
		    </c:if>
		    <c:if test="${currentQuestion == null}">
		        <p>No question found.</p>
		    </c:if>
			
			<!-- <form id="quizForm" action="submitAnswer" method="post">
				
				<input type="hidden" name="questionId" value="${questionId}" />
				
				<c:forEach var="answer" items="">
					
					<input type="radio" name="answer" value="${answer}"/>
					 ${answer}<br />
					
				</c:forEach>
			
			</form> -->
			
		
	</div>
	
	<script>
	
		let timeLimit = 30;
		let timeRemaining = timeLimit;
		let timer = document.getElementById("timer");
		let quizForm = document.getElementById("quizForm");
		
		function startTimer() {
			let timerInterval = setInterval(() => {
				
				timer.textContent = "Time Remaining: " + timeRemaining + " seconds";
				timeRemaining--;
				
				//if time runs out
				if(timeRemaining < 0) {
					clearInterval(timerInterval);
					quizForm.submit();
				}
				
			}, 1000);
		}
		
		
		window.onload = startTimer;
	
	</script>

</body>
</html>























