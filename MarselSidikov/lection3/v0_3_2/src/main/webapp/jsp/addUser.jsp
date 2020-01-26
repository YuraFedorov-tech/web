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


</form>
</body>
</html>
