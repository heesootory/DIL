# 데이터를 다루는 Serializers


<br>

## index



---

<br>

## Serializers 란?

* Django의 form같은 존재.
    - client이 보내온 데이터에 대한 유효성 검사 & 처리.
    - html을 그려줌.

* json 형태를 기본으로 데이터를 받아온다.(객체 직렬화)
    - 작성자가 작성한 model의 속성들을 데이터가 들어올시, json형태로 변환시켜 저장.
    - json 형태의 데이터를 받아 api가 또 json형태로 응답.

![s](/Image/Django/e26.PNG)
![s](/Image/Django/e27.PNG)
![s](/Image/Django/e28.PNG)

> Serializers 를 BaseSerializers에서 모든 데이터 속성을 받아오고, ListSerializers에서 필요한 속성만 추린후 사용할 수 있다. (exclude를 사용해서, 필요없는 속성을 제외시키는 방법도 있음.)

![s](/Image/Django/e29.PNG)

> 이런 식으로 Serializers를 커스터마이징 해서, 여러가지 필요한 속성들로 구성된 Serializers모델들을 만들어 놓고 사용하면 된다.

* depth 사용해보기

![s](/Image/Django/e30.PNG)
> admin에서 post를 가져오고,
![s](/Image/Django/e31.PNG)
> admin 하나 생성.
![s](/Image/Django/e33.PNG)
> 생성자를 하나 지정.
![s](/Image/Django/e34.PNG)
![s](/Image/Django/e35.PNG)
> depth를 이용해, 그 생성자의 정보까지 모두 긁어온걸 볼 수 있다.











 



















