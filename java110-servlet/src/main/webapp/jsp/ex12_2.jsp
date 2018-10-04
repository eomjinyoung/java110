<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP액션태그</title>
</head>
<body>
<h1>jsp:useBean - scope의 기본 값은 page이다.</h1>
<%
request.setAttribute("name", "유관순");//ServletRequest 보관소
//pageContext.setAttribute("name", "안중근");//PageContext 보관소
%>

<jsp:useBean    
    id="name"
    class="java.lang.String"/>

<p>이름: <%=name%></p>

</body>
</html>








































