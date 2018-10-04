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
<h1>jsp:setProperty - 객체의 셋터 호출하기</h1>

<jsp:useBean    
    scope="request" 
    id="m1"
    class="bitcamp.java110.Member"/>
 
<jsp:setProperty name="m1" property="no" value="100"/>
<jsp:setProperty name="m1" property="name" value="홍길동"/>
<jsp:setProperty name="m1" property="email" value="hong@test.com"/>
<jsp:setProperty name="m1" property="tel" value="1111-2222"/>
   
<p>
번호:<%=m1.getNo()%>, ${m1.no}<br>
이름:<%=m1.getName()%>, ${m1.name}<br>
이메일:<%=m1.getEmail()%>, ${m1.email}<br>
전화:<%=m1.getTel()%>, ${m1.tel}<br>
</p>


</body>
</html>








































