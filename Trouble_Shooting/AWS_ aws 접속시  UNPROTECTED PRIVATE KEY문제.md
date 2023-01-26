# aws 접속시 UNPROTECTED PRIVATE KEY 문제



## 🧨 문제

> aws EC2 최초 접속시, pem키 파일의 권한이 너무 열려있기 때문에 발생하는 문제.

<img
    src = "../Image/trouble_shooting/003_00.png"
    width = 1200px
    height = 200px
/>



## 💡 해결

> 해당 pem 키의 권한을 변경해주고 다시 접속하면 된다.

```zsh
$ chmod 400 xxx.pem
```

