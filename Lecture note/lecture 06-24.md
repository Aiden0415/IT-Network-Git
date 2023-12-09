# 기능반 06-24 강의

> Network : 정보를 주고받는 것
> 

## MEDIA(매체)

> 전자기파
> 
1. Copper (구리선) - 거리 500m / 전기신호 이용 +- 2.5V 이용
2. Fiber opticel (광섬유) - 거리 70km / on, off 로 0, 1을 표현
3. Radio wave (전파) - 거리 매우 김 / 진폭변조, 주파수변조 두 변조를 이용해 0, 1 을 표현

> LAN: 아나로그 포트 사용
> 

> WAN → MAN 현재는 사용하지 않음
> 

> Internet
> 
- LAN과 INTERNET을 연결하는 Gateway(라우터) 가 있음

1. Unicast (1:1) / 양방향 통신
2. Broadcast (1:N) / 불특정 다수에게 통신 - 단방향
3. Multicast (1:M) / 단방향 - 특정한 그룹에 서비스

> broadcast는 Unicast 전 수행되어야함
> 

물리적 주소: MAC - 47bit - IEEE에서 할당 

논리적 주소: IP - 32bit - IANA 할당

> Broad band → 주파수 분할방식
> 

> Base band → 시분할 방식
> 

## OSI 7 layer

- 7~5 = upper layer (Application)
- 4~1 = Data layer

## Layer 7 (Application Layer)

- HTTP, HTTPS, IMAP, POP3, DNS, DHSP

> HTTP / HTTPS
> 
- 대칭키 기반 암호화 방식 / 비대칭키 암호화방식
- 대칭키 → 암호화 key = 복호화 key
- 비대칭키 → 암호화 key ≠ 복호화 key
- Wireshark : 랜카드를 통해 오거나 나가는 트래픽을 캡쳐하는 툴
- Wireshark HTTP 트래픽 : 전부다나와 → 보안성이 떨어짐

## Layer 6 (Presentation Layer)

- hwp,txt 기타 확장들이 뭔지 판단
- 데이터를 표현해서 파싱을 한다
- 파싱: 데이터 → packet단위로 분해해서 검사

## Layer 5(session Layer)

- 5게층은 4계층을 제어하는 역할
- Telnet, ssh
- 좀 더 안전한 세션을 확립하고 중지하고 실행
- 4-way Handshaking (세션 종료)

## Layer 4 (Transport)

- 4계층은 분할 - MSS (1460) - 합치는 과정 / 에러제어의 역할을 함
- 4계층은 flow control (흐름제어)를 하며 TCP/UDP 이용
- 1480bit로 분할 후 이동
- TCP, UDP \IP
    
    > TCP/IP
    > 
    - Flag 패킷에다가 추적을 할 수 있음
    - 신뢰성 향상
    
    > UDP/IP
    > 
    - 속도가 빠르지만 신뢰성이 떨어짐
- 3-way Handshaking (세션 확립)

## Layer 3 (Network)

- 3계층은 어느 PC로 이동할지 결정하는 역할을 함
- L3 pdu = Packet
- Mtu(1500)

## Layer 2 (Data Link)

- MAC 주소를 보고 통신을 함
- L2 pdu = Frame

## Layer 1 (Physical)

- 네트워크 통신을 위한 물리적인 표준을 정의하는 계층
- 두 컴퓨터간의 전기적, 기계적, 절차적 연결을 정의하는 계층
- Physical 계층 장비 : 리피터, 허브
- L1 pdu = bit

## Encapsulation

- 7~1계층까지 내려오면서 헤더를 붙이는 과정

## De encapsulation

- 1~7까지 역으로 올라가는 방법

## 포트

0 ~ 1023 - Wellknown port

1024 ~ 49151 - Resistered port

49152 ~ 68735 - Dynamic port

# Ethernet

- LAN 구간에서 사용되는 네트워킹 방식 중 하나 (Layer 2 에서 사용됨)
- 가장 큰 특징은 CSMA/CD 방식으로 통신함
- Ethernet이 Frame을 전송하는 방식은 Full-duplex, Half-duplex 가 있음

## CSMA/CD (Carrier Sense Multiple Access / Collision Detection)

- half-duplex에서 동작하는 링크에서 ethernet이 frame을 전송하는 절차

> TokenRing access : 토큰을 하나씩 주고 받으면서 통신 순서를 기다림
> 
- 단점 : 중요한 데이터를 보내야하는 PC가 뒷 순서이면 통신 속도가 느리다.
1. 호스트가 Frame을 전송하기 전에 네트워크 상에 다른 Frame이 전송되는지 확인 - Carrier Sense
2. Ethernet에 연결된 장비들은 네트워크 상에 Frame의 흐름이 없을떄 서로 동시에 Frame을 전송할 수 있다 - Multiple Access
3. Ethernet은 복수의 장비가 동시에 Frame을 전송할 수있고, 이 경우 충돌이 일어날 수 있기 때문에 전송후 충돌 발생 여부를 확인
4. 충돌이 발생하면 Frame을 전송한 장비들을 서로 랜덤한 시간을 대기했다가 재전송
5. half-duplex 네트워크에서는 데이터 전송량이 많을때 Frame 충돌이 자주 발행
6. Ethernet 장비들은 충돌 발생시 최대 15회 까지 재전송을 시도 ,그래도 실패시 포기

---

# Ethernet frame 구조

