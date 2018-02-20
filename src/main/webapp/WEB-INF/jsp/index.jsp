<%--
  Created by IntelliJ IDEA.
  User: dakon
  Date: 04.02.2018
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Table of users </title>
    <meta charset="utf-8">
    <meta rel="viewport" content="width=device=width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <td><a href="/logout" class="btn btn-red">Logout</a></td>

</head>
<body>
<div class="container">

    <p>List of Library Users</p>
    <table border="1" class="table-condensed">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>login</th>
            <th>password</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.user_id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td><a href="/delete/${user.user_id}" class="btn btn-dark">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
