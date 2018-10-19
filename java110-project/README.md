# java110-project

## v6.0

- Mybatis와 Spring IoC 컨테이너 연동
- 작업
    - mybatis-spring 연동 라이브러리 가져오기
        - mvnrepository.com에서 'mybatis-spring' 검색
        - build.gradle 에 라이브러리 정보 등록
        - 'gradle eclipse' 실행
        - 이클립스 프로젝트 리프래시
    - mybatis-spring 문서 참고하여 스프링 설정하기
        - mybatis.org 사이트 => github.com => spring 저장소 => 문서
        - 즐겨 찾기에 등록
    - jdbc.properties 파일 로딩
        - @PropertySource 애노테이션 사용
    - DataSource 객체 준비
        - apache common-dbcp 라이브러리 추가
        - DataSource 객체 생성 메서드 추가
    - SqlSessionFactory 객체 생성
        - XML 기반 mybatis 설정을 스프링 Java Config로 대체한다.
        - mybatis-spring 라이브러리에서 제공하는 SqlSessionFactoryBean 을 사용한다.
        - 의존 라이브러리 spring-jdbc를 추가해야 한다.
        
## v5.9

- Spring IoC 컨테이너 적용
- 작업
    - Spring IoC 컨테이너 라이브러리 추가
    - ContextLoaderListener 변경
    - Service와 DAO를 Spring IoC 컨테이너에서 관리하도록 변경

## v5.8

- Mybatis에서 자동으로 생성해주는 Mapper(DAO) 객체 사용하기
- Mybatis에서 트랜잭션 다루기
- 작업
    - 기존 DAO 구현체를 모두 제거한다.
    - Service 객체에 SqlSessionFactory를 주입한다.
    - Service 객체는 SqlSessionFactory를 통해 DAO를 얻어 쓴다.
    - insert, delete 메서드에 트랜잭션을 적용한다.
    - ContextLoaderListener 변경

## v5.7

- Mybatis persistence framework 적용하기
- 작업
    - build.gradle에 mybatis 라이브러리 등록
    - 'gradle eclipse' 실행
    - 이클립스 프로젝트 리프래시
    - DAO, Service, Servlet 변경
    - ContextLoaderListener 변경

## v5.6

- Statement를 PreparedStatement로 변경하기
    - SQL 삽입 해킹을 방지하기
- 작업
    - 로그인 방어막을 뚫기를 통해 보안 문제 확인
    - DAO의 모든 SQL문을 PreparedStatement로 교체한다.

## v5.5

- 트랜잭션 관리하기
- 작업
    - 트랜잭션을 위해 DataSource의 Connection을 관리하는 클래스를 작성한다.
    - DataSource는 트랜잭션을 사용할 때와 아닐 때를 다룬다.
    - 서비스 객체에 트랜잭션 관리자를 적용한다.

## java110-project (tag: v5.4)

- Service 컴포넌트 적용
    - Servlet이나 DAO에 있는 업무 로직을 별도의 클래스로 분리한다.
    - 고객사 마다 업무 로직을 달리할 수 있도록 구조를 변경한다.
- 작업
    - 업무 로직에 대한 규칙을 인터페이스로 정의한다.
    - 서비스 컴포넌트의 규칙을 준수하는 클래스를 작성한다.

## v5.3

- 파일 업로드 적용
- 작업
    - DB 테이블에 사진 파일명을 저장할 컬럼을 추가한다.
    - DAO 변경
    - 서블릿 변경
    - 입력폼 변경

## v5.2

- JSTL 적용
- 작업
    - JSP 파일에 JSTL 태그를 적용한다.

## v5.1

- EL 적용
- 작업
    - JSP 파일에 EL 문법을 적용한다.

## v5.0

- JSP 액션 태그 적용
- 작업
    - JSP 파일에 JSP 액션 태그를 적용한다.

## v4.9

- JSP를 활용한 MVC 모델 1 타입 적용
- Servlet + JSP를 활용한 MVC 모델 2 타입 적용
- MVC type 1 작업
    - /webapp/mvc1/manager/list.jsp 생성
    - /webapp/mvc1/header.jsp 생성
    - /webapp/mvc1/footer.jsp 생성
- MVC type 2 작업
    - /webapp/manager/list.jsp 생성
    - ManagerListServlet 변경
       
## v4.8

- 필터를 이용하여 사용 권한 제어하기
- 작업
    - AuthFilter 클래스를 생성하여 등록한다.
    - 로그인 사용자만 add와 delete 할 수 있도록 제어한다.

## v4.7

- 세션 적용하기
- 작업
    - 로그인 후 회원 정보를 세션에 보관한다.
    - 페이지 헤더에 로그인 사용자의 이름을 출력한다.
        - 로그아웃 링크도 출력한다.
    - 로그인 되어 있지 않을 경우, 로그인 링크를 출력한다.
    - 로그아웃 기능을 추가한다.

## v4.6

- 쿠키 적용하기
- 작업
    - 로그인 폼을 작성한다.
    - 아이디 저장 기능을 쿠키로 구현한다.

