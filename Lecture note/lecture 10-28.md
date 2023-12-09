# 기능반 10-28 강의

가상머신을 구동하는 SW → Hypervisor

Hypervisor 종류

- Vyper -V
- VMWare (workstation, ESXi)
- VirtualBox (Oracle이 제작 → Opensource)

## VMWare  단축키

- ALT + e + n → virtual network editor
- Ctrl + n → 새로운 머신 생성
- Ctrl + d → VM settings

# Virtual Network Editor

Adapter (VMnet) type

- Bridge
    - 실제 호스트의 해당 네트워크 인터페이스 네트워크로 직접 연결
- NAT
    - 실제 호스트의 해당 네트워크 인터페이스 주소로 변환되서 연결
- Host-only
    - 실제 호스트 내부에서만 사용가능
- Partition, Disk
    - disk - 물리적인 disk (ssd, harddisk 전체)
    - Partition 논리적인 Disk (물리적인 Disk 분할)
- 암호 국룰
    - Pa$$worD, sysop

---

# swap

- 가상메모리
- 메모리가 초과되면 사용하지 않는 프로세스 메모리정보를 디스크에 보냄

## VMware Template

- Template VM에는 Snapshot이 있어야함

## VMWare Clone

- Linked clone - VMware snapshot
- Full clone
    - VMware Snapshot(Ctrl = m)
        - 현재 시점 기록
        - 기록 시점으로 돌아가기
        - 기록 시점에서 Clone

## Linux device

- /dev folder에 위치함
- 알아야 할 것들
    - cdom → sr0
    - sr0 (좀더 원천적임)
    - sd{x | x는 알파벳 순서대로}
        - 디스크| 파티션을 나타냄
        - /dev/sda1 → /dev/sda 디스크의 1번째 파티션
        - /dev/sda → /dev/sda 디스크
    - tty{x| x는 0부터 시작}

## Linux tty

- Ctrl + Alt + F1~(F1 tty 1으로 전환)

---

## Linux 명령어

- sudo - 일반적인 root 권한을 사용할수 있음
- su (set user)
- sudo su  - root로 감
- mount
    - mount <device> <folder>
- fdisk
- df → 디스크 용량과 사용량을 알 수 있음
    - df -h (h옵션을 사용할시 Human readable size로 변환)
- du → (현재, 지정한 디렉토리의 사용량을 출력)
    - du -sh
- fallocate → 해당 용량의 file 을 생성
    - fillocate - <size> <filename>
- cd → change(choose) directory → working 디렉터리 변경
    - working directory - 절대 경로로 포현되는데 그렇지 않은 경우
        - ‘~’ → 현재 사용자의 Home direcory
        - ‘~user’ → user 사용자의 home directory
- touch
    1. 0byte 파일 생성
    2. 해당 파일에 최종 수정 시간을 update
- ls
    - -a (all) → 숨김 파일까지 포함해서 모두 보여줌
    - -l (list) → 상세정보 (권한, 소유자, 크기, 수정시각)
    - -h (Human readable size)
        - rwxrwxrwx → 권한이 777인 file
        - drwxrw-rw- →  권한이 755인 file
        - lrw-r—r— → 권한이 644인 link
- chmod
    - type1 - numeric) ex> chmod 777 <file/folder name>
    - type 2 - alphabet) ex> chmod +x  <file/folder name>
        
                                             chmod u+x <file/folder name> → user만 execute부여
        
    - -R(recursive) → 하위 폴더까지 모두 권한을 동일하게 적용
    - chown (change owner) - 소유권 변경
- lsattr
    - lsattr (file) →  파일의 속성 확인
- chattr
    - chattr + {alphabet} + {filename}
- 가장 많이 나오는(사용되는)거
    - a(append only), i(immutable, 불변)
    - a option은 추가만 가능
    - i option은 파일에 대해서 아무것도 못함 | 실행은 가능 (명령어를 위한 것)
