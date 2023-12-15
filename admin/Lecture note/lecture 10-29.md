# 기능반 10-29 강의

> 숙제: date formatting 능숙하게 다루기
> 

> 숙제:  linux system이 boot 될때 어떤것들이 순차적으로 실행되는지 | crontab @reboot과 root.local의 순서
> 

> 숙제: ㅣLinux packet forwarding 절차 | iptable chain 처리 절차
> 

pre-up, post-up, managle….

post(후에), pre(전에) 

왜 SNAT→ postrouting이고 DNAT(Port forwarding) → prerouting??

> 숙제: iptables 명령어 공부
> 

> 숙제: stateful/stateless firewall 조사
> 

## Ctrl+alt+F3 = gui ip address

- 오늘 공부할 command
    - time management
    - crontab / rc.local
    - package management
    - serivice management
    - linux networking
    - linux dns service

## VMware showtcut

- 종료 Ctrl +e (graceful shutdown이 아니고 강제종료임)
- reboot Ctrl +r (강제 재시작)
- Alt + m+ m+d → 종료된 VM 삭제
- Alt + m + m + c → vm clone
- Ctrl + tab → 오른쪽 vm으로 전환
- Ctrl + Shift + tab → 왼쪽 VM으로 전환
- Ctrl + G → 바깥에 있는 커서를 내부로 이동

## Linux command -time management

- 서버에서 시간은 왜 중요한가?
    - log
    - 유지시간 (uptime)
    - 인증서 (certificate)
    - 동기화 (synchronize)
    - 스케줄링 (scheduling)
    
- date → 현재 시간을 출력 (system locale에 맞는 시간을 출력)
- UTC +9  | 한국시간 KST + 9
- system locale이 별도 시간대로 설정되어도 UTC로 로그가 작성되거나 동작하는 서비스가 있을수 있으니 주의가 필요
- date 명령어의 경우 formatting을 사용해 특정 값이나 원하는 형식으로 출력 가능
- formatting은 + 로 시작한다

> Linux os의 특징중 하나 - Multi user OS
> 

### 환경변수

Path → 경로에 대한 환경 변수

## crontab / rc.local

- crontab
    - /etc/crontanb
        - system 전체에 해당하는 crontanb
    - 각 user 별 crontab도 있음 (crontab -l / -e)
    - cron 이라는 형식이 있음 →  cron expression
        - M H D M 요일
        - 최소단위 : 1분마다 실행
        - ex> 1분마다 실행하고 싶다. *****
        - ex> 매시간의 1분마다 실행하고 싶다 1****
        - ex> 00시 05분마다 실행하고싶다 0 5 * * *
    - syslog file에 현재 시간을 1분마다 기록하는 script & crontab
        - syslog file에 ‘logger’ 명령어를 사용해 기록가능

## package management

- Linux 계열 | 배포?
    - Debian계열은 APT, Fedora 계열은 DNF를 사
- apt update → update list of available packages
    - apt package들이 저장된 위치(다운로드할 주소)는 /etc/apt/source.list
    - apt upgrade → upgrade 가능한 패키지를 upgrade 한다
- apt install → 패키지 삭제
- apt —purge autoremove <package name>
- apt search

## Service managment

- systemctl 명령을 사용
- service 상태 확인
- service 시작/중지/재시작
- service 등록?

## Linux basic configuration

- package 설치및 기본설정
    - vim, ssh, tcpdump, open-vm-tools, net-tools, dnsutils, curl
    - vim 기본설정
    - ssh 기본설정
- Time zone 설정 (과제에 맞게)
- user 설정 (과제에 맞게)
- AppArmor 비활성화 | 여기서부터 필수
    - Apparmor Debian계열에서 사용되는 보안 솔루션 (like SELInux)
    - 끄는 방법은 boot loader 에서 비활성하면 됨
    - boot loader configuration file : /etc/default/grub
    - sed -i ‘s/quiet/quiet apparmor=0/g’ /etc/default/grub
- sysctl 설정
    - sysctl → Linux Kernel Parameter 설정
    - /etc/sysctl.conf
    - 28번째 line 주석 해제
    - echo ‘net.ipv4.ip_forward=1’ >> /etc/sysctl.conf
- hostname 변경
    1. /etc/hostname 변경
    2. hostname set -hostname <hostname>
- hosts file 변경
    1. /etc/hosts로 직접 수정
    2. sedfh /etc/hosts 변경
- network 설정 변경
    1. /etc/network/interfaces 수
    2. Linux nat
        1. iptables -persistent 패키지 설치
        2. iptables를 재시작해도 기록되게 해주는 용도
    - 기본 명령어
        - netfilter-persistent flush → 현재 저장된 정보 삭제
        - iptables -Z → 현재 iptables의 chain rule, count등 정보삭제
        - iptables -F
        - iptables -X
        - netfilter-presistent save → 현재 iptables 정보 저장
        - iptables -nL → 기본 table에 iptables 설정 확인
        - iptables -t nat -Nl NAT table의 iptables 설정 확인
    1. tcpdump를 통해 들어오는 packet 확인하기
        1. tcpdump -n -p icmp -i ens36
        2. -n → dns 주소 변환 안함
        3. -i → 들어오는 interface 지정
        4. -p tcp port 80 → tcp protocol에서 80번 port에 대해서만 확인가능
- resolv.conf 변경

## DNS 계층구조

- 기본적인 tree 구조
    - TLD - TOP level Domlan
    - SLD - Sub level domain (second)
- DNS Record
    - A record → 정방향 레코드 | NAME → IP (정방향) | IP → NAME (역방향)
    - AAAA → 정방향 레코드 (IPv6)
    - CNAME (canonical) → 별칭
    - PTR (Pointer) → 역방향 레코드
    - MX record → main server record
    - NS → nameserver
    - SOA → domain 정보가 담겨있음
- DNS 질의 절차
    1. local computer cache
    2. hosts file을 봄
    3. dns server 질의 
    4. cache save
1. recursive query (재귀적 질의)
2. iterative query (반복적 질의)
    - Root hint → Root dns 서버의 정보
    - Forwarder → Root viewer을 거치지 않고 바로 가져옴
    - view → client 시점 (IP)
- DNS server 동작 과정
    - recursive (재귀적걸의) →

---

## DNS package → bind9

- apt install bind9 -y
- /etc/bind → bind9 설정 파일들 위치
- /var/cache/bind → zone file이 위치
- zone file필수
    - ns 레코드
    - ns레코드 nameserver 주소의 a레코드가 어떤 dns zone이던지 존재해야함

---

기능반 10-29 강의에서는 시간 관리, crontab / rc.local, 패키지 관리, 서비스 관리, Linux 네트워킹, Linux DNS 서비스 등에 대해 다루었습니다. 또한 VMware의 단축키와 Linux 명령어, 환경 변수, DNS 계층 구조, DNS 패키지인 bind9에 대해서도 다루었습니다.