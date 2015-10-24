<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>

</head>
<body>

<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.1.js"></script>
<script type="text/javascript">
    function BindJson() {
        console.log('jQuery running..');
        var reqStr = JSON.stringify({"key": "$1$12309856$euBrWcjT767K2sP9MHcVS/"})
        var url = "http://tripcomposer.net/rest/test/countries/get"
        $.ajax({
            url : "http://tripcomposer.net/rest/test/countries/get",
            contentType: 'application/json; charset=utf-8',
            crossDomain: true,
            type : "POST",
            data : reqStr,
            dataType : "json",

            success:function(data)
            {
                alert("Data from Server"+JSON.stringify(data));
            },
            error:function(jqXHR,textStatus,errorThrown)
            {
                alert("You can not send Cross Domain AJAX requests: "+errorThrown);
            }
        });
    } $(document).ready(function() {
        BindJson();
    });
</script>
</body>

</html>

