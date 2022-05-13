# Forms

<br>

---

## index

<!-- TOC -->

- [Forms](#forms)
  - [index](#index)
  - [Forms 만들어보기.](#forms-만들어보기)
    - [Widget - forms의 input data type](#widget---forms의-input-data-type)
    - [rendering option](#rendering-option)
      - [forms rendering - 태그 이용 (기본 - 구조 자동생성)](#forms-rendering---태그-이용-기본---구조-자동생성)
      - [forms rendering - 반복문 이용](#forms-rendering---반복문-이용)
  - [Forms 으로 실제 데이터 받기](#forms-으로-실제-데이터-받기)
    - [DB의 Modeling 객체로 넘겨주기](#db의-modeling-객체로-넘겨주기)
  - [Form 데이터를 좀더 쉽게 받아보기](#form-데이터를-좀더-쉽게-받아보기)
    - [필요한 데이터만 받게 커스텀하기](#필요한-데이터만-받게-커스텀하기)
    - [자체 유효성 검사하기](#자체-유효성-검사하기)
  - [cf. 주석처리](#cf-주석처리)

<!-- /TOC -->

<br>

---

## Forms 만들어보기.

> 먼저 사진과 글을 입력받는 '입력 화면'부터 변경해보자.

[Django forms field - https://docs.djangoproject.com/en/4.0/ref/forms/fields/#charfield](https://docs.djangoproject.com/en/4.0/ref/forms/fields/#charfield)

![d](/Image/Django/f0.PNG)

![d](/Image/Django/f1.PNG)

> Form을 만들기 위해, posts/forms.py 파일을 만들고,
> import를 해주자.

![d](/Image/Django/f2.PNG)

> 기존에 사용했던, post_create_view와 유사한 형태이므로, 복붙해주고 수정하기

* context를 return 으로 넘겨줄건데, context는 dictionary 타입.

![d](/Image/Django/f3.PNG)

> url path를  방금 만든 post_create_form_view로 변경.

![d](/Image/Django/f4.PNG)

> 정상 실행 확인.

![d](/Image/Django/f5.PNG)

> post_form.html 을 복붙해서, post_form2.html을 만들고 변경시켜보자.
> 
>controller도 post_form2.html로 변경.


![d](/Image/Django/f6.PNG)

> 현재 아무 화면도 입력받지 못하는 상태에서,

![d](/Image/Django/f7.PNG)
![d](/Image/Django/f8.PNG)


> 우리가 작성하지 않은 html태그들이 모두 생긴걸 볼수 있다.

> 장고가 제공하는 form을 이용하여, html들을 모두 렌더링 할 수 있는것!!!


### Widget - forms의 input data type

[Django forms Widget 공식문서 - https://docs.djangoproject.com/en/4.0/ref/forms/widgets/](https://docs.djangoproject.com/en/4.0/ref/forms/widgets/)

![d](/Image/Django/f9.PNG)

> widget의 설정에 따라, html을 컨트롤할 수 있다.

![d](/Image/Django/f10.PNG)
![d](/Image/Django/f11.PNG)


> modeling과 비슷한 방식으로, forms를 이용해서 html template을 동적으로 다룰수 있게 된다.



### rendering option

#### forms rendering - 태그 이용 (기본 - 구조 자동생성)

![d](/Image/Django/f12.PNG)

> form.as_p 는 p태그를 이용해서 form을 만들어 준다는 것을 알 수 있다.

![d](/Image/Django/f13.PNG)

> ul 바꾸면!?

> 이런식으로 template으로 전체적인 form의 구조를 정해주고 작업할 수 있다.

![d](/Image/Django/f14.PNG)
![d](/Image/Django/f15.PNG)

> 이외에도 수동으로 form의 구조를 잡거나, 반복문을 사용할 수도 있다.

#### forms rendering - 반복문 이용 

![d](/Image/Django/f16.PNG)
![d](/Image/Django/f17.PNG)

> 반복문을 이용해서, forms의 속성들을 하나씩 꺼내줄수도 있다.

<br>
<br>
<br>

## Forms 으로 실제 데이터 받기

![d](/Image/Django/f19.PNG)

> GET방식과 다르게 POST방식에서는 request로 들어온 데이터를
> 
> forms template으로 보낼, PostBaseForm에 실어준다.(사진은 일반 POST데이터가 아니라, FILES 데이터 )


![d](/Image/Django/f18.PNG)
> 디버그모드로 데이터가 실어졌는지, 확인.

### DB의 Modeling 객체로 넘겨주기

![d](/Image/Django/f20.PNG)

* changed data : 변경된 데이터
* cleaned data : 새로운 데이터가 들어올시, 유효성 검사도 진행<br>
> 유효성 검사: 장고 forms 에서 제공하는 자체 기능으로, 타입이 맞는지 등을 검사한다.

![d](/Image/Django/f21.PNG)

> cleaned_data 인지 유효성 검사를 조건문으로 작성해야하는데, true이면  cleaned_data로 잘 넘어갈수 있다.

> 이렇게만 작성해줘도 새로운 피드가 잘 추가되는 것 확인.

> 유효성 검사 실패시, 다시 원래 페이지로 redirect하게 설정.




## Form 데이터를 좀더 쉽게 받아보기

> DB의 modeling했던 정보를 그대로 손쉽게 받아올 수 있다.

![d](/Image/Django/f22.PNG)

* forms.Modelform : model에 작성한 form을 그대로 가져오기
* import Post : modeling 객체를 import하고,
* model = Post : Post 객체를 받아와서,
* fields = '__all__' : 모든 속성을 다 받겠다는 문법. 

![d](/Image/Django/f23.PNG)

* 우리가만든 PostCreateForm으로 바꿔주면, 모든 DB modeling객체의 속성이 다 보이는 것을 볼 수 있다.

### 필요한 데이터만 받게 커스텀하기

![d](/Image/Django/f24.PNG)

> 전체 데이터를 다받는 class 이외에, 새로운 class로 상속을 받아서, 커스텀한 후, view에서 사용하면 됨.

### 자체 유효성 검사하기

[forms fields 유효성 검사 공식 - https://docs.djangoproject.com/en/4.0/ref/forms/validation/](https://docs.djangoproject.com/en/4.0/ref/forms/validation/)


![d](/Image/Django/f27.PNG)
![d](/Image/Django/f28.PNG)

> 공식 문서 참고해서 유효성 검사를 하는 함수를 넣어줄 수 있다.

> views.py에서 유효성 검사에 실패해서, 다시 빈 페이지로 리다이렉션 되는것 확인 할 수 있다.

* clean_content : 함수명 자체에 _ 뒷부분에 검사할 데이터 속성을 적어준다. - 장고 규칙

* raise ValidationError : 장고에서 예외처리가 일어날 시, 에러는 raise로 호출시킨다.

![d](/Image/Django/f29.PNG)

> 방금 해본 특정 필드속성의 유효성 검사

![d](/Image/Django/f30.PNG)

> 전체적인 검사도 만들어 줄 수 있다.

<br>
<br>
<br>
<br>

## cf. 주석처리

> 백엔드 사이드 주석처리 & 프론트 사이드 주석처리

![d](/Image/Django/f25.PNG)

> html주석 : 현재 서버사이드에서 렌더링을 간편하게 해주고 있으므로, html주석은 마지막에 html로 변환시 뒤늦게 주석임을 인지하고 처리하므로, 주석처리된 결과가 보일수 밖에 없다.


![d](/Image/Django/f26.PNG)

> 서버사이드 주석: 서버사이드 렌더링을 할 시에는, 서버사이드 주석 문법을 따라줘야, 아예 출력이 안된다.

