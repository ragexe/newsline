<%--
  Created by IntelliJ IDEA.
  User: ragexe
  Date: 02.05.2015
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> Очень простая страница JSP </title>
</head>
<body>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<h1> Очень простая страница JSP </h1>

<h3>Этот пример показывает, как работать с выражениями JSP</h3>
Текущая дата: <%= new java.util.Date()%>
<br>
<!-- //request.setCharacterEncoding("utf-8")-->
Значение параметра
"param": <%= (request.getParameter("param") == null) ? "null" : new String(request.getParameter("param").getBytes("ISO-8859-1"), "UTF-8")%>
<br>
</body>
</html>
