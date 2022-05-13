# User

<br>

---

## index

<!-- TOC -->

- [User](#user)
  - [index](#index)
  - [User 커스텀.](#user-커스텀)
  - [Manager 커스텀](#manager-커스텀)
    - [Manager란??](#manager란)
      - [_create_user](#_create_user)
      - [create_user  &  create_superuser](#create_user----create_superuser)
    - [User에 넣고, superuser 생성](#user에-넣고-superuser-생성)

<!-- /TOC -->

<br>

---

## User 커스텀.

[User 공식문서 - https://docs.djangoproject.com/en/4.0/ref/contrib/auth/](https://docs.djangoproject.com/en/4.0/ref/contrib/auth/)

[User custom  - https://docs.djangoproject.com/en/4.0/topics/auth/customizing/#extending-the-existing-user-model](https://docs.djangoproject.com/en/4.0/topics/auth/customizing/#extending-the-existing-user-model)


![s](/Image/Django/s1.PNG)

> 장고 기본 user에 없는 속성들을 우리만의 user 속성들을 추가해 커스텀해보기.

![s](/Image/Django/s2.PNG)

> User 을 위한 app 만들기

![s](/Image/Django/s4.PNG)
![s](/Image/Django/s5.PNG)

> settings.py 에 app추가, 사용할 커스텀user 추가.(공식문서 참고)

![s](/Image/Django/s6.PNG)

> 간단히 modeling을 하고, makemigrations를 해보자.

![s](/Image/Django/s7.PNG)

> 에러가 나는데, 그 이유는 기존에 만들던 데이터가 기본 User을 모두 사용해서 만들었기 때문에, 충돌이 된다.

![s](/Image/Django/s8.PNG)

> 기존에 있던 db 삭제.

![s](/Image/Django/s9.PNG)

> 다시 migrate 하게되면, db 재생성.

![s](/Image/Django/s10.PNG)

> admin(12) 로 다시 만들고, 

![s](/Image/Django/s11.PNG)

> 새로운 db에 속성들을 확인할 수 있다.

> 원래 User의 기본속성들도 모두 들어가 있고, 내가 커스텀한 속성도 추가되어 있다.

![s](/Image/Django/s12.PNG)

> 주된 정보가 아닌 보고 정보들은(자주 안쓰이는 정보들) 사용자를 외래키로 묶어서 확장시켜 새롭게 만들어 줄 수 있다.

![s](/Image/Django/s13.PNG)

> admin.py도 살짝 만들고, admin 페이지 확인해보자.

![s](/Image/Django/s14.PNG)

> 사용자들 app이 따로 생성된거 확인!!

![s](/Image/Django/s15.PNG)

> 우리가 커스텀한 속성 확인!



## Manager 커스텀

[공식문서 - https://docs.djangoproject.com/en/4.0/ref/contrib/auth/#manager-methods](https://docs.djangoproject.com/en/4.0/ref/contrib/auth/#manager-methods)

### Manager란??

> 장고모델이 DB로 퀴리를 날릴때, 제공해주는 인터페이스. 

> Post.object.~~~   -> 이게 manager


![s](/Image/Django/s16.PNG)
> 우리가 커스텀해야 할 3가지를 받아오자.

* _create_user : 언더바가 들어가면, 외부로 유출을 꺼리는 내부에서만 사용하고 싶은 데이터라고 생각하자.

* create_user : 일반 사용자
* create_superuser : admin(관리자)

#### _create_user

![s](/Image/Django/s17.PNG)

* email: 유효성검사를 넣어보자.

* set_password(password): 비밀번호는 set_password라는 함수를 따로 써서 적용시키는데, 암호를 복호화하는 함수이다. <br>
암호는 그대로 저장이 되면 안되기 때문에, 꼭 복호화 함수를 사용해야함!<br>
복호화하게되면, admin도 그 값을 확인할 수 없고, 다시 비밀번호로 되돌리는 과정이 불가 하다.

#### create_user  &  create_superuser

![s](/Image/Django/s18.PNG)

> 둘의 차이는 'is_staff'와 'is_superuser'의 값을 다르게만 해주면 된다.


### User에 넣고, superuser 생성

![s](/Image/Django/s19.PNG)

> User에 object에 적용시켜주면,
> 
> 우리가 사용했던, Post.Object.~~~에서 onject 부분에 적용되게 된다.

![s](/Image/Django/s20.PNG)

> 이메일 유효성에러 정상 작동.

![s](/Image/Django/s21.PNG)
![s](/Image/Django/s22.PNG)
> system(12)로 superuser생성.

