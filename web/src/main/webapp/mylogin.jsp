<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<body>
    <form action="logincorrect" align="center">
        <p>
            <br>Input your login and password<br>
        </p>
        <table width="100%">
            <tr>
                <td align="right" width="50%">login:</td>
                <td width="50%"><input name="email" placeholder="email"></td>
            </tr>
            <tr>
                <td align="right" width="50%">password:</td>
                <td width="50%"><input type="password" name="password" placeholder="password"></td>
            </tr>
        </table>
        <br>
        <input type="submit">
    </form>
</body>
</html>