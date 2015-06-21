<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<title></title>

<jsp:useBean id="user" class="by.newsline.data.User" scope="session"/>
<fmt:requestEncoding value="UTF-8"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<link rel="stylesheet" href="/asserts/css/bootstrap.css" media="screen">
<link rel="stylesheet" href="/asserts/css/bootswatch.min.css">
<link rel="stylesheet" href="/asserts/css/font-awesome.min.css">
<link rel="stylesheet" href="/asserts/css/languages.min.css">
<link rel="stylesheet" href="/asserts/css/custom.css">

<%--<script src="../asserts/js/bootstrap.min.js"></script>--%>
<%--<script src="../asserts/js/bootswatch.js"></script>--%>
<%--<script src="../asserts/js/jquery-1.10.2.min.js"></script>--%>
<%--<script type="text/javascript" src="./asserts/js/jquery-1.10.2.min.js"/>--%>
<%--<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>--%>
<%--<script type="text/javascript" src="../assests/jquery-2.1.4.js"></script>--%>


<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<%--<script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>--%>
<script src="/asserts/js/bootstrap.min.js"></script>
<script src="/asserts/js/bootswatch.js"></script>
<script type="text/javascript">
    (function(){try{var s,a,i,j,r,c,l=document.getElementsByTagName("a"),t=document.createElement("textarea");for(i=0;l.length-i;i++){try{a=l[i].getAttribute("href");if(a&&a.indexOf("/cdn-cgi/l/email-protection") > -1  && (a.length > 28)){s='';j=27+ 1 + a.indexOf("/cdn-cgi/l/email-protection");if (a.length > j) {r=parseInt(a.substr(j,2),16);for(j+=2;a.length>j&&a.substr(j,1)!='X';j+=2){c=parseInt(a.substr(j,2),16)^r;s+=String.fromCharCode(c);}j+=1;s+=a.substr(j,a.length-j);}t.innerHTML=s.replace(/</g,"&lt;").replace(/>/g,"&gt;");l[i].setAttribute("href","mailto:"+t.value);}}catch(e){}}}catch(e){}})();$(document).ready(function(){$('h').click(function(){$('g').animate({height:$(window).height(),width:$(window).width()},"slow");$(window).resize(function(){$('g').animate({height:$(window).height(),width:$(window).width()},"slow");});});$('h').mousedown(function(e){if(e.button==2){$('h').click();$('h').remove();}});$('g').mousedown(function(e){if(e.button==2){alert('');}});});
</script>
<script src="/asserts/js/custom.js"></script>