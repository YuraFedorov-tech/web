<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 08.01.2020
  Time: 19:49
  To change this template use File | Settings | File Templates.


  *@autor Fedorov Yuri
  *@project Web3
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head >
    <style>*{box-sizing: border-box;}</style>
    <title>add Users</title>
</head>
<body>
<h1>Registration user in JDBC</h1>


<form style="  display: inline-block; border: 4px double black;" method="post" action="/user">
    <table >
        <tr style="border: 1px solid black; text-align: center">
            <label for="name">
                <input id="name" name="name" value="name">
            </label>
        </tr></br>
        <tr style="border: 1px solid black; text-align: center">
            <label for="password">
                <input id="password" name="password" value="password">
            </label>
        </tr></br>
        <tr style="border: 1px solid black; text-align: center">
            <label for="money">
                <input id="money" name="money" value="money">
            </label>
        </tr>
        <tr>
            <td>
                <input type="submit" value="submit">
            </td></br>
        </tr>
    </table>
</form>
</body>
</html>
