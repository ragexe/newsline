<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>
<html>
<style>
    .error {
        padding: 15px;
        margin-bottom: 20px;
        border: 1px solid transparent;
        border-radius: 4px;
        color: #a94442;
        background-color: #f2dede;
        border-color: #ebccd1;
    }

    .msg {
        padding: 15px;
        margin-bottom: 20px;
        border: 1px solid transparent;
        border-radius: 4px;
        color: #31708f;
        background-color: #d9edf7;
        border-color: #bce8f1;
    }

    #login-box {
        width: 300px;
        padding: 20px;
        margin: 100px auto;
        background: #fff;
        -webkit-border-radius: 2px;
        -moz-border-radius: 2px;
        border: 1px solid #000;
    }
</style>
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
            <form name="loginForm" class="form-horizontal" action="<core:url value="/auth/login_check?targetUrl=${targetUrl}"/>" method="post">
                <fieldset>
                    <legend><fmt:message key="authorization"/></legend>
                    <div class="form-group">
                        <label for="username_or_email" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-6">
                            <input type="text" name="username" class="form-control" id="username_or_email" placeholder="Login">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label"><fmt:message key="password"/></label>
                        <div class="col-lg-6">
                            <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password"/>
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
                        <label class="col-lg-2 control-label"></label>
                        <div class="col-lg-6">
                            <div class="checkbox">
                                <core:if test="${empty loginUpdate}">
                                    <input type="checkbox" name="remember-me" /><fmt:message key="rememberMe"/>
                                </core:if>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-6 col-lg-offset-2">
                            <%--<fieldset>--%>
                            <%--<input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>--%>
                            <%--&lt;%&ndash;<label for="remember_me" class="inline"><fmt:message key="rememberMe"/></label>&ndash;%&gt;--%>
                            <%--<label for="remember_me" class="inline">Запомнить меня</label>--%>
                            <%--</fieldset>--%>

                            <button type="reset" class="btn btn-default"><fmt:message key="cancel"/></button>
                            <button type="submit" class="btn btn-primary"><fmt:message key="submit"/></button>
                            <a href="/reg" class="btn btn-default btm-xs"><fmt:message key="signin"/></a>
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