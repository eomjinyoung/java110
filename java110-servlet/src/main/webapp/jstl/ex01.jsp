<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h1>JSTL 개요</h1>
<pre>
- JSTL(JSP Standard Tag Library)? 
  - JSP 확장 태그이다.
  - 기본으로 제공하지 않는다.
  - JSTL API를 구현한 외부 라이브러리를 가져와서 사용해야 한다.
- JSTL 라이브러리 가져오기
  - mvnrepository.com 에서 JSTL 검색하여 라이브러리를 정보를 알아낸다.
  - build.gradle 파일의 dependencies {} 블록에 추가한다.
  - 'gradle eclipse' 실행하여 이클립스 설정 파일을 갱신한다.
  - 이클립스 프로젝트를 리프래시 한다.
- JSTL 라이브러리 모듈
  - Core(c) : http://java.sun.com/jsp/jstl/core
  - XML(x) : http://java.sun.com/jsp/jstl/xml
  - I18N(fmt) : http://java.sun.com/jsp/jstl/fmt
  - Database(sql) : http://java.sun.com/jsp/jstl/sql
  - Functions(fn) : http://java.sun.com/jsp/jstl/functions
- JSP 페이지에서 JSTL 라이브러리의 모듈 사용하기
  - JSTL 모듈의 네임스페이스를 가져온다.
      &lt;%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  - JSTL 태그 사용
      &lt;접두어명:태그명 속성="값" 속성="값"/> 
</pre>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:out value="<h2>오호라!!!<h2>"/>

</body>
</html>












