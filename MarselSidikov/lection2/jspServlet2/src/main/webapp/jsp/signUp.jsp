<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.Yura.models.User" %><%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 31.12.2019
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hi Niger</title>
</head>
<body>
<form method="post" action="/signUp">
    <label for="name" >user name
        <input type="text" id="name" name="name"  ></br>
    </label>
    <label for ="birthDay">birthDay
        <input type="text" id="birthDay" name="birthDay">
    </label></br>
    <label for="password" > password
        <input type="password" id="password" name="password"  >
    </label></br>
  <input type="submit" value="Sign Up" >
</form>
<table>
    <tr>
        <th>userName</th>
        <th>Birthday</th>
    </tr>
    <c:forEach items="${usersFromServer}" var="user">
        <tr>
            <th>${user.name}</th>
            <td>${user.birthday}</td>
            <td>${user.password}</td>

        </tr>

    </c:forEach>

</table>
</body>
</html>
