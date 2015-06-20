<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.06.2015
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<ul>
  <core:forEach var="page2" items="${pages}">
    <li><a href="${page2.title}"/>${page2.title}</li>
  </core:forEach>
</ul>

</body>
</html>
