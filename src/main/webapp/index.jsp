<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="AutoParkingServlet" method="post">
		Enter admin ID:<input type="text" name="adminId"> <br>
		Enter Password:<input type="password" name="password"> <br>
		<input type="submit" value="Submit" />
	</form>
	<%if(request.getAttribute("message")!=null){
out.print(request.getAttribute("message"));
} %>
</body>
</html>