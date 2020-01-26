<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 05.01.2020
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>see Users</title>
</head>
<body>
<h1>we have next Users</h1>
<table>
    <tr>
        <th>first_name</th>
        <th>last_name</th>
    </tr>
    <c:forEach items="${usersInJDBC}" var="User">
        <tr>
            <th>${User.firstName}</th>
            <th>${User.lastName}</th>
        </tr>
    </c:forEach>
</table>

</body>
</html>
