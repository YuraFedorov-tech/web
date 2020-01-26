<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.Yura.models.User" %><%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 31.12.2019
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hi Niger</title>
</head>
<body>
<%
    ArrayList<User> users=(ArrayList)request.getAttribute("usersFromServer");
%>
<table>
    <tr>
        <th>userName</th>
        <th>Birthday</th>
    </tr>
 <%
     for(User user:users){
 %>
    <tr>
    <th><%=user.getName()%></th>
    <th><%=user.getBirthday()%></th>
    </tr>
    <%}%>
</table>
</body>
</html>
