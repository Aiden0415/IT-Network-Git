# 기능반 10-29 숙제

> 숙제: date formatting 능숙하게 다루기 ✅
> 

> 숙제:  linux system이 boot 될때 어떤것들이 순차적으로 실행되는지
> 

> crontab @reboot과 root.local의 순서✅
> 

> 숙제: ㅣLinux packet forwarding 절차✅ | iptable chain ✅처리 절차
> 

pre-up, post-up, managle…. ✅ | post(후에), pre(전에) 

왜 SNAT→ postrouting이고 DNAT(Port forwarding) → prerouting?? ✅

> 숙제: iptables 명령어 공부
> 

> 숙제: stateful/stateless firewall 조사 ✅
> 

---

# Linux system 부팅 순서

## 0. 시스템 전원 공급

- 메인보드의 Rom-Bios에 있는 Bios 프로그램을 실행시킴
    - Rom-Bios(Read only Memory-Basic Input Output System) - 컴퓨터 메인보드에 장착된 컴퓨터 부팅 시 가장 먼저 실행되는 프로그램 (컴퓨터 하드웨어 인식과 장치사용을 위한 인식 및 준비를 위한 가장 기초적인 프로그램)
- Bios 프로그램은 전원공급과 함께 메모리의 특정번지 (ex→ FFF0H)의 BIOS 프로그램을 자동실행한다

## 1. BIOS 단계

- 자체진단기능(POST(Power On Self Test))
- 부팅매체검색과 부트로더 실행
    - POST 과정이 이상없이 진행 완료되면 검색된 부팅매체 (하드디스크, CD-ROM, 플로피 디스크)에서 부트로더 (GRUB, LILO)를 불러들인다
    - ex) 하드디스크가 부팅매체로 선택되었다면 하드디스크의 부팅파티션에 있는 0번섹터 (MBR)에 있는 부트로더(Boot loader = GRUB)를 읽어들임
    - 부트로더(GRUB)가 메모리에 적재되면 BIOS는 종료되고 시스템 제어권은 부트로더(GRUB)이 갖게된다

## 2. 부트로드 단계

### 부트로더

- 리눅스에서 사용하는 부트로더는 LILO(Linux Loader)나 GRUB가 있다.
GRUB는 커널(kernel) 이미지를 불러들이고 시스템 제어권을 커널에게 넘긴다

### GRUB (GRand Unified Bootloader)

- 환경 설정 파일 : /boot/grub/grub.conf(/etc/grub.conf)
- 실행 파일 : /sbin/grub
    - CMOS검사, CPU, MEMORY, 그래픽카드, 키보드, 마우스등 각종 장치들의 이상 유무를 검사하고 하드웨어들을 초기화시킨다.
- 설정 옵션 : /boot/grub/grub.conf

```bash
timeout=5 5초 후 부팅                             /* 부팅시 타임아웃 설정    */ 

default=0 첫 번째로 부팅                          /* 기본 부팅 레이블(예: 0) */ 

hiddenmenu                                       /* GRUB 메뉴 숨김         */ 

splashimage=(hd0,0)/bot/grub/splash.xpm.gz       /* splashimage 위치       */ 

title CentOS (2.6.18-164.11.1.el5)-->            /* 타이틀                 */ 

root (hd0,0) 하드디스크 0번에 존재함               /* root 파티션 위치       */ 

kernel /boot/vmlinuz-2.6.18-164.11.1.el5 ro root=LABEL=/ rhgb quiet 

-> 부트 밑에 내용으로 부팅하겠다 initrd /boot/initrd-2.6.18-164.11.1.el5.img
```

### (RHEL 7 or CentOS 7 이상일 경우)

**/etc/default/grub**

```bash
GRUB_TIMEOUT=5

GRUB_DISTRIBUTOR="$(sed 's, release .*$,,g' /etc/system-release)"

GRUB_DEFAULT=saved

GRUB_DISABLE_SUBMENU=true

GRUB_TERMINAL_OUTPUT="console"

GRUB_CMDLINE_LINUX="crashkernel=auto rd.lvm.lv=centos/root rhgb quiet"

수정 후 # grub2-mkconfig -o /boot/grub2/grub.cfg 명령어로 설정 적용
```

## 3. 커널 단계

