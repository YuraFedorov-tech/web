<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 02.01.2020
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<span style="color: ${cookie.color.value} ">Hi Niger
<form method="post" action="/home">
    <label for="color">
        <select name="color" id="color">
            <option value="red" >Красный</option>
            <option value="black" >Черный</option>
            <option value="green" >Зеленый</option>
        </select>
    </label>
    <input type="submit" value="Send color" >


</form>


</span>


</body>
</html>
