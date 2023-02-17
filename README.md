# 자바 ECO 스터디 저장소

자바 환경의 웹 어플리케이션 개발을 위해 학습했던 예제 코드들을 정리해놓은 저장소 입니다.

- **Backend** : 자바를 베이스로 하는 웹 어플리케이션 개발 지식
- **Deploy and Infrastructure** : 형상관리와 배포 관리, 어플리케이션 실행 환경 구성

## Backend

| 분야            | 이름            | 주제                     | 내용                                                                |
| --------------- | --------------- | ------------------------ | ------------------------------------------------------------------- |
| Language        | Java            | 프로그래밍 기초          | 자바, OOP, 스레딩, I/O                                              |
| Framework       | Spring 5        | Spring Framework Core    | AOP, DI, Bean Lifecycle, Interceptor, Validation, Logging, MVC, JSP |
| Web Application | Spring Boot     | Spring Boot 기본         | Web Backend Architecture, Multipart, RestController                 |
| Web Application | Spring Security | Session, Token, OAuth2   | Payload 커스터마이징, JWT 인증/인가, 세션 인증, OAuth2 인증         |
| Concurrent      | Spring WebFlux  | Async, Non-Blocking      | Spring의 비동기 처리                                                |
| Message Broker  | Kafka           | Pub-sub, Messaging Queue | Publisher-Subscriber 패턴, Publishing, Listening                    |
| Database        | Mapper          | Database Mapper          | Spring Data JDBC, MyBatis, 동적 쿼리                                |
| Database        | ORM             | JPA                      | Spring Data JPA                                                     |
| Database        | NoSQL           | Redis                    | k-v 데이터베이스 CRUD, RedisTemplate, Spring Data Redis (Lecttuce)  |
| Database        | NoSQL           | MongoDB                  | Document 데이터베이스 CRUD, MongoTemplate, Spring Data MongoDB      |

## Deploy and Infrastructure

| 분야  | 이름           | 주제                | 내용                                |
| ----- | -------------- | ------------------- | ----------------------------------- |
| Cloud | Container      | Docker              | Dockerfile, docker-compose          |
| SCM   | git            | git, GitHub, GitLab | 소프트웨어 형상 관리 및 브랜치 관리 |
| CI/CD | JUnit          | 테스트 코드         | 테스트 주도 개발                    |
| CI/CD | GitHub Actions | 어플리케이션 배포   | 어플리케이션 빌드 및 배포 자동화    |

<!--# 웹 개발자가 되기 위한 나의 로드맵

## 로드맵

