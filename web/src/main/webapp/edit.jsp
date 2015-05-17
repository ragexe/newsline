<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="Page" class="data.Page" scope="request"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Редактирование страницы</title>
</head>
<body>
<form action="adminPanel" accept-charset="utf-8">
    <p>
        <input type="hidden" name="operation" value="editwrite">
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
        Parentid(раздел):<input name="parentid" VALUE=<jsp:getProperty name="Page" property="parentid"/>><br>
        user:<input name="user" VALUE=<jsp:getProperty name="Page" property="user"/>><br>
        date:<input name="date" VALUE=<jsp:getProperty name="Page" property="date"/>><br>
        title:<input name="title" VALUE=<jsp:getProperty name="Page" property="title"/>><br>
        title4menu:<input name="title4menu" VALUE=<jsp:getProperty name="Page" property="title4menu"/>><br>
        maintext:<br>
        <textarea rows="15" cols="80" name="maintext"><jsp:getProperty name="Page" property="maintext"/></textarea>
        <br>
        <input type="submit">
    </p>
</form>
</body>
</html>