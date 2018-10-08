<%@page import="bitcamp.java110.cms.domain.Student"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생 관리</title>
<link rel='stylesheet' href='../css/common.css'>
<style>
table, th, td {
    border: 1px solid gray;
}
</style>
</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>

<h1>학생 상세정보(MVC)</h1>

<jsp:useBean
    scope="request"
    id="student"
    class="bitcamp.java110.cms.domain.Student"
/>
<%
if (student == null) {
%>
<p>해당 번호의 학생이 없습니다!</p>
<%    
} else {
%>
<table>
<tbody>
<tr><th>번호</th><td><%=student.getNo()%></td></tr>
<tr><th>이름</th><td><%=student.getName()%></td></tr>
<tr><th>이메일</th><td><%=student.getEmail()%></td></tr>
<tr><th>암호</th><td><%=student.getPassword()%></td></tr>
<tr><th>전화</th><td><%=student.getTel()%></td></tr>
<tr><th>최종학교</th><td><%=student.getSchool()%></td></tr>
<tr><th>재직여부</th><td><%=student.isWorking()%></td></tr>
</tbody>
</table>
<button type='button' onclick='remove()'>삭제</button>
<script>
function remove() {
    location.href = 'delete?no=<%=student.getNo()%>'
}
</script>
<%
}
%>

<jsp:include page="../footer.jsp"/>

</body>
</html>

    