<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	Hello! ${USER}
</h1>
<form action="schedule.html" method="post">
<input type="hidden" name="user" value="${USER}">
<input type="submit" value="View Appointment">
</form>
<form action="appoint.html" method="post">
<input type="hidden" name="user" value="${USER}">
<input type="text" name="ailment" placeholder="Enter Your Ailment Details">
<br>
<input type="submit" value="Request Appointment">
</form>
</body>
</html>