<%--
  Created by IntelliJ IDEA.
  User: ragexe
  Date: 16.05.2015
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="Page" class="data.Page" scope="request"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <fmt:requestEncoding value="UTF-8"/>
  <title>
    <!--<jsp:getProperty name="Page" property="title"/>-->
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
            <!--<br><%= request.getAttribute("onmain")%>-->
          </td>
          <td width="60%" align="right">
            <!--<br><%= request.getAttribute("auth")%>-->
          </td>
        </tr>
        <tr>
          <td width="40%">
            <!--<%= request.getAttribute("pagemenu") %>-->
            <!-- берем из запроса текстовую переменную созданного меню  -->
            <c:out value="${param.sect}"/>
            <c:out value="${param.subsect}"/>
            <jsp:include page="/menu"></jsp:include>
            <c:forEach var="page1" items="${result1}">
              <li><a href=\?sect=<c:out value="${page1.id}"/>><c:out value="${page1.title4menu}"/></a></li>
              <jsp:include page="/menu">
                <jsp:param name="sect" value="${page1.id}"/>
              </jsp:include>
              <c:forEach var="page2" items="${result1}">
                <ul><a href=\?sect=<c:out value="${page1.id}"/>&subsect=<c:out value="${page2.id}"/>><c:out value="${page2.title4menu}"/></a></ul>
              </c:forEach>
            </c:forEach>

            <!--for (data.Page mpage : mpages) {
            menutext.append("<li><a href=\"PageControlPanel?email=");
                                    menutext.append(email);
                                    menutext.append("&sect=");
            menutext.append(mpage.getId());
            menutext.append("\">");
            menutext.append(mpage.getTitle4menu());
            menutext.append("</a>");
            List<Page> spages = service.getPagesByParent(mpage.getId());
              menutext.append("<ul>");
                if (mpage.getId().equals(section) || section == null) {
                for (data.Page spage : spages) {
                menutext.append("<li><a href=\"PageControlPanel?email=");
                                        menutext.append(email);
                                        menutext.append("&sect=");
                  menutext.append(mpage.getId());
                  menutext.append("&subsect=");
                  menutext.append(spage.getId());
                  menutext.append("\">");
                  menutext.append(spage.getTitle4menu());
                  menutext.append(" - ");
                  menutext.append(spage.getDate());
                  menutext.append(" - ");
                  menutext.append("</a></li>");
                }
                }
                menutext.append("</ul>");
              menutext.append("</li>");
            }
            menutext.append("</ul>");-->
          </td>
          <td width="60%" align="center">
            <!--<jsp:getProperty property="maintext" name="Page"/>-->
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