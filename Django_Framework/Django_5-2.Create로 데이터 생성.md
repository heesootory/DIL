# Create

<br>

---

## index

<!-- TOC -->

- [Create](#create)
  - [index](#index)
  - [글쓰기 버튼 url 태그로 연동](#글쓰기-버튼-url-태그로-연동)
    - [글 작성을 위한, post_form.html](#글-작성을-위한-post_formhtml)
    - [view.py 데이터 처리](#viewpy-데이터-처리)
    - [model에 필요한 객체 만들기](#model에-필요한-객체-만들기)
  - [media 파일 다루기](#media-파일-다루기)

<!-- /TOC -->

<br>

---

## 글쓰기 버튼 url 태그로 연동


![CRUD](/Image/Django/t47.PNG)
![CRUD](/Image/Django/t48.PNG)

* {% url 'posts:post-create%}
 -> 'app_name:url name'으로 작성.
* 페이지를 검사해보면, 하드코딩된 url명으로 알아서 바뀐것을 볼 수 있다.

<br>
<br>
<br>

### 글 작성을 위한, post_form.html 

![CRUD](/Image/Django/c8.PNG)
![CRUD](/Image/Django/c9.PNG)

* form action 
> 에는 "" 아무것도 안쓰면, 자기 자신을 가르키므로, "{% url 'posts:post-create' %}"와 같은 의미.<br>

* method
> 게시글 생성에 관련된 부분이므로, POST로 보내주기.

* enctype = "multipart/form-data"
> 어떤 파일이든 보내려면, 인코딩을 해서 보내줘야 함.
> 
> 현재 우리가 form데이터로 데이터를 쏘기 때문에 form-data로 인코딩을 해줘야 함.

* {% csrf_token %}
> csrf토큰이란 csrf위조 사이트 방지를 위한 목적으로, POST시 토큰을 붙여줘야 가능하다. 장고는 태그로 제공하고 있다.
> 
> hidden으로 토큰이 실려서 보내지는 걸 볼 수 있다.

![CRUD](/Image/Django/c10.PNG)

* input type = "file"
> 이미지를 받는 type이 file이다. 이미지도 사실상 파일이므로.

* laber for ="id_image" 
> input의 id와 같은 걸 넣어주면, label글씨를 누를때, 입력 버튼을  누른것과 같은 효과를 냄. <br>
> input앞에는 될 수 있으면, label을 기입하자.

<br>
<br>
<br>

### view.py 데이터 처리

* 이미지나 내용을 보내는 처리과정이 POST방식.
* 그 이전 페이지를 가져오는 행위는 GET방식.
* 방식이 다른 두 분기를 처리.
* post가 된후는 redirect로 처리 (import 필요)
* print로 디버깅해보기

![CRUD](/Image/Django/c11.PNG)
![CRUD](/Image/Django/c12.PNG)
![CRUD](/Image/Django/c13.PNG)

<br>
<br>
<br>

### model에 필요한 객체 만들기

* Post.objects.create

> 실제로 데이터에 데이터를 생성.
> 
> Post는 우리가 데이터를 위해 model을 만들때의 객체.
> 
> 그 객체(objects)를 생성(create)한다.는 의미의 문법.
![CRUD](/Image/Django/c17.PNG)

* writer = request.user
> 작성자를 넣을 수 잇는데, 현재 admin에 로그인이 되어 있지 않다면, 에러가 뜬다.
> 
> 현재 로그인되어있는 사용자의 id가 request 정보에 포함되서 넘어온다고 할 수 있다.
> 
> 로그인 된 상태로, admin페이지로 들어가 데이터가 저장된지 확인!!
![CRUD](/Image/Django/c14.PNG)
![CRUD](/Image/Django/c15.PNG)
![CRUD](/Image/Django/c16.PNG)



## media 파일 다루기

> 사용자들이 업로드 하는 미디어 파일도 따로 관리한다.

![CRUD](/Image/Django/c18.PNG)
> static 과 유사한 형태로 폴더를 만들고 , settings.py에 경로 설정.

![CRUD](/Image/Django/c19.PNG)
> config/urls.py에서 url 을 추가.

![CRUD](/Image/Django/c20.PNG)
> 이렇게 경로만 설정해줘도, 이전에 프로젝트 폴더 단위로 저장되던 사진들이, media폴더로 들어가게 된다.

![CRUD](/Image/Django/c21.PNG)
![CRUD](/Image/Django/c22.PNG)
> admin에서 확인했을떄도, url이 media로 들어가는 것 볼 수 있음.

![CRUD](/Image/Django/c23.PNG)
> 로그인이 되어 있을때만, 동작하게 하는 어노테이션.