- /etc/grub/grub.conf 파일에 의해서 커널이 메모리상에서 실행되면, 하드웨어를 점검하고 /var/log/dmesg 파일에 기록을 해야한다
- 루트 파일시스템 (/)을 읽기 전용으로 마운트 | 만약 마운트 실패시 “**kernel panic**”메세지를 출력
- 커널은 swapper 프로세스 (PID 0번)를 호출
- swapper (PID 0번)은 커널이 사용할 각 장치 드라이브들을 초기화하고 init프로세스 (PID 1번)을 실행하게 된다
- /sbin/init 프로세스가 실행되면서 /etc/inittab 파일을 읽어들여서 그 내용들을 차례대로 실행하게된다

## 4. Init 프로세스 단계

### init프로세스 호출 후

- /sbin/init 프로세스가 실행이 되면 /etc/inittab 파일에 정의된 순서에 따라서 시스템을 초기화하기 시작
- 즉, 로그인프롬프트가 나오는 부팅완료화면까지 init프로세스에 의해서 실행되는 내용들인 것

---

# Stateful | Stateless firewall

## Stateful Firewall (상태 추적 방화벽)

- Stateful 방화벽은 패킷의 상태와 연결 정보를 추적함
- 이전패킷과의 관계를 파악하여 패킷을 승인 또는 거부하는 결정을 함
- 연결을 시작하는 패킷과 해당 연결의 모든 후속 패킷을 관리
- 고급 보안 정책을 구현하고 네트워크 트래픽에 대한 상세한 제어를 제공함 (공격을 감지하고 차단하는 기능 강화)

## Stateless Firewall (상태없음 방화벽)

- Stateless 방화벽은 패킷의 상태와 연결정보를 추적하지 않고 각 패킷을 개별적으로 검사
- 이러한 방화벽은 패킷의 source ip address, 대상 IP 주소, port num 등 기본 정보만을 검사
- 간단하고 빠르게 동작하며 기본적 네트워크 트래픽 필터링에 유용
- 네트워크공격이나 보안 위협에 취약함

---

# date formatting

### ko_KR.utf8 locale 시

```bash
$ date

2020. 04. 12. (일) 13:16:43 KST
```

## C locate 시

```bash
$ date 

Sun Apr 12 13:17:34 KST 2020
```

## format 지정

- 날짜를 원하는 포멧으로 출력할 경우 date + Format 형식으로 사용하면 된다.

```bash
#날짜 출력을 YYYY-MM-DD 포멧으로 출력

$ date "+%Y-%m-%d"

2023-11-1
```

- 시간과 초를 포함하려면 다음 키워드를 사용하며 대소문자에 주의해야함
    - 24 시간: %H
    - 12시간: %I
    - 분: %M
    - 초: %S
    - 오전/오후: %p
    - unix time stamp: %s(소문자)

```bash
#오라클의 date 함수의 YYYY-MM-DD HH24:MI:SS  와 동일한 출력
$ date "+%Y-%m-%d %H:%M:%S"

2023-11-2 13:21:10

#12시간으로 표시하고 오전/오후를 추가하려면 %H 를 %I 로 오전/오후 표시하는 %p 를 사용
$ date "+%Y-%m-%d %I:%M:%S %p"

2023-11-2 13:21:10
```

## 특정 날짜 구하기

```bash
#-d 옵션뒤에 구할 날자의 문자열을 지정
$ date -d "-1 days"

2023. 11. 2. (토) 13:23:05 KST

#한주 전
$ date -d "-1 weeks"

2023. 10. 26. (일) 13:23:30 KST
```

## 시간 설정

```bash
#yyyy-mm-dd (root)
date +%Y%m%d --set="20231102"
or
date +%Y%m%d -s "20231102"
or
date  "+%Y-%m-%d %H:%M:%S" -s "20231102-13:24:50
```

---

# Linux packet Forwarding 절차

## 1. 패킷 수신 (packet reception)

- 패킷 포워딩 프로세스가 시작되면 먼저 네트워크, 인터페이스로 패킷이 옴

## 2. 패킷 검사 (packet inspection)

- 패킷 포워딩 프로세스가 도착한 패킷을 검사하고 목적지 ip 및 포트 번호 확인

## 3. 라우팅 결정 (Routing Decision)

- 패킷 포워딩 프로세스는 라우팅 테이블을 참고해 어떤 인터페이스를 통해 패킷을 전달할지 결정

## 4. NAT (Network Address Translation)

