<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 06.01.2020
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form method="post" action="/login">
    <label for="email" >
        <input id="email" name="email" value="email">
    </label></br>
    <label for="password" >
        <input id="password" name="password" value="password">
    </label></br>
    <input type="submit" value="login up">
</form>
</body>
</html>
