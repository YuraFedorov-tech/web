
<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 03.01.2020
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form method="post" action="/register">
    <label for="id">user id
        <input type="text" id="id" name="id">
    </label></br>
    <label for="email">email
        <input type="text" id="email" name="email">
    </label></br>
    <label for="password">password
        <input type="password" id="password" name="password">
    </label></br>
    <input type="submit" value="login Up">
</form>


<table>
    <tr>
        <th>id</th>
        <th>email</th>
        <th>password</th>
    </tr>

    <c:forEach items="${userInBase}" var="user">
        <tr>
            <th>${user.id}</th>
            <th>${user.email}</th>
            <th>${user.password}</th>
        </tr>
    </c:forEach>

</table>

</form>
</body>
</html>
