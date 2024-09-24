<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<link rel="stylesheet" href="styles/Login.css" />
</head>
<body>

	<div class="wrapper container-sm">
		
		<div class="form-container">
			<h4>Sign In</h4>
			<form action="login" method="get">
				
				<div class="input-container">
					
					<input type="text" name="regNo" id="regNo" required />
					<label for="regNo">Registration Number</label>
				</div>
				
				
				<div class="input-container">
					
					<input type="password" name="password" id="password" required />
					<label for="password">Password</label>
				</div>
				
				<div>
					<input type="submit" id="loginBtn" value="Login" />
				</div>
				
			</form>
			
			<div class="signup-container">
				Don't have an account yet? <a href="SignUp.jsp">Sign Up</a>
			</div>
			
		</div>
		
	</div>

</body>
</html>