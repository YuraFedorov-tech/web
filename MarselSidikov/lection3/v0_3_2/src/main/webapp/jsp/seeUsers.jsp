<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 08.01.2020
  Time: 15:11
  To change this template use File | Settings | File Templates.
  

  *@autor Fedorov Yuri
  *@project DbExample
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>users in JDBC</title>
</head>
<body>
<h1>How sre you. brather?</h1>
<h1>Done thrid work</h1>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>password</th>
        <th>money</th>
    </tr>
    <c:forEach items="${usersInDB}" var="User">
        <tr>
            <td>${User.id}</td>
            <td>${User.name}</td>
            <td>${User.password}</td>
            <td>${User.money}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
