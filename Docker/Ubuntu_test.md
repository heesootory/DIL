# Ubuntu docker로 사용하기


<br>
<br>
<br>



## docker로 ubuntu 이미지 다운.

```zsh
$ docker pull ubuntu
```



## ubuntu 실행

```zsh
$ docker run -d --name ubuntu -p 22222:22 -p 8081:80 -it --privileged [이미지이름/이미지ID]
```

* -d : 백그라운드 실행

* --name : 사용할 이름 등록

* -p : 포트연결 (host : docker)

* -it : 해당 서버에서 상호작용 지속.

* --privileged : 관리자 권한으로 실행.
