<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>매니저 관리</title>
<link rel='stylesheet' href='../css/common.css'>
<style>
table, th, td {
    border: 1px solid gray;
}
#photo-image {
    height: 100px;
}
</style>
</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>

<h1>매니저 상세정보(MVC)</h1>

<table>
<tbody>
<tr><th>번호</th><td>${manager.no}</td></tr>
<tr><th>이름</th><td>${manager.name}</td></tr>
<tr><th>이메일</th><td>${manager.email}</td></tr>
<tr><th>암호</th><td>${manager.password}</td></tr>
<tr><th>전화</th><td>${manager.tel}</td></tr>
<tr><th>직위</th><td>${manager.position}</td></tr>
<tr>
    <th>사진</th>
<c:choose>
<c:when test="${not empty manager.photo}">
    <td><img id='photo-image' src='/upload/${manager.photo}'></td>
</c:when>
<c:otherwise>
    <td><img id='photo-image' src='/img/anonymous.png'></td>
</c:otherwise>
</c:choose>
</tr>
</tbody>
</table>
<button type='button' onclick='remove()'>삭제</button>
<script>
function remove() {
    location.href = 'delete?no=${manager.no}'
}
</script>

<jsp:include page="../footer.jsp"/>

</body>
</html>
    