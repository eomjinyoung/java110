# Mybatis persistence framework

## 라이브러리 준비
- mvnrepository.com 에서 'mybatis'로 검색한다.
- build.gradle에 mybatis 의존 라이브러리를 추가한다.
- 콘솔에서 'gradle eclipse' 실행한다.
- 이클립스에서 프로젝트를 리프래시 한다.

## mybatis 적용
- SqlSessionFactory 객체 준비
    - 'Getting started' 문서에서 코드 발췌하여 자바 소스 파일에 둔다.
- Mybatis 설정 파일 준비
    - 'Getting started' 문서에서 코드를 발췌한다.
    - mybatis-config.xml(이름 변경 가능) 설정 파일에 붙여 넣는다.
- Sql 맵퍼 파일 준비
    - 'Getting started' 문서를 참조하여 SQL 맵퍼 파일을 만든다.
    - MemberDao.xml 파일 생성
- Dao에 적용
