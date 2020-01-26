<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 10.01.2020
  Time: 20:47
  To change this template use File | Settings | File Templates.
  

  *@autor Fedorov Yuri
  *@project Web3
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <style>*{box-sizing: border-box;}</style>
    <title>print</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>password</td>
        <td>money</td>
    </tr>
    <c:forEach items="${clientInBase}" var="client">
        <tr>
            <td>${client.id}</td>
            <td>${client.name}</td>
            <td>${client.password}</td>
            <td>${client.money}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
