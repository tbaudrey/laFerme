<%-- 
    Document   : rafraichir
    Created on : 17 mars 2016, 12:10:48
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">

            var task = function () {

                document.location.reload();
            }
            window.setTimeout(task, 1000);

        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
