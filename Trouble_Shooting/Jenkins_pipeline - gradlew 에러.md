# ./gradlew : commend not found  에러!!



## 🧨 문제

<img
    src = "../Image/trouble_shooting/006_00.png"
    width = 700px
    height = 150px
/>

## 💡 문제 원인

> ./gradlew을 사용할 수 있는 권한이 없음!!

> permission denied!


## 💡 해결

> 젠킨스 pipeline script 작성시. 권한을 주면 가능!

```groovy
sh "chmod +x ./gradlew"
```