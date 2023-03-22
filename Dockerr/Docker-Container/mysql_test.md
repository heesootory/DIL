# mysql docker 설정



<br>
<br>
<hr>
<br>
<br>

## docker run 실행

<br>

```zsh
docker run -d -p 3306:3306 --name mysql-server -e MYSQL_ROOT_PASSWORD=1234 mysql:latest
```


## docker-compose script


```zsh
mysql:
    container_name: mysql-server
    image: 'mysql:latest'
    ports:
      - 3307:3306
    environment:
      MYSQL_ROOT_PASSWORD: ssafy
```

