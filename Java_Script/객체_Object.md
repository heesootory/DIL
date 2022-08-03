# Object - 객체



## 객체

* 객체는 문자열로 이름을 붙인 값들의 집합체. (key : value)
    - Json 이 이런 모양새.
    - key : 문자열.
    - value : 어떤값이든 가능.
* 객체에 저장하는 값을 프로퍼티(Property)라고 한다.
* 객체는 prototype이라는 특별한 프로퍼티를 가지고 있다.



## 객체 만들기

* 객체 리터럴 이용 : {}
* Object 생성자 이용 : new Object();

```js
let member1 = {};
let member2 = new Object();
function Member(){}
let member3 = new Member();     // 생성자 사용
```

* 객체 프로퍼티로 접근

```js
let member1 = { id : : "shy", email : "hs@naver.com"}
function Member(id, email){
    this.id = id;
    this.email = email;
}
let member2 = new Member("shy", "hs@naver.com")

```

```js
let student = {
    name : "heesoo",
    age : 20,
    hobby : ["공부", "숙면"],
    "favorite singer" : "아이유",
};


```

* 객체 변수에는 주소가 저장되어 공유 가능

```js
let member1 = {id: "hong", email : "hong@naver.com}
let member2 = member1;
member2.id = "kang";

console.log()
```

* 함수안에서의 this는 함수를 호출한 객체

```js
var m1 = {name : "이창걸"}
var m2 = {name : "김승호"}

function msg(){
    console.log(this);
    console.log(this.name + "님이 입장함...")

    m1.msg = msg;
    
}
```






































































