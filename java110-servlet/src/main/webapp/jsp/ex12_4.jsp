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
<h1>jsp:useBean - type 속성</h1>
<pre>
- 지정한 타입의 객체가 보관소에 객체가 없으면 예외 발생! 객체를 만들지 않는다.       
    &lt;jsp:useBean 
        scope="request" 
        id="names1"
        type="java.util.ArrayList"/>
- 위의 태그는 다음과 같이 동작하는 자바 코드로 변환된다.
  자바 코드:
    java.util.ArrayList names1 = 
        (java.util.ArrayList)request.getAttribute("names1");
    if (names1 == null) {
        throw new Exception("해당 타입의 객체가 없다!");
    }
</pre>

<%
ArrayList<String> list1 = new ArrayList<>();
list1.add("홍길동");
list1.add("임꺽정");
list1.add("유관순");
request.setAttribute("names1", list1);
%>

<jsp:useBean    
    scope="request" 
    id="names1"
    type="java.util.ArrayList"/>

<p>names1.get(1): <%=names1.get(1)%></p>

<jsp:useBean    
    scope="request" 
    id="names2"
    type="java.util.ArrayList"/>

<%--  자바코드
java.util.ArrayList names2 = 
    (java.util.ArrayList)request.getAttribute("names2");
if (names2 == null) {
    throw new Exception("해당 타입의 객체가 없습니다");
}
 --%>
<p>names2.size(): <%=names2.size()%></p>


</body>
</html>








































