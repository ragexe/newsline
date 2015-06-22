<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.06.2015
  Time: 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>


<h5><fmt:message key="category"/></h5>
<div class="col-lg-7">
    <table border="3" rules="rows">
        <core:forEach var="category" items="${categories}">
            <tr>
                <td>
                    <h5>${category.title}</h5>
                </td>
                <td><a href="/menu/adminController/${category.id}" class="btn btn-danger"><fmt:message
                        key="delcategory"/></a>
                </td>
            </tr>
        </core:forEach>
    </table>
</div>

<h5><fmt:message key="users"/></h5>
<div class="col-lg-7" align="center">
    <table border="3" rules="rows">
        <core:forEach var="users" items="${users}">
            <tr>
                <td>
                    <h5>${users.name}</h5>
                </td>
                <td><a href="/menu/adminController/" class="btn btn-danger"><fmt:message
                        key="deluser"/></a>
                </td>
            </tr>
        </core:forEach>
    </table>
</div>
</body>
</html>
