# PostGreSQL과 PgAdmin 설치 및 데이터베이스 설정

<!-- TOC -->

- [PostGreSQL과 PgAdmin 설치 및 데이터베이스 설정](#postgresql과-pgadmin-설치-및-데이터베이스-설정)
  - [주의할 점](#주의할-점)
  - [1. PostGreSQL 다운](#1-postgresql-다운)
  - [2. PgAdmin 다운](#2-pgadmin-다운)
  - [3. dvdrental.tar 파일 다운](#3-dvdrentaltar-파일-다운)
  - [4. 재부팅](#4-재부팅)
  - [5. 데이터베이스 복구](#5-데이터베이스-복구)
  - [쿼리들로 잘 동작하는지, 확인하기](#쿼리들로-잘-동작하는지-확인하기)
    - [Query Tool](#query-tool)

<!-- /TOC -->



---

<br>
<br>
<br>
<br>


## 주의할 점

1. dvdrental.tar 라는 데이터베이스 파일은 절대 직접 열지 않기.
2. PostGreSQL 암호 기억하기.



## 1. PostGreSQL 다운

> 실제 우리가 사용할 DB.

[다운로드 - https://www.enterprisedb.com/downloads/postgres-postgresql-downloads](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)

![sql](/Image/sql/1.PNG)
> 설치 중, 슈퍼이용자의 비밀번호를 설정하는 곳이 나온다.
> 
> 단순하게 설정하는게 좋음..(0813)
> 
> 암호를 까먹으면, 전부 삭제하고 다시 설치해야 하므로, 꼭 기억하기.

![sql](/Image/sql/2.PNG)
> 다음으로 port 번호를 설정해야하는데, 기존에 다른 db에서 port를 사용하고 있지 않은 한, 5432이 default이므로, 그냥 사용하기.

![sql](/Image/sql/3.PNG)
> db 클러스터 사용 설정인데, default값으로 설정.




## 2. PgAdmin 다운

> DB 사용 편리성을 위한, GUI.

[PgAdmin - https://www.pgadmin.org/](https://www.pgadmin.org/)


## 3. dvdrental.tar 파일 다운

>  연습으로 사용할 DB 압축버젼이다. <br>
🔥❗ 절대 그냥 열면 안된다!!!

> PgAdmin 이외의 것으로 열면 절대 안되기 때문에, 더블클릭 하지 않도록 유의 하여야 한다.

![sql](/Image/sql/4.PNG)


❄️ 혹시나 하는 복구를 위해서 이 파일의 정확한 경로를 알고 있어야함.

## 4. 재부팅

> DB의 모든 변경 사항을 적용하기 위해서는, 재부팅해야 한다.



## 5. 데이터베이스 복구

![sql](/Image/sql/5.PNG)

> DB 기본 암호 설정(0813)


![sql](/Image/sql/6.PNG)
> 설치한 모든 postgreSQL의 버젼들을 볼 수 있음.

> 사용할 버젼을 누르면, 설치할 때 설정했던 비밀번호를 쳐야 들어갈 수 있다.(0813)

> 앞서 설정한 암호를 사용하여, 서버에 접속하는 것.



![sql](/Image/sql/7.PNG)

> 작은 코끼리 모양으로 보이면, 잘 접속된걸 확인할 수 있다.


* PostgreSQL13  > create > Database

![sql](/Image/sql/8.PNG)
> 빈 데이터베이스 생성.

![sql](/Image/sql/9.PNG)

> 우클릭 > restore

❄️ restore 및 path 관련 오류
[https://www.youtube.com/watch?v=7cBkXKCY4Ew](https://www.youtube.com/watch?v=7cBkXKCY4Ew)

![sql](/Image/sql/10.PNG)
> 다운받은 dvdrental.tar파일의 경로만 입력하면 끝.

> restore!

![sql](/Image/sql/11.PNG)

![sql](/Image/sql/12.PNG)
> 완료!

* dvdrental > refresh(새로 고침)

## 쿼리들로 잘 동작하는지, 확인하기

* dvdrental > Query Tool...

### Query Tool

> 실질적으로 쿼리를 수행하고, 정보를 불러올 수 있다.
![sql](/Image/sql/13.PNG)


![sql](/Image/sql/14.PNG)

> Successful!

❄️ 만약 이과정에서, 제대로 동작하지 않는다면??

🔥 재부팅 or 더 낮은 버젼으로 재 설치<br>
-> 보통 호환이 안되서 생기는 문제들이 많으므로, 더 낮은 버젼으로 설치하면, 동작될 가능성이 높다.