## v4.5, v4.5.1

- 포워드, 인클루드 적용하기
- 작업
    - 여러 서블릿에서 공통으로 수행하는 작업을 별도의 서블릿으로 분리한다.
    - 그 서블릿으로 포워드를 수행한다.
    - 예1) ErrorServlet 클래스 생성하고 포워드를 적용한다.
    - 예2) HeaderServlet, FooterServlet 클래스를 생성하고 인클루드를 적용한다.

## v4.4

- 리프래시, 리다이렉트 적용하기
- 작업
    - 등록, 삭제한 후에 목록 페이지를 자동으로 요청하도록 리프래시 적용

## v4.3

- HTML 출력하기
- 작업
    - 서블릿의 출력 콘텐트를 일반 텍스트에서 HTML로 바꾼다.

## v4.2

- 리스너를 이용하여 공용 자원을 준비하기
- 작업
    - ContextLoaderListener 클래스 생성
    - 이 리스너에서 DAO 준비하기

## v4.1

- 서블릿의 loadOnStartup 배치 속성을 이용하여 공용 자원을 준비하기
- ServletContext를 이용하여 공용자원을 공유하기
- 작업
    - InitServlet 클래스 생성 
    - InitServlet에서 DAO와 DataSource 준비하기
    - ServletContext에 DAO 보관하기

## v4.0

- 서블릿 기술을 적용하여 서버 애플리케이션 만들기
- 작업
    - 클라이언트 요청을 처리하는 컨트롤러를 서블릿으로 전환한다.

## v3.1 

- 웹서버를 중계 서버로 사용하기
- 서블릿 컨테이너 적용
    - 톰캣 서버 설치
    - build.gradle 에 servlet-api 라이브러리 추가 


## v3.0

- 웹브라우저를 클라이언트로 사용하기
- 서버에 HTTP 프로토콜을 처리하는 기능 추가
- ServerApp 클래스를 HTTP 프로토콜 요청과 응답을 처리하는 방식으로 변경한다.

## v2.9 

- Command 패턴으로 분할된 메서드를 한 클래스로 합치기
- 관련된 컨트롤러 클래스를 한 클래스로 만든다.
    - ManagerListController, ManagerAddController, ManagerDetailController, ManagerDeleteController 클래스를 ManagerController 클래스로 합친다.
    - 학생 관리와 강사 관리도 마찬가지이다.
    - 각각의 컨트롤러가 크지 않을 때는 관리하기 쉽게 한 클래스로 합치기도 한다.

## v2.8 (Stateless)

- 멀티스레드 적용하기(Connection-Oriented에서 Stateless 방식으로 요청 처리)

## v2.7 (Stateful)

- 멀티스레드 적용하기(Connection-Oriented에서 Stateful 방식으로 요청 처리)
- 별도의 스레드를 만들어 클라이언트의 요청을 처리하게 한다.
- 즉 동시에 여러 클라이언트 요청을 처리한다.

## v2.6

- Client/Server 구조로 변경
- 소켓 프로그래밍 구현
- 프로토콜 개념 이해

## v2.5

- Spring IoC 컨테이너 도입
- 기존에 만들었던 ApplicationContext 대신에 Spring 프레임워크에서 제공하는 ApplicationContext 사용하기
- 작업
    - Spring IoC 컨테이너 라이브러리 추가(build.gradle 파일 편집)
        - "spring context" 로 mvnrepository.com에서 검색한다.
        - 명령창에서 "gradle eclipse" 실행한다.
        - 이클립스에서 프로젝트를 "refresh" 한다.
    - 스프링 설정 파일 추가(application-context.xml)
        - bitcamp/java110/cms/conf/application-context.xml
    - 기존의 ApplicationContext 관련 클래스들을 제거한다.
    - 기존의 @Autowired, @Component 애노테이션을 제거한다.
    - 기존 클래스에서 사용한 애노테이션을 Spring 프레임워크에서 제공하는 것으로 바꾼다.

## v2.4

- DB 커넥션 공유하기
- DB 연결 객체를 재사용하여 가비지를 줄이고, 실행 속도를 높이기 위함

## v2.3

- DAO에 JDBC 적용
- 작업 
    - Data Modeling과 forward engineering 수행
    - 테이블 준비
    - JDBC API 활용
    - 트랜잭션 다루기

## v2.2

- 예외처리 적용
- 예외처리 문법이 없던 시절
    - 리턴 값으로 예외 상황을 호출자에게 알렸다.
    - 특정 타입의 값을 리턴하는 경우 이 방법을 쓰기 곤란하다.
- 예외처리 문법이 등장
    - 리턴 값이 아닌 별도의 경로로 예외 상황을 호출자에게 알린다.
    - 이전 방식에 비해 메서드의 리턴 타입에 영향을 받지 않는다.
    - 예외 상황을 자세하게 호출자에게 알릴 수 있다.

## v2.1

- 객체 Serialize/Deserialize 적용
- java.io.Serializable 인터페이스 활용
- transient modifier 사용법

