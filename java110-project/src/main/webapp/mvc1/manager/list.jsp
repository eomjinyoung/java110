<%@page import="bitcamp.java110.cms.domain.Manager"%>
<%@page import="java.util.List"%>
<%@page import="bitcamp.java110.cms.dao.ManagerDao"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>매니저 관리</title>
<link rel='stylesheet' href='../../css/common.css'>
<style>
table, th, td {
    border: 1px solid gray;
}
</style>
</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>

<h1>매니저 목록</h1>
<p><a href='form.html'>추가</a></p>
<table>
<thead>
<tr>
    <th>번호</th> <th>이름</th> <th>이메일</th> <th>직위</th>
</tr>
</thead>
<tbody>
<%
ManagerDao managerDao = (ManagerDao)this.getServletContext()
.getAttribute("managerDao");
List<Manager> list = managerDao.findAll();
for (Manager m : list) {
%>
<tr>
    <td><%=m.getNo()%></td>
    <td><a href='detail?no=<%=m.getNo()%>'><%=m.getName()%></a></td>
    <td><%=m.getEmail()%></td>
    <td><%=m.getPosition()%></td>
</tr>
<%
}
%>

</tbody>
</table>

<jsp:include page="../footer.jsp"/>

</body>
</html>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    