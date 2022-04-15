# Django Basic Logic - URLs and Logics
---

## index 


---
 >모든 장고 프로젝트는 "앱"들로 구성되어 있다.


## 1. 장고 앱(App) 만들기
```bash
$ django-admin startapp demos
```
![app](/Image/Django/app.PNG)

"demos"라는  앱 생성.
> 만들어진 앱 안의 폴더명들은 임의의 바꾸지 말자.

#### migrations 폴더
: models.py에서 데이터를 정의하고 데이터베이스를 만들때, 그 기록들을 저장하는 곳.

#### admin.py
: 관리자 인터페이스를 만들때, 작성하는 곳.

#### apps.py
: 앱의 설정값들이 있는 곳. 크게 만질일 없음.

#### models.py
: 우리가 저장해야하는 데이터들을 작성해서 데이터베이스들을 만드는 곳.

#### tests.py
: 테스트 코드를 짜는 곳.

#### view.py
: 기능에 대한 실질적인 코드를 작성하는 곳. -> 컨트롤러!


<br>

## 2. 장고 앱 추가하기

![app_add](/Image/Django/app_add.PNG)

> config/settings.py 에 들어가서 INSTALLED_APP 목록에 추가!!!

> 목록에 있는데로, 방금 만든 앱명을 추가하고, "콤마" 잊지 말자!!

<br>

## views.py(컨트롤러) 작성. URLS와 연결

![views1](/Image/Django/views1.PNG)

> views.py에 요청(request)를 받는 함수 생성.
>  -> 간단하게 글자만 응답으로 보내는 함수. (HttpResponse를 사용하면, templates없이, 렌더링이 가능하다.)

> views 는 항상 urls이 불러줘서 실행이 된다.

![urls1](/Image/Django/urls1.PNG)

> urlpattern에 있는 목록들이 127.0.0.1/~ 뒤에 붙어서 갈 경로들 모임이다.
> <br>
> path ('url', 함수명) 형태로 작성.
> <br>
> 함수가 urls파일이 아닌 view 파일에 있으므로, import 해주자.
> <br>
>  -> from demos.views import calculator

![web1](/Image/Django/web1.PNG)

> url(경로)를 정확히 입력해주면, (= 웹브라우저의 요청)
> <br>
> urls가 요청을 받아, 해당하는 views(컨트롤러)에게 요청을 전달.
> views에서 요청에 해당하는 함수를 호출시켜서, 다시 웹에 응답.

#### 해당 구조
![url,view](/Image/Django/url,view.PNG)

<br>

## templates 와 연결

![templates](/Image/Django/templates.PNG)

> templates을 위한 폴더명도, 항상 "templates"로 만들어준다.
> templates에 html파일들을 만들어주고, 보여질 프론트 단을 생성.

![front](/Image/Django/front.PNG)

> views.py에서 이제 templates에 있는 html파일을 가지고, 웹브라우저로 응답해야 한다.
> render(request, '보여질 html파일') 함수를 이용해, 응답.

![render](/Image/Django/render.PNG)

> 이후 서버 재실행
```bash
$ python manage.py runserver
```

![web2](/Image/Django/web2.PNG)

> html 파일을 응답으로 성공.


#### 해당 구조
![templates_add](/Image/Django/template_add.PNG)


<br>

## templates(html파일)에서 값 받아오기

![views2](/Image/Django/views2.PNG)

> 변수 num1에 html 파일의 name이 'num1'인 값 get 하기. <br>
> render함수의 매개변수로 값을 전달할수 있다. <br>
>  -> 'result' (html에서 표시할 변수.) : result (result값 전달.)


![html1](/Image/Django/html1.PNG)

> html파일에 렌더링.

![web3](/Image/Django/web3.PNG)


![log](/Image/Django/log.PNG)

> log로 전달값들 모두 출력됨.(위의 결과와 맞지는 않음...)


