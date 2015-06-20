<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.06.2015
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="col-lg-2">
    <div class="panel panel-success">
        <div class="panel-heading">Категории</div>
        <div class="panel-body">
            <ul>
                <core:forEach var="categ" items="${category}">
                    <li><a href="menu/${categ.id}">${categ.title}</a></li>
                </core:forEach>
            </ul>
        </div>
    </div>
</div>
</div>

<div class="col-lg-7">
    <!--Body content-->

    <core:forEach var="page" items="${pages}">
        <blockquote>
            ${page.title}
        </blockquote>

    </core:forEach>












</div>

</body>
</html>
