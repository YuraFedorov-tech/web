<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 02.01.2020
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>ADD USER</title>
</head>
<body>
<h1>Please add user</h1>
<form method="post" action="/users">
<label for="first_name" >first_name
    <input type="text" id="first_name" name="first_name">
</label></br>
<label for="last_name" >last_name
    <input type="text" id="last_name" name="last_name">
</label></br>
<input type="submit" value="add User">
</form>
</body>
</html>