## v2.0

- DAO에 파일 입출력 도입
- DAO에 인터페이스 적용
- 작업
    - DAO에 데이터를 파일로 저장하고 읽는 기능 추가
    
## java110-project (tag: v1.9)

- IoC 컨테이너가 객체 생성 후에 수행하는 작업을 별도의 클래스로 분리한다.
- 향후 객체 생성 후에 또 다른 작업을 추가하기 쉽도록 한다.
- 작업 
    - 객체 생성 후에 수행할 작업 별도의 클래스로 분리한다.
    

## v1.8

- 의존 객체 주입하기 
- 미니 IoC 컨테이너 개선
- 작업
    - 의존 객체를 주입 받을 수 있도록 setter를 준비한다.
    - IoC 컨테이너가 setter를 자동으로 호출하도록 애노테이션으로 표시한다.

## v1.7

- DAO(Data Access Object) 도입하기
    - 데이터를 저장하는 방식이 바뀌더라도 기존 클래스에 영향을 주지 않게 하려면, 데이터를 다루는 부분을 List가 아니라 별도의 클래스로 정의해야 한다.
    - 즉 List를 통해 데이터를 메모리에 저장하는 대신에 파일이나 데이터베이스에 저장한다면 기존 코드를 변경해야 하는 문제가 있다. 
    - 이 부분을 해결하기 위함이다.
- 작업
    - 학생관리, 강사관리, 매니저관리 각각에 사용할 DAO 클래스를 정의한다.

## v1.6

- Command 디자인 패턴 적용
- 컨트롤러 구조 변경
- 작업
    - 컨트롤러에서 명령을 처리하는 각각의 메서드를 별도의 클래스로 분리한다.
    
## v1.5

- 리플렉션 API 활용 II
- 애노테이션 활용
- 미니 IoC 컨테이너 개선
- 작업
    - 자동으로 생성되어야 할 객체에 붙일 애노테이션 정의
    - 컨트롤러 객체에 애노테이션 적용
    - 애노테이션이 붙은 클래스만 객체를 생성 

## v1.4

- 리플렉션 API 활용
- File 클래스로 디렉토리 및 파일 다루기
- 미니 IoC 컨테이너 작성

## v1.3

- 인터페이스 활용
- App 클래스와 Controller 들 사이의 호출규칙(사용규칙)을 인터페이스로 정의한다.

## v1.2

- 자바 컬렉션 API 사용
- 직접 제작한 List, ArrayList, LinkedList 대신에 자바에서 제공하는 Collection API를 사용한다.

## v1.1

- 인터페이스 적용
- 의존 객체 주입(Dependency Injection; DI) 적용
- 데이터 목록을 다룰 때 호출하는 메서드의 규칙을 정의한다.
    - 다양한 방법으로 구현한 객체를 사용할 수 있다.
    - 즉 규칙을 따르기만 한다면 어떤 객체라도 대체할 수 있다.
- 인터페이스의 default 메서드의 활용

## v1.0

- LinkedList 구동 원리 및 적용

## v0.9

- 제네릭 활용법
- ArrayList에 제네릭 적용하기

## v0.8

- 목록을 다루는 클래스들을 리팩토링하기
- 다형적 변수의 활용법
- 클래스 멤버(변수,메서드,블록)와 인스턴스 멤버의 차이점
- 생성자 사용
- StudentList, ManagerList, TeacherList 클래스를 한 클래스로 합친다.
- 다형적 변수를 사용하여 Student,Manager,Teacher 객체를 모두 저장할 수 있게 한다.

## tag: v0.7

수업 관리 시스템 만들기

- 목록 다루기
- 배열에 항목을 추가하고 삭제하는 기능을 추가한다.
- 배열의 값 목록을 다루는 기능을 별도의 클래스로 분리한다.

## tag: v0.6

- 패키지 활용 및 클래스의 접근 범위

## tag: v0.5

- 조건문, 반복문, 메서드 활용
- 강사, 학생, 매니저를 구분하여 입력받고 출력한다.

## v0.4

- 여러 속성의 값을 다루기 쉽도록 클래스를 이용하여 사용자 정의 데이터 타입을 만든다. 또한 그 데이터를 다룰 연산자를 정의한다.

## v0.3

- 관련된 명령들을 재사용하기 쉽도록 메서드 블록으로 묶는다.

## v0.2

- 배열을 이용하여 여러 회원의 정보를 저장하기

## v0.1

- 반복문을 이용하여 여러 회원의 정보를 입력 받아 출력하기
- 작업
    - App.java 변경

## Initial Commit 

- 자바 프로젝트 디렉토리 구성하기

```
1) 자바 프로젝트 디렉토리 구성하기
$ gradle init --type java-application

2) Gradle 설정 파일에 'eclipse' 플러그인 추가
build.gradle 파일에 id 'eclipse' 추가

3) 이클립스 설정 파일 생성
$ gradle eclipse

4) 이클립스에서 프로젝트를 임포트
```