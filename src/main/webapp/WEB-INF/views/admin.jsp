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
<h2>Add User</h2>
<form action="add.html" method="post">
<select name="userType">
<option value="admin">Admin</option>
<option value="patient">Patient</option>
<option value="doctor">Doctor</option>
</select>
<br>
<input type="text" name="userId" placeholder="Enter Username">
<br>
<input type="text" name="password" placeholder="Enter password">
<br>
<input type="submit" value="SUBMIT">
<br><br>
</form>
<h2>Remove User</h2>
<form action="remove.html" method="post">
<input type="text" name="removeId" placeholder="Enter Username to delete">
<input type="submit" value="SUBMIT">
</form>
<br><br>
<h2>Schedule Appointment</h2>
</body>
</html>