<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="styles/Home.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>

	<nav class="p-3">
		<h4>LOGO</h4>
		
		<div class="list">
			<ul>
				<li> <a href="Home.jsp">Home</a> </li>
				<li> <a href="#">Admission</a> </li>
				<li> <a href="#">Finance</a> </li>
				<li> <a href="#">News</a> </li>
				<li> <a href="profile.jsp">Profile</a> </li>
			</ul>
		</div>
	</nav>

	<div class="wrapper container-sm">
		<h4>Welcome</h4>
		<div class="details">
			You are required to carry out the quiz before deadline. Each question carries 5 marks. After completion
			of the quiz, your total mark will be calculated and displayed to you. Each question is 30 seconds long.
			Here are the rules to follow before starting the quiz, read them carefully:
			<ul>
				<li>You MUST answer each question.</li>
				<li>The timer will start automatically once a question is loaded.</li>
				<li>Once the 30 seconds are over and the question is not yet answered, the question will be saved as a fail and awarded zero marks.</li>
				<li>Once you click next, you cannot navigate to the previous question for re-answering.</li>
				<li>After completion of the quiz, you cannot re-take the quiz.</li>
				<li>After you click start quiz button, ensure you continue to the end.</li>
			</ul>
		</div>
		<button id="startBtn"><a href="Question.jsp">Start Quiz</a></button>
	</div>

</body>
</html>