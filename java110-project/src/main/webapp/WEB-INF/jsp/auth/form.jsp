<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>로그인</title>
<link rel='stylesheet' href='/css/common.css'>
<style>
th {
    text-align: right;
}
</style>
</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>

<h1>로그인</h1>

<form action='login' method='post'>
<table>
<tr>
    <th></th>
    <td>
        <input type='radio' name='type' value='student' checked>학생
        <input type='radio' name='type' value='teacher'>강사
        <input type='radio' name='type' value='manager'>매니저
    </td>
</tr>
<tr>
    <th>이메일</th>
    <td><input type='email' name='email' value='${cookie.email.value}'></td>
</tr>
<tr>
    <th>암호</th>
    <td><input type='password' name='password'></td>
</tr>
<tr>
    <th></th>
    <td><input type='checkbox' name='save'>이메일 저장</td>
</tr>
<tr>
    <th></th>
    <td><button>로그인</button></td>
</tr>
</table>
</form>

<jsp:include page="../footer.jsp"/>

</body>
</html>










    