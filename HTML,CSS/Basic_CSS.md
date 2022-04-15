# CSS 기초

## Index
- [CSS 기초](#css-기초)
  - [Index](#index)
  - [style 태그 표기 - Selector](#style-태그-표기---selector)
  - [block과 inline](#block과-inline)
      - [display 태그를 이용해서 서로 변경가능](#display-태그를-이용해서-서로-변경가능)
      - [margin 표기](#margin-표기)
    - [collapsing margins](#collapsing-margins)

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
       display:inline;
   }
<style>
```

#### margin 표기
```css
<style>
    div{
        margin: 20px 10px 5px 16px;
        //      top right bottom left -> 시계 방향으로 자동 순서 지정 가능
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



