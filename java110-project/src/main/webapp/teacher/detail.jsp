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

<h1>강사 상세정보(MVC)</h1>

<jsp:useBean
    scope="request"
    id="teacher"
    class="bitcamp.java110.cms.domain.Teacher"
/>

<%
if (teacher == null) {
%>
<p>해당 번호의 강사가 없습니다!</p>
<%    
} else {
%>
<table>
<tbody>
<tr><th>번호</th><td><%=teacher.getNo()%></td></tr>
<tr><th>이름</th><td><%=teacher.getName()%></td></tr>
<tr><th>이메일</th><td><%=teacher.getEmail()%></td></tr>
<tr><th>암호</th><td><%=teacher.getPassword()%></td></tr>
<tr><th>전화</th><td><%=teacher.getTel()%></td></tr>
<tr><th>강의료</th><td><%=teacher.getPay()%></td></tr>
<tr><th>강의과목</th><td><%=teacher.getSubjects()%></td></tr>
</tbody>
</table>
<button type='button' onclick='remove()'>삭제</button>
<script>
function remove() {
    location.href = 'delete?no=<%=teacher.getNo()%>'
}
</script>
<%
}
%>

<jsp:include page="../footer.jsp"/>

</body>
</html>


    