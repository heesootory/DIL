# 회원가입

<br>

---

## index



<br>

---

## Accounts

[공식문서 - https://docs.djangoproject.com/en/4.0/topics/auth/default/](https://docs.djangoproject.com/en/4.0/topics/auth/default/)

![s](/Image/Django/a1.PNG)

>  User app은 사용자의 정보를 저장하는 목적에 있다면, Accounts app은 사용자가 회원가입을 할때 사용할 정보를 받아오는 목적이 있다.
> 
> 서로 유사해보이지만, 회원가입을 할때, 핸드폰번호로 인증을 받거나, 로봇인지 확인하는 과정 등... 일반 사용자 정보와 구별되는 정보들을 위해 존재한다.

![s](/Image/Django/a2.PNG)
![s](/Image/Django/a3.PNG)
![s](/Image/Django/a4.PNG)
![s](/Image/Django/a5.PNG)

* password2 = forms.CharField(widget=forms.PasswordInput())
: 첫 번째 쓴 비밀번호와 일치하는지 여부를 확인하기 위한 두번째 비번 입력

![s](/Image/Django/a6.PNG)

> 장고에서 기본으로 제공하는 회원User form으로 바꿔서 비교해보자.































