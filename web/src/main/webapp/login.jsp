<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <jsp:include page="common/navipanel.jsp"/>
    <jsp:include page="common/styles-common.jsp"/>
</head>
<body>
<%--<form action="authoriz" align="center" method="post">--%>
<%--<p>--%>
<%--<br>Input your login and password<br>--%>
<%--login:<br><input name="email" placeholder="email"><br>--%>
<%--password:<br><input type="password" name="password" placeholder="password"><br>--%>
<%--<br>--%>
<%--<p class="text-danger"> <core:out value="${message}"></core:out></p><br>--%>
<%--&lt;%&ndash;<a href="index.jsp">Войти без авторизации</a><br>&ndash;%&gt;--%>
<%--<input class="btn btn-primary btm-xs" type="submit">--%>
<%--<a href="#" class="btn btn-default btm-xs">Регистрация</a>--%>
<%--</p>--%>
<%--</form>--%>
<%--<form action="authoriz" align="center" method="post">--%>
<%--<div class="input-lg">--%>
<%--<span class="add-on"><i class="icon-bar"></i></span>--%>
<%--<input class="span2" type="text" placeholder="Email">--%>
<%--</div>--%>
<%--<div class="input-lg">--%>
<%--&lt;%&ndash;<span class="add-on"><i class="icon-key"></i></span>&ndash;%&gt;--%>
<%--<input class="span2" type="password" placeholder="Пароль">--%>
<%--</div>--%>
<%--</form>--%>

<div class="container">
    <div class="row">
        <div class="well bs-component">
            <form class="form-horizontal" action="authoriz" method="post">
                <fieldset>
                    <legend>Authorization</legend>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-6">
                            <input type="text" name="email" class="form-control" id="inputEmail" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                        <div class="col-lg-6">
                            <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-6 col-lg-offset-2">
                            <button type="reset" class="btn btn-default">Cancel</button>
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <a href="#" class="btn btn-default btm-xs">Регистрация</a>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>

</body>
</html>