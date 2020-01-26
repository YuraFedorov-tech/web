<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 01.01.2020
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<span style="color: ${cookie.color.value} "> Hello


    <form method="post" action="/home">
        <label for="color">
              <select name="color" id="color">
                  <option value="red">Красный</option>
                  <option value="black">Черный</option>
                  <option value="yellow">Желтый</option>
        </select>
        </label>
        <input type="submit" value="color send">

    </form>
</span>
</body>
</html>
