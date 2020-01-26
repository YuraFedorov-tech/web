<%@ page import="ru.Yura.models.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 31.12.2019
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HI NIGER</title>
</head>
<body>
<%
    List<User> users=(List)request.getAttribute("UsersFromServer");
%>
<table>
    <tr>
        <th>User name</th>
        <th>Birthday</th>
        <th>Password</th>
    </tr>

    <%
        for(User user:users){
    %>
    <tr>
        <th><%=user.getName()%></th>
        <th><%=user.getBirthday()%></th>
        <th><%=user.getPassword()%></th>

    </tr>
    <%}%>

</table>



</body>
</html>
