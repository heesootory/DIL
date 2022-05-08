# Read

<br>

---

## index

<!-- TOC -->

- [Read](#read)
  - [index](#index)
  - [Post_list에 model데이터 읽어오기](#post_list에-model데이터-읽어오기)
  - [Debug toolbar](#debug-toolbar)
  - [index에 데이터 렌더링하기.](#index에-데이터-렌더링하기)
  - [post_detail 상세페이지 만들기](#post_detail-상세페이지-만들기)
    - ["더보기"를 눌렸을때, 상세페이지로 이동.](#더보기를-눌렸을때-상세페이지로-이동)
    - [상세페이지의 "더보기" 분기처리 - 필요없기 떄문에 없애준다](#상세페이지의-더보기-분기처리---필요없기-떄문에-없애준다)
    - [content 내용도 분기처리](#content-내용도-분기처리)
    - [댓글의 갯수 분기처리](#댓글의-갯수-분기처리)
    - ["모두 보기"도 "더보기"처럼 분기처리](#모두-보기도-더보기처럼-분기처리)
  - [해당 상세페이지 존재하지 않을때. 예외처리](#해당-상세페이지-존재하지-않을때-예외처리)

<!-- /TOC -->

<br>

---

## Post_list에 model데이터 읽어오기

![CRUD](/Image/Django/r1.PNG)

* Post.objects.all()
> Post.objects(model을 뜻함)에 있는 모든 데이터를 불러온다.

* context
> render의 3번째 인자가 context인데,
> view에서 컨트롤하는 model객체를 html파일에 넘겨주고 사용할 수 있게 만듬.
> 리스트 형태로 여러 객체들을 전달.

* {{post_list}}
> context로 넘어온 객체를 그대로 사용할때는 중괄호 2개.
> {% %} 아님!

![CRUD](/Image/Django/r2.PNG)
![CRUD](/Image/Django/r3.PNG)
> post 정리.

![CRUD](/Image/Django/r4.PNG)

* Post.objects.filter(writer=request.user)
> 작성자를 필터링해서 가져올 수 있다.


## Debug toolbar

[공식문서(설치) - https://django-debug-toolbar.readthedocs.io/en/latest/installation.html](https://django-debug-toolbar.readthedocs.io/en/latest/installation.html)


## index에 데이터 렌더링하기.

> model에서 가져온 객체를 index에서 이용해서, 실제 인스타 홈처럼 list형태로 보여지게 만들기.

![CRUD](/Image/Django/r5.PNG)

> index 에 해당하는 controller에 post_list객체들 담고 보내주기.
> 
> 하지만, index.html은 죄다 post_card.html로 구성되어 있으므로, 
> 
> post_card.html을 데이터 변수로 모두 바꿔주자. 

![CRUD](/Image/Django/r6.PNG)

> index페이지에서 post_card를 모델 객체마다 반복시킴.

![CRUD](/Image/Django/r7.PNG)
> image.url에서 에러가 난걸 알 수 있는데, 이미지url이 없을 경우가 있기 때문!!


![CRUD](/Image/Django/r8.PNG)
![CRUD](/Image/Django/r9.PNG)
> 분기문으로 처리


![CRUD](/Image/Django/r10.PNG)
![CRUD](/Image/Django/r11.PNG)

* 내용 출력 {{post.content|truncatechars:35}}
> template의 필터를 적용시, | 바를 적고 해당 필터적용.'
> 
> 이 필터는 글자수 제한하고, 그 뒤는 "..."으로 표시


* 댓글 갯수 {{post.comment_set.all.count}}
> post객체를 받아와서는 comment에 대해 알수가 없다!! 
> 
> why?! model구성으로 post에는 comment속성이 없기 때문.
> 
> 하지만, comment는 post를 참조 하고 있다.
> 
> 이럴때는 "역참조"를 해서 데이터를 찾아올 수 있음.
> 
> 객체1.참조객체_set.all.count


* 댓글들 {% for comment in post.comment_set.all %}
> 마찮가지로 역참조로 comment를 가져오고 반복문 실행.

* 날짜 {{post.created_at|date:"Y년 m월 d일"}}
> 필터를 안써도 날짜는 가져오지만, 우리가 원하는 포맷으로 조정을 위해, 필터 사용.


[장고 템플릿 필터 참고 - Django template filter](https://docs.djangoproject.com/en/4.0/ref/templates/builtins/)<br>
[공식문서 - https://docs.djangoproject.com/en/4.0/ref/templates/builtins/#date](https://docs.djangoproject.com/en/4.0/ref/templates/builtins/#date)

![CRUD](/Image/Django/r12.PNG)

* order_by('-created_at')
> 생성날짜의 역순으로 배치.
> 
> 애초에 view에서 model객체들을 가져올 때부터 역순으로 배치됨.

[queryset API를 참고하자 - https://docs.djangoproject.com/en/4.0/ref/models/querysets/](https://docs.djangoproject.com/en/4.0/ref/models/querysets/)


## post_detail 상세페이지 만들기


### "더보기"를 눌렸을때, 상세페이지로 이동.

![CRUD](/Image/Django/r13.PNG)

* "/posts/{{post.id}}"
> /app_name(namespace)/{{url에 들어간 id}}.
> post.id는 우리가 게시물을 create할때마다 POST의 속성인 id가 자동으로 부여되는 id값이다.
> detail페이지로 들어가기위해선, url(app)를 확인하면, "/<int::id>"이므로, post.id를 저기에 매칭.


![CRUD](/Image/Django/r14.PNG)
![CRUD](/Image/Django/r15.PNG)

* url도 태그로 변경(쉽게 수정하기 위함.) 'posts:post-detail' post.id
> 'app_name(namespace): url명' post객체.id


* post = Post.objects.get(id=id) 
> url의 id와 post.id가 같은 것만 조회.
> 
> url의 id는 여러개 가져다 쓸 수도 있다.
 


### 상세페이지의 "더보기" 분기처리 - 필요없기 떄문에 없애준다
> 분기 처리로 , index페이지에서는 보이게, detail페이지서는 안보이게!

![CRUD](/Image/Django/r16.PNG)
![CRUD](/Image/Django/r18.PNG)
![CRUD](/Image/Django/r19.PNG)

* with detail=True
> 변수를 함게 지정해서, 뿌려줄 수 있다.
> 주의!!!! : "변수=값" 일때, 띄워쓰기하면 에러가 난다!!!

### content 내용도 분기처리
![CRUD](/Image/Django/r17.PNG)

> 상세페이지시, filter없애고 전체 내용이 다 보이게.

### 댓글의 갯수 분기처리

![CRUD](/Image/Django/r20.PNG)
> index페이지에선 2개만 보이게.

### "모두 보기"도 "더보기"처럼 분기처리

![CRUD](/Image/Django/r21.PNG)
> index페이지에서만 보이고, 클릭시 상세페이지로.


![CRUD](/Image/Django/r22.PNG)
> list페이지와 detail페이지 차이 확인.


## 해당 상세페이지 존재하지 않을때. 예외처리

![CRUD](/Image/Django/r23.PNG)

> view에서 url의 id를 가져와서, post의 id와 매치되는 페이지만 불러올 수 있도록, get함수를 사용했는데,
> get함수는 없는 id를 조회시, 에러를 나게한다.

![CRUD](/Image/Django/r24.PNG)

> 예외처리를 해줘서, index페이지로 redirect되게 만듬.

