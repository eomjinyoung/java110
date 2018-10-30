<%@page import="java.io.PrintWriter"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>실행 오류</title>
<link rel='stylesheet' href='/css/common.css'>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<%
String message = (String)request.getAttribute("message");
Exception error = (Exception)request.getAttribute("error");
%>
<h1>JSP:<%=message%></h1>
<p><%=error.getMessage()%></p>
<pre>
<%
error.printStackTrace(new PrintWriter(out));
%>
</pre>

<jsp:include page="footer.jsp"/>

</body>
</html>
    