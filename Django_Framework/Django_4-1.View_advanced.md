# View

<br>

---

## index



<br>

---

## View란?!

> 웹 요청을 수신하고, 응답하는 파이썬 클래스 또는 함수.

![view](/Image/Django/v1.PNG)

![view](/Image/Django/v2.PNG)

> 일회성, 특수 목적을 가진 view에 적합

![view](/Image/Django/v3.PNG)

> 일반적인 생성, 조회, 수정, 삭제 등의 view에 적합

👍 FBV와 CBV는 뭐가 좋고 나쁘다가 아니라, 상황에 따라 적합한 방식을 선택하는 것이 바람직함.

<br>
<br>
<br>
 
---

## Function based View 로 요청받기

> 요청은 크게 3가지가 있다고 볼 수 있는데,
> 
> 1. url 로 받기
> 
> 2. query로 받기
> 
> 3. form으로 받기
> 
> 가 있다.


### 단순 request로 받기

#### HttpResponse 응답

* HttpResponse()는 html를 그대로 넘겨 줄 수 있다.(심지어 태그까지)
![view](/Image/Django/v4.PNG)
![view](/Image/Django/v5.PNG)

#### JsonResponse 응답

* JsonResponse로 받는다면, Json형식에 맞춰, 파이썬 Dictionary 형태로 데이터를 넘겨줄 수 있다.

![view](/Image/Django/v6.PNG)
![view](/Image/Django/v7.PNG)

<br>


###  query 형식으로 받기
> query형식은 url뒤에, "?key=value"형식으로 요청할 수 있다.
> 
> request.GET을 그대로 찍어보면, key값들만 나타나는 걸 볼 수 있다.

![view](/Image/Django/v8.PNG)
![view](/Image/Django/v9.PNG)


### url형식으로 받기

> url 형식은 url구성 자체에, "<typr:변수명>/" 의 형태로 받아준다.


![view](/Image/Django/v10.PNG)
![view](/Image/Django/v11.PNG)


### query & url형식 둘다 해보기

![view](/Image/Django/v12.PNG)
![view](/Image/Django/v13.PNG)

> url형식에 int도 가능하다.

![view](/Image/Django/v14.PNG)
![view](/Image/Django/v15.PNG)


### render 로 "응답" 하기

> render는 템플릿 네임을 넣어서, 어느 페이지로 보낼지를 기입한다.

![view](/Image/Django/v16.PNG)
![view](/Image/Django/v17.PNG)


### form 으로 요청

>GET 요청 : 흔히 조회를 용도로 사용.
>
>POST 요청 : 보통 데이터의 추가, 수정, 삭제 시 사용.


![view](/Image/Django/v18.PNG)

> POST요청은 {% csrf_token %} 붙혀서 보냈는데, 추후에 배움.
> 
> -> CMD로 보면 POST요청은 보안정보로 넘어온 데이터도 볼수 있다.
> 
> html form태그의 name이 key값이고, 우리가 적은 데이터가 value이다.
> 
> 열린 페이지 창에서보면, url이 query형식이다! 결국 query를 사용하는 것이다.
> 
> -> 우리가 수정하면, url상에서 바꿀수 있다.
> 
> get,post 적는건 대소문자 상관없다!

![view](/Image/Django/v19.PNG)

![view](/Image/Django/v20.PNG)

> request.method를 이용해서, get인지, post인지에 따라 분기 처리 가능.

<br>
<br>
<br>
 
---

## Class based View 로 요청받기

공식문서 - 
[https://docs.djangoproject.com/en/4.0/ref/class-based-views/](https://docs.djangoproject.com/en/4.0/ref/class-based-views/)






