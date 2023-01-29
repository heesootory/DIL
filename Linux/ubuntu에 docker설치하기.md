# ubuntu에 docker 설치



<br>
<br>
<br>

# docker 설치하기


## 기본 사항

> 패키징 툴 업데이트, 업그레이드 시키기.

```zsh
sudo apt update && apt upgrade -y
```

## docker 설치에 필요한 필수 패키지들 설치

```zsh
sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common
```

## 설치 후 GPC Key 인증하기.

```zsh
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
```

> OK 라고 출력되야 정상적으로 인증완료된 것.

## Docker Repository를 등록

> 이는 Docker 환경을 구축할 때 필수적인 절차이다.

```zsh
sudo add-apt-repository \
"deb [arch=amd64] https://download.docker.com/linux/ubuntu \
$(lsb_release -cs) \
stable"
```

## 도커 설치.

> Repository 등록이 완료되었다면, apt-get 패키징 툴을 통해 도커를 설치하자.

```zsh
sudo apt-get update && sudo apt-get install docker-ce docker-ce-cli containerd.io
```


### 도커 설치 완료.
<hr>
<br>
<br>
<br>
<br>
<br>


# 도커 버전 확인

```zsh
sudo docker -v
```

<hr>
<br>
<br>
<br>
<br>
<br>

# docker 실행하기

## docker 활성화 시키기.

```zsh
sudo systemctl enable docker
```

## docker 실행.

```zsh
sudo service docker start
```


## docker 상태 확인.

```zsh
service docker status
```


