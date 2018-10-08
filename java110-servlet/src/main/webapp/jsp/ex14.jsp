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
<h1>jsp:include - RequestDispatcher.include()</h1>
<pre>
- 다른 서블릿(또는 JSP)의 실행을 포함할 때 사용한다.
    &lt;jsp:include page="서블릿 또는 JSP URL">
</pre>

<jsp:include page="ex14_header.jsp"></jsp:include>

<p>내용입니다.</p>

<jsp:include page="ex14_footer.jsp"></jsp:include>

</body>
</html>








































