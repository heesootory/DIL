# Django Setting
---
<br>

## index


## 파일 생성

### 1. "Django-review1"이라는 폴더 생성.
```bash
$ mkdir Django-review1
```
<br>

### 2. 폴더안에 패키지 확인
```bash
$ pip list
$ pip3 list     // 맥의 경우
```
![piplist](/Image/Django/piplist.PNG)
pip는 파이썬 패키지 관리자로, 파이썬에서 쓰이는 다른 패키지들도 모두 pip를 통해 사용하게 된다. <br>
장고도 파이썬 패키지로 취급이 된다. 

<br>
(pip 업그레이드)
   
```bash
$ pip install --upgrade pip
```

<br>

### 3. 가상환경 만들기

```bash
$ python -m venv venv
```
![venv](/Image/Django/venv.PNG)

가상환경을 사용하기 위해 venv라는 이름으로 폴더 만들기. <br>
일반적으로 venv라는 이름을 많이 사용한다.

<br>

### 4. 가상환경 실행

```bash
$ .\venv\Scripts\activate
```
![venv_activate](/Image/Django/venv_activate.PNG)

가상환경 실행시, (venv) 가 앞에 붙었는지 확인.

<br>

### 5. 장고 설치
   
```bash
$ pip install Django
```
![install_Django](/Image/Django/install_Django.PNG)

장고 설치 후 내용을 확인하면,  Installing collected packages: ...
장고에 필요한 여러다른 패키지들도 다운받아 진 것을 볼 수 있다.

<br>


### 6. 장고 프로젝트,앱 설치

```bash
$ django-admin startproject config .
```
![config](/Image/Django/config.PNG)

유지보수 관리를 위해 config . 폴더를 생성. <br>
app들을 관리해주는 폴더하고 생각.

### 7. 장고 실행

![manage.py](/Image/Django/manage.py확인.PNG)

장고 실행은 manage.py 를 통해서 실행시키므로, 현재 디렉토리에 있는지 확인.


```bash
$ python manage.py runserver
```
![django_run](/Image/Django/django_run.PNG)

오류메세지 :  아직 데이터베이스를 만들지 않아서 나오는 메세지

![django_run2](/Image/Django/django_run2.PNG)
기본 장고 홈페이지가 나옴. -> 정상적으로 실행됨!