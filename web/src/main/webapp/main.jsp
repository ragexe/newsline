<%--
  Created by IntelliJ IDEA.
  User: ragexe
  Date: 16.05.2015
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<!DOCTYPE html>
<%--<jsp:useBean id="page" class="data.Page" scope="request"/>--%>
<jsp:useBean id="user" class="data.User" scope="session"/>
<%--<jsp:useBean id="Category" class="data.Category" scope="request"/>--%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html lang="ru">
<head>

  <%--<jsp:include page="/page">--%>
  <%--<jsp:param name="sect" value="${param.sect}"/>--%>
  <%--<jsp:param name="subsect" value="${param.subsect}"/>--%>
  <%--</jsp:include>--%>
  <fmt:requestEncoding value="UTF-8"/>
  <jsp:include page="common/styles-common.jsp"/>
  <jsp:include page="common/navipanel.jsp"/>
  <!-- Заголовок страницы -->
  <title>
    <%--<jsp:getProperty name="pageBean" property="title"/>--%>
  </title>
</head>

<body>
<%--Header--%>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="page-header">
      <div class="row">
        <div class="col-lg-12">
          <h1>News</h1>
        </div>
      </div>
    </div>
  </div>

  <div class="row-fluid">
    <div class="col-lg-2">
      <!--Sidebar content-->
      <div class="panel panel-default">
        <div class="panel-heading">Категории</div>
        <div class="panel-body">
          <%--<jsp:include page="/menu">--%>
          <%--<jsp:param name="sect" value="0"/>--%>
          <%--</jsp:include>--%>
          <%--<ul>--%>
          <%--<core:forEach var="page1" items="${result}">--%>
          <%--<li><a href=/main.jsp?sect=<core:out value="${page1.id}" /> class="btn btn-link"><core:out value="${page1.title4menu}"/></a></li>--%>
          <%--&lt;%&ndash;<core:if test="${param.sect.equals(page1.id)}">&ndash;%&gt;--%>
          <%--<core:if test="${param.sect == page1.id}">--%>
          <%--<jsp:include page="/menu">--%>
          <%--<jsp:param name="sect" value="${page1.id}"/>--%>
          <%--</jsp:include>--%>
          <%--<ul>--%>
          <%--<core:forEach var="page2" items="${result}">--%>
          <%--<li><a href=/main.jsp?sect=<core:out value="${page1.id}" />&subsect=<core:out value="${page2.id}"/> class="btn btn-link"><core:out value="${page2.title4menu}"/></a></li>--%>
          <%--</core:forEach>--%>
          <%--</ul>--%>
          <%--</core:if>--%>
          <%--</core:forEach>--%>
          <%--<core:if test="${sessionScope.login != null}">--%>
          <%--<li><a href="add.jsp" class="btn btn-link">+ Добавить новость</a></li>--%>
          <%--</core:if>--%>
          <jsp:include page="/menu"/>
          <ul>
            <core:forEach var="page1" items="${result}">
              <li><a href=/main.jsp?sect=<core:out value="${page1.id}" /> class="btn btn-link"><core:out value="${page1.title4menu}"/></a></li>
            </core:forEach>
          </ul>




            <table border="1" cellpadding="5" cellspacing="5">
              <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Date</th>
              </tr>

              <c:forEach var="employee" items="${employeeList}">
                <tr>
                  <td>${employee.employeeId}</td>
                  <td>${employee.employeeName}</td>
                  <td>${employee.salary}</td>
                  <td>${employee.deptName}</td>
                </tr>
              </c:forEach>
            </table>

            <%--For displaying Previous link except for the 1st page --%>
            <c:if test="${currentPage != 1}">
              <td><a href="employee.do?page=${currentPage - 1}">Previous</a></td>
            </c:if>

            <%--For displaying Page numbers.
            The when condition does not display a link for the current page--%>
            <table border="1" cellpadding="5" cellspacing="5">
              <tr>
                <c:forEach begin="1" end="${noOfPages}" var="i">
                  <c:choose>
                    <c:when test="${currentPage eq i}">
                      <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                      <td><a href="employee.do?page=${i}">${i}</a></td>
                    </c:otherwise>
                  </c:choose>
                </c:forEach>
              </tr>
            </table>

            <%--For displaying Next link --%>
            <c:if test="${currentPage lt noOfPages}">
              <td><a href="employee.do?page=${currentPage + 1}">Next</a></td>
            </c:if>








        </div>
      </div>
    </div>
    <div class="col-lg-10">
      <!--Body content-->


      <%--<h2><p class="text-info"><jsp:getProperty name="pageBean" property="title"/></p></h2>--%>
      <%--<p><jsp:getProperty name="pageBean" property="maintext"/></p>--%>
      <%--<br><p class="text-warning" align="right"><i>--%>
      <%--<jsp:getProperty name="pageBean" property="date"/> - <jsp:getProperty name="pageBean" property="author"/></i></p>--%>


      <%--<jsp:include page="/page">--%>
      <%--&lt;%&ndash;<jsp:param name="sect" value="${param.sect}"/>&ndash;%&gt;--%>
      <%--</jsp:include>--%>
      <%--<core:forEach var="page2" items="${resulty}">--%>
      <%--&lt;%&ndash;<li><a href=/main.jsp?sect=<core:out value="${page2.id}" /> class="btn btn-link"><core:out value="${page2.title4menu}"/></a></li>&ndash;%&gt;--%>
      <%--<core:out value="${page2.title}"/>--%>
      <%--</core:forEach>--%>

      <jsp:include page="/test">
        <jsp:param name="sect" value="${param.sect}"/>
      </jsp:include>
      <core:forEach var="hoboct" items="${page}">
        <h1><core:out value="${hoboct.title}"/></h1>
        <blockquote>
          <p><core:out value="${hoboct.maintext}"/><br></p>
          <small>author - <core:out value="${hoboct.date}"/></small>
        </blockquote>
        
      </core:forEach>
      <%--<core:out value="${category}"/>--%>







      <%--<p class="text-warning"> <fmt:formatDate type="both"--%>
      <%--dateStyle="long" timeStyle="long"--%>
      <%--value="${pageBean.date}" /></p>--%>
    </div>
  </div>
</div>
</body>
</html>