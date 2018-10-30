<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 관리</title>
<link rel='stylesheet' href='/css/common.css'>
<style>
th {
    text-align: right;
}
</style>
</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>

<h1>학생 등록(MVC)</h1>

<form action='add' method='post' enctype="multipart/form-data">
<table>
<tbody>
<tr>
    <th>이름</th>
    <td><input type='text' name='name'></td>
</tr>
<tr>
    <th>이메일</th>
    <td><input type='email' name='email'></td>
</tr>
<tr>
    <th>암호</th>
    <td><input type='password' name='password'></td>
</tr>
<tr>
    <th>전화</th>
    <td><input type="tel" name='tel'></td>
</tr>
<tr>
    <th>최종학교</th>
    <td><input type='text' name='school'></td>
</tr>
<tr>
    <th>재직여부</th>
    <td><select name='working'>
        <option value='false'>미취업</option>
        <option value='true'>재직중</option>
    </select></td>
</tr>
<tr>
    <th>사진</th>
    <td><input type='file' name='file1'></td>
</tr>
<tr>
    <th></th>
    <td><button>등록</button></td>
</tr>
</tbody>
</table>
</form>

<jsp:include page="../footer.jsp"/>

</body>
</html>
















    