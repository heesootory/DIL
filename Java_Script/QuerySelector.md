# javascipt

<br>


---
## 특징

* 함수 밖에 만들어진 변수는 전역변수가 아니라, 함수내에서 사용이 불가하다.
함수 내에서 사용하려면, 함수 내에서 변수를 정의 해야함.

* ==과 ===는 다르다
> '100' == 100  -> True <br>
> '100'=== 100  -> False<br>
>  100 === 100  -> True

* html 문서에서 받아온 숫자들은 모든 string type이다.
> 보통 html에서 받아올 경우, document.querySelector("form")을 사용해서 받아오는데, 모두 string 타입이므로, 계산을 할시 ParseInt로 형변환을 해주자.

* 문자형인데도, 숫자타입과 계산이된다!
>  결과가 제대로 나오므로, 항상 typeof(variable) 을 이용해서, 타입을 잘 확인하고, 사용하자.

* 숫자-> 문자
> String(number);
* 문자 -> 숫자
> parseInt(str);


<br><br><br>
---
## 함수 정리

* innerText = ``
> html에 있던 글씨는 무시하고 추가.
```js
clock = `현재 시간 - ${hours}:${minutes}:${seconds}`;
```

<br>

* padStart(2, "0") : 문자열 형태를 무조건 두자리로 앞에서부터 0으로 채운다.
```js
cosnt seconds = String(new Date().getSeconds()).padStart(2, "0");
``` 
> 01, 02, 03,,,,09, 10 ,11 출력.

<br>

* setInterval(function, ms)
```js
setInterval(getClock, 1000);
```
> 해당함수를 1000ms(1초)마다 반복적으로 실행.

<br>





