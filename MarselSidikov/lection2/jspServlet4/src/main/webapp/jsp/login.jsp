<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 02.01.2020
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="/login">
<label for="name" >name
<input type="text" id="name" name="name">
</label></br>
<label for="password" >password
    <input type="password" id="password" name="password">
</label></br>
<input type="submit" value="send login">
</form>
</body>
</html>
