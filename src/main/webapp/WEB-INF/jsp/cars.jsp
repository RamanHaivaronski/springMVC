<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="style" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="utf-8">
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    <meta rel="viewport" content="width=device=width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>Car Selection</title>
</head>

<body>
<div class="container">

    <h4>Select Your Cars</h4>
    <table border="1" class="table-condensed" id="table">
        <thead>
        <tr>
            <td><img src = "https://goodlogo.com/images/logos/small/volkswagen_logo_2388.gif"></td>
            <td><img src = "https://www.gap-turbos.com/wp-content/uploads/2014/01/audi-logo.png"></td>
            <td><img src = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/BMW.svg/100px-BMW.svg.png"></td>
            <td><img src = "https://motors-4.azureedge.net/v3/live/20180209-0804/images/logo/mercedes-benz.jpg"></td>
            <td><img src = "https://media.glassdoor.com/sql/650150/toyota-israel-squarelogo-1473160174363.png"></td>
        </tr>
        </thead>
        <tbody>
            <td>
                <input name="1"   type="submit" value="Submit" class="btn btn-dark" style="width:100%"/>
            </td>
            <td>
                <input id="2"  type="button" value="Add" class="btn btn-dark" style="width:100%" onclick="addCar(id, 2)"/>
            </td>
            <td>
                <input id="3"  type="button" value="Add" class="btn btn-dark" style="width:100%" onclick="addCar(id, 3)"/>
            </td>
            <td>
                <input id="4"  type="button" value="Add" class="btn btn-dark" style="width:100%" onclick="addCar(id, 4)"/>
            </td>
            <td>
                <input id="5"  type="button" value="Add" class="btn btn-dark" style="width:100%" onclick="addCar(id, 5)"/>
            </td>
        </tbody>
        <tfoot>
            <td>
                <input   type="button" value="Delete" class="btn btn-dark" style="width:100%" onclick="deleteCar(id, 1)"/>
            </td>
            <td>
                <input   type="button" value="Delete" class="btn btn-dark" style="width:100%" onclick="deleteCar(id, 2)"/>
            </td>
            <td>
                <input  type="button" value="Delete" class="btn btn-dark" style="width:100%" onclick="deleteCar(id, 3)"/>
            </td>
            <td>
                <input  type="button" value="Delete" class="btn btn-dark" style="width:100%" onclick="deleteCar(id, 4)"/>
            </td>
            <td>
                <input   type="button" value="Delete" class="btn btn-dark" style="width:100%" onclick="deleteCar(id, 5)"/>
            </td>
        </tfoot>
    </table>
</div>

<script>
    function addCar(user_id, car_id){
            // не рабочая
            $.ajax({
                url: "addCar",
                type: "POST",
                data: { username: user_id, car_id: car_id},
                success: function(data)
                {
                    console.log("SUCCESS : ", data);
                    $("#Submit").prop("disabled", true);
                }
            });

    }



    function deleteCar(user_id, car_id){
        $.ajax({
            // и снова не рабочая
            url: "deleteCar",
            type: "POST",
            data: { 'username': user_id, 'car_id': car_id },
            success: function()
            {
                alert("ok");
            }
        });

    }

</script>
</body>
</html>