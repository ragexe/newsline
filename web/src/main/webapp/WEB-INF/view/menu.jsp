<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><core:out value="${page.title4menu}"/></title>
</head>
<body>
<%--<div class="col-lg-2">
    <div class="panel panel-success">
        <div class="panel-heading"><fmt:message key="categories"/></div>
        <div class="panel-body">
            <ul>
                <core:forEach var="categ" items="${category}">
                    <li><a href="../menu/${categ.id}">${categ.title}</a></li>
                </core:forEach>
            </ul>
        </div>
    </div>
</div>
</div>--%>

<div class="col-lg-7">
    <core:forEach var="page" items="${pages}">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title"><a href="../post/${page.id}"><core:out value="${page.title}"/></a></h3>
            </div>
                <%--<h1><a href="../post/${page.id}"><core:out value="${page.title}"/></a></h1>--%>
            <small><cite><core:out value="${page.author.name}"/></cite> <fmt:message key="addedOn"/>написал <core:out
                    value="${page.date}"/></small>
            <div class="jumbotron">
                <p><core:out value="${page.maintext}"/><br></p>
            </div>
        </div>

    </core:forEach>


</div>

</body>
</html>
