# Read

<br>

---

## index



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






