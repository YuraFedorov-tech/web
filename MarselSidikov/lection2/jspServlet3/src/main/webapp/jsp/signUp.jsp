<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.Yura.models.User" %><%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 01.01.2020
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign UP</title>
</head>
<body>

<form method="post" action="/signUp">
    <label for="name"> user name
        <input type="name" id="name" name="name">
    </label></br>
    <label for="birthday"> user birthday
        <input type="text" id="birthday" name="birthday">
    </label></br>
    <label for="password"> user birthday
        <input type="password" id="password" name="password">
    </label></br>
    <input type="submit" value="Sign Up">
</form>
<table>
    <tr>
        <th>userName</th>
        <th>Birthday</th>
        <th>Password</th>
    </tr>

    <C:forEach items="${usersFromServer}" var="user">
        <tr>
            <th>${user.name}</th>
            <th>${user.birthday}</th>
            <th>${user.password}</th>
        </tr>
    </C:forEach>


</table>

</body>
</html>
