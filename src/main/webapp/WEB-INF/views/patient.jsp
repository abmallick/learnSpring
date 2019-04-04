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
<form action="/schedule.html/?user=${USER}" method="post">
<input type="submit" value="View Appointment">
</form>
<form action="/patient.html" method="post">
<input type="text" placeholder="Enter Your Ailment Details">
<input type="date" placeholder="Enter Preferred Date">
<br>
<input type="submit" value="Request Appointment">
</form>
</body>
</html>