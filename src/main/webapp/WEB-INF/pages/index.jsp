<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TripComposer Test Task</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <h3>TripComposer Test Task</h3>
    <input type="submit" value="Run script" class="btn btn-success" onclick="BindJson()" />
    <br><br>
    <form action="/tripcomposer/json" method="post">
        <input type="submit" value="Read JSON from file" class="btn btn-success">
    </form>
</div>

<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.1.js"></script>
<script type="text/javascript">
    function BindJson() {
        console.log('jQuery is running..');
        var reqStr = JSON.stringify({"key": "$1$12309856$euBrWcjT767K2sP9MHcVS/"})
        var url = "http://tripcomposer.net/rest/test/countries/get"
        $.ajax({
            url : url,
            contentType: 'application/json; charset=utf-8',
            crossDomain: true,
            type : "POST",
            data : reqStr,
            dataType : "json",
            success:function(data)
            {
                alert("Data from TripComposer"+JSON.stringify(data));
            },
            error:function(jqXHR,textStatus,errorThrown)
            {
                alert("The request from TripComposer has not received "+errorThrown);
            }
        });
    };
</script>

</body>