<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <div class="col-lg-7">
        <h1><core:out value="${page.title}"/></h1>
        <small><cite><core:out value="${page.author.name}"/></cite> <fmt:message key="addedOn"/> <core:out value="${page.date}"/></small>
        <blockquote>
            <p><core:out value="${page.maintext}"/><br></p>
        </blockquote>

        <core:if test="${fn:length(comments)==0}">
            <div class="alert alert-dismissible alert-info">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <fmt:message key="noComments"/>
            </div>
        </core:if>

        <table class="table table-striped table-hover ">
            <tbody>
                <core:forEach var="comment" items="${comments}">
                    <core:choose>
                        <core:when test="${page.author.id==comment.user.id}">
                                <tr class="warning">
                        </core:when>
                            <core:otherwise>
                                <tr>
                            </core:otherwise>
                        </core:choose>
                                    <td><core:out value="${comment.user.name}"/></td>
                                    <td><core:out value="${comment.date}"/></td>
                                    <td><core:out value="${comment.maintext}"/></td>
                                </tr>
                </core:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
