<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Список всех городов в базе</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">
  <h3>Список всех городов</h3>
  <table class="table table-striped">
    <thead>
    <tr>
      <td><b>Город</b></td>
    </tr>
    </thead>
    <c:forEach items="${cities}" var="city">
      <tr>
        <td>${city.cityName}</td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
