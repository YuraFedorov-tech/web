<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 06.01.2020
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>print</title>
</head>
<body>
<h1>registred users</h1>
<table>
    <tr>
        <th>id</th>
        <th>email</th>
        <th>password</th>
    </tr>
    <c:forEach items="${dataBaseInMemory}" var="user">
        <tr>
            <th>${user.id}</th>
            <th>${user.email}</th>
            <th>${user.password}</th>
        </tr>
    </c:forEach>
</table>
</br>
</br>
</br>
<h1>Logined users</h1>
<table>
    <tr>
        <th>id</th>
        <th>email</th>
        <th>password</th>
    </tr>
    <c:forEach items="${dataBaseInMemoryLogin}" var="user">
        <tr>
            <th>${user.id}</th>
            <th>${user.email}</th>
            <th>${user.password}</th>
        </tr>
    </c:forEach>
</table>
</br>
</br>
</br>


<h2>method get /api</h2>
<form method="get" action="/api/*">
    <label for="id" >id
        <input id="id" name="id" value="id">
    </label></br>
    <label for="email" >email
        <input id="email" name="email" value="email">
    </label></br>
    <label for="password" >password
        <input id="password" name="password" value="password">
    </label></br>
    <input type="submit" value="register up">
</form>






<form method="get" action="/login">
    <label for="email" >email
        <input  name="email" value="email">
    </label></br>
    <label for="password" >password
        <input  name="password" value="password">
    </label></br>
    <input type="submit" value="register up">
</form>

<form method="get" action="/dfh">
    <label for="email" >email
        <input  name="email" value="email">
    </label></br>
    <label for="password" >password
        <input  name="password" value="password">
    </label></br>
    <input type="submit" value="register up">
</form>


</body>
</html>
