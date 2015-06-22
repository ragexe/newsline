<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: HappyQ
  Date: 22.06.2015
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h5><fmt:message key="users"/></h5>
<div class="col-lg-7">
  <table border="3" rules="rows">
  <core:forEach var="user" items="${users}">
    <tr>
      <td>
        <h5>${user.name}</h5>
      </td>
      <td><a href="/menu/adminController/users/${user.id}" class="btn btn-danger"><fmt:message
              key="deluser"/></a>
      </td>
    </tr>
  </core:forEach>
</table>
</div>
</body>
</html>
