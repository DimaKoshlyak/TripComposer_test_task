<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>

</head>
<body>

<input type="button" value="post" onclick="post()">
<br>
<input type="button" value="put" onclick="put()">
<br>
<input type="button" value="putJson" onclick="putJson()">

<hr />
<form:form method="put" action="json/putform">
    <p class="submit">
        <input name="name" type="text" value="Put As Form" />
        <input type="submit" value="Put As Form" />
    </p>
</form:form>

<script src="/discover-spring/resources/jquery-1.11.2.js"></script>
<script>
    function post() {
        $.ajax({
            url : "http://tripcomposer.net/rest/test/countries/get",
            type : "POST",
            contentType : "application/json;chaset=UTF-8",
            data : JSON.stringify({
                "key" : "$1$12309856$euBrWcjT767K2sP9MHcVS/"
            }),
            dataType : "json"
        });
    }
    function put() {
        $.ajax({
            url : "/discover-spring/json/put",
            type : "PUT",
            contentType : "application/json;chaset=UTF-8",
            data : JSON.stringify([{
                "name" : "Hell",
                "age" : 43,
                "pet": {
                    id: 3,
                    nickname: "asshole"
                }
            }]),
            dataType : "json"
        });
    }

    function putJson() {
        $.ajax({
            url : "/discover-spring/json/putjson?_method=put",
            type : "POST",
            contentType : "application/json;chaset=UTF-8",
            data : JSON.stringify({
                "name" : "Heal",
                "age" : 43
            }),
            dataType : "json"
        });
    }
</script>
</body>

</html>