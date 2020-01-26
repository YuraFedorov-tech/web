<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 05.01.2020
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>add Users</title>
</head>
<body>
<h1>Registration user in JDBC</h1>
<form method="post" action="/users">
    <label for="first_name">first_name
        <input id="first_name" name="first_name">
    </label></br>
    <label for="last_name">last_name
        <input id="last_name" name="last_name">
    </label></br>
    <input type="submit" value="inside in JDBC">
</form>



</body>
</html>
