# Cookie



## 확인하고 넘어가야할 Http Protocal 특징

![http protocal](/Image/C%26S/HTTP.webp)

* 비연결(connectioness) 지향형 통신 프로토콜

* 응답 후 연결을 종료(stateless)
    - 지속적인 연결 유지로 인한 자원 낭비 방지를 위해 연결 해제
    - 연결이 해제되면 서버는 클라이언트 정보를 알 수 없음.
        - 예) 장바구니에 상품을 담아 두었는데, 페이지가 바뀌면 정보가 없어짐. 로그인 정보가 없음

> 🚀🚀 이러한 문제를 해결하기 위해 Cookie와 HttpSession을 활용!!🚀🚀

<br>
<br>
<br>

## Cookie : javax.servlet.http.Cookie

    - 쿠키도 하나의 클래스이다.
    - 서버가 생성하는 클라이언트 정보를 가지고 있는 파일 🚀
    - 클라이언트 컴퓨터에 저장되며, 필요에 따라 요청 시 서버로 같이 전송. 🚀
    - key-value 형태로 구성되며 문자열 데이터.
    - 브라우져(클라) 별로 별도의 쿠기가 생성. (브라우저가 다르면 다른 사용자로 처리)
    - 세션관리(사용자 아이디, 접속시간, 장바구니 등)을 위해 사용.
    - 사용자마다 다른 페이지를 보여줄 수 있다.
    - 사용자의 행동과 패턴을 분석하고 기록하는데 사용.(사용자가 클리한 상품 관현 광고 배너)


* Cookie 동작순서
    1. 클라가 요청 생성.
    2. WAS는 Cookie를 생성하고 Http Header에 Cookie를 넣어 응답.
        - response를 이용해서 클라에게 쿠키를 보내준다(response.addCookie())
    3. 클라(브라우저)는 쿠키를 저장, 해당 서버에 요청할 때 요청과 함께 쿠키를 전송.
    4. 쿠키는 브라우저가 종료되더라도 계속 저장되기 때문에(만료 되기 전까지) 동일 사이트 재 방문하여 요청 시 필요에 따라 Cookie가 재 전송된다. 🚀


> 🐶 Http 연결은 비연결성인데, 쿠키를 이용해서 요청과 응답에 실어서 보내줌으로써 연결이 되어있는거 처럼 보이게 한다!! 🐶


## Cookie 특징

* 이름, 값, 만료일, 경로정보로 구성.
* 클라이언트에 최대 300개의 쿠키를 저장 가능.
* 하나의 도메인당 20개의 쿠키를 저장.
* 쿠키 하나는 4KB(= 4096 byte)의 정보를 저장 가능.
  - 이 말은 왠만한 사진한장보다도 용량이 작다는 말이므로, 사진같은 것은 쿠키에 저장되지 않는다는 말이다!! 🚀🚀 (cf.이미지는 경로/주소로 저장을 한다.)
* 따라서, 컴퓨터 한대당 1.2MB의 쿠키가 저장 가능.
* 클라(브라우저)가 쿠키를 저장하므로, 브라우저마다 쿠키의 저장 내용은 다르게 된다. -> 크롬에서 장바구니에 물건을 넣어놔도, 인터넷 익스플로어에서는 장바구니가 비어있다!!🚀🚀

## Cookie 생성 및 추가

* 쿠키 생성 : javax.servlet.http.Cookie(java.lang.String name, java.lang.String value) -> 키, 값
```java
Cookie cookie = new Cookie("userid", "ssafy");
```

* 쿠키 응답 추가 : void javax.servlet.http.HttpServletResponse.addCookie(Cookie cookie)
```java
response.addCookie(cookie);
```