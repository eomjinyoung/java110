<%@page import="bitcamp.java110.cms.domain.Student"%>
<%@page import="java.util.List"%>
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

<h1>학생 목록(MVC)</h1>
<p><a href='add'>추가</a></p>
<table>
<thead>
<tr>
    <th>번호</th><th>이름</th><th>이메일</th> <th>최종학교</th><th>재직여부</th>
</tr>
</thead>
<tbody>
<%
List<Student> list = (List<Student>) request.getAttribute("list");
for (Student s : list) {
%>
<tr>
    <td><%=s.getNo()%></td>
    <td><a href='detail?no=<%=s.getNo()%>'><%=s.getName()%></a></td>
    <td><%=s.getEmail()%></td>
    <td><%=s.getSchool()%></td>
    <td><%=s.isWorking()%></td>
</tr>
<%
}
%>

</tbody>
</table>

<jsp:include page="../footer.jsp"/>

</body>
</html>

    
    
    
    
    
    
    
    
    
    
    
    
    