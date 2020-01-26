<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 02.01.2020
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>SignUp</title>
</head>
<body>
<form method="post" action="/signUp">
    <span style="color: ${cookie.color.value} ">
<label for="name">user name
    <input type="text" id="name" name="name">
</label></br>
        <label for="birthday">birthday
        <input type="text" id="birthday" name="birthday">
    </label></br>
        <label for="password">password
        <input type="password" id="password" name="password">
    </label></br>
        <input type="submit" value="Sign Up">
        </span>
</form>

<%--
здесь цвет не срабатывает. а почему?
--%>
<span style="color: ${cookie.color.value} ">
<table>
    <tr>
        <th>user name</th>
        <th>birthday</th>
        <th>password</th>
    </tr>

    <c:forEach items="${usersFromServer}" var="user">
        <tr>
            <th>${user.name}</th>
            <th>${user.birthday}</th>
            <th>${user.password}</th>
        </tr>
    </c:forEach>

</table>
</span>
</form>
</body>
</html>
