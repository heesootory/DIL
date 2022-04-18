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
ex) span, a, img, code 등...

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

* 자식 엘리먼트에 명시하지 말고, 부모 엘리먼트에만 명시할 수 있다.
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

> 눈에 보이는 화면상에서 특정 위치에 고정시킨다. <br>
> 화면을 이동해도, 계속 같은 위치에 따라다님. <br>
> 넷플릭스의 상위 바 같이 , 함께 이동. <br>
> block개념인, div에 적용했을시, 상위 div를 무시한다. <br>

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
* first-child/ last-child
* nth-child(**옵션)
    - n을 사용해 규칙적용 가능.
    - even, odd  
* required/ optional
* input의 옵션들도 정할 수 있음.
    - [~"..."] : ... 문자열을 포함한 모든것.
    - [type = ""/ placeholder = ""] 등

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

![selector](/Image/html/s5.PNG)

![selector](/Image/html/s6.PNG)
> 바로 아래 자식을 표현할때 ">" <br>

![selector](/Image/html/s7.PNG)
> 자식 엘리먼트이면 어디있어도 가능.

![selector](/Image/html/s8.PNG)
> 동일한 계층의 두 엘리먼트에서 하나 다음에 있는 태그를 칭할때 <br>
> -> "+" (p + span = p다음에 있는 같은 계층의 span)






