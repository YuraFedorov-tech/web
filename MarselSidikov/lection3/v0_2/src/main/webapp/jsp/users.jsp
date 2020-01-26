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
    <title>all users</title>
</head>
<body>
<h1>Registred users</h1>
<table>
    <tr>
        <th>first name</th>
        <th>last name</th>
    </tr>
    <c:forEach items="${userFromServer}" var="user">
        <tr>
            <th>${user.firstName}</th>
            <th>${user.lastName}</th>
        </tr>
    </c:forEach>
</table>


<h5>Thank you very much</h5>
<h6>Wot krasavchiki</h6>
</body>
</html>
