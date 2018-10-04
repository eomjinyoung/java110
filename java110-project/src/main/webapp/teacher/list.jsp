<%@page import="bitcamp.java110.cms.domain.Teacher"%>
<%@page import="java.util.List"%>
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
<%
List<Teacher> list = (List<Teacher>) request.getAttribute("list");
for (Teacher t : list) {
%>
<tr>
    <td><%=t.getNo()%></td>
    <td><a href='detail?no=<%=t.getNo()%>'><%=t.getName()%></a></td>
    <td><%=t.getEmail()%></td>
    <td><%=t.getPay()%></td>
    <td><%=t.getSubjects()%></td>
</tr>
<%
}
%>

</tbody>
</table>

<jsp:include page="../footer.jsp"/>

</body>
</html>

    