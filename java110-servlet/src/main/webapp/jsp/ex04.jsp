<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>스크립트릿(scriptlet) 응용</h1>
<% // _jspService() 메서드 안에 자바코드를 작성한다는 것을 절대 잊지말자!
String[] names = {"홍길동", "임꺽정", "유관순"};
%>

<ul>
<%for (String name : names) { %>
    <li><%out.write(name);%></li>
<%} %>
</ul>


 
</body>
</html>












