<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: HappyQ--%>
  <%--Date: 18.06.2015--%>
  <%--Time: 12:27--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="navbar navbar-default navbar-fixed-top">--%>
  <%--<div class="container">--%>
    <%--<div class="navbar-header">--%>
      <%--<a href="/main.jsp" class="navbar-brand">Главная</a>--%>
      <%--<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">--%>
        <%--<span class="icon-bar"></span>--%>
        <%--<span class="icon-bar"></span>--%>
        <%--<span class="icon-bar"></span>--%>
      <%--</button>--%>
    <%--</div>--%>
    <%--<div class="navbar-collapse collapse" id="navbar-main">--%>
      <%--<ul class="nav navbar-nav">--%>
        <%--<li class="dropdown">--%>
          <%--<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Themes <span class="caret"></span></a>--%>
        <%--<li><a href="../default/">Default</a></li>--%>
        <%--</li>--%>
        <%--<li>--%>
          <%--<a href="https://github.com/ragexe/newsline/">GitHub</a>--%>
        <%--</li>--%>
        <%--<li class="dropdown">--%>
          <%--<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="blog">Author's<span class="caret"></span></a>--%>
          <%--<ul class="dropdown-menu" aria-labelledby="blog">--%>
            <%--<li><a href="https://vk.com/ragexe">Roman aka ragexe</a></li>--%>
            <%--<li><a href="https://vk.com/followhappyq">Ivan aka happyQ</a></li>--%>
          <%--</ul>--%>
        <%--</li>--%>
        <%--<li><a href="https://wrapbootstrap.com/?ref=bsw" target="_blank">WrapBootstrap</a></li>--%>
      <%--</ul>--%>

      <%--<ul class="nav navbar-nav navbar-right">--%>
        <%--<li>--%>
          <%--<div style="margin-bottom: -1px;">--%>
            <%--<div class="btn-toolbar bs-component" style="margin: 0;">--%>
              <%--<core:choose>--%>
                <%--<core:when test="${sessionScope.login == null}">--%>
                  <%--<a href="/add.jsp" class="btn btn-success disabled" title="Авторизуйтесь">+ Добавить новость</a>--%>
                <%--</core:when>--%>
                <%--<core:otherwise>--%>
                  <%--<a href="/add.jsp" class="btn btn-success">+ Добавить новость</a>--%>
                <%--</core:otherwise>--%>
              <%--</core:choose>--%>
            <%--</div>--%>
          <%--</div>--%>
        <%--</li>--%>
        <%--<li>--%>
          <%--<div style="margin-bottom: -1px;">--%>
            <%--<div class="btn-toolbar bs-component" style="margin: 0;">--%>
              <%--<div class="btn-group">--%>
                <%--<core:choose>--%>
                  <%--<core:when test="${sessionScope.login == null}">--%>
                    <%--<a href="#" class="btn btn-info">Гость</a>--%>
                    <%--<a href="#" class="btn btn-info dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                      <%--<li><a href="login.jsp" class="bg-primary">Войти</a></li>--%>
                      <%--<li class="divider"></li>--%>
                      <%--<li><a href="reg.jsp">Регистрация</a></li>--%>
                    <%--</ul>--%>
                  <%--</core:when>--%>
                  <%--<core:otherwise>--%>
                    <%--<a href="#" class="btn btn-info">${user.name}</a>--%>
                    <%--<a href="#" class="btn btn-info dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                      <%--<li><a href="#">Мои новости</a></li>--%>
                      <%--<li><a href="#">Профиль</a></li>--%>
                      <%--<li class="divider"></li>--%>
                      <%--<core:if test="${user.role == 1}">--%>
                        <%--<li><a href="admpanel.jsp">Админка</a></li>--%>
                        <%--<li class="divider"></li>--%>
                      <%--</core:if>--%>
                      <%--<li><a href="/logout" class="bg-danger">Выйти</a></li>--%>
                    <%--</ul>--%>
                  <%--</core:otherwise>--%>
                <%--</core:choose>--%>
              <%--</div>--%>
            <%--</div>--%>
          <%--</div>--%>
        <%--</li>--%>
      <%--</ul>--%>
    <%--</div>--%>
  <%--</div>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>
