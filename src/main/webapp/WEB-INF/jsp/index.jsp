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
<html>
<head>
    <title>Table of users </title>
    <meta charset="utf-8">
    <meta rel="viewport" content="width=device=width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

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
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.user_id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td><a href="/delete/${user.user_id}" class="btn btn-dark">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h3>               </h3>
    <h3>Add User Window</h3>
    <button  type="button" class="btn btn-success" data-toggle="modal" data-target="#popUpWindow">Add User</button>

    <div class="modal fade" id="popUpWindow">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- header-->
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <!-- body-->
                <div class="modal-body">
                    <form role="form" name="user" action="/addUser" method="post">
                        <div>
                            <p>Name</p>
                            <input title="Name" type="name" name="name" class="form-control" placeholder="Enter name here">
                        </div>
                        <div>
                            <p>Surname</p>
                            <input title="Surname" type="surname" name="surname" class="form-control" placeholder="Enter surname here">

                        </div>
                        <div class="modal-footer">
                            <!--<a th:href="@{/addUser}"> </a>-->
                            <button th:th:href="@{/addUser}" class="btn btn-primary btn-block" type="submit">Ok</button>

                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
