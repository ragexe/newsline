<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><core:out value="${page.title4menu}"/></title>
</head>
<body>
<div class="col-lg-2">
    <div class="panel panel-success">
        <div class="panel-heading"><fmt:message key="categories"/></div>
        <div class="panel-body">
            <ul>
                <core:forEach var="categ" items="${category}">
                    <li><a href="/menu/${categ.id}/1">${categ.title}</a></li>
                </core:forEach>
            </ul>
        </div>
    </div>
</div>
</div>

<div class="col-lg-7">
    <core:forEach var="page" items="${pages}">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title"><a href="/post/${page.id}"><core:out value="${page.title}"/></a></h3>
            </div>
                <%--<h1><a href="../post/${page.id}"><core:out value="${page.title}"/></a></h1>--%>
            <small><cite><core:out value="${page.author.name}"/> </cite><fmt:message key="addedOn"/> <core:out value="${page.date}"/></small>
            <div class="jumbotron">
                <p><core:out value="${page.maintext}"/><br></p>
            </div>
        </div>
    </core:forEach>
    <div align="center">
        <core:if test="${not empty pages}">
            <core:set var="counter" value="${counter}"/>
            <ul class="pager">
                <core:choose>
                    <core:when test="${counter < 2}">
                        <li class="previous disabled"><a href="../${categoryId}/1">← First</a></li>
                    </core:when>
                    <core:otherwise>
                        <li class="previous"><a href="../${categoryId}/${counter-1}">← Newer</a></li>
                    </core:otherwise>
                </core:choose>

                <core:choose>
                    <core:when test="${pages.size()/5 < 1}">
                        <li class="next disabled"><a href="../${categoryId}/${counter}">Older →</a></li>
                    </core:when>
                    <core:otherwise>
                        <li class="next"><a href="../${categoryId}/${counter+1}">Older →</a></li>
                    </core:otherwise>
                </core:choose>
            </ul>
        </core:if>
    </div>
</div>

</body>
</html>
