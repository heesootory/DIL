# git branch


## commit & hash

![git](/Image/git&github/9.png)

> 각 커밋은 고유의 해시값을 가지고 있고, 직전 커밋의 해시값을 부모 해시로 참조(ref)한다.
(첫 커밋만 부모 커밋이 none)



## branch

* 독립적인 작업을 하기 위해, 별도의 작업을 진행하고 서로 맞추기위해 필요.

* 다른 브랜치는 서로 영향을 전혀 미치지 않기 때문에, 실험을 해볼 수도 있고, 버그를 만들어 볼 수도 있음.


### master branch -> main breach

> 기본으로 생성되는 기본 브랜치 이름.

### Head -> Master 의미!?

![git](/Image/git&github/10.png)

* 브랜치 포인터 : 현재 브랜치가 있는 위치. (책의 북마크라고 생각.) 각 브랜치마다 브랜치 포인터가 존재하므로, 브랜치가 여러 개라면 각 브랜치 포인터는 모두 다르다.

* head : 브랜치 포인터에 대한 레퍼런스 포인터. -> 현재 열여있는 작업, 현재 저장소에서 내가 확인하고, 보고 있는 작업을 의미.

> 수없이 많은 브랜치가 존재할 수 있고, 각 브랜치마다 가장 최신의 작업이 결국, 브랜치 포인터이다. 우리는 head를 움직여서 브랜치 포인터마다 옮겨다니면서 병합, 수정, 등 작업이 가능하다.


### branch 명령어

#### 새 브랜치 생성

```zsh
$ git branch
```
> 브랜치 목록을 보여줌.


```zsh
$ git branch <branch-name>
```

* 새 브랜치로 이동은 X.

* 현재 커밋을 가르키는 HEAD를 기준으로 생성.

![git](/Image/git&github/11.png)

> 브랜치를 생성한 직후.  HEAD 는 여전히 마스터에 있고, 새 브랜치가 생성만 된 상태로 작업이 안 이루어졌기 때문에, master에 일단 존재.

> 2개의 브랜치 래퍼런스가 같은 곳을 가르킴.

#### 브랜치 이동

```zsh
$ git switch <branch-name>
```

* 브랜치를 이동한다는 말은 결국, HEAD를 다른 브랜치 포인터로 이동시킨다는 말.

![git](/Image/git&github/12.png)
![git](/Image/git&github/13.png)

> 브랜치가 oldies로 바뀜. git log에서 아직 master브랜치가 나오는 이유는 oldies에서 작업을 한적이 없어서, 아직 둘다 같은 곳을 가르키고 있기 때문.

![git](/Image/git&github/14.png)

> 새 브랜치에서 작업 후, commit 

> 현재 oldies 브랜치에 HEAD가 존재하는 것이고, master브랜치는 북마크처럼 접어둔 상태.

![git](/Image/git&github/15.png)
![git](/Image/git&github/16.png)
![git](/Image/git&github/17.png)
![git](/Image/git&github/18.png)
![git](/Image/git&github/19.png)

> swtich를 이용해, master로 돌아가서 작업하던걸 확인하면, oldies에서 작업한 것 이전의 것으로 되있는 걸 볼 수 있다.

> git log 또한 master에 해당되는 작업이력만 출력됨.









































