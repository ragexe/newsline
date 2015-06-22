<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>
<!DOCTYPE html>


<html>
<head>
    <title></title>
</head>
<body>
<form:form method="POST" action="/saveUser" modelAttribute="newUser" accept-charset="utf-8">
  <table>

    <tr>
      <td>
        <fmt:message key="log"/>:
      </td>
      <td>
        <form:input path="name" type="text" name="name" required="required" title="Name" />
      </td>
    </tr>

    <tr>
      <td>
        <fmt:message key="lastname"/>:
      </td>
      <td>
        <form:input path="lastname" type="text" name="lastname" required="required" title="Last name" />
      </td>
    </tr>
    <tr>




      <td>
        <fmt:message key="email"/>:
      </td>
      <td>
        <form:input path="email" type="text" name="email" required="required" title="Email" />
      </td>
    </tr>
    <tr>
      <td>
        <fmt:message key="password"/>:
      </td>
      <td>
        <form:input path="password" type="text" name="password" required="required" title="Password" />
      </td>
    </tr>


  </table>
  <input type="submit" align="middle" value="<fmt:message key="submit"/>">
</form:form>
<core:if test="${not empty error}">
  <div class="error">${error}</div>
</core:if>

</body>
</html>
