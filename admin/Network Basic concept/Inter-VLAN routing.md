# Inter-VLAN routing

## Inter-VLAN

- VLAN으로 고립된 각 서브넷 간의 데이터 교환을 가능하게 해줌
- 일반적으로 다른 망 (서브넷) 의 사용자와 통신하고자 할 때 라우터와 같은 3계층 장비가 필요하듯이 Inter-VLAN 라우팅 기술에서도 라우터와 L3 스위치를 이용할 수 있음

## Router-on-a-stick

- 라우터를 이용하여 VLAN 간에 통신을 지원하는 기술
- 한대의 라우터가 하나의 LAN 인터페이스를 통하여 스위치와 연결되어 2개 이상의 VLAN 간의 라우팅을 수행하는 방식
- 스위치와 연결된 라우터의 포트는 스위치의 트렁크 포트 역할 수행
- 스위치와 라우터가 연결된 케이블을 Stick으로 보고 이 위에 라우터가 놓여있어서 붙여진 이름
- 서브넷(VLAN)간의 모든 트래픽이 라우터와 LAN 인터페이스로 집중되기 떄문에 망의 크기가 소규모일 경우에 적당
- 외부로 나가는 트래픽도 처리해야 하기 때문에 라우터의 부담이 늘어나 네트워크의 크기가 커지면 커질수록 전체적인 네트워크 성능이 떨어짐

## VLAN trunking using sub interface

- 라우터에서 여러 VLAN 데이터를 전달할 수 있도록 스위치의 트렁크 포트 기능을 제공하고 있음
- 라우터의 LAN 인터페이스에 특정 VLAN을 매핑함
- 따라서 망 내의 VLAN 수만큼의 서브 인터페이스가 필요하며, 서브 인터페이스는 스위치의 트렁크 포트와 같이 VLAN을 식별하기 위한 802.1q 방식을 해석할 수 있음

---

### Switch, Router setting

- command
    
    > Switch
    > 
    1. 트렁크 포트 설정 명령어 - switchport mode trunk
    2. 스위치 주소 설정 명령어 - 주로 VLAN 1번에 주소를 할당해 사용
    3. 스위치에서 디폴트 게이트웨이 설정 명령어 - ip default-gateway, gateway-router-ip address
    
    > Router
    > 
    1. 서브 인터페이스 설정 명령어 - interface port-number.subinterface-number
    2. 트렁킹 프로토콜 설정 명령어 - encapsulation dot1q vlan-number