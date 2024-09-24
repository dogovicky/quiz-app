<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
   
   <%
   	
	   HttpSession sess = request.getSession();
	
	   // Retrieve the score from session
	   int score = (int) sess.getAttribute("score");
	
	   // Invalidate the session after quiz completion
	   sess.invalidate();
	
	   
   	
   %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>

	<h1>Quiz Completed!</h1>
    <p>Your score is: <%= score %></p>

</body>
</html>