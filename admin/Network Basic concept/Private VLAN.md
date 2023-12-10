# Private VLAN

## Private VLAN

- 사설 (Private) VLAN은 VLAN 부족, IP주소의 과다 요구, 보안 문제 해결
- 만약 개인 가입자가 4500명이고 보안 문제 때문에 가입자 별로 VLAN을 부여해야 한다면 VLAN은 최대 4096개를 지원하므로 VLAN 부족 현상 발생
- 개인 가입자 별로 서브넷을 할당한다면 IP 주소가 많이 필요하게됨
- 사설 VLAN은 사설 IP를 처리하는 NAT기술과 유사하게 하나의 주 VLAN과 여기에 매핑되는 여러개의 부 VLAN을 통해서 VLAN 부족 문제를 해결하고 있음
- 주 VLAN 번호는 NAT에서 공인 IP 주소에 해당하고 부 VLAN 번호들은 사설 IP 주소로 생각해도 됨

## Private VLAN 장점

- 여러개의 VLAN이 하나의 서브넷, 디폴트 게이트웨이를 사용하므로 IP 주소를 절약할 수 있음
- 동일한 VLAN에 속한 사용자 간의 통신은 막아주고 외부 통신망으로 나가는 경로는 공유해야 하는 경우 유용

## Private VLAN 정의

- 하나의 스위치에서 여러 사용자 그룹이 연결되어 있는 환경에서 IP 주소와 VLAN 번호를 절약하면서 상호 그룹간에 보안을 유지하는 기술을 사설 VLAN이라 함
- 일반적으로 VLAN당 하나의 서브넷을 사용해야 하지만 2개의 VLAN이 동일한 서브넷 주소를 공유하면서도 상호 간에 독립적으로 동작한다면 IP 주소 절약 가능
- 사설 VLAN은 주 (Primary) VLAN과 부 (Secondary) VLAN 으로 구분
- 부 VLAN은 사용하는 포트 유형에 따라 독립(Isolated) VLAN과 커뮤니티 (Community) VLAN으로 구성

---

## 독립 포트

- 독립 포트는 다른 포트와 통신이 되지 않는 호스트 포트
- 독립 포트에 할당된 장비들은 상호 간에 통신이 되지 않음
- 동일한 VLAN 소속이고, 동일한 서브넷을 사용하며, 동일한 디폴트 케이트웨이를 지정하고 있더라도 상호 간 독립적임
- 독립포트에 할당하는 VLAN은 동일해아 함

## 커뮤니티 포트

- 커뮤니티 포트는 독립 포트와는 달리 VLAN 번호만 같으면 통신이 가능한 호스트 포트임
- 같은 VLAN 번호의 커뮤니티 포트에 연결된 장비 간에는 통신이 가능하지만 독립 포트, 다른 VLAN 번호의 커뮤니티 포트에 연결된 장비와는 통신이 되지 않음
- 커뮤니티 포트에는 여러 다른 VLAN 번호 지정 가능

## 프로미스 큐어스 포트

- 프로미스큐어스 포트는 독립 포트와 커뮤니티 포트에 접속된 장비들이 외부망과 통신할 수 있도록 통로로 사용되는 포트
- 라우터와 연결된 트렁크 포트 역할을 한다고 생각하면 됨
- 공용 서버를 연결할때도 사용

---

## Private VLAN 고려사항

- 사설 VLAN은 VTP 트랜스페어런트 모드에서 설정
- VLAN 1번과 1002~1005번은 사용할 수 없음
- 사설 VLAN에 소속된 포트가 없어도 사설 VLAN을 설정해야 함
- 사설 VLAN에서는 하나의 STP만 실행됨
    - 프룀스큐어스 포트에는 포트패스트를 설정하면 안됨
- 이더채널 포트를 사설 VLAN 포트로 설정하면 안됨
- Private VLAN setting procedure
    
    VTP 설정 → 부 VLAN 생성 → 주 VLAN 생성 → 포트 설정
    
- commands
    
    > 주,부 VLAN 설정
    > 
    - private-vlan 명령어
    - private-vlan association 명령어
    
    > 포트 설정
    > 
    - switchport mode private-vlan 명령어
    - switchport private-vlan host-association 명령어
    - switchport private-vlan mapping 명령어