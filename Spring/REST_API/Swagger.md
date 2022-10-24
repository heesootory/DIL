# Swagger


## 🌈 Swagger를 이용한 REST API 문서화.

* 프로젝트 개발 시, 일반적으로 frontEnd 개발자와 BackEnd 개발자가 분리.

* FrontEnd 개발자의 경우 화면에 집중하고, BackEnd개발자가 만든 문서  API를 보며 데이터를 처리.

* 이때 개발 상황의 변화에 따라 API의 추가 또는 변경할 때 마다 문서에 적용하는 불편함 발생.

* 이 문제를 해결하기 위해 Swagger를 사용.

<br>
<br>
<br>

## 🌈 Swagger란??

* 기존 문서로 사용하던 문제를 해결하기 위해 사용/

* 간단한 설정으로 프로젝트의 API 목록을 웹에서 확인 및 테스트 할 수 있게 해주는 LIbrary.

* Swagger를 사용하면 Controller에 정의되어 있는 모든 URL을 바로 확인 가능/

* API 목록 뿐 아니라 API의 명세 및 설명도 볼 수 있으며, 또한 API를 직접 테스트도 가능.


<br>
<br>
<br>
<br>


## 🌈 사용방법

* pom.xml에 의존성 추가
    - jackson
    - swagger

```xml
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>

```


## 🌈 Swagger 관련 Annotation

|Annotation | 설명 |
|-|-|
|@Api | Controller가 REST 방식을 처리하기 위한 것임을 명시.
|@Apilgnore | Class, method에 선언이 가능하며 클라이언트에 노출하고 싶지 않은 경우 사용 |
|@ApiOperation | 제공되는 API에 대한 간단한 설명. |
|@ApiModel | URL 경로에 있는 값을 파라미터로 추출. |
|@ApiModelProperty | 결과로 응답되는 데이터 필드에 대한 설명  |
|@ApiIplicitParam | API 요청시 설정하는 파라미터에 대한 설명 |
|@ApiImplicitParams | API 요청시 설정하는 파라미터가 여러개일 경우 ApiImplicitParam과 함께 사용 |


<Br>
<Br>
<Br>
























