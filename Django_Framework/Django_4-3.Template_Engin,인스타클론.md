# Template Engine - 인스타그램 클론


<br>

---

## index

<!-- TOC -->

- [Template Engine - 인스타그램 클론](#template-engine---인스타그램-클론)
  - [index](#index)
  - [화면 구성](#화면-구성)
  - [마크업](#마크업)
    - [media 폴더](#media-폴더)
    - [static 폴더](#static-폴더)
      - [홈화면 - 메뉴 영역](#홈화면---메뉴-영역)
      - [홈화면 - 카드 영역](#홈화면---카드-영역)
      - [카드 영역 재사용성을 위해 refactory](#카드-영역-재사용성을-위해-refactory)

<!-- /TOC -->

<br>

---

## 화면 구성

* 화면 구조화 -> 화면 모델링

![view](/Image/Django/t24.PNG)
![view](/Image/Django/t25.PNG)

* 화면 구조화
![view](/Image/Django/t26.PNG)


## 마크업
> css 입히전에 html의 태그로 구조를 잡기


### media 폴더 
> 고객들이 올리는 미디어 파일들.


###  static 폴더 
> 서비스 제공자(직원)들이 필요에 의해서 올리는 이미지 파일들. -> 서비스의 자원.

[공식문서 - https://docs.djangoproject.com/en/4.0/howto/static-files/](https://docs.djangoproject.com/en/4.0/howto/static-files/)

![view](/Image/Django/t29.PNG)

1. static 빈 폴더 - 프로젝트 단위의 폴더
2. settings.py 설정
3. 모든 html의 부모격인 base.html에 load해주기

#### 홈화면 - 메뉴 영역

![view](/Image/Django/t27.PNG)
![view](/Image/Django/t28.PNG)
![view](/Image/Django/t30.PNG)
![view](/Image/Django/t31.PNG)

1. 준비한 아이콘 이미지들 저장.
2. static 파일을 사용하는 곳이면, 어느 페이지던 {% load sttaic %} 해주기.
3. img 삽입 - src는 static을 load했기 떄문에, static 폴더명 먼저 써주고, 상세 주소 기입.

![view](/Image/Django/t33.PNG)

4. css폴더에도 준비한 css파일들 넣어주기
5. base.html에 link(css) 달기.
6. (하단 nav바는 모든 창에 필요함으로, base.html로 이동시킴)

<br>
<br>
<br>


#### 홈화면 - 카드 영역

* 카드 헤더 & 이미지
![view](/Image/Django/t34.PNG)
> img src에 "http://via.placeholder.com/32x32"는 아직 마땅한 이미지가 없을때, 사용하는 이미지로 아직 공백인 이미지 공간에 사용하기 유용.

![view](/Image/Django/t35.PNG)

* 카드 버튼
![view](/Image/Django/t36.PNG)
![view](/Image/Django/t37.PNG)

* 카드 내용

![view](/Image/Django/t38.PNG)
> truncatechars : 35 -> 35글자 이후 "..."으로 표시.

>현재 내용에 들어간 부분을 직접 입력해 줬지만, 추후 model에서 꺼내와 변수(model.content 같은?) 로 저장하게됨.

![view](/Image/Django/t39.PNG)

* 댓글 & 날짜

![view](/Image/Django/t40.PNG)
![view](/Image/Django/t41.PNG)

#### 카드 영역 재사용성을 위해 refactory

![view](/Image/Django/t43.PNG)
> templates/mixin/posts/post_card.html 파일로 card부분만 이동.

![view](/Image/Django/t44.PNG)
1. post_card.html은 static 을 사용하기 때문에 load.


![view](/Image/Django/t45.PNG)

2. templates 안에서 html 파일을 include할때 {% include '' %}를 사용하는데, settings.py 의 templates 를 설정한 dir 경로가 templates까지 되어있기 때문에 그 아래 상세주소만 기입.


![view](/Image/Django/t46.PNG)

3. 다른 페이지에서도 include만 해주고 사용. -> 재사용성!












