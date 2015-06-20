<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>University Enrollments</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Categories</h2>
	<table>
		<tr>
			<td>id</td><td>title</td><td>title4menu</td>
		</tr>
		<core:forEach items="${categories}" var="category">
			<tr>
			<td>${category.id}</td>
			<td>${category.title}</td>
			<td>${category.title4menu}</td>
			<td><a href="<core:url value='/delete-${category.id}-category' />">delete</a></td>
			</tr>
		</core:forEach>
	</table>
	<br/>
	<a href="<core:url value='/new' />">Add New Employee</a>
</body>
</html>