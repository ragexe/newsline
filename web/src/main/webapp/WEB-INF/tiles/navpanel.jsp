<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@page session="true" %>

<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="/menu" class="navbar-brand"><fmt:message key="newslineBrand"/></a>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="themes"><fmt:message
                            key="themes"/><span class="caret"></span></a>
                    <ul class="dropdown-menu" aria-labelledby="themes">
                        <li><a href="../menu/" target="_blank"><fmt:message key="default"/></a></li>
                    </ul>
                </li>
                <li>
                    <a href="https://github.com/ragexe/newsline/" target="_blank"><fmt:message key="git"/></a>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="blog"><fmt:message
                            key="authors"/><span class="caret"></span></a>
                    <ul class="dropdown-menu" aria-labelledby="blog">
                        <li><a href="https://vk.com/ragexe" target="_blank"><fmt:message key="ragexe"/></a></li>
                        <li><a href="https://vk.com/followhappyq" target="_blank"><fmt:message key="happyQ"/></a></li>
                    </ul>
                </li>
                <li><a href="https://wrapbootstrap.com/?ref=bsw" target="_blank"><fmt:message key="wapBootstrap"/></a>
                </li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <div style="margin-bottom: -1px;">
                        <div class="btn-toolbar bs-component" style="margin: 0;">
                            <core:choose>
                                <core:when test="${empty pageContext.request.userPrincipal.name}">
                                    <a href="/menu/add" class="btn btn-success " title="Авторизуйтесь"><fmt:message
                                            key="addNews"/></a>
                                </core:when>
                                <core:otherwise>
                                    <a href="/menu/add" class="btn btn-success"><fmt:message key="addNews"/></a>
                                </core:otherwise>
                            </core:choose>
                        </div>
                    </div>
                </li>
                <li>
                    <div style="margin-bottom: -1px;">
                        <div class="btn-toolbar bs-component" style="margin: 0;">
                            <div class="btn-group">
                                <core:choose>
                                    <core:when test="${empty pageContext.request.userPrincipal.name}">
                                        <a href="/login" class="btn btn-info"><fmt:message key="guest"/></a>
                                        <a href="#" class="btn btn-info dropdown-toggle" data-toggle="dropdown"><span
                                                class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="/login" class="bg-primary"><fmt:message key="login"/></a></li>

                                            <li class="divider"></li>
                                            <li><a href="/reg"><fmt:message key="signin"/></a></li>
                                        </ul>
                                    </core:when>
                                    <core:otherwise>
                                        <a href="#" class="btn btn-info">${pageContext.request.userPrincipal.name}</a>
                                        <a href="#" class="btn btn-info dropdown-toggle" data-toggle="dropdown"><span
                                                class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#"><fmt:message key="myNews"/></a></li>
                                            <li><a href="#"><fmt:message key="profile"/></a></li>
                                            <li class="divider"></li>
                                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                                <li><a href="/menu/adminController"><fmt:message key="adminPanel"/></a>
                                                </li>
                                                <li class="divider"></li>
                                            </sec:authorize>

                                            <core:url value="/logout" var="logoutUrl"/>
                                            <form action="${logoutUrl}" method="post" id="logoutForm">
                                                <input type="hidden" name="${_csrf.parameterName}"
                                                       value="${_csrf.token}"/>
                                            </form>
                                            <script>
                                                function formSubmit() {
                                                    document.getElementById("logoutForm").submit();
                                                }
                                            </script>
                                            <li><a href="javascript:formSubmit()" class="bg-danger"><fmt:message
                                                    key="logout"/></a></li>
                                        </ul>
                                    </core:otherwise>
                                </core:choose>
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div style="margin-bottom: -1px;">
                        <div class="btn-toolbar bs-component" style="margin: 0;">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                    <span class="lang-sm" lang="<fmt:message key="locale"/>"></span> <span
                                        class="caret"><g/></span>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="?lang=ru" class="lang-sm lang-lbl" lang="ru"></a></li>
                                    <li><a href="?lang=en" class="lang-sm lang-lbl" lang="en"></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
