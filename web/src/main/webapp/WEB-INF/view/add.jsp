<%--
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
<title></title>
         </head>
           <body>

<form:form method="POST" action="/menu/save" modelAttribute="newPage" accept-charset="utf-8">
    <core:out value="${pageContext.request.userPrincipal.name}"/>

    <table class="form-horizontal">
    <fieldset>
    <tr>
    <td>
    <fmt:message key="category"/>
    </td>
    <td>
    <select name="categoryId" class="form-control">
    <c:forEach items="${categories}" var="category">
    <option value="${category.id}">${category.title4menu}</option>
    </c:forEach>
    </select>
    </td>
    </tr>

    <tr>
    <td>
    <fmt:message key="title"/>
    </td>
    <td>
    <div class="form-group">
    <div class="col-lg-10">
    <form:input path="title" type="text" name="title" required="required" title="Title"/>
    </div>
    </div>
    &lt;%&ndash;<form:input path="title" type="text" name="title" required="required" title="Title"/>&ndash;%&gt;
    </td>
    </tr>

    <tr>
    <td>
    <fmt:message key="title4menu"/>:
    </td>
    <td>
    <div class="form-group">
    <div class="col-lg-10">
    <form:input path="title4menu" type="text" name="title4menu" required="required"
    title="Title for menu"/>
    &lt;%&ndash;</div>&ndash;%&gt;
    &lt;%&ndash;</div>&ndash;%&gt;
    &lt;%&ndash;</td>&ndash;%&gt;
    &lt;%&ndash;</tr>&ndash;%&gt;

    &lt;%&ndash;<tr>&ndash;%&gt;
    &lt;%&ndash;<td valign="top">&ndash;%&gt;
    <fmt:message key="maintext"/>:
    </td>
    <td><div class="form-group">
    <div class="col-lg-10">
    <form:input path="maintext" type="textarea" name="maintext" required="required"
    title="Title for menu"/>

    </div>
    </div>
    </td>
    </tr>
    </fieldset>
    <input class="btn btn-default" type="submit" align="middle" value="<fmt:message key="submit"/>">
    <button type="reset" align="middle" class="btn btn-default">C111111ancel</button>
    </table>
    <input class="btn btn-default" type="submit" align="middle" value="<fmt:message key="submit"/>">
    <button type="reset" align="middle" class="btn btn-default"><ftm:message></button>

   &lt;%&ndash; <div class="col-lg-6">
        <form class="form-horizontal">
            <fieldset>
                <legend><fmt:message key="addnews"/></legend>

                <div class="form-group">
                    <label for="select" class="col-lg-2 control-label"><fmt:message key="category"/></label>
                    <div class="col-lg-10">
                        <select class="form-control" name="categoryId" id="select">
                            <c:forEach items="${categories}" var="category">
                                <option value="${category.id}">${category.title4menu}</option>
                            </c:forEach>
                        </select>
                        <br>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-2 control-label"><fmt:message key="title"/>:</label>
                    <div class="col-lg-10">
                        <form:input path="title" type="text" name="title" required="required" title="Title" cssClass="form-control"/>
                        <span class="help-block">A longer block of help text that breaks onto a new line and may extend beyond one line.</span>
                    </div>
                </div>

                <div class="form-group">
                    <label  class="col-lg-2 control-label"> <fmt:message key="title4menu"/>:</label>
                    <div class="col-lg-10">
                        <form:input path="title4menu" type="text" name="title4menu" required="required" title="Title for menu" cssClass="form-control"/>
                        <span class="help-block">A longer block of help text that breaks onto a new line and may extend beyond one line.</span>
                    </div>
                </div>

                <div class="form-group">
                    <label  class="col-lg-2 control-label"> <fmt:message key="maintext"/>:</label>
                    <div class="col-lg-10">
                        <form:input path="maintext" type="textarea" name="maintext" required="required" title="MainText" cssClass="form-control"/>
                        <span class="help-block">A longer block of help text that breaks onto a new line and may extend beyond one line.</span>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="reset" class="btn btn-default"><fmt:message key="cancel"/></button>
                        <button type="submit" class="btn btn-primary"><fmt:message key="submit"/></button>
                    </div>
                </div>

                <form:input path="author" type="hidden" value="${pageContext.request.userPrincipal.name}"/>
            </fieldset>
        </form>
    </div>
    >&ndash;%&gt;


</form:form>
</html>
 --%>

<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form:form method="POST" action="/menu/save" modelAttribute="newPage" accept-charset="utf-8">
    <table class="form-horizontal">
        <fieldset>
            <tr>
                <td>
                    <fmt:message key="category"/>
                </td>
                <td>
                    <select name="categoryId" class="form-control">
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.id}">${category.title4menu}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td>
                    <fmt:message key="title"/>
                </td>
                <td>
                    <div class="form-group">
                        <div class="col-lg-10">
                            <form:input path="title" type="text" name="title" required="required" title="Title"/>
                        </div>
                    </div>
                </td>
            </tr>

            <tr>
                <td>
                    <fmt:message key="title4menu"/>:
                </td>
                <td>
                    <div class="form-group">
                        <div class="col-lg-10">
                            <form:input path="title4menu" type="text" name="title4menu" required="required"
                                        title="Title for menu"/>
                        </div>
                    </div>
                </td>
            </tr>

            <tr>
                <td valign="top">
                    <fmt:message key="maintext"/>:
                </td>
                <td>
                    <div class="form-group">
                        <div class="col-lg-10">
                            <form:input path="maintext" type="textarea" name="maintext" required="required"
                                        title="Title for menu"/>

                        </div>
                    </div>
                </td>
            </tr>
            <form:input path="author" type="hidden" value="${pageContext.request.userPrincipal.name}"/>
        </fieldset>
        <input class="btn btn-default" type="submit" align="middle" value="<fmt:message key="submit"/>">
        <button type="reset" align="middle" class="btn btn-default">Cancel</button>
    </table>



</form:form>
