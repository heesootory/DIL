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

