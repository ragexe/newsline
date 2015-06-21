<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="/WEB-INF/view/test/main.jsp" class="navbar-brand">NEWSLINE</a>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Themes <span class="caret"></span></a>
                    <ul class="dropdown-menu" aria-labelledby="themes">
                        <li><a href="../default/">Default</a></li>
                        <li class="divider"></li>
                        <li><a href="../cerulean/">Cerulean</a></li>
                        <li><a href="../cosmo/">Cosmo</a></li>
                        <li><a href="../cyborg/">Cyborg</a></li>
                        <li><a href="../darkly/">Darkly</a></li>
                        <li><a href="../flatly/">Flatly</a></li>
                        <li><a href="../journal/">Journal</a></li>
                        <li><a href="../lumen/">Lumen</a></li>
                        <li><a href="../paper/">Paper</a></li>
                        <li><a href="../readable/">Readable</a></li>
                        <li><a href="../sandstone/">Sandstone</a></li>
                        <li><a href="../simplex/">Simplex</a></li>
                        <li><a href="../slate/">Slate</a></li>
                        <li><a href="../spacelab/">Spacelab</a></li>
                        <li><a href="../superhero/">Superhero</a></li>
                        <li><a href="../united/">United</a></li>
                        <li><a href="../yeti/">Yeti</a></li>
                        <li class="divider"></li>
                        <li><a href="/WEB-INF/view/test/new.jsp">Пример</a> </li>
                    </ul>
                </li>
                <li>
                    <a href="https://github.com/ragexe/newsline/">GitHub</a>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="blog">Author's<span class="caret"></span></a>
                    <ul class="dropdown-menu" aria-labelledby="blog">
                        <li><a href="https://vk.com/ragexe">Roman aka ragexe</a></li>
                        <li><a href="https://vk.com/followhappyq">Ivan aka happyQ</a></li>
                    </ul>
                </li>
                <li><a href="https://wrapbootstrap.com/?ref=bsw" target="_blank">WrapBootstrap</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <div style="margin-bottom: -1px;">
                        <div class="btn-toolbar bs-component" style="margin: 0;">
                            <core:choose>
                                <core:when test="${sessionScope.login == null}">
                                    <a href="/menu/add" class="btn btn-success " title="Авторизуйтесь">+ Добавить новость</a>
                                </core:when>
                                <core:otherwise>
                                    <a href="/menu/add" class="btn btn-success">+ Добавить новость</a>
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
                                    <core:when test="${sessionScope.login == null}">
                                        <a href="#" class="btn btn-info">Гость</a>
                                        <a href="#" class="btn btn-info dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="login.jsp" class="bg-primary">Войти</a></li>
                                                <%--<li><a href="#">Another action</a></li>--%>
                                                <%--<li><a href="#">Something else here</a></li>--%>
                                            <li class="divider"></li>
                                            <li><a href="reg.jsp">Регистрация</a></li>
                                        </ul>
                                    </core:when>
                                    <core:otherwise>
                                        <a href="#" class="btn btn-info">${user.name}</a>
                                        <a href="#" class="btn btn-info dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">Мои новости</a></li>
                                            <li><a href="#">Профиль</a></li>
                                            <li class="divider"></li>
                                            <core:if test="${user.role == 1}">
                                                <li><a href="admpanel.jsp">Админка</a></li>
                                                <li class="divider"></li>
                                            </core:if>
                                            <li><a href="/logout" class="bg-danger">Выйти</a></li>
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
                                    <span class="lang-sm" lang="be"></span> <span class="caret"><g/></span>
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
