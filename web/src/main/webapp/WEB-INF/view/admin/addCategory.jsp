<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form:form method="POST" action="/menu/saveCategory" modelAttribute="newCategory" accept-charset="utf-8">
    <table>

        <tr>
            <td>
                <fmt:message key="title"/>:
            </td>
            <td>
                <form:input path="title" type="text" name="title" required="required" title="Title" />
            </td>
        </tr>

        <tr>
            <td>
                <fmt:message key="title4menu"/>:
            </td>
            <td>
                <form:input path="title4menu" type="text" name="title4menu" required="required" title="Title for menu" />
            </td>
        </tr>

    </table>
    <input type="submit" align="middle" value="<fmt:message key="submit"/>">
</form:form>