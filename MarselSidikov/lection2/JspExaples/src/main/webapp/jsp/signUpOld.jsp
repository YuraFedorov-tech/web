<%@ page import="ru.Yura.models.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 31.12.2019
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GOGOGO</title>


</head>
<body>
<%
    ArrayList<User> users = (ArrayList) request.getAttribute("UsersFromServer");


%>
<table>
    <tr>
        <th>user name</th>
        <th>Birthsday</th>
    </tr>
    <%
        for(User user:users){
    %>
    <tr>
        <th><%=user.getName()%></th>
        <th><%=user.getBirthday()%>
        </th>

    </tr>
    <%
        }
    %>


</table>
</body>
</html>
