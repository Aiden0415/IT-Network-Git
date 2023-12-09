# Part 6 Switch
## STP의 동작과정

- 브리지 ID란?
    - 브리지나 스위치가 서로 통신하기 위해 하나씩 가지고 있는 번호
    - 총 8비트
    - 앞의 2바이트(16bit)는 Bridge Priority
    - 뒤의 6바이트(48bit)는 MAC 주소로 이루어짐
    - 브리지 id의 맥주소는 스위치에 고정된 맥 주소이
- Path cost란?
    - 브리지가 얼마나 가까이, 얼마나 빠른 링크로 연결되있는지 확인할 수 있는 값
    - 원래 IEEE.1D에서는 1000Mbps를 자신의 속도로 나눈 값을 사용함
    - 기술의 발전에 따라 다양한 속도가 나오면서 소수점이 나오지 않도록 Path cost의 정수값을 정의함

## STP의 3대 구성요소

1. 네트워크당 하나의 Root Bridge를 갖는다
2. 루트브리지가 아닌 나머지 브리지(Non Root Bridge)는 무조건 하나씩의 루트 포트(Root port)를 갖는다
3. 세그먼트(Segment)당 하나씩의 데지그네이티드(Designated port) 포트를 갖는다
- 루트 브리지(Root Bridge): STP에서 가장 기본이 되는 브리지
- 루트 포트(Root port): 루트 브리지가 아닌 나머지 브리지, 루트브리지에 가장 가까운 포트
- 세그먼트(Segment): 브리지 또는 스위치 간에 서로 연결된 링크

> STP에서 루트 포트나 데지그네이티드 포트가 아닌 나머지 포트는 다 막아버린다
> 

## STP의 순서 정하기

1. 누가 더 작은 Root BID를 가지는가?
2. 루트브리지까지의 Path cost는 누가 더 작은가?
3. 누구의 BID가 더 낮은가?
4. 누구의 포트 ID가 더 낮은가?
- BPDU: STP 정보를 주고받기 위한 특수한 프레임 | Root BID, Root path cost, Sender BID, Port ID가 실려있음
- 브리지나 스위치가 부팅을 하면 각 포트마다 2초씩 한번 BPDU를 내보내면서 서로의 정보를 주고받음

## Root Bridge 선출

- 무조건 낮은 BID를 갖는 장비가 루트 브리지가 됨
- BID를 사용자가 더 작은 값으로 설정할 수 있음

```jsx
Spanning-Tree vlan 1 priority 100
```

## Root port 선출

- 모든 non root bridge는 반드시 한개의 루트 포트를 갖는다
- Root path cost: 루트 브리지까지의 path cost
- Root port는 루트 브리지에서 가장 가까운 포트로 선정

## Designated Port 선출

- designated 포트를 뽑아야 어떤 포트를 닫고 어떤 포트를 열지 결정
- 루트브리지까지의 path cost가 가장 작은 포트가 선정되는데 이말은 즉슨 루트 브리지의 모든 포트가 designated port로 선정된다는 뜻이다

## STP의 5가지 상태변화

- Disabled - 포트가 고장나서 사용할 수 없거나 관리자가 일부로 포트를 Down시켜놓은 상태
    - 데이터 전송 불가
    - MAC 주소 학습 불가
    - BPDU 교환 불가
- Blocking - 스위치를 맨 처음 켜거나 disabled되어 있는 포트를 관리자가 다시 살렸을떄 블로킹 상태로 돌입 이 상태에서는 BPDU만 교환함(위의 루트 브리지, 포트 등 설정이 일어남)
    - 데이터 전송 불가
    - MAC 주소 학습 불가
    - BPDU 교환
- Listening- 블로킹 상태에 있던 포트가 루트포트나 데지그네이티드 포트로 선정되면 바로 리스닝 상태로 넘어가게 된다. | 네트워크에 새로운 스위치가 접속했거나 구성값이 바뀌면 바로 designated 포트로 상황이 변할 수 있음
    - 데이터 전송 불가
    - MAC 주소 학습 불가
    - BPDU 교환
- Learning - 리스닝 상태의 스위치 포트가 포워딩 딜레이(Forwarding Delay) 디폴트 시간인 15초 동안 그 상태를 유지하면 리스닝 상태에서 러닝 상태로 넘어가게 된다 이 상태는 맥 주소를 학습해 맥 테이블을 만들게 된다
    - 데이터 전송 불가
    - MAC 주소 학습
    - BPDU 교환
- Forwarding - 스위치가 러닝 상태에서 다른 상태로 넘어가지 않고 다시 포워딩 딜레이(Forwarding Delay) 디폴트 시간을 버티면 포워딩 상태로 넘어감
    - 데이터 전송 시작
    - MAC 주소 학습
    - BPDU 교환
