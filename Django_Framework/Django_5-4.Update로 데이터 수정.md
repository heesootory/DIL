# Update

<br>

---

## index



<br>

---

## Update - GET요청
> 게시물 수정은 Create와 Detail의 기능이 섞여있기 때문에, POST와 GET이 모두 필요.

![CRUD](/Image/Django/r25.PNG)
![CRUD](/Image/Django/u1.PNG)
![CRUD](/Image/Django/u2.PNG)
![CRUD](/Image/Django/u3.PNG)

* view.py
> 분기 문으로 get요청과 post요청을 모두 만들어준다.
* get
> get요청은 단순히 수정하기를 들어갔을때, 페이지를 불러오는 역할이므로, id에 맞는 post를 호출.
* post_card.html
> 조건문으로, 작성자가 현재 로그인된 유저일때만, "수정하기" 버튼이 나오도록 구현.

### 원래 존재하는 글, 그림 불러오기

![CRUD](/Image/Django/u4.PNG)
![CRUD](/Image/Django/u5.PNG)
> template 태그들을 문단 정리하면, 불러오는 글들도 띄워쓰기가 되서 정리x...

* {% if post %}
> 객체(post)만 적어줘도, 있는지 없는지 bool 반환값으로 처리됨.

![CRUD](/Image/Django/u6.PNG)

> 이미지 파일은 현재 존재할 경우, 현재 파일과 변경선택을 모두 넣어줌.

* {{post.image.name}}
> image.name은 파일명을 뜻함.

* action = ""
> 현재 post_form을 create시에도, 사용하고, update시에도 사용하므로, action부분을 없애줘야 각 기능에 맞춰서 자동적으로 들어가게 된다.

<br>
<br>
<br>


## Update - POST요청
> create와 유사.

![CRUD](/Image/Django/u7.PNG)

* create와 똑같이 image와 content를 받아오고,
* save() 함수로 저장

### 문제 : 수정시마다 새로운 이미지가 media폴더에 계속 쌓이기만함.

![CRUD](/Image/Django/u8.PNG)

> 새로운 이미지가 들어왔을때만 동작.
> 
> delete() 함수로 간단히 원래 있는 이미지 제거.


### get_object_or_404 로 받기

> get 요청시, 예외처리 대신에
> get_object_or_404을 이용하면, 손쉽게 해당id가 없을때 404페이지로 넘어갈 수 있다.
> 현재 디버그모드여서 에러창과 유사한 404페이지가 나오는데, 나중에 배포시에는 404페이지도 따로 만들기 때문에, 에러창과 다르다고 할 수 있다.

![CRUD](/Image/Django/u9.PNG)
![CRUD](/Image/Django/u10.PNG)
![CRUD](/Image/Django/u11.PNG)
