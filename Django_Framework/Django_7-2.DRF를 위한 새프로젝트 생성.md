# DRF project












## project 생성 about Mac


> 프로젝트 생성
```zsh
$ mkdir dir명
```

> 파이썬 설치

```zsh
$ brew install python@3.10
```

> 파이썬 버젼 확인

```zsh
$ python -V
```

> 파이썬 패키지 설치, 패키지 업그레이드

```zsh
$ python3.10 -m pip install --user --upgrade pip
```

> 파이썬 가상 환경 설치

```zsh
$ python3.10 -m pip install --user virtualenv
```

> 가상환경 폴더 생성 

```zsh
$ python3.10 -m venv venv
```

>  가상환경 실행, 활성화
```zsh
$ source venv/bin/activate
```

> Django 설치
```zsh
$ pip install django
```

> pip 장고 설치 확인
```zsh
$ pip list
```

![s](/Image/Django/e1.PNG)

> 관리 폴더 config 생성 -> 뒤에 .은 "현재 디렉토리에 생성해라"의미.

```zsh
$ django-admin startproject config .
```

> 장고 서버 실행
```zsh
$ python manage.py runserver
```

![s](/Image/Django/e2.PNG)


## DRF 설치 (Django Rest Freamwork 설치)

```zsh
$ pip install djangorestframework
```

![s](/Image/Django/e3.PNG)

> DRF 추가 된것 확인.

![s](/Image/Django/e4.PNG)

> settings.py에 app 추가.

```zsh
$ django-admin startapp posts
```

> posts 앱 생성.

![s](/Image/Django/e5.PNG)

> 이전 장고 모델 사용.

* serializers 만들기.
: posts/ serializers.py 파일 생성.

![s](/Image/Django/e6.PNG)

* view.py

![s](/Image/Django/e7.PNG)

* url.py

![s](/Image/Django/e8.PNG)

* settings.py
-> apps 꼭 추가!!!
![s](/Image/Django/e9.PNG)

* migrations
![s](/Image/Django/e10.PNG)
![s](/Image/Django/e11.PNG)

* 서버 실행시, api가 루트를 알려주는걸 알수 있다.

![s](/Image/Django/e12.PNG)

![s](/Image/Django/e13.PNG)

> 정보를 보내면 json형태(python dictionary 형태)로 정보를 확인할 수 있다.

* postman 으로 확인
-> postman으로 client 역할을 해서, 백엔드 서버 이슈가 발생하는지 빠르게 확인해볼 수 있다.

![s](/Image/Django/e14.PNG)
![s](/Image/Django/e15.PNG)

* post로 데이터 보내보기

![s](/Image/Django/e16.PNG)

## api 사용해서 view 이용해보기

* 함수기반. -> 간단한 계산기

![s](/Image/Django/e17.PNG)

![s](/Image/Django/e18.PNG)

> 이것 또한 postman을 이용해 간단하게 확인!!

![s](/Image/Django/e19.PNG)

> api를 사용하지 않았던 이전 코드와 비교

- api사용코드(좌) / api미사용(우)

> api를 사용한 코드는 결국 api_view라는 걸 사용해서, 자동으로 랜더링을 도와주게 된다. 따라서 가장 큰 차이는 랜더링 코드를 삽입의 여부가 들어 있는 return문의 차이이다.


## class 기반으로 만들기.

![s](/Image/Django/e20.PNG)
![s](/Image/Django/e21.PNG)
![s](/Image/Django/e22.PNG)
![s](/Image/Django/e23.PNG)
![s](/Image/Django/e24.PNG)

* class 안의 get요청의 함수를 만들어서 구현.

* 함수안의 self는 class기반이므로, 기본적으로 self를 넣어줘야 함.

* 






































