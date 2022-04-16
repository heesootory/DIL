# QuerySet API
---

<br>

## index

<br>

---
## QuerySet API 란?

![q](/Image/Django/q.PNG)

> ORM은 Model과 QuerySet API로 구성되 그 기능과 역할을 수행한다.

#### Query : DB에 정보를 요청하는 것.
#### QuerySet : DB에서 전달 받은 객체의 목록.
#### QuerySet API : DB에 요청하기 위한 인터페이스.

[QuerySet 공식문서](https://docs.djangoproject.com/en/4.0/ref/models/querysets/)


![q1](/Image/Django/q1.PNG)


<br>

---
## Django Shell

* 파이썬 인터프리터 형식으로 장고 사용. (대화형 형식으로)
* Model을 import하여 사용 가능.

```bash
$ python manage.py shell
```
* 그냥 python을 쳐서 들어가는 것과 다르다. (장고 명령어를 전달하는데 있어서)


#### QuerySet API를 이용하여, model 다루기(실습)

![q2](/Image/Django/q2.PNG)

![q3](/Image/Django/q3.PNG)

![q4](/Image/Django/q4.PNG)

![q5](/Image/Django/q5.PNG)



<br>


---
## Database Tool

* 데이터베이스에 관리를 위한 도구
* 툴을 활용하여 테이블이나 데이터를 조작
* GUI 제공

[tool 다운](https://dbeaver.io/)

![q6](/Image/Django/q6.PNG)

![q7](/Image/Django/q7.PNG)

![q8](/Image/Django/q8.PNG)

> 우리 만드는 프로젝트 앱의 db.sqlite3파일을 path로 지정.

![q9](/Image/Django/q9.PNG)

![q10](/Image/Django/q10.PNG)



<br>


































