<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.06.2015
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<ul>
<core:forEach var="categ" items="${category}">
  <li><a href="${categ.title}">${categ.title}</a></li>
</core:forEach>
</ul>

</body>
</html>