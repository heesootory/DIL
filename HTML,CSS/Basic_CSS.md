# CSS 기초

## Index
- [CSS 기초](#css-기초)
  - [Index](#index)
  - [style 태그 표기 - Selector](#style-태그-표기---selector)
  - [block과 inline](#block과-inline)
      - [display 태그를 이용해서 서로 변경가능](#display-태그를-이용해서-서로-변경가능)
      - [margin 표기, padding 표기](#margin-표기-padding-표기)
    - [collapsing margins](#collapsing-margins)
      - [모든 요소에 적용](#모든-요소에-적용)
      - [id도 한데모아서 쓸수 있다.](#id도-한데모아서-쓸수-있다)
  - [flexbox](#flexbox)
      - [vh(viewport height)](#vhviewport-height)
  - [position](#position)
    - [position: fixed](#position-fixed)
    - [position: relative](#position-relative)
    - [position: absolute](#position-absolute)
  - [Pseudo Selector](#pseudo-selector)
  - [Conbinator](#conbinator)
  - [State](#state)
    - [active](#active)
    - [hover](#hover)
    - [focus](#focus)
    - [visited](#visited)
    - [focus-within](#focus-within)
    - [조합 가능!!](#조합-가능)
  - [pseudo element](#pseudo-element)
    - [placeholder](#placeholder)
    - [selection](#selection)
      - [first-letter, first-line](#first-letter-first-line)
  - [custom property(색상을 변수로 지정!)](#custom-property색상을-변수로-지정)
  - [Transition](#transition)
    - [ease function](#ease-function)
  - [Transformations](#transformations)
  - [animation](#animation)
  - [Media Queries](#media-queries)

<br><br>

## style 태그 표기 - Selector

대표적인 html태그들은 태그만 적고, 스타일링이 가능. <br>
id나 class설정해준 태그 - .id/ #class로 표시.

1. <mark>css를 따로 파일을 만들어서 사용시</mark> : 
링크와 관계를 명시해주기.

```html
<link href= "style.css" rel = "stylesheet">
```

2. <mark>html파일에 삽입시</mark> :
style 태그를 이용해서, 꼭 head에 넣어주기!

```html
<head>
    <style>{
        div{}
        h1{}
        #id{}
        .class{}
    }
    </style>
</head>
```
<br><br>

---

## block과 inline

<ul>
    <li>block</li>
        <ul>
            <li>양옆에 올수 없다. 아래위로만 쌓이는 구조.</li>
            <li><mark>margin</mark> : box의 border(경계) <mark>바깥에</mark> 있는 공간<br>
            </li> 
            <li>border : 경계</li>
            <li><mark>padding</mark> : box의 border(경계) <mark>안에</mark> 있는 공간</li>
        </ul>
    <li>inline("in the same line")</li>
        <ul>
            <li>옆으로 계속해서 생김.</li>
            <li>height, width 요소를 가질 수 없다.</li>
            <li>padding, margin 은 가질수 있다.</li>
            <li style = "background-color: #ffdce0">But!!!! padding은 모든방향으로 가질 수 있는데, margin은 좌우로 밖에 못가진다!!!!</li>
        </ul>
</ul>
<br>

<span style = "background-color: #ffdce0"> **대부분이 block 구조이다!!!**</span>

따라서, block 구조가 아닌 대표적인 예들만 외워가자!<br>
ex) span, a, img, input 등...

#### display 태그를 이용해서 서로 변경가능
```html
<style>
   div{
       display:inline-block;
   }
<style>
```
> inline으로 인식하지만, 성격은 block처럼, width, height, padding, margin 모두 4방향으로 가질수 있다. -> but 동작이 자연스럽지 않아서, 잘 사용하지 않음.<br>
> (원하지 않은 공간도 생기게됨. 불편.)<br>
> 결과적으로 나오게 된게 <mark>"flexbox"</mark>

#### margin 표기, padding 표기

* 하나만 설정시 : 사방향
* 두개만 설정시 : 상하, 좌우
* 4개 설정시 : 위, 우, 아래, 좌 -> 시계방향
```css
<style>
    div{
        margin: 20px 10px 5px 16px;
        //      top right bottom left -> 시계 방향으로 자동 순서 지정 가능
    }
</style>
```

```css
<style>
    div{
        padding: 20px 10px;
        //       상하, 좌우
    }
</style>
```

### collapsing margins
두 block(box)의 경계가 겹쳐져 있을때, 이 두 box의 margin은 하나처럼 움직임.
(위, 아래 margin만 해당!!)<br>
-> 이상한 현상

```css
<style>     //이럴때 body와 div가 모두 위, 아래 margin이 20px, 5px로 적용됨.
    body{
        margin: 0px;
    }
    div{
        margin: 20px 10px 5px 16px;
    }
</style>
```
-> (body 에 div 하나만 존재할 때, body전체의 높이는 div의 높이가 전부이기 때문에 
아래 코드처럼 현상이 나타남.)

#### 모든 요소에 적용
```css
<style>
    *{
        border: 2px dashed black;   //2px 굵기로, 점선, 검정
    }
</style>
```

#### id도 한데모아서 쓸수 있다.
```css
<style>
    # id1, id2, id3, id4{
        background-color : tomato;
    }
</style>
```
> id1, id2, id3, id4 에 모두 적용됨. -> class 쓰는게 더 나음.

<br>

---

## flexbox

* 자식 엘리먼트에 명시하지 말고, 부모 엘리먼트에만 명시할 수 있다. -> 부모가 자식을 컨트롤!
* 부모를 flex container로 만든 후, main 축, cross 축에 따라 이동시킴.
* <span style = "background-color: #ffdce0">주축(main)과 교차축(cross) 이지 수직, 수평이 아니다!</span>
* justify-content : 주축
* align-items: 교차축
* flex-direction : column/row -> 주축 변경 

```html
<head>
    <style>
        body{
            display: flex;  //이렇게 하고 자식들 컨트롤 -> div들 컨트롤
            justify-content : space-between;       // main-axis 기준
            align-items: center;                   // cross-axis 기준
        }
        div{
            width :50px;
            height: 50px;
        }
    </style>
</head>
<body>
    <div></div>
    <div></div>
    <div></div>
</body>

```
> flex 는 다양한 속성과 성격들이 있어서 연습이 필요!<br>
[flex container 연습 사이트](https://flexboxfroggy.com/#ko)

![flex](/Image/html/flex.png)

#### vh(viewport height)
: viewport = screen
-> 100vh = 100% 화면크기<br>
 화면이 이동해도 그 비율대로 움직인다.

```html
    <style>
        body{
            height : 100vh
            display: flex;  
            justify-content : space-between;       
            align-items: center;                   
        }
        div{
            width :50px;
            height: 50px;
        }
    </style>
```
> 화면을 스크롤로 내려도 계속해서 align-items: center 가 유지된다.<br>
> (화면 세로기준 가운데 위치)

<br>

---

## position

### position: fixed

* 눈에 보이는 화면상에서 특정 위치에 고정시킨다. <br>
* 화면을 이동해도, 계속 같은 위치에 따라다님. <br>
* 넷플릭스의 상위 바 같이 , 함께 이동. <br>
* block개념인, div에 적용했을시, 상위 div를 무시한다. <br>

```html
position : fixed;
top : 15px;     // position  위치 지정
```

![fixed](/Image/html/fixed.PNG)
![fixed](/Image/html/fixed2.PNG)


### position: relative

> 처음에 (원래) 위치한 곳에서 조금씩 이동할때 사용

![fixed](/Image/html/fixed3.PNG)


### position: absolute

> 부모 엘리먼트 중, relative 한 엘리먼트를 기준으로 움직이게 함. <br>
> <span style = "background-color: #ffdce0">부모 중 relative 요소가 없다면, 가장 밖의 relative한 body를 기준으로 움직임.</span>
> (아래 예시)

![fixed](/Image/html/fixed4.PNG)

> 부모 엘리먼트인, div를 relative로 바꿔준다면, div를 기준으로 이동.

![fixed](/Image/html/fixed5.PNG)

<br>

---

## Pseudo Selector

> style 태그로 조건부를 붙흰 태그를 설정가능케 . <br>
> id나 class를 만드는 것보다 훨씬 좋은 방법이다.
* first-child/ last-child - 형제관계(동족 태그랑 상관없음) 들중 첫번쨰와 마지막!
* nth-child(**옵션)
    - n을 사용해 규칙적용 가능.
    - even, odd  
* required/ optional
* input의 옵션들도 정할 수 있음.
    - [~"..."] : ... 문자열을 포함한 모든것.
    - [type = ""/ placeholder = ""] 등

🤞 주의!! <br>
```css
.fruits p:nth-child(1){
    color : red;
}
<div class = "fruits">
        <div>딸기</div>
        <p>망고</p>
        <p>오렌지</p>
        <span>사과</span>
    </div>
```
> 1. fruits의 첫번째 자식 요소가 p태그가 아니기 때문에 선택되지 않는다!!

```css
box-group div:first-child{
    color : red;
    font-weight : bold;
}
<div class = "box-group">
        <div>1</div>
        <div>2</div>
        <div>3
            <div>3-1</div>
            <div>3-2</div>
            <div>3-3</div>
        </div>
    </div>

```
해결 👇
```css
.box-group>div:first-child{
    color : red;
    font-weight : bold;
}
```
> 2. 후손 선택자가 모두 선택이 되기 때문에 1과 3-1 모두 css처리된다!!<br>
> (1만 되는거아님!) <br>
> but, 자식 선택자로 선택해주면 해결 가능.


[관련링크 - MDN](https://developer.mozilla.org/en-US/docs/Web/CSS/Attribute_selectors)


![selector](/Image/html/selc.PNG)
![selector](/Image/html/s1.PNG)
![selector](/Image/html/s2.PNG)
![selector](/Image/html/s3.PNG)
![selector](/Image/html/s9.PNG)
![selector](/Image/html/s10.PNG)
![selector](/Image/html/s11.PNG)


<br>

---


## Conbinator

> 여러 태그를 조합해, 속성 찾기 <br>
> 원하는 만큼 자세히 부모들을 적어서 세부적으로 표시할 수 있다.

🤞 주의!! <br>
* selector로 선택은, 두번째 자식까지만 허용된다. 

![selector](/Image/html/s5.PNG)

![selector](/Image/html/s6.PNG)
> 바로 아래 자식을 표현할때 ">" <br>

![selector](/Image/html/s7.PNG)
> 자식 엘리먼트이면 어디있어도 가능.

![selector](/Image/html/s8.PNG)
> 동일한 계층의 두 엘리먼트에서 하나 다음에 있는 태그를 칭할때 <br>
> -> "+" (p + span = p다음에 있는 같은 계층의 span)

<br>

---

## State

![state](/Image/css/s.PNG)

### active

```css
    button: active{
        background-color: tomato;
    }

<button>Hello</button>
```

> 버튼을 누를시 tomato 색상으로 변함.

### hover

> 마우스가 올라갔을때, 변화.

### focus

> active와 비슷해 보이지만, 키보드로 선택되었을때, 변화. <br>

![focus](/Image/css/s1.PNG)

🤞 주의!🤞  <br>
<mark>active</mark>는 누르는 순간에만, 변화가 있는데, <mark>focus</mark>는 키보드의 입력을 기다리기 때문에, 다른 곳을 누르기 전까지 변화가 유지됨.

### visited

> 링크에만 적용됨. 방문 했던 사이트 변화.

```css
    a:visited{
        color : tomato;
    }

<a href="https://apple.com>Go To apple</a>
```

### focus-within

> focusd 된 자식을 가진 부모 엘리먼트에 적용!

![focus](/Image/css/s2.PNG)
![focus](/Image/css/s3.PNG)


### 조합 가능!!

```css
 form:hover input{          
            border-color: seagreen;
        }

 <form>
    <input type="text" name="" id="">
    <input type="text" name="" id="">
    <input type="text" name="" id="">
</form>
```
>form 영역에 hover될 경우, input이 변함.

```css
 form:hover input:focus{          
            border-color: seagreen;
        }

 <form>
    <input type="text" name="" id="">
    <input type="text" name="" id="">
    <input type="text" name="" id="">
</form>
```
> 마우스도 form안에 있는상태에서, input이 키보드 입력을 받을준비가 될때, 변화<br>
>-> 두 가지 조건을 모두 충족시켜야함!

<br>

---

## pseudo element

### placeholder

>placeholder만 변경하고 싶을때, "::" 두 개사용.

![focus](/Image/css/s5.PNG)

### selection
>"::" 두 개사용.

![focus](/Image/css/s4.PNG)

#### first-letter, first-line
> 첫 글자만, 첫 줄만 변경

<br>

---

## custom property(색상을 변수로 지정!)

* :root{} 안에 변수와 함께 정의.
* 변수 이름은 공백이 없이, 공백은 -로 채워줌.
* 사용할때는 변수처럼 var(변수명)

![focus](/Image/css/s6.PNG)

<br>

---

## Transition

> state 상태를 애니메이션처럼 변화시키는 것.
* 항상 state 없는 속성에 붙히기.
* transition 어떤걸? 몇초? 어떻게?
* transition에서 변화시킬 속성은 state쪽에 존재해야함.

```css
        a{
            color:wheat;
            background-color: tomato;
            text-decoration: none;
            padding: 5px;
            border-radius: 5px;
            font-size: 55px;
            transition: background-color 1s ease-in-out, color 1s ease-in-out;
        }
        a:hover{
            color: tomato;
            background-color: wheat;
        }

<a href="#">Go home</a>
```

```css
        a{
            color:wheat;
            background-color: tomato;
            text-decoration: none;
            padding: 5px;
            border-radius: 5px;
            font-size: 55px;
            transition: all 3s ease-in-out;    
        }
        a:hover{
            color: tomato;
            background-color: wheat;
        }

<a href="#">Go home</a>
```
> "all"이라고 지정할시, a{} -> a:hover{}로 전부다 (여기선 background-color와 color뿐)을 변경.
<br>

### ease function

> 애니메이션 되는 방식.

[공식문서](https://developer.mozilla.org/en-US/docs/Web/CSS/animation-timing-function)

* 기본요소
  - linear
  - ease
  - ease-in
  - ease-out
  - ease-in-out
* cubic-bezier<br>
    : 자기만의 애니메이션 만들수 있음.

<br>

---

## Transformations

> 다른 형제들의 위치를 완전 무시하고, 적용될 속성만 변화.
> rotateX,Y,Z 에 설정한 축이 회전축!

* 회전
  - rotateX(30deg) - deg:각도   : x를 기준축으로 30도 회전
  - rotateY(50deg)
  - rotateZ(80deg)
* 크기
  - scaleX(2) : x축방향으로 두배키우기
  - scale(2,2): x,y축 모두 두배키우기
  - scale(4) : 그냥 4배 키우기
* 옮기기
  - translateX(-60px) : 왼쪽으로 60 픽셀 옮기기.

```css
    img{
        transform: scale(0.4);
    }
```
[공식문서](https://developer.mozilla.org/en-US/docs/Web/CSS/transform)

<br>

---

## animation

> 애니메이션 만들기!!
* keyframes 애니메이션명{from{} to{}} 형식으로 제작.
* %로 진행단계 설정도 가능.(step에 제한 없음)
* 애니메이션될 태그에 "animation: 애니메이션명 진행시간 방식 (infinite)" 속성값 설정. <br>
-> transition과 같은 방식으로 설정.

[추천링크](https://animista.net/)

```html
<style>
        @keyframes supersexyCoinFlip{
            from{
                transform:rotateX(0);
            }
            to{
                transform:rotateX(360deg);
            }
        }
        img{
            border: 5px solid black;
            border-radius: 50%;
            animation: supersexyCoinFlip 5s ease-in-out infinite;
        }
    </style>
</head>
<body>
    
    <img src="image/me1.jpg"/>
</body>
</html>
```
```html
 <style>
        @keyframes supersexyCoinFlip{
            0%{
                transform:rotateY(0);
            }
            25%{
                transform: scale(2);
                 border-radius: 0px;
            }
            50%{
                transform:rotateY(180deg) translateY(-100px);
                border-color: tomato;
            }
            75%{
                transform: scale(5);
                 border-radius: 20px;
            }
            100%{
                transform:rotateY(0);
            }
        }
        img{
            border: 5px solid black;
            border-radius: 50%;
            width: 300px;
            animation: supersexyCoinFlip 5s ease-in-out infinite;
        }
    </style>
```


<br>

---

## Media Queries

```css

```









