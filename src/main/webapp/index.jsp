<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="resources/js/login-functions.js"></script>
    </head>
    <body>
        <form name="loginForm" action="/Jakarton-1.0-SNAPSHOT/login-servlet" method="post" onsubmit="return validarForma(this)">
            <label>Username:</label>
            <input type="text" name="ldapUsername"><br><br>
            <label>Password:</label>
            <input type="password" name="ldapPassword"><br><br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>