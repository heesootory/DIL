# git


## git 이란?

> 버전관리시스템 = "VCS"
* 버전관리는 파일의 변화를 시간에 따라 추적하고 관리하는데 도움을 주는 sw.

* 수많은 작업들을 서로 병합하거나 변화를 비교하거나 변화를 되돌리고, 그 작업들을 다른 사람들과 공유하는데 도움을 준다.

* git은 이런 버전관리시스템 중에 하나고, Subversion, CVS, Mercurial을 포함해 가장 잘 알려진 것중 하나다.

  
## git 사용자이름 & 이메일 설정.

> git 작업을 올리는 사람이 누구인지 사용자의 이름과 이메일이 작업별로 표시된다. 따라서 이름을 지정해놓으면 누가 작업한 건지 알아보기 수월.


* 사용자 이름 확인 (없다면 아무것도 나오지 않음)

```bash
$ git config user.name
```

* 사용자 이름 설정

```bash
$ git config --global user.name "사용자명"
```

* 이메일 확인

```bash
$ git config user.email
```

* 사용자 이메일 설정

```bash
$ git config --global user.email "이메일"
```





















