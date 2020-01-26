<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 08.01.2020
  Time: 19:48
  To change this template use File | Settings | File Templates.
  

  *@autor Fedorov Yuri
  *@project Web3
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head >
    <style>*{box-sizing: border-box;}</style>
    <title>transaction</title>
</head>
<body>
<h1>Transaction</h1>


<form style="  display: inline-block; border: 4px double black;" method="post" action="/transaction">
    <table >
        <tr style="border: 1px solid black; text-align: center">
            <label for="senderName">
                <input id="senderName" name="senderName" value="senderName">
            </label>
        </tr></br>
        <tr style="border: 1px solid black; text-align: center">
            <label for="senderPass">
                <input id="senderPass" name="senderPass" value="senderPass">
            </label>
        </tr></br>
        <tr style="border: 1px solid black; text-align: center">
            <label for="count">
                <input id="count" name="count" value="count">
            </label></br>
        </tr>
        <tr style="border: 1px solid black; text-align: center">
            <label for="nameTo">
                <input id="nameTo" name="nameTo" value="nameTo">
            </label></br>
        </tr>
        <tr>
            <td>
                <input type="submit" value="submit">
            </td></br>
        </tr>
    </table>

    </br>
    </br>
    </br>

    <h5>Do you want add yet one user?</h5>
    <form method="get" action="/user">
        <label for="addYetOneUser">
            <input id="addYetOneUser" name="addYetOneUser">
        </label></br>
        <input type="submit" value="go niger">
    </form>

    <h1>${message}</h1>
</form>
</body>
</html>
