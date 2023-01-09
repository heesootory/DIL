# REST API

(Representational State Transfer)

## 🌈 정의

* 하나의 URI는 하나의 고유한 리소스를 대표하도록 설계된다는 개념에서 전송방식을 결합해서 원하는 작업을 지정.


## 🌈 REST  구성


* 자원 (Resource) : Uri

* 행위 : HTTP Method

* 표현 
    - 잘 표현된 HTTP URI로 리소스를 정의.
    - HTTP method로 리소스에 대한 행위를 정의.
    -리소스는 JSON, XML 과 같은 여러가지 언어로 표현 가능.

> URI + GET/POST/PUT/DELETE

## 🌈 기존의 웹 접근 방식과 REST API 의 차이점

*  기존의 접근 방식
    - GET과 POST만으로 자원에 대한 CRUD를 처리.
    - URI는 액션을 나타냄.
    - 대부분을 POST와 GET방식을 이용하고, URI의 파라미터를 이용하여 처리함.

* REST 
    - 4가지 (POST, GET, PUT, DELETE) method를 모두 사용하여, CRUD를 처리.
    - URI는 제어하려는 자원을 나타냄.
    - 4가지 method로 먼저 분류를 하므로써, uri의 구성이 간략해짐.

<br>
<br>
<br>
<br>

<hr>

# API란?

## 🌈 정의

* 두 sw요소들이 서로 통신 할 수 있게 하는 방식.

* interface는 두 어플리케이션 간의 요청과 응답에 의해 통신하는 방법.

## 🌈 유형

### 🐳 프라이빗 API

* 기업 내부에 있으며 비즈니스 내에서 시스템과 데이터를 연결하는데만 사용.

### 🐳 퍼블릭 API

* 일반에 공개되며, 누구나 사용가능.
(상ㅇ에 대한 권한 설정과 비용이 청구될수 있음)

* 대부분이 REST방식으로 작성.

<hr>


## 🌈 REST API 의 특징

* 기존의 전송방식과는 달리 서버는 요청으로 받은 리소스에 대해 순수한 데이터를 전송.

* 기존의 GET/POST 외 PUT/DELETE 방식을 사용하여 리소스에 대한 CRUD처리가 가능.

* HTTP URI를 통해 제어할 자원을 명시.

* HTTP method를 통해 해당 자원을 제어하는 명령을 내리는 방식의 아키텍쳐.

* 단점
    - 딱 정해진 표준이 없어 암묵적인 기준만 정해져있음.

    - 하이튼(-)은 사용 가능하지만, 언더바(_)는 사용하지 않음.
    - URI 마지막에 슬래시 사용하지 않음.
    - 특별한 경우를 제외하고 대문자를 사용하지 않음.(대소문자를 구분하기 때문)
    - 슬래시(/)로 계층 관계를 나타냄.
    - 확장자가 포함된 파일 이름을 직접 포함시키지 않음.
    - URI는 명사를 사용.

![REST_API](/Image/rest_api/rest1.png)

<br>
<br>
<hr>
<br>


## 🌈 기존 Service와 REST API Service

### 🐳 기존 Service
> 요청에 대한 처리를 한 후 가공된  data를 이용하여 특정 플랫폼에 적합한 형태의 View로 만들어서 반환.

### 🐳 REST Service
> data 처리만 한다거나, 처리 후 반환될 data가 있다면 JSON이나 XML형식으로 전달. View에 대해서는 신경 쓸 필요 없음! <br>
> 이러한 이유로 Open API에서 많이 사용.

<br>

![REST_API](/Image/rest_api/rest0.png)


<br>

## 🌈 Spring REST 관련 Annotation 및 클래스

| Annotation | 설명 |
|-|-|
| @GetMapping |     요청방식    |
| @PostMapping |   요청방식     |
| @PutMapping |      요청방식   |
| @DeleteMapping | 요청방식     |
| @RestController | Controller가 REST방식을 처리하기 위한 것임을 명시.|
| @ResponseBody | JSP 같은 뷰로 전달되는 것이 아니라 데이터 자체를 전달. |
| @PathVariable | URL 경로에 있는 값을 파라미터로 추출. |
| @CrossOrigin | Ajax의 크로스 도메인 문제를 해결 |
| @RequestBody | JSON 데이터를 원하는 타입으로 바인딩 |
| ResponseEntity | 데이터 응답시[상태코드, 헤더, 데이터] 설정이 가능|










