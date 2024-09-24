<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIGN UP</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="styles/SignUp.css" />
</head>
<body>

	<div class="wrapper container-sm">
		
		
		<div class="form-container">
			<h4>Sign Up</h4>
			<form action="signup" method="post">
				<div class="input-container">
					
					<input type="text" name="firstName" id="firstName" required />
					<label for="firstName">First Name</label>
				</div>
				
				<div class="input-container">
					
					<input type="text" name="lastName" id="lastName" required />
					<label for="lastName">Last Name</label>
				</div>
				
				<div class="input-container">
					
					<input type="text" name="regNo" id="regNo" required />
					<label for="regNo">Registration Number</label>
				</div>
				
				<div class="input-container">
					
					<input type="text" name="email" id="email" required />
					<label for="email">Email</label>
				</div>
				
				<div class="input-container">
					
					<input type="password" name="password" id="password" required />
					<label for="password">Password</label>
				</div>
				
				<div class="input-container">
					
					<input type="int" name="phone" id="phone" required />
					<label for="phone">Phone</label>
				</div>
				
				<div>
					<input type="submit" id="submitBtn" value="Sign Up" />
				</div>
				
			</form>
			
			<div class="login-container">
				Already have an account? <a href="Login.jsp">Login</a>
			</div>
			
		</div>
	</div>

</body>
</html>