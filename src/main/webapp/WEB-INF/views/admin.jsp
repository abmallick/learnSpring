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
<form action="/admin.html" method="post">
<select name="action">
<option value="add">Add User</option>
<option value="remove">Remove User</option>
<option value="schedule">Schedule Appointment</option>
</select>
<br>
<input type="submit" value="SUBMIT">
</form>
</body>
</html>