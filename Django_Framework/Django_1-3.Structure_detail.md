# Django Structure Detail
---
<br>

## index

---
![files](/Image/Django/files.PNG)

## config
: 설정파일들이 전부 모여있는 곳. <br>
  유지보수에 용이하게, 이름을 config로 하는 암묵적 규칙이 있음.<br>
  이름을 바꾸거나 임의로 변경시, 찾기 힘든 에러 발생할 수 있음.

#### _init_.py
: "config 가 파이썬 패키지이다." 라고 정의해주는 파일. <br>
    이 파일이들어 있는 폴더는 전부 파이썬 패키지라고 보면 된다.


#### asgi.py
: 배포시 사용되는 파일.


#### settings.py
: 장고가 실행되는데, 필요한 모든 설정값, 변수값들이 존재.


#### urls.py
: view가 받기 위한 url들이 모여있는 곳.


#### wsgi.py
: 배포시 활용되는 파일.




## manage.py
: 우리가 장고에게 명령어를 쓸 수 있도록 하는 파이썬 파일.
  굉장히 중요한 파일이지만, 자주 건드릴 일은 없음.


