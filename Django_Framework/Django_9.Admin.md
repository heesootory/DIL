# Admin
---

<br>

## index

<br>


---
## Admin 이란?

[장고 admin 공식문서](https://docs.djangoproject.com/en/4.0/ref/contrib/admin/)

*  실무에 가면, 개발자 이외에도, 기획자, 디자이너, 마케터 등 여러 관리자들이 존재하는데, 권한을 다르게 설정하고, 다같이 관리할 수 있는 환경을 만들어 주는 역할이다.

* 장고의 최대 장점은 admin을 app마다 생성해준다는 건데, 원래는 따로 개발해야할 노력을 많이 줄여준다. 기본적으로 admin 파일이 같이 만들어 져서, 서버를 실행한 후, 127.0.0.1/admin 으로 들어갈시 바로 실행가능.

![admin](/Image/Django/ad.PNG)

![admin](/Image/Django/ad11.PNG)

![admin](/Image/Django/ad12.PNG)

![admin](/Image/Django/ad1.PNG)

* 국제화 - 다국어 적용

> 기본적으로 사이트 언어가 처음에 영어로 되어있으므로, 위 처럼 setting에서 언어를 바꿔주면 한국어로 실행된다.

![admin](/Image/Django/ad2.PNG)

> 127.0.0.1:8000/admin 기본페이지


<br>

---
## Admin 기본구성하기

![admin](/Image/Django/ad3.PNG)

> admin.py 에 작성하는 내용이 관리자페이지. <br>
> 우리가 만들었던 Post와 Comment 테이블을 import 받고 항목으로 가져온다. <br>
> (from .models 은 이 admin.py와 같은 계층의 파일 이므로, posts/models라고 할필요 없다.)

![admin](/Image/Django/ad4.PNG)

> 항목 추가된것을 확인 할수 있다. (F5) <br>
> -> 우리가 만든 테이블 명이라 한국어로 변경되지 않는다. <br>
> Posts에 들어가면 우리가 만들었던 object들을 확인할 수 있다.


![admin](/Image/Django/ad5.PNG)

![admin](/Image/Django/ad6.PNG)

![admin](/Image/Django/ad7.PNG)

![admin](/Image/Django/ad8.PNG)

> 우리가 설정한 속성들 한에서, CRUD가 모두 가능하다!

#### cf . Comment table에 작성일 속성을 자동으로 현재시간 받아오게 하자
 -> auto_now_add = True 

![admin](/Image/Django/ad9.PNG)

![admin](/Image/Django/ad10.PNG)

> 이후 다시 서버를 돌리면, 작성일 작성 부분이 아예 사라진걸 볼 수 있는데, 자동으로 현재시간이 저장되므로, 입력창 자체가 사라졌다.<br>
> 같은 말로, 사용자가 수정하지 못해야 하는 부분을 말하는 것이다.

<br>

---
## Admin 페이지 커스터마이징

[장고 admin 모델옵션 공식문서](https://docs.djangoproject.com/en/4.0/ref/contrib/admin/#modeladmin-options)
![admin](/Image/Django/ad19.PNG)

> 공식문서를 읽어도 되고, 위의 ModelAdmin을 ctrl+클릭으로 들어가서 속성들을 보고 하나씩 써보는것도 좋은 방법이다.

<br>

### annotation과 list_display

![admin](/Image/Django/ad13.PNG)
![admin](/Image/Django/ad14.PNG)

* 어노테이션 사용 <br>
  admin.site.register(Post) -> @admin.register(Post)
* list_display : 보여질 목록(column)들 리스트
* 리스트 형태를 써도되는데, 튜플로 써도 무관하다. (튜플로 작성시, 원소 한개면, 콤마 꼭 붙여주기)

<br>

### filter 적용

![admin](/Image/Django/ad15.PNG)
![admin](/Image/Django/ad16.PNG)


### search_fields, search_help_text 적용

* search_fields : 조건 검색 가능.
* search_help_text : 조건 검색에 대한 설명.

![admin](/Image/Django/ad17.PNG)
![admin](/Image/Django/ad18.PNG)
<br>

### 댓글 기능 구현하기
 
* inlines 활용
![admin](/Image/Django/ad20.PNG)
![admin](/Image/Django/ad21.PNG)
![admin](/Image/Django/ad22.PNG)
![admin](/Image/Django/ad23.PNG)

* 공식 문서를 참조로 댓글 클래스를 만들고, inline을 활용해, post에 넣어줌.
* 댓글 클래스 옵션:
    - extra = 1    : 댓글이 하나만 보이게 설정
    - verbose_name = '댓글' : 댓글창 위의 명칭
* post 클래스 옵션 :
    - readonly_field = ('created_at', ) : 작성일을 읽기전용으로 만들어 보여지게함.

<br>

### actions 추가

* actions에 적용시킬 함수를 class안에 작성하고, 그 함수의 이름을 튜플의 원소로 받아 적용시킬 수가 있다.

![admin](/Image/Django/ad24.PNG) ![admin](/Image/Django/ad25.PNG)

> 디버그를 통해 함수에서 들어온 queryset = item 을 확인해서 선택한 Post object가 들어오는지 확인 가능.

* 디버그 확인

![denug](/Image/Django/d4.PNG)
![denug](/Image/Django/d5.PNG)

>  item으로 querySet과 request 모두 정상적으로 선택한 object가 들어오는 것을 확인할 수 있다. 