| 기간                | 주제              | 내용                                                                                                     |
| ------------------- | ----------------- | -------------------------------------------------------------------------------------------------------- |
| 2022.08~            | Java 심화         | 이펙티브 자바 3/E, JUnit                                                                                 |
| 2022.07~            | Spring, Java 심화 | ORM(JPA), Spring Security, Spring Batch, Concurrent                                                      |
| 2022.04~            | 개발방법, 설계론  | DDD, Cloud Native, MSA                                                                                   |
| ~~2022.03~~         | ~~프로젝트~~      | ~~(가칭) FOR PHOTOGRAPHER LIFE 프로젝트~~                                                                |
| 2022.02~            |                   | **한빛미디어 2022 서평단**                                                                               |
| ~~2022.02~2022.03~~ | ~~Spring 심화~~   | ~~이펙티브 자바 3/E, 토비의 스프링~~                                                                     |
| 2021.12~2021.02     | JS, SQL 기본      | Javascript ES6, jQuery, SQL, Query tuning                                                                |
| 2021.11~2022.02     | 인턴              | **이커머스 서비스 인턴**                                                                                 |
| 2021.10~2021.11     | Java 심화         | 자바 성능 튜닝 이야기, Practical 모던 자바                                                               |
| 2021.08~2021.11     | 코딩 인터뷰       | [코딩 테스트 준비](https://github.com/platanus-kr/coding-interview) 강의, 서적, 백준, 리트코드, 기출문제 |
| 2021.07~            | 프로젝트          | [Plata Board](https://github.com/platanus-kr/spring-boot-webboard) 프로젝트                              |
| 2021.06~2021.07     | 프로젝트          | [42 Helper](https://github.com/innovationacademy-kr/swlabs-helper) 프로젝트                              |
| 2021.04~2021.06     | CS 기초           | Operating system, Database, SQL                                                                          |
| 2021.03~2021.06     | JSP, 디자인 패턴  | JSP, JSTL, Servlet, 디자인 패턴                                                                          |
| 2021.03~2022.03     | C                 | **42 Seoul 4기** libc/string.h 구현, OS 기초, Network, Linux                                             |
| 2021.02~2021.04     | CS 기초           | 자료구조, 알고리즘                                                                                       |
| 2021.02~2021.03     | Spring boot 기본  | MVC, Controller, JDBCTemplate, MyBatis ...                                                               |
| 2021.01~2021.02     | Spring 기본       | IoC/DI, AOP, Component scan, Bean, Bean lifecycle ...                                                    |
| 2020.11~2020.12     | Java 기본         | **우아한테크코스 3기** 객체지향 설계방법론, Java 기본문법                                                |

---

## 정리노트

- blog: [stack from platanus](https://platanus.me/til)

## 참고 서적 및 강의

### Java

- ✅ **강의** [자바 기초 특강](https://github.com/jongpak/dev-tip/issues/8) (박종훈)
- ✅ [Do it! 자바 프로그래밍 입문](http://www.easyspub.co.kr/20_Menu/BookView/A001/267/PUB) (박은종, 이지퍼블리싱)
- ✅ [Practical 모던 자바](https://blog.insightbook.co.kr/2020/09/16/practical-%EB%AA%A8%EB%8D%98-%EC%9E%90%EB%B0%94-%EC%96%B4%EB%A0%A4%EC%9B%8C%EC%A7%84-%EC%9E%90%EB%B0%94-%EC%8B%A4%EB%AC%B4%EC%97%90-%EC%9E%90%EC%8B%A0-%EC%9E%88%EA%B2%8C-%EC%A0%81%EC%9A%A9%ED%95%98/) (장윤기, 인사이트)
- ✅ [자바 성능 튜닝 이야기](https://blog.insightbook.co.kr/2013/11/05/%ec%98%a4%eb%8a%98%eb%8f%84-%ec%84%b1%eb%8a%a5-%eb%ac%b8%ec%a0%9c%eb%a1%9c-%ea%b3%a0%ea%b5%b0%eb%b6%84%ed%88%ac%ed%95%98%eb%8a%94-%ea%b0%9c%eb%b0%9c%ec%9e%90%eb%a5%bc-%ec%9c%84%ed%95%9c/) (이상민, 인사이트)
- [이것이 자바다](https://www.hanbit.co.kr/store/books/look.php?p_code=B1460673937) (신용권, 한빛미디어)
- 🏃🏻‍♂️ [JAVA Concurrency in Practice 자바 병렬 프로그래밍](http://www.acornpub.co.kr/book/java-concurrency) (Brain Goetz 외, 에이콘)
- [Effective Java 이펙티브 자바 3/E](https://blog.insightbook.co.kr/2018/10/24/%EC%9D%B4%ED%8E%99%ED%8B%B0%EB%B8%8C-%EC%9E%90%EB%B0%94-3%ED%8C%90effective-java-3-e/) (Joshua J. Bloch, 인사이트)

### Spring Framework

- ✅ **강의** [예제로 배우는 스프링 입문](https://www.inflearn.com/course/spring_revised_edition/dashboard) (백기선, 인프런)
- ✅ [스프링5 프로그래밍 입문](https://www.kame.co.kr/nkm/detail.php?tcode=306&tbook_jong=3) (최범균, 가메출판사)
- ✅ **강의** [스프링 부트 입문 강의](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard) (김영한, 인프런)
- ✅ [스프링 부트 시작하기](https://blog.insightbook.co.kr/2019/03/25/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8-%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0/) (김인우, 인사이트)
- ✅ [스프링 부트와 AWS로 혼자 구현하는 웹 서비스](https://freelec.co.kr/book/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-aws%EB%A1%9C-%ED%98%BC%EC%9E%90-%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94-%EC%9B%B9-%EC%84%9C%EB%B9%84%EC%8A%A4/) (이동욱, 프리렉)
- 🏃🏻‍♂️ **강의** [스프링 시큐리티](https://www.inflearn.com/course/%EB%B0%B1%EA%B8%B0%EC%84%A0-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0) (백기선, 인프런)
- [토비의 스프링 3.1](http://www.acornpub.co.kr/book/toby-spring3-1-set) (이일민, 에이콘)
- [Spring in Action 스프링 인 액션](https://jpub.tistory.com/539) (Craig Walls, 제이펍)
- [Hands-On Microservices with Spring Boot and Spring Cloud 스프링으로 하는 마이크로서비스 구축](http://www.acornpub.co.kr/book/microservices-spring) (Magnus Larsson, 에이콘)
- [Cloud Native Java 클라우드 네이티브 자바](https://www.onlybook.co.kr/entry/cloud-native-java) (Kenny Bastani, Josh Long, 책만)

### Servlet / JSP

- [자바 웹을 다루는 기술](https://www.gilbut.co.kr/book/view?bookcode=BN002351) (이병승, 길벗)
- ✅ [자바 고양이 Tomcat 이야기](https://www.g-world.co.kr/home/book.page;jsessionid=C165054A4AA24AB958879C435E5A6EB4?cmd=home-book-view&book_id=1625) (최진식, 좋은땅)

### Javascript

- ✅ **강의** 나도 jQuery 전문가! (박종훈)
- ✅ [Modern JavaScript for the Impatient 무던한 개발자를 위한 모던한 자바스크립트](https://www.hanbit.co.kr/store/books/look.php?p_code=B8356303939) (Cay S. Horstmann, 한빛미디어)
- [러닝 자바스크립트 Learning JavaScript](https://www.hanbit.co.kr/store/books/look.php?p_code=B2328850940) (Ethan Brown, 한빛니디어)

### Database / ORM

- ✅ [데이터베이스 개론](https://www.hanbit.co.kr/store/books/look.php?p_code=B8582604063) (김연희, 한빛미디어)
- [SQL AntiPatterns](http://ebook.insightbook.co.kr/book/25) (Bill Karwin, 인사이트)
- ✅ [SQL 정복](https://www.hanbit.co.kr/store/books/look.php?p_code=B9543045444) (김상형, 한빛미디어)
- ✅ **강의** 핵심으로 짚어보는 비즈니스 SQL 전략 (송유진)
- 🏃🏻‍♂️ **강의** [자바 ORM 표준 JPA 프로그래밍](https://www.inflearn.com/course/ORM-JPA-Basic) (김영한, 인프런)

### OOP, Design patterns, DDD, and more..

- [Head first, Design pattern](https://www.hanbit.co.kr/store/books/look.php?p_code=B9860513241)(Eric Freeman 외, 한빛미디어)
- [객체지향적으로 생각하라!](http://www.infopub.co.kr/new/include/detail.asp?sku=06000224) (Matt Weisfeld, 정보문화사)
- ✅ [프로그래머로 사는 법 Making it Big in Software: Get the Job. Work the Org. Become Great](https://www.hanbit.co.kr/store/books/look.php?p_code=B6104154358) (Sam Lightstone, 한빛 미디어)
- ✅ [스프링 입문을 위한 자바 객체 지향의 원리와 이해](https://wikibook.co.kr/java-oop-for-spring/) (김종민, 위키북스)
- ✅ [JAVA 객체지향 디자인 패턴: UML과 GoF 디자인 패턴 핵심 10가지로 배우는](https://www.hanbit.co.kr/store/books/look.php?p_code=B3400922670) (정인상/채홍석, 한빛미디어)
- 🏃🏻‍♂️ [실용주의 프로그래머 The Pragmatic Programmer](https://ebook.insightbook.co.kr/book/113) (David Thomas, Andrew Hunt, 인사이트)
- [객체지향의 사실과 오해](https://wikibook.co.kr/object-orientation/) (조영호, 위키북스)
- ✅ [도메인 주도 개발 시작하기](https://hanbit.co.kr/store/books/look.php?p_code=B4309942517) (최범균, 한빛미디어)

### Cloud Native

- ✅ [SRE with Java Microservices 자바 마이크로서비스를 활용한 SRE](https://hanbit.co.kr/store/books/look.php?p_code=B2761632078) (Jonathan Schneider, 한빛미디어)
- ✅ [Fundamentals of Software Architecture 소프트웨어 아키텍처 101](https://hanbit.co.kr/store/books/look.php?p_code=B1494466807) (Mark Richards, Neal Ford, 한빛미디어)
- ✅ [Design Patterns for Cloud Native Applications 클라우드 네이티브 애플리케이션 디자인 패턴](https://hanbit.co.kr/store/books/look.php?p_code=B3886303135) (Kasun Indrasiri, Sriskandarajah Suhothayan, 한빛미디어)

### Computer Science

- ✅ [Operating System Concepts Essentials : Second Edition](http://www.hongpub.co.kr/shop/item.php?it_id=20181204081002) (Wiley)
- [클린 코드 Clean Code](http://ebook.insightbook.co.kr/book/79) (Robert C. Martin, 인사이트)
- [리얼월드 HTTP Real World HTTP](https://www.hanbit.co.kr/store/books/look.php?p_code=B7009240426) (渋川 よしき, 한빛미디어)

### Coding interview

- ✅ [Do it! 자료구조와 함께 배우는 알고리즘 입문 파이썬](http://easyspub.co.kr/20_Menu/BookView/PUB/381)(柴田 望洋, 이지스퍼블리싱)
- [파이썬 알고리즘 인터뷰](https://www.onlybook.co.kr/entry/algorithm-interview) (박상길, 책만)
- ✅ [이것이 취업을 위한 코딩 테스트다 with 파이썬](https://www.hanbit.co.kr/store/books/look.php?p_code=B8945183661) (나동빈, 한빛미디어)
- [Elements of Programming Interviews in Java 262가지 문제로 정복하는 코딩 인터뷰 in Java](https://blog.insightbook.co.kr/2021/09/28/%E3%80%8A262%EA%B0%80%EC%A7%80-%EB%AC%B8%EC%A0%9C%EB%A1%9C-%EC%A0%95%EB%B3%B5%ED%95%98%EB%8A%94-%EC%BD%94%EB%94%A9-%EC%9D%B8%ED%84%B0%EB%B7%B0-in-java%E3%80%8B-%E3%80%8A266%EA%B0%80%EC%A7%80-%EB%AC%B8/) (Adnan Aziz 외, 인사이트)

### Mini-project

- [42 Helper](https://github.com/innovationacademy-kr/swlabs-helper) (Spring Boot + Spring Data JPA + Thymleaf 프로젝트 : 멘토링 팀 매칭 서비스)
- [Plata Board](https://github.com/platanus-kr/spring-boot-webboard) (Spring Boot + JDBC 프로젝트 : 게시판 웹 서비스)

---

**범주**

```
✅ : 완독
🏃🏻‍♂️ : 독서중
```

**코멘트**

```
1. 각 분야별로 분류를 나눴습니다.
2. 분류 내 책 및 강의를 본 순서는 위에서 아래로 입니다.
3. 왠만하면 직접 서점에서 보고 경쟁 도서 대비 괜찮은 책으로 담았습니다.
4. 이 목록은 협찬 및 선물 도서가 포함되어 있습니다.
5.
```-->
