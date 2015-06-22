<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <%--<jsp:root version="2.0" xmlns:jsp="http://java.sun.com/jsp/jstl/xml"--%>
    <%--xmlns:spring="http://www.springframework.org/tags"--%>
    <%--xmlns="http://www.w3.org/1999/xhtml"/>--%>
</head>
<body onload='document.loginForm.j_username.focus();'>
<spring:url var="authUrl" value="/j_spring_security_check"/>
<div class="container">
    <div class="row">
        <div class="well bs-component">
            <form name="loginForm" class="form-horizontal" action="<core:url value='/auth/login_check?targetUrl=${targetUrl}' />" method="post">
                <fieldset>
                    <%--<legend><fmt:message key="authorization"/></legend>--%>
                    <legend>Авторизация</legend>
                    <div class="form-group">
                        <label for="username_or_email" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-6">
                            <input type="text" name="username" class="form-control" id="username_or_email" placeholder="Login">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                        <div class="col-lg-6">
                            <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <core:if test="${not empty error}">
                            <div class="error">${error}</div>
                        </core:if>
                        <core:if test="${not empty msg}">
                            <div class="msg">${msg}</div>
                        </core:if>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-6 col-lg-offset-2">
                            <%--<fieldset>--%>
                                <%--<input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>--%>
                                <%--&lt;%&ndash;<label for="remember_me" class="inline"><fmt:message key="rememberMe"/></label>&ndash;%&gt;--%>
                                <%--<label for="remember_me" class="inline">Запомнить меня</label>--%>
                            <%--</fieldset>--%>
                            <fieldset>
                                <core:if test="${empty loginUpdate}">
                                    <tr>
                                        <td></td>
                                        <td>Запомнить меня<input type="checkbox" name="remember-me" /></td>
                                    </tr>
                                </core:if>
                            </fieldset>
                            <button type="reset" class="btn btn-default">Cancel</button>
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <a href="#" class="btn btn-default btm-xs">Регистрация</a>
                        </div>
                    </div>
                </fieldset>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form>
        </div>
    </div>
</div>

</body>
</html>