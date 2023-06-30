<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/css/log2.css" rel="stylesheet">

</head>
<body>
 	<%
		response.setHeader("Cache-Control", "no-cache,no-store");
		response.setHeader("Progma", "no-cache");
		response.setDateHeader("Expires", 0);
	 %>
	<div class="container">
		<div class="fix-content">
			<form class="form-label" style="padding: 15px;" action="ServletLogin" method="post">
			<input type="hidden" name="url" value="<%request.getParameter("url");%>">
				<h1 class="title" >Login</h1>
				<div class="single-input">
					<input required type="email" name="email" id="email" class="input" autocomplete="off">
					<label class="form-label" for="email">E-mail</label>
				</div>
				<div class="single-input">
					<input required type="password" name="password" id="password" class="input">
					<label class="form-label" for="password">Password</label>
				</div>
				<p>${msg}</p>
				<div class="button-login">
					<button>Login</button>
				</div>
			</form>					
		</div>
	</div>
</body>
</html>