- 리스닝, 러닝, 포워딩 상태에서는 언제나 블로킹 상태로 변할 수 있음(루트. 데지그네이트 포트에서 탈락하면)
- 언제든 사용자에 의한 shutdown이나 고장으로 인한 disable 가 발생할 수 있음

## STP의 변화

- 루트 브리지는 2초마다 hello BPDU를 non root bridge에게 보내는데 만약 non root bridge가 지정된 시간동안 hello패킷을 받지 못한다면 STP를 재편성 하는 모드로 들어감
- Hello Time: 루트브리지가 얼마만에 헬로 BPDU를 보내는지에 대한 시간 (default 2sec)
- Max Age: 브리지들이 루트 브리지로붙 헬로패킷을 받지 못하면 max age 만큼 기다린 후 트리 변경을 시작
- Forwarding Delay: 브리지 포트가 블로킹 상태에서 포워딩으로 넘어갈때까지 걸리는 시간

## 카타리스트 스위치

- PoE (Power over Ethernet) - 이더넷 케이블 위에 데이터만 보내는게 아닌 전원까지 싫어 보내는 것
    - IP phone이나 AP(access point) 같은 무선 랜 장비, ip 감시 카메라에 데이터와 전원을 같이 공급하기 위해 만들어 짐

## 맥 어드래스 (MAC address)

- Dynamic 방식 - mac 주소를 자동으로 학습하는 방식
    - 맥 주소를 하나 배우고 나면 맥 테이블에 저장해 사용하는데 300초가 지나도록 이용하지 않으면 mac 테이블에서 삭제한다
- Permanent 방식 - 사용자가 직접 수동으로 주소를 넣어주는 방식(삭제되지 않음)

```jsx
mac-address-table static aaaa.aaaa.aaaa.aaaa vlan 1 interface fastEthernet 0/24 
//맥 주소 aaaa.aaaa.aaaa.aaaa가 vlan 1을 통해 들어왔을때의 목적지를 fa0/4를 static으로 구성함
clear mac-address table  //맥 주소를 삭제함
```

## VLAN

- vlan을 사용하면 한대의 스위치를 여러 분리된 스위치처럼 사용하고 여러개의 네트워크 정보를 하나의 포트를 통해 전송 할 수 있음
- 트렁크 포트 - 하나의 포트를 통해 다른 여러개의 vlan을 전송할 수 있게 하는 프로토콜

## VLAN에서의 Trunking, VTP

- 트렁킹도 ISL 트렁킹, IEEE 802.1Q 트렁킹 2가지가 있다
- ISL - 시스코에서 만든 트렁킹 프로토콜로 시스코 장비끼리만 사용
- IEEE 802.1Q - 트렁킹에 대한 표준 프로토콜
    - 네이티브 VLAN(Native Vlan) : 패킷에 vlan 정보를 붙이지 않고 보내는 vlan (Untagged 트래픽이라고도 부름)
- ISL(Inter-Switch Link) 방식은 시스코만의 트렁킹 프로토콜로 스위치간의 링크, 스위치와 라우터 간의 링크에서 여러개의 vlan정보를 함께 전달하는 방식
- IEEE 802.1Q 와 큰 차이는 없지만 Native VLAN라는 개념이 없어 모든 vlan에 이름표를 붙임
- 트렁킹 - 여러개의 vlan을 한번에 전송하는 방식
- VTP - 스위치간의 vlan 정보를 서로 주고받아 스위치들이 가지고있는 정보를 일치시켜주는 프로토콜
- VTP가 주고받는 메세지
    - Summary Advertisement - vtp 서버가 자기에게 연결되어 있는 스위치들에게 5분마다 한번씩 전달하는 메세지로 자신이 관리하는 vtp domain에 대한 Revision 번호를 보내 최신버젼인지 아닌지릃 판단 | summary advertisement는 vlan에 구성이 생겼을때 5분을 기다리지 않고 바로 전송
    - Subset Advertisement : vlan의 구성이 변경되었거나 VTP 클라이언트로부터 Summary Advertisement 메세지를 받았을 때 전송됨
    - Advertisement Request : 클라이언트가 vtp 서버에 summary advertisement와 subset advertisement를 요청하는 용도로 사용됨
    
- VTP 서버 모드 - vlan을 생성, 삭제, 이름을 수정할 수 있으며 나머지 스위치에게 이름, 구성, configuration revision 넘버를 전달해 줄 수 있다
- VTP 클라이언트 모드 - vlan을 만들거나 삭제, 이름을 바꾸는게 불가능하고 다른쪽 스위치한테 전달하는 것 만 가능
- VTP 트랜스페어런트 모드 - 들어온 메세지를 자기를 통해 연결된 다른 스위치 쪽으로 전달해 주거나 자기와 연결된 다른 스위치쪽에서 서버쪽으로 가는 vtp 메세지를 전달해 주는 역할을 한다