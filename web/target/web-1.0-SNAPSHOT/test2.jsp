<%--
  Created by IntelliJ IDEA.
  User: ragexe
  Date: 03.05.2015
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=Windows-1251" pageEncoding="cp1251" %>
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
"param": <%= (request.getParameter("param") == null) ? "null" : new String(request.getParameter("param").getBytes("ISO-8859-1"), "cp1251")%>
<br>
</body>
</html>