<%@page import="bitcamp.java110.cms.domain.Teacher"%>
<%@page import="bitcamp.java110.cms.domain.Manager"%>
<%@page import="bitcamp.java110.cms.domain.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<header>
    <h1>비트캠프</h1>
    <ul>
<%
Member loginUser = (Member)session.getAttribute("loginUser");
if (loginUser == null) {
%>
        <li><a href='/app/auth/login'>로그인</a></li>
<%
} else {
    String loginType = "학생";
    if (loginUser instanceof Manager) {
        loginType = "매니저";
    } else if (loginUser instanceof Teacher) {
        loginType = "강사";
    }
%>
        <li>[<%=loginType%>]<%=loginUser.getName()%>(<a href='/app/auth/logout'>로그아웃</a>)</li> 
<%
}
%>    
        <li><a href='/app/student/list'>학생관리</a></li>
        <li><a href='/app/teacher/list'>강사관리</a></li>
        <li><a href='/app/manager/list'>매니저관리</a></li>
    </ul>
</header>









