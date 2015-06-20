<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><core:out value="${page.title4menu}"/></title>
</head>
<body>
<div class="col-lg-2">
    <div class="panel panel-success">
        <div class="panel-heading">Категории</div>
        <div class="panel-body">
            <ul>
                <core:forEach var="categ" items="${category}">
                    <li><a href="../menu/${categ.id}">${categ.title}</a></li>
                </core:forEach>
            </ul>
        </div>
    </div>
</div>
</div>

<div class="col-lg-7">
    <core:forEach var="page" items="${pages}">
        <h1><a href="../post/${page.id}"><core:out value="${page.title}"/></a></h1>
        <small><cite><core:out value="${page.author.name}"/></cite> написал <core:out value="${page.date}"/></small>
        <blockquote>
            <p><core:out value="${page.maintext}"/><br></p>
        </blockquote>
    </core:forEach>












</div>

</body>
</html>
