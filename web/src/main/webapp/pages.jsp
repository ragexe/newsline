<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="Page" class="data.Page" scope="request"/>
<!-- бин объекта хранения строки базы для обращения к нему -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <fmt:requestEncoding value="UTF-8"/>
    <title>
        <jsp:getProperty name="Page" property="title"/>
    </title> <!-- заголовок из бина для отображения в окне -->
</head>


<body>
<table width="100%" cellspacing="0" cellpadding="10">
    <tr>
        <td>
            <h1 align="center">NEWS</h1>
        </td>
    </tr>
    <tr>
        <td>
            <table width="100%">
                <tr>
                    <td width="40%">
                        <a href="PageControlPanel">На главную</a>
                    </td>
                    <td width="60%" align="right">
                        <!--<a href="mylogin.jsp">Войти</a>
                        <br>Привет, <jsp:getProperty name="User" property="email"/>-->
                        <br><%= request.getAttribute("auth")%>
                    </td>
                </tr>
                <tr>
                    <td width="40%">
                        <%= request.getAttribute("pagemenu") %>
                        <!-- берем из запроса текстовую переменную созданного меню  -->
                    </td>
                    <td width="60%" align="center">
                        <jsp:getProperty property="maintext" name="Page"/>
                        <!-- берем текст из бина   -->
                    </td>
                </tr>

            </table>
        </td>
    </tr>
</table>

<%-- 
<%= request.getAttribute("pageid") %>
<%= request.getAttribute("pagedata") %>--%>

</body>
</html>