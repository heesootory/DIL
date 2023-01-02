# mariaDB test


<br>
<br>
<hr>
<br>
<br>




## 설치 -> 실행 -> 터미널 접속

* image pull
    - 버젼이나 태그를 명시 안할시, 자동적으로 docker 공식 이미지로 다운.

```zsh
$ docker pull mariadb
```

* container 실행
    - run 명령어 = create + start 명령어를 합친것(container 만들기 + container 시작)
    - -d : 백그라운드로 실행
    - -p : 3306에 mysql 포트와 충돌하므로 host 포트를 다른걸로 연결.
    - -e : 환경변수 설정을 admin 비밀번호 없는 상태(true)로 설정하면, 비번없이 연결 가능.
    - -name : [내가 사용할 별칭] [이미지이름:태그]

```zsh
$ docker run -d -p 13306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=true --name mariadb_test mariadb:latest
```

* 


