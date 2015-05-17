<%--
  Created by IntelliJ IDEA.
  User: ragexe
  Date: 17.05.2015
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<%--<head>--%>
    <%--<title></title>--%>
<%--</head>--%>
<fmt:requestEncoding value="UTF-8"/>
<body>
<%--<core:out value="1111"></core:out>--%>
<%--<core:out value="${sessionScope.login}"></core:out>--%>
<%--<core:if test="${sessionScope.login == null}">условие сработало</core:if>--%>
<core:choose>
  <core:when test="${sessionScope.login == null}">
    Привет, гость. Чтобы добавить новость, необходимо <a href="login.jsp">авторизоваться</a>
    <br><i><a href="login.jsp">Регистрация</a></i>
  </core:when>
  <core:otherwise>
    Привет, <core:out value="${sessionScope.login}"/>
    <br><i><a href="logout.jsp">Выйти</a></i>
  </core:otherwise>
</core:choose>
</body>
</html>
