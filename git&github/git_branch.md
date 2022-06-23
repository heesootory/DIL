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

### 기타옵션. git Checkout 대 git switch

```zsh
$ git checkout <branch-name>
```

> 브랜치 이동.(switch와 동일하게)

* git switch의 구식 명령어이다. 아직존재 하지만, 새명령어인 git switch가 나와서 현재에는 브랜치 이동시 switch를 더 많이 사용.

* git checkout은 이동 뿐만아니라, 작업트리의 복원에도 사용되고, 다른 기능들도 추가로 있다. -> docs의 옵션들을 참고.


```zsh
$ git switch -c <branch-name>
$ git checkout -b <branch-name>
```

* 브랜치를 생성하고, 이동까지 진행하는 명령어. (-c : create)


🔥🔥🔥
예제로 해본 작업들은 모두 파일안에서 이루어지는 파일 단위였지만, git branch를 이용해서 폴더나 파일등도 branch마다 다르게 생성되고, 작업할 수 있으므로 좀더 큰 단위로도 생각해보기
🔥🔥🔥


### 스테이징되지 않은 상태로 브랜치 변경.

> 현재 브랜치에서 작업을 마친뒤, git add(스테이징으로올리기)하지 않은 상태에서 브랜치를 변경해보자.

![git](/Image/git&github/22.png)

> 방금 브랜치에서 했던 작업이 사라질 것이라는 오류메세지가 출력.

> 따라서, 변경사항을 커밋하거나 임시로 백업하라고 말하고 있다.
(stash는 곧 배울 내용.)

* 변경사항이 존재할때 커밋하거나 그 작업을 삭제할 것이 아니라면, 다른 브랜치로의 이동이 불가하다.

![git](/Image/git&github/23.png)

> 변경이력을 커밋하고 switch하면 성공.

* 별 건 아니지만, 저런 오류 메세지가 뜰때 왜 뜨는지 아는 것이 중요!

#### 브랜치 변경이 가능한 경우!

![git](/Image/git&github/24.png)

> 위의 경우와 다른게, 새 branch를 만들고 거기서 작업 후, 스테이징하지 않고서도 브랜치  이동이 된걸 확인할 수 있다.

* 앞선 경우와 다르게, 위와 같은 경우에는 새로 만든 브랜치에서 만든 파일이 어떤 브랜치에서도 가지고 있지 않기 때문에, 충돌할 일이 없고 따라서 브랜치 이동이 가능하다!

* 앞선 경우는 다른 브랜치에서도 가지고 있는 파일을 수정했기 때문에, 충돌이 일어날 일을 방지해서 오류메세지가 출력되는 것!

🔥 변경사항을 만들때마다 브랜치 이동전에 항상 등록하고 커밋할 것을 권장!!🔥

![git](/Image/git&github/25.png)

🔥커밋하지 않은 작업이 존재할 때 이 메세지가 출력되므로, 항상 이 메세지가 출력되는지 확인하면서 작업하기!!🔥



### branch 삭제 &  이름 변경

* branch 삭제 
> 삭제할 브랜치 이외의 브랜치에서 아래 명령어 사용으로 브랜치 삭제 가능.
```zsh
$ git branch -d <branch-name>
```

* branch 강제 삭제
> 병합 상태에 상관없이 삭제.
```zsh
$ git branch -D <branch-name>
```

* branch 이름변경
> 삭제할때와 다르게, 이름을 변경할 branch에서 실행.
```zsh
$ git branch -m <new branch-name>
```







































