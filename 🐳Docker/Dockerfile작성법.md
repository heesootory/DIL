# Dockerfile 작성하기


<br>
<br>
<hr>
<br>
<br>
<br>


## docker image 만들기

* docker image 일단 local환경에서 만드려면, dockerfile을 만들고 build 수행

* 만들어진 image를 push하면, docker hub에 등록.

* 그냥 local환경에서 그대로 run 시켜서 image를 가지고 container 생성/실행.

* build 명령
    - 해당 target이 존재하는 디렉토리에서 실행
    - -t : --tag => image명을 줄 옵션
    - 🎯 여기서 가장 중요한 건 맨 마지막에 붙여하는 점(.)이다~!!!!🎯

```zsh
$ docker build -t [image명] .
```