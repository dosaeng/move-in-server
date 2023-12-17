# MOVE-IN
## 기능
### 앱 유저 기능
- 회원 가입 API
- 로그인 API
- 관심 필터 추가 API
- 제안 요청 API
- 내 관심 필터 목록 보기 API
- 내 관심 필터 상세 보기 API
- 제안 목록 보기 API
- 제안 상세 보기 API
- 중개사 카드 보기 API
### 중개인 기능
- 로그인 API
- 관심 필터 목록 조회 API
- 관심 필터 상세 조회 API
- 내 매물 목록 API
- 제안 API

중개인 계정 + 물건 미리 등록

## 의존성
- gradle 8.5 
- jdk 21

## 실행 방법 
```shell
git clone [레포지토리 URL]
cd [프로젝트 디렉토리]
./gradlew bootRun
```

## Swagger
```http://{{host}}:{{port}}/swagger-ui.html```

## H2 Console
```http://{{host}}:{{port}}/h2-console```
>  계정은 application.yml 참조