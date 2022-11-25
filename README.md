# Make Short Url!
![Make Short Url Image](https://user-images.githubusercontent.com/88480600/203907927-8b21e8ab-7803-468e-884b-56e788321c69.png)
## 📃  Make Short Url!

[🗂 기능 시연을 포함한 Make Short Url! 상세 포트폴리오](https://yuda-gim.notion.site/Make-Short-Url-15d87726bda545e1b8f0f1d8abe78862)

길고 못생긴 `destination URL` 대신 귀엽고 깜찍한 `short URL`을 만들 수 있는 서비스입니다.

SpringBoot와 JPA를 이용해 제작했습니다.

기능은

1. `short URL` 생성
2. `short URL` 에 매핑된 `destination URL` 로 redirect
    1. redirect 시 클라이언트 `access log` 저장
3. `short URL` 의 상세 정보 확인
    1. `short URL` 상세 정보 확인 시 비밀번호로 인증한 뒤, 인증 정보 세션에 저장

총 3가지 입니다.

## 🛠  개발 환경

### 언어

- Java11
- HTML5, CSS3
- JavaScript, jQuery

### DB

- Oracle

### 프레임워크

- Spring Boot
- JPA/Hibernate

### 형상관리

- Git & GitHub
- SourceTree

### 개발툴

- IntelliJ
- SQL Developer

## 🗺  모델링 및 구조

### 데이터베이스 모델링

![db](https://user-images.githubusercontent.com/88480600/203908101-8326645c-9bd9-4f54-8d65-2a834496eac8.png)

- 총 2개의 테이블, 12개의 컬럼으로 구성했습니다

### 시스템 구조

![mvc](https://user-images.githubusercontent.com/88480600/203908106-b23956cd-eb62-47f0-b226-1b1fad6d7855.png)

- SpringMVC 구조로 제작했습니다.

## ✔  기능 목록

- `short URL` 생성
- `short URL` 에 매핑된 `destination URL` 로 redirect
    - redirect 시 클라이언트 `access log` 저장
- `short URL` 의 상세 정보 확인
    - `short URL` 상세 정보 확인 시 비밀번호로 인증한 뒤, 인증 정보 세션에 저장
