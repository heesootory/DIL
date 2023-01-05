# ubuntu 사용하기


> docker나 aws 등 사용시 기본 설정들....



## 기본 업데이트와 설치

* aws의 경우 기본으로 제공하는 우분투의 설정이 옛날것일 수 있으므로, 일단 ㄱㄱ.

```zsh
$ apt-get update
$ apt-get upgrade
```


## network 확인이 필요할때

* ifconfig 명령이 없을 때 설치 .

```zsh
$ apt-get install net-tools
```

## 원격접속이 가능하게 할 ssh 설치

```zsh
$ apt-get install openssh-server -y
$ /etc/init.d/ssh start     // ssh 실행
$ /etc/init.d/ssh status    // ssh 실행중인지 확인
$ adduser jenkins-ssh       // ssh사용할 user 추가 -> adduser [user명]
```

## ssh를 이용한 원격접속

```zsh
$ ssh -p [포트번호] 유저이름@IP주소
```


## 시스템 자체를 다루기 위한 systemd

```zsh
$ apt-get install systemd
```




