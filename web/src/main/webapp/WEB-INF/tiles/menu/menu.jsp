<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: HappyQ
  Date: 22.06.2015
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="private-info">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="col-lg-2">
            <div class="panel panel-warning">
                <div class="panel-heading"><fmt:message key="adminPanel"/></div>
                <div class="panel-body">
                    <a href="/menu/adminController/category"><fmt:message key="addcategory"/></a><br>
                    <a href="/menu/adminController/"><fmt:message key="delcategory"/></a><br>
                    <a href="/menu/add/"><fmt:message key="addnews"/></a><br>
                    <a href="/menu/adminController/users"><fmt:message key="users"/></a><br>
                    <a href="/menu/adminController/banUsers"><fmt:message key="deluser"/></a>
                </div>
            </div>
        </div>
    </sec:authorize>
</div>
</div>
