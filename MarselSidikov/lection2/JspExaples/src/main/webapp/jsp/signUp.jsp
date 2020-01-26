<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.Yura.models.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<form method="post" action="/signUp">

    <label for ="name">User name
    <input type="name" id="name" name="name">
    </label></br>
    <label for ="birthDay">birthDay
        <input type="text" id="birthDay" name="birthDay">
    </label></br>
    <label for ="password">password
    <input type="password" id="password" name="password">
    </label></br>
    <input type="submit" value="Sign Up">
</form>


    <table>
        <tr>
            <th>User name</th>
            <th>Birth Date</th>
        </tr>
        <c:forEach items="${UsersFromServer}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.birthday}</td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>