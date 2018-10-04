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
<h1>jsp:useBean - type 속성과 class 속성 동시 사용하기</h1>
<pre>
- 지정한 타입의 객체가 보관소에 객체가 없으면 예외 발생! 객체를 만들지 않는다.       
    &lt;jsp:useBean 
        scope="request" 
        id="names1"
        type="java.util.List&lt;String>"
        class="java.util.ArrayList"/>
- 위의 태그는 다음과 같이 동작하는 자바 코드로 변환된다.
  자바 코드:
    java.util.List&lt;String> names1 = 
        (java.util.List&lt;String>)request.getAttribute("names1");
    if (names1 == null) {
        names1 = new ArrayList();
        request.setAttribute("names1", names1);
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
    type="java.util.List<String>"
    class="java.util.ArrayList"/>
    
<p>names1.get(2): <%=names1.get(2)%></p>


</body>
</html>








































