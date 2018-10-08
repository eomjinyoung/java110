<%@page import="bitcamp.java110.cms.domain.Teacher"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>강사 관리</title>
<link rel='stylesheet' href='../css/common.css'>
<style>
table, th, td {
    border: 1px solid gray;
}
</style>
</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>

<h1>강사 목록(MVC)</h1>
<p><a href='add'>추가</a></p>
<table>
<thead>
<tr>
    <th>번호</th><th>이름</th><th>이메일</th> <th>강의료</th><th>강의과목</th>
</tr>
</thead>
<tbody>

<jsp:useBean
    scope="request"
    id="list"
    class="java.util.ArrayList"
    type="java.util.List<bitcamp.java110.cms.domain.Teacher>"
/>
<%
for (Teacher t : list) {
    pageContext.setAttribute("t", t);
%>
<tr>
    <td>${t.no}</td>
    <td><a href='detail?no=${t.no}'>${t.name}</a></td>
    <td>${t.email}</td>
    <td>${t.pay}</td>
    <td>${t.subjects}</td>
</tr>
<%
}
%>

</tbody>
</table>

<jsp:include page="../footer.jsp"/>

</body>
</html>

    