# docker-compose


<BR>
<BR>
<BR>


## 🌈 docker compose 란?

* docker의 여러 container를 통합해서 시작하거나 종료시키려는 툴.

* 다중 컨테이너 환경을 하나의 설정파일(yaml)에서 통합관리하려는 목적에서 나온 개념.




<BR>
<BR>
<HR>
<BR>
<BR>

## 🌈 docker compose의 특징

* docker 명령으로 할 수 있는 명령어의 모든 것을 동일하게 사용할 수 있다.
    - port 설정
    - Environment Variables 
    - Volumns
    - Network





<BR>
<BR>
<HR>
<BR>
<BR>

## 🌈 docker compose 작성법

* 작성 위치 : dockerfile이 있는 프로젝트들의 상위 디렉토리에 'docker-compose.yaml'이라는 설정파일로 만든다.

### 🐳 docker-compose 내부 설정 구조

* version : docker-compose의 버젼을 설정.
    - 일반적인 경우에는 큰 문제없이 과거의 버젼을 사용해도된다.

* services : 띄울 컨테이너들을 하나씩 작성하는 공간.
    - 바로 하위에는 띄울 컨테이너들의 이름을 나열한다.
    - docker 명령에서 --name에 해당하는 부분을 나열한다고 볼수 있음.
    - 모든 컨테이너의 이름은 "최상위 디렉토리_service이름"으로 만들어짐.

    <img
        src = "../../Image/docker/docker_compose/0.png"
        width = 800px
        height = 400px
    />

### 🐳 컨테이너 안의 설정 구조

<br>

* default 설정 : services에 들어가 있는 기본 설정.
    - --rm (자동제거)
    - -d (detach모드)


<br>

* image : 사용할 이미지를 작성.
    - 이미 존재하는 이미지를 사용할 때

    <img
        src = "../../Image/docker/docker_compose/1.png"
        width = 800px
        height = 400px
    />


* volumns : 볼륨 마운트

    ```yml
    volumns:
        - data:/data/db
    ```


* environment : 환경변수 설정
    - key: value 로 쓸때는 앞에 '-'를 붙히지 말아야함.
    - key=value로 쓸때는 앞에 '-'를 붙힘.

    ```yml
    environment:
      - eureka.client.serviceUrl.defaultZone=http://discovery-service:8761/eureka/ 
      eureka.client.serviceUrl.defaultZone: http://discovery-service:8761/eureka/
    ```

    <img
        src = "../../Image/docker/docker_compose/2.png"
        width = 900px
        height = 450px
    />


* networks : 네트워크 설정
    - docker-compose로 컨테이너를 구성해서 띄울경우에는, "현재 docker-compose.yml이 존재하는 최상위 디렉토리명과 동일한 이름 + _default"의 network로 자동으로 묶이게 됨.

    - 사용자가 정의한 network 를 사용할 시에만 따로 networks 설정을 명시해 주면됨.

    - 사용자 network를 사용할시, 최하단에 services와 같은 레벨에서 따로 정의를 해줘야 사용이 가능.
        - driver의 default가 설정되어 있으므로, 굳이 명시 안해도 되긴함.
        - driver default 
            - docker-compose : bridge
            - docker swarm의 stack : overlay
        ```yml
        networks:
          [사용자 네트워크 이름]:
            driver: [드라이버 종류]
        ```

    - 사용자 정의 network를 사용시 network의 이름은 "최상위 디렉토리명_사용자정의 network이름"으로 만들어짐.

    <img
        src = "../../Image/docker/docker_compose/3.png"
        width = 900px
        height = 500px
    />

* ports : 포트 포워딩

    <img
        src = "../../Image/docker/docker_compose/4.png"
        width = 900px
        height = 500px
    />

* container_name : 컨테이너 이름을 사용자가 정의할 수 있음.




### 🐳 위의 설정대로 docker-compose를 실행한 결과


<br>

* container name과 network name 확인!

<img
    src = "../../Image/docker/docker_compose/7.png"
    width = 900px
    height = 100px
/>

<img
    src = "../../Image/docker/docker_compose/6.png"
    width = 900px
    height = 100px
/>

<img
    src = "../../Image/docker/docker_compose/5.png"
    width = 900px
    height = 800px
/>



### 🐳 사용한 docker-compose.yaml

```yaml
version: "3"

services: 
  discovery-service:
    image: 'local/discovery-service'
    networks:
      - marizoo
    ports: 
      - 8761:8761

  apigateway-service:
    image: 'local/apigateway-service'
    environment:
      # - eureka.client.serviceUrl.defaultZone=http://discovery-service:8761/eureka/ ('='이나 ':' 모두 가능)
      eureka.client.serviceUrl.defaultZone: http://discovery-service:8761/eureka/
    networks:
      - marizoo
    ports:
      - 9999:9999

  user-service:
    image: 'local/user-service'
    environment:
      eureka.client.serviceUrl.defaultZone: http://discovery-service:8761/eureka/
    networks:
      - marizoo
    
  owner-service:
    image: 'local/owner-service'
    environment:
      eureka.client.serviceUrl.defaultZone: http://discovery-service:8761/eureka/
    networks:
      - marizoo

networks:
  marizoo:
    driver: bridge

```

<BR>
<BR>
<HR>
<BR>
<BR>

### 🐳 build 명령어를 이용한 docker-compose

* build: docker build 명령어를 실행할 디렉토리 명을 명시.(dockerfile이 당연히 내부에 존재해야 함.)

<img
    src = "../../Image/docker/docker_compose/8.png"
    width = 900px
    height = 600px
/>


* 이름 규칙
    - image name : 최상위 디렉토리명(msa_gradle_test)_[각자 service 명]으로 생성.
    - container name : image name과 동일한 형식으로 만들어짐.


<BR>
<BR>
<HR>
<BR>
<BR>

## 🌈 docker-compose 명령어

<br>

```zsh
$ docker-compose up         // 모든 컨테이너 생성+실행
$ docker-compose up -d      // 백그라운드로 실행
$ docker-compose down       // 모든 컨테이너 종료+삭제     
```

### 🐳 