- 패킷 포우딩이 NAT을 포함한다면 출발지 IP주소 및 포트번호, 대상IP주소 및 포트번호를 변경

## 5. 패킷 전송 (Packet Transmition)

- 패킷 포워딩 프로세스가 패킷의 전송 경로를 결정하면 해당 인터페이스로 패킷을 전달

## 6 . 패킷 송출 (Packet Emmision)

- 패킷은 목적지로 전달되며, 네트우크 인터페이스에서 목적지로 라우팅된 패킷을 전송

## 7. 목적지에서의 패킷 수신 (Packet Reception at Destination)

- 패킷이 수신되고 처리됨

---

# iptables chain 절차

> iptables: Linux 패킷 필터링 및 NAT을 위해 사용되는 도구로 체인이라고 불리는 작업세트를 제공해 패킷이 시스템을 통과하는 과정을 제어
> 

## 1. Input Chain

- input 체인은 시스템이 수신한 패킷을 처리하는 체인
- 시스템으로 들어오는 모든 패킷을 검사하며 대부분의 시스템에서 방화벽 규칙을 추가

## 2. Output Chain

- output 체인은 시스템에서 생성된 패킷을 처리하는 체인
- 시스템에서 생성되어 외부로 전송되는 모든 패킷을검사하고 로컬 프로세스에서 나가는 패킷을 제어하는데 사용

## 3. Forward Chain

- forward 체인은 시스템을 경유하여 전달되는 패킷을 처리하는 체인
- 시스템을 라우터로 사용하는 경우 관여하며 패킷이 인터페이스로 들어와 다른 인터페이스로 나가는 경우 처리

## 4.  Pre-routing Chain (PREROUTING)

- prerouting 체인은 패킷이 라우팅 테이블에 들어가기 전에 처리되는 체인
- 패킷에 대한 NAT 같은 변경을 적용하는데 사용

## 5. Post-routing Chain (POSTROUTING)

- postrouting 체인은 패킷이 라우팅 테이블을 통과한 후에 처리되는 체인
- 패킷에 대한 NAT설정 및 마지막 변경을 적용하는데 사용

---

# 왜 SNAT은 postrouting이고 DNAT = prerouting

## DNAT(Destination Network Address Translation)

- DNAT은 패킷이 외부에서 내부로 들어올 때 대상 IP 주소를 변경
- 주로 공인IP주소로 들어온 요청을 내부 프라이빗 IP 주소로 매핑할때 사용 (원격 클라이언트 내부시스템 접근)
- prerouting단계에서 이룽지므로 패킷이 라우팅 결정을 하기전에 대상 IP주소를 변경 | 라우팅 테이블을 참조할 때 패킷은 이미 목적지 IP 주소가 변경된 상태임

## SNAT(Source Network Address Translation)

- SNAT은 패킷이 내부에서 외부로 나갈때 출발지 IP주소를 변경
- 주로 내부에서 외부로 나가는 패킷이 내부 프라이빗 IP 주소에서 공인 IP주소로 변결될 때 사용
- ‘postrouting’단계에서 이루어지므로 패킷이 라우팅 결정을 하고 라우팅 된 후 출발지 IP 주소가 변경

> DNAT은 외부에서 내부로 패킷이 들어오는 경우, SNAT은 내부에서 외부로 패킷이 나가는 경우에 사용
> 

---

# pre-up, post-up, mangle

## Pre-up

- “pre-up”은 네트워크 인터페이스가 활성화 되기 전에 실행되는 스크립트나 명령어를 정의하는데 사용
- ex) DHCP

## Post-up

- "post-up"은 네트워크 인터페이스가 활성화된 후에 실행되는 스크립트나 명령어를 정의하는 데 사용
- 특정 서비스가 시작되거나 다른 네트워크 연결이 설정된 후에 "post-up" 스크립트를 실행하여 관련 작업을 수행할 수 있음

## managle

- “managle”은 Linux의 iptables 방화벽과 관련된 개념으로 사용
- “Managle”테이블은 데이터 패킷의 헤더정보를 조작하거나 변경하는 목적으로 사용
- 패킷의 TTL(생존 시간), TOS(서비스 유형), 라우팅 결정 등을 변경하거나 패킷의 속도를 조절하기 위해 사용될 수 있음
- "Mangle" 테이블은 주로 네트워크 트래픽을 조절하거나 제어하는데 사용되며, 특정 QoS(Quality of Service) 정책을 적용하는 데 유용