<%--
  Created by IntelliJ IDEA.
  User: dakon
  Date: 04.02.2018
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Table of users </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<table border="1">
    <tr>
        <th>user_id</th>
        <th>name</th>
        <th>surname</th>
        <th></th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.user_id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td><a href="/delete/${user.user_id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<form name="user" action="/addUser" method="post">
    <p>Name</p>
    <input title="Name" type="text" name="name">
    <p>Surname</p>
    <input title="Surname" type="text" name="surname">
    <input type="submit" value="OK">
</form>
</body>
</html>
