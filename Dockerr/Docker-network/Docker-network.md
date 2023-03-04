# Docker network 구성




## 명령어

* docker 내 network 목록

```zsh
$ docker network ls
```

* docker network 생성
    - --gateway : 기본게이트웨이 주소 (아래는 예시)
    - --subnet : 서브넷마스크 주소 (아래는 예시)
```zsh
$ docker network create --gateway [172.18.0.1] --subnet [172.18.0.0/16] [network이름]
```

* network 상세정보 보기

```zsh
$ docker network inspect [network이름]
```


* docker network 삭제

```zsh
$ docker network rm [network이름]
```



