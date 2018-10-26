<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Test26 - 7 페이지</h1>

이름: ${sessionScope.name}<br>
나이: ${sessionScope.age}<br>
강사여부: ${sessionScope.teacher}<br>
과목: 
<c:forEach items="${sessionScope.language}" var="lang">
    ${lang},
</c:forEach>
<br>
성별: ${sessionScope.gender}<br>

<p>
<a href="m8">세션 무효화시키기</a>
</p>

</body>
</html>










