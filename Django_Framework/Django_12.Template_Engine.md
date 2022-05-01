# Template Engine


<br>

---

## index



<br>

---

## Template Engine

![view](/Image/Django/t1.PNG)

### template은 서버에서 실행한다!!

> template에서 우리가 만든 폼이 template engine을 통해 번역이되고, html의 
> 
> 언어로 자동 번역이 되게된다.
> 
> view에서 그걸 가져와 웹브라우저로 보내주면, 브라우저가 html을 번역해 
> 
> 랜더링 작업을 하게된다.

### template의 태그 & 필터

![view](/Image/Django/t2.PNG)
![view](/Image/Django/t3.PNG)

> 많은 html페이지들을 전부 각각 만드는게 아니라, 상속을 이용해 재사용성을 늘리고, 반복을 줄인다.

![view](/Image/Django/t4.PNG)

<br>
<br>
<br>
<br>



### template을 앱 단위가 아닌, 프로젝트 단위로 관리하는 설정을 해보기.

![view](/Image/Django/t5.PNG)
![view](/Image/Django/t6.PNG)
![view](/Image/Django/t7.PNG)

 > settings.py에 있는 BASE_DIR이 워크스페이스를 가리키는 경로이므로, 
 워크스페이스 밑에 있는 templates로 경로를 설정하고 폴더를 만들어서 사용한다.


![view](/Image/Django/t8.PNG)

> template 중 어떤 앱에서 사용될 템플릿일지 구별을 위해, 앱명과 동일한 posts폴더를 만들고 그 아래, 필요한 템플릿들은 모두 구성

![view](/Image/Django/t9.PNG)

> view 에서 해당 페이지들을 가져올, 함수들을 만들어 준다.
> 
> render뒤에 경로를 우리가 settings에서 설정한,  BASE_DIR/'templates' 이하의 주소만 적어주면 됨.

### urls 는 프로젝트 단위가 아닌, 앱단위 관리 urls를 설정해보자.

![view](/Image/Django/t10.PNG)
![view](/Image/Django/t11.PNG)

* 프젝단위 urls.py : 프로젝트 단위에 include를 활용해서, 앱단위에 있는 urls.py 를 연동시켜준다.
* 앱단위 urls.py : 경로를 넣는 곳에 <int:id>는 동일한 페이지가 여러 개 일때, 해당하는 id를 받아 보여줄 수 있는 id이다.
* views.py에서 request와 함께 id를 받으면, url에 표현되는 id의 값을 받을 수 있다.
* 앱단위의 url에서는 "목록화면"에 해당되는 url이 빈 url이지만, 프젝단위의urls에 include되기전에, <mark>기본적으로 "posts/"로 경로를 설정해야,</mark> 해당 앱단위의 url로 가능하므로, posts/를 포함시키는 걸 잊지말기!

![view](/Image/Django/t12.PNG)
![view](/Image/Django/t13.PNG)
![view](/Image/Django/t14.PNG)
![view](/Image/Django/t15.PNG)
![view](/Image/Django/t16.PNG)

<br>
<br>
<br>
<br>


### index 화면 구성 & 태그 활용(templates Engine 사용)

![view](/Image/Django/t17.PNG)
![view](/Image/Django/t18.PNG)
![view](/Image/Django/t19.PNG)

* views.py : 요청 받을 함수 구성.
* index.html : posts폴더 아래가 아닌, templates 폴더 아래 생성.
* posts앱단위 urls.py : 앱단위 url의 폴더의 app_name을 만들면, index.html의 태그에서 인식 가능.
> {% url 'app_name:path의 name'%}
* 프젝단위 urls.py : include 안에, 앱단위의 app_name을 namespace에 작성.<br> (이건 구별을 위함이지, 동작을 위함은 아닌것 같다...) 
* index의 name은 path에 들어간 이름으로, html 태그가 이용 가능한 이름.<br> (path('', post_list_view, name='post-list')처럼!)


### 상속관련 태그들 구현하기.

![view](/Image/Django/t20.PNG)
> 현재 많은 posts 페이지들이 중복되고 있다.