- rm (remove)
    - -r (recursive) 하위 내용까지 [폴더 삭제시 필수]
    - -f(force) 강제로 삭제
    - ex> rm -rf (현재 폴더에 있는 것이 다 삭제됨) 주의(현재 폴더에 잇는것이 다 삭제됨
- mnan (command/filename)
    - linux 명령어나 설정 파일에 대한 매뉴얼 표시
- mkdir (make direction)
    - -p (parent) → 부모 디렉터리까지 같이 생성
    - mkdir a/b/c 를 하려고 하는데 a/b가 존재하지 않아 만들수 없을때 a/b도 같이 만들어준다
- rmdir (remove directory)
    - 폴더 내부가 비어있어야 함
- mv (move)\
    - 이동, 이름 바꾸기를 할 수 있다
    - ex> mv <filename><newpath>
    - ex> mv<old filename><new filename>
    - 파일의 권한이 그대로 유지됨
- cp (copy)
    - 파일 또는 폴더를 복사 할 수 있다
        - 단, 폴더는 반드시 (-r) recursive option을 같이 사용
    - 파일의 권한이 그대로 유지되지 않는다
        - 따라서 -a(archive)를 사용해 권한을 유지한다
- cat
    - 파일의 전체를 한번에 출력
    - cat의 활용
        - 파일 합치기
            - cat <file 1><file 2> <new file>
        - cat을 통한 text 입력
            - cat > <newfile> << EOF
                - <text……>
                EOF
                - EOF는 End-of-File
- echo
    - 입력한 내용을 출력
- more
    - 파일을 페이지 별로 보여줌
- head
    - 파일의 상단 부분을 보여줌
    - -n <number> 옵션으로 몇줄만큼 볼것인지
- tail
    - 파일의 하단부분을 보여줌
    - -n <number> 옵션으로 몇줄만큼 볼것인지
    - -f 실시간으로 추가되는 내용을 볼 수 있음
- grep
    - 특정 경로(폴더)나 특정 파일 또는 입력에 대한 필터링을 수행 할 수 있음
    - ex> grep -rnw <keyword> <folder>
    - ex echo asdf | grep asdf
- awk
    - 특정 열에 출력된 내용을 filtering할때 주로 사용함
    - ex> ip addr | grep link/ether | awk ‘{print $2}’ → NIC Mac Address 가져올때
- diff (difference)
    - 입력1 입력 2에 대한 차이 확인
    - ex> diff<a> <b>
- wc (word count)
    - -l (line) line의 갯수를 출력
- adduser (user 추가)
    - adduser —gecos “” <username>
    - adduser는 홈폴더도 같이 생성함
    - 홈폴더의 내용은 /etc/skel에서 자동으로 가져옴
    
- deluser (user 삭제)
    - deluser —remove-home <username>

---

## Linux User/ group

- UserID(uid), GroupID(gid)
    - Linux는 모든 계정정보를 숫자로 표현함
    - Linux의 모든 user는 group에 속함
    - user는 한개 이상의 group에 속할 수 있음
    - 범위는 0~63333, 65533 → nobody, nogroup
    - 그룹에 속하지 않은 사용자를 만드려면?
        - user의 gid를 65534로 설정하면 됨
    - 0 → root
    - 1~999 → system user/group
    - 1000~ → general user
    - uid는 1000번부터 생김
- addgroup (group 추가)
- delgroup (group 삭제)
- usermod (user 수정)
    - usermod -aG <groupname> <username>
- passwd (비밀번호 변경)
    - ex > passwd (현재 계정의 비밀번호 변)
- User 정보를 확인하는 방법
    - getent password → 모든 user(네트워크를 통해 받아온 정보 포함)정보
    - cat /etc/passwd → 로컬 인증정보 보기
    - root:x:o:0:root:/root:/bin/bash
    username:password:uid:gid:gecos:homefolder:shell
- getent group → 모든 group 정보
    - vidio:x:44:sysop
    groupname:x:gid:users(’,’로 구분)

## Linux standard Input/Output/Error → redirection/Pipeline

Standard Input (stdin) → 0

Standard Output (stout) → 1

Standard Error (stderr) → 2

1. Redirection method
    1. > | overwrite (덮어씌우기)
    2. >> | append(추가)
    3. 1> → 표준 출력을 redirect
    4. 2> → 표준 에러를 redirect
    5. 2>&1 → 표준 에러를 표준 출력 redirect
2. pipeline
    1. 표준 출력을 명령어에 전달 할 수 있음

---

## Bash Scripting

- 기본 맨 위에 #!/bin/bash를 적는다
- 모든 스크립트는 실행 권한이 있어야 한다

argument 받는 방법

- $0 -> 실행한 파일 이름
- $1,$2,.... -> 사용자가 입력한 argument를 가져온다.

if 연산자 

- if 문
    - 사용자가 $1를 yes을 입력했을 경우, yes 를 출력하고 no를 입력하면 noooo를 출력하기 yes, no 둘다 입력되지 않았을 경우 sorry 출력
- while 문
- for 문
    - range 설정을 2가지 방법으로 가능함
    - ‘seq 0 10’
    - -{1..10}. {001..100}
    - list의 내용을 반복하려면
        - list={”a” “b” “c” “d”} → bash의 list는 띄어쓰기로 구분
- switch-case 문

숙제

1. [user.sh](http://user.sh) 코드를 작성
2. user.hs는 4가지 입력을 받아야함echo
3. create|delete
4. password
5. username
6. 생성개수
7. ex> ./user.sh create password user 10 → user1, user2……user10이 생성
8. ex> ./user.sh delete user 10 → user1, user2,…, user10이 삭제

## Linux vim

- 설치 apt install vim -y
- echo ‘set ic si nu’ >> /etc/vim/vimrc
- ic(ignore case) 검색 시 대소문자 구분 않마
- si(smart indenter)  똑똑한 들여쓰기
- nu (number) - 줄 번호를 표시
- Vim의 Mode
    - Insert
        - a 현재 커서 뒤에서 부터 insert
        - shift +a 현재 라인 맨 뒤에서 insert
        - i 현재 커서 위치부터 insert
        - shift + i 현재 라인 맨 앞에서 insert
        - o → 현재 랑니 밑에 줄 추가후 insert
        - shift+ o → 현재 랑니 위에 줄 추가후 insert
    - Replace
        - shift+r로 replace모드 현재 커서 위치에서 진입
        - 또는, insert mode 에서 insert key를 통해 전환이 가능함
    - Visiual line
        - shift+v
    - Visual Block
        - ctrl + v
    - Command / search
        - <number>y, yy → 해당 줄만큼 복사, 현재 줄 복사
        - <number>d, dd → 해당 줄만큼 잘라내기, 현재 줄 잘라내기
        - p → 붙여넣기
        - u → undo (되돌리기)
        - /<keyword>
            - 검색 후, enter을 해당위치로 커서가 옮겨짐
            - 다음 위치의 <keyword>로 커서를 옮기고 싶으면 n, 위로 가고싶으면 shift + n
    - %s/replace text/new text/g → replace text를 new text로 대체
        - 맨 뒤의 g는 무엇인가요?
            - g를 넣어야 한 라인의 모든replace text를 대체함
            - g를 안넣으면 각 라인에서 한번만 바꿈
        - 들여쓰기
            - >>, <<
        - 잡기술(주석하고 싶은 라인 주석)
            1. 내가 주석하고 싶은 line들을 visual line으로 긁기
            2. >> 들여쓰기를 해서 왼쪽 공간 확보
            3. 왼쪽 공간을 visual block으로 drag하기
            4. ctrl + i로 insert 진입 후, #dlqdur esc 2번
    - :w → 저장 (창을 닫지 않음)
    - :wq → 저장 후 나가기
    - :wq! → 강제로 저장하고 나가기 (read only file에 유용할 수도 있음)
    - :q → 나가기 (대신 파일 수정된 상태면 못나감)
    - :q! → 강제로 나가기 (저장 안됨)

## Linux file permission

- 777 형태로 표현
    - 소유자(user), 소유 그룹(group), 나머지(other)
    - 7 = 4(read) + 2(write) + 1(execute)
- umask (명령어)
    - 파일은 기본적으로 666 / 디렉터리는 기본적으로 777
    - 디렉터리는 실행권한 있으면 접근 가능
- 왜 파일을 만들면 644가 되는가?
- umask 022 라고 profile같은 곳에 설정하게 되면 숫자가 표기된 부분은 제외하고 권한이 설정

---

## 절대경로 / 상대경로

- 절대경로 - 전체 경로가 모두 나와있음 (반드시 ‘/’ 부터 시작)
- 상대경로 - 현재 working directory 기준으로 하는 경로
    - Linux 숨김 파일
        - 파일이름 앞ㅁ에 ‘.’을 붙이면 된다

## Linux Directory 구조

- Tree 형태
- Windows와 다른점?
    - Windows는 거의 각 파티션이 (/) 이 됨
    - 그러나 Linux는 반드시 전체가 (/) 에 속해있음
    - 따라서 Linux가 disk를 mount하려면 폴더에 마운트만 가능

## /

- / etc
- /var
- /usr
- /home
- /sys

특정 Linux Directory 표현\

- ‘.’ → 현재 디렉터리
- ‘..’ → 상위 디렉터

---

기능반 10-28 강의에서는 Linux 명령어와 기본적인 사용법, Linux 사용자 및 그룹 관리, 리다이렉션 및 파이프라인, Bash 스크립팅, Vim 편집기 사용법, 파일 권한 설정, 절대경로와 상대경로, Linux 디렉터리 구조에 대해 다루었습니다.