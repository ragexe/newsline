<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <fmt:requestEncoding value="UTF-8"/>
    <title>Меню администратора</title>
</head>
<body>

<table>
    <tr>
        <th><h1>NEWS</h1></th>
    </tr>
    <tr>
        <td><%= request.getAttribute("menu") %>
        </td>
    </tr>
</table>

</body>
</html>