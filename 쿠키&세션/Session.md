# Session


## session : javax.servlet.http.Httpsession


* HttpSession은 인터페이스이다.
    - 직접 구현은 NO.
    - 어떤걸 가져와서 집어넣어야함.

* 사용자가 웹 서버에 접속해 있는 상태를 하나의 단위보고 세션이라고 함.

* 각 세션은 sessionId를 이용해 구분.

* WAS의 메모리에 객체 형태로 저장.

* 메모리가 허용하는 용량까지 제한없이 저장 가능.

* 쿠키는 클라에 저장되기 때문에 공유 PC의 경우 보안이 취약할 수 있다.
하지만 세션은 서버에 저장되기 때문에 쿠키에 비해 보안이 굳.

* 사용자(로그인) 정보 및 장바구니 등에 사용.


## 세션의 동작 순서


1. 클라가 페이지를 요청

2. 서버는 쿠키에 session id 가 있는지 확인.

3. session id가 존재하지 않으면, session id 를 생성해 쿠키에 쓴 다음 클라로 반환.

4. 생성된 session id를 이용하여 서버 내 메모리를 생성.

5. 클라가 다음 요청 시 쿠키에 session id를 포함해 전달하면 서버내에 저장된 session id와 비교하여 데이터를 조회.

## 세션 설정

* 브라우저 당 하나의 session id(JSESSIONID)를 할당 받음.

* 아이디 또는 닉네임곽 같이 로그인했을 경우, 자주 사용되는 정보를 session에 저장하면 db에 접근할 필요가 없으므로 효율적.

## session 사용하기

* 요청 객체로부터 session 객체를 얻어옴.

* session에 데이터를 설정하여 저장.

```java
HttpSession session = request.getSession();
session.setAttribute("userid", "ssafy");
```