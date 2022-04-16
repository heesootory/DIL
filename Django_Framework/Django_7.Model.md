# Model

<br>

---

## index



<br>

---

## 모델이란??

![model](/Image/Django/model.PNG)

![model1](/Image/Django/model1.PNG)

> Field가 하는 역할!! -> Field 덕에 타입명도 모두 python코드로 가능해진다!

![model2](/Image/Django/model2.PNG)



<br> 

---

## 모델링이란?
> 저장하고자 하는 데이터를 모델로 저장하는 것.

[ex]
![ex](/Image/Django/ex.PNG)

![ex2](/Image/Django/ex2.PNG)

![ex3](/Image/Django/ex3.PNG)


[공식문서 - Field Type 에 대해]([/Image/Django/ex3.PNG](https://docs.djangoproject.com/en/4.0/ref/models/fields/#field-types))

<br>

---

## 실습

### 1. 기본세팅

>  장고프로젝트생성 - 가상환경설치 - 장고 설치 - config . 파일 생성.

<br>

### 2. 게시판을 위한 posts(App) 생성

![posts](/Image/Django/posts.PNG)


![posts2](/Image/Django/posts2.PNG)

> config/settings.py -> app 추가

<br>

### 3. posts/models.py 작성하기

![models](/Image/Django/models.PNG)

> verbose_name : 관리자나 일반사용자들에게 노출될 필드에 대한 명칭을 지정.

<br>

### 4. 모델의 내용 명세하기.

```bash
$ python manage.py makemigrations
```

![models2](/Image/Django/models2.PNG)

> Pillow 패키지가 없다고 에러나는데, 이 패키지는 image 파일을 다룰때 사용하는 
> 사용빈도가 높은 패키지이다.

```bash
$ pip install Pillow
```
> Pillow 패키지 설치

![models3](/Image/Django/models3.PNG)

> 다시 makemigrations로 명세 시키면, 

![models4](/Image/Django/models4.PNG)

> migrations 에 새로운 파일들이 생성됨.

![models5](/Image/Django/models5.PNG)

> 파일에 들어가보면, 실제 데이터베이스화 되기 전, 명세를 적어논 파일이라고 할 수 있다. <br>
> 만들어질 테이블에 대한, Post방식인지(name='Post'), id값은 어떤 형식(models.
BigAutoField)인지 등...이 설정되어 있다. 


<br>


### 5. 데이터베이스 생성

```bash
$ python manage.py migrate
```
![models6](/Image/Django/models6.PNG)

<br>


### 6. 데이터베이스 사용자 넣고, 확인하기

```bash
$ python manage.py createsuperuser
```

![models7](/Image/Django/models7.PNG)

> username : admin <br>
> Email :  안써도됨 <br>
> Password : 12(예시니까 짧게)


* SQLite 설치

![sqlite](/Image/Django/sqlite.PNG)


![models8](/Image/Django/models8.PNG)

> db.sqlite3 -> 우클릭 -> open database <br>
> 아래 만들어진 데이터베이스들 보임
> 우리가 방금 만든 auth_user 을 확인하면,


![models9](/Image/Django/models9.PNG)

> 데이터가 들어와 있는걸 확인할 수 있다. <br>
> 비밀번호는 해싱되어 들어가기 때문에, 저딴식임.


<br>

---
## 모델 관계

![models10](/Image/Django/models10.PNG)

![models11](/Image/Django/models11.PNG)

> 1:N 관계에서는 N이 되는 모델에 ForeignKey를 사용.

![models12](/Image/Django/models12.PNG)

![models13](/Image/Django/models13.PNG)


<br>

---
## 실습2

<br>

### Python interpreter 설정

> ctrl + shift + p -> 팔레트 검색 <br>
> Python : Select Interpreter 선택. <br>
> Python 3.10.4('venv':venv). 경로~   선택 <br>

파이썬이 이 vscode에서 어떤 버젼으로 사용하라고 설정함으로써, 잡다한 오류를 줄일 수 있다.


### models.py에 댓글관련 테이블 추가시키기

![models14](/Image/Django/models14.PNG)

> 관계 매핑으로 확인하면, <br>
> 작성자와 POST(게시글)은 1:N 관계이므로, N 에 해당하는 POST에서 1에 해당하는 작성자를 참고해야 하므로, writer에 외래키가 붙은 걸 알 수있다. <br>
> POST(게시글)와 Comment(댓글)은 1:N 관계이므로, N 에 해당하는 comment에서 1에 해당하는 post를 참고해야 하므로, post에 외래키가 붙은 걸 알 수있다. 또 작성자와의 관계도 1:N의 관계이므로, 마찮가지이다. <br>
> 이 때, ForeignKey 속성에는 to 속성과, on_delete 속성은 필수이다. <br>
> to 속성 : 사용자 방식, on_delete: 삭제방식

![models15](/Image/Django/models15.PNG)

> 추가시킨 후엔, 다시 명세 작업을 한다.
```bash
$ python manage.py makemigrations
```
![models16](/Image/Django/models16.PNG)

> 새로운 명세 파일이, migrations에 생긴걸 확인할 수 있다. <br>
> 추가된 내용에 관련된 제목으로 자동 생성된다.

![models17](/Image/Django/models17.PNG)

> 이제 실제 DB table에 migrate해준다.
```bash
$ python manage.py migrate
```

<br>

### QuerySet API를 이용해서, 데이터를 넣고, 확인하기

![models18](/Image/Django/models18.PNG)

> 파이썬에 들어가기

![models19](/Image/Django/models19.PNG)

```bash
$ from posts.models import Post
```
> posts(앱)에 있는 models.py에서 Post모델(클래스)를 불러온다.

```bash
$ Post
```
> Post 모델이 불러와 졌는지, 확인 -> class가 검색되면, 제대로 불러온것.

![models20](/Image/Django/models20.PNG)

> 데이터베이스에 데이터 여러개 저장. <br>
> 간단한 예시이므로, 필수 항목인 context만 입력함.

![models21](/Image/Django/models21.PNG)

> SQLite EXPLORER/ posts_post 에서 제대로 들어간것을 확인.


















