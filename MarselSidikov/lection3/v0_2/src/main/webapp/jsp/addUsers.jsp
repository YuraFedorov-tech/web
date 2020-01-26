<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 04.01.2020
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>add Users</title>
</head>
<body>
<h1>Please add user</h1>
<form method="post" action="/users">
    <label for="first_name">
        <input type="text" id="first_name" name="first_name">first_name
    </label></br>
    <label for="last_name">
        <input type="text" id="last_name" name="last_name">last_name
    </label></br>
    <input type="submit" value="add user">
</form>
<h5>Thank you very much</h5>
</body>
</html>
