<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="s" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="user" class="by.newsline.data.User" scope="session"/>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <s:insertAttribute name="head"/>
</head>
<body>
<s:insertAttribute name="navpanel"/>
<s:insertAttribute name="header"/>
<s:insertAttribute name="menu"/>
<s:insertAttribute name="content"/>
<s:insertAttribute name="footer"/>
</body>
</html>