1. Preamble
- Frame 전송의 시작을 나타내는 필드, 101010이 반복되는 7byte 길이의 필드
- 수신 측에 Frame이 전송된다는 것을 알리고 0과 1을 제대로 구분할 수 있게 Synchronization(동기화)신호를 제공하는 역할
1. SFD(SOF)
- 10101011의 값을 가지며 Frame의 시작을 알리는데 사용
1. 목적지 주소
- Destination MAC address 즉, 수신지의 MAC address
1. 출발지 주소
- Source MAC address 즉, 출발지의 MAC address
1. 타입 or 길이
- 상위 계층 프로토콜, 데이터필드의 길이나 MAC 클라이언트 프로토콜의 종류를 표시
1. 데이터
- 상위계층에서 받은 캡슐화 된 데이터 (packet)
1. FCS (Frame Check Sequence)
- 오류 검출용 필드
- 전송되는 이더넷 프레임의 목적지 MAC 주소부터 데이터 필드까지 에러발생 여부를 확인하기 위한 필드

# 5-4-3-2-1 rule

- 네트워크 카드 사이에 리피터를 설치함에 있어서 **4**개까지의 설치만 권장됨을 표현하는 초기의 네트워크 디자인 **규칙**
- **5**개의 구간, **4**개의 리피터, **3**개의 중계구간을 의미한다. Max **5** segments. Max **4** repeaters.
- 512bit time = 64byte = Ethernet slot Time

## Physical Layer (물리)

- 인접장비간 적용되는 물리적 protocol(신호 변환 방식, 속도, LAN에 사용되는 connector 및 cable 종류 등) 정의

> 리피터
> 
- cable 전송으로 약화된 신호를 초기화, 증폭, 재전송의 기능을 수행

> 허브
> 
- 리피터와 마찬가지로 전기적 신호를 증폭

## Data link Layer

- MAC address를 사용하는계층

> LLC, MAC
> 

## Network Layer

- ip 주소를 사용하는 계층

> Router
> 
- 라우터와 L3스위치는 IP 주소 등으로 Layer 3 header에 있는 주소를 참조하여 목적지와 연결되는 포트로 Packet을 전송
- 라우터는 특정 인터페이스를 통하여 수신한 packet의 목적지 ip 주소를 보고 목적지와 연결된 인터페이스를 통하여 전송할 것을 결정
- 스위치는 멀티캐스트, 브로드캐스트, 목적지를 모르는 유니캐스트를 수신할 경우 수신포트를 제외한 모든 포트로 flooding
- L3 장비들은 이런 Frame을 모두 차단

## UTP

- 대표적인 LAN Cable : UTP cable
- 장점 - 설치가 쉽고 저렴, 작은 외부 작은 외부 직경
- 단점 - 다른 매체와 비교해 외부 간섭과 전기적인 간섭에 약하다
- 상대적으로 속도가 느렸었음
- 최대 전송 길이 : 100M

## STP

- Cable 절연체로 감음
- UTP보다 성능이 우수 (외부 간섭으로부터 모든 장치 보호)
- 단점 - 설치가 어렵고 비용이 높음
- 최대 전송 거리: 100M

## Straight-through cable

1. 청색 +48V
2. 주황색 (TX) 주+횐 = +
3. 녹색 (RX) 녹 + 횐 = +
4. 갈색 -48V

## ip address

- TCP/IP 프로토콜을 사용하는 장비들을 구분해주기 위해 만든 것이 바로 IP address.
- IP 는 논리적인 주소
- 사용 가능한 IPv4 주소
- 2^32 = 약 42억 9천개 - 최근들어 IP 부족해 공인 IP주소를 얻기 쉽지 않음
- IPv6, 사설 IP등으로 해결
- IP 주소는 Network 부분과 Host 부분으로 규정
- 총 네트워크 범위에서 Network field에 1을 할당하고 Host field에 0을 할당한 값이 Subnet mask

## Subnet mask

- Host field를 모두 0으로 채우면 Network Id
- Host field를 모두 1로 채우면 Broadcast 주소
- 위 둘은 IP 주소로 사용할 수 없다
- 2진수로 표현헸을때 1이 연속적으로 나와야 한다

## Class A (0~127)

- 0과 127은 제외되고 1~126까지 사용
- 0.0.0.0은 All-zero
- 127.0.0.0 Localhost
- 위 둘은 일반 IP 주소로 사용하지 않는다

## Class B (128~191)

- 128~191까지 Class B
- Default Subnet Mask : 255.255.0.0 (/16)

## Class C (192~223)

- 192~223까지 Class C
- Default Subnet Mask: 255.255.255.0 (/24)

## Subneting

- ip를 효율적으로 낭비 없이 분배하고 Broadcast Domain의 크기를 작게 나눠주는 것이 Subneting.
- Class별 default Subnet mask로 사용자의 상황에 따라 하나의 네트워크를 작게 여러개로 나눠 사용 → Classless
- 즉, Classful Network를 여러개의 Network로 나누는 것
- 과거에는 Subneting 된 첫번째, 마지막 네트워크를 사용하지 않았다

## VLSM (Variable Length Subnet Mask)

- Subneting 된 Network를 다시 Subneting 하는 것
- 가장 큰 조건부터 차례로 Subneting 을 해야한다

## CIDR (Classless Interdomain Routing)

- Subnet mask를 깨면서 요약가능
- 표기법
- ex) 10.0.0.1 / 24 → 네트워크 비트 24개로 채워져 있음
- 네트워크 비트수를  /수로 표현하는 방법

## CDP (Cisco Discovery Protocol)

- 연결된 (neighbor)  장비의 정보를 알 수 있음.

## NAT (Network Address Translation)

- Private 주소 ≠ Public 주소
- 사설 IP를 공인 IP주소로 변환하여 나가는 기술
- n개의 IP → 1개의 공인 IP
- 공인 ip 절약
- 보안성 (외부 → 내부) 내부 →외부
- 내부 ip를 그대로 외부 유출 x → Public 공인 IP로 바꿔서 내보냄
- IPv4 주소의 절약