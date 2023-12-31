# STP

## 이중화 구조

> 장점
> 
1. 스위치 네트워크 구축 시 통신망의 성능 향상과 신뢰성 제공을 위해 이중화 사용
2. 이중화 구조란 스위치 또는 링크를 중복 연결하는 방법으로 물리적인 에러(스위치 오류, 링크 고장)에도 통신망이 정상적으로 운영될 수 있음

> 단점
> 
1. 이중화 구조로 인한 루프 구조 형성 루프 구조가 형성됨에 따라 예기치 못한 3가지의 문제점 발생
2. 브로드캐스트 폭풍(Broadcast Storm)
3. 중복프레임 수신
4. MAC주소 테이블 불안정
5. 루프 구조로 발생한 문제점으로 인해 부하 급증과 링크의 단절
6. 속도와 신뢰성의 향상을 위한 이중화가 오히려 망이 다운되는 예기치 못한 현상

---

## 브로드캐스트 폭풍

- 브로드캐스트 폭풍이란 망 내부에 루프가 발생되어 브로드캐스트 데이터(LAN 프레임)가 넘쳐나는 현상
- 스위치의 프레임 전달 특성에 따라 브로드캐스트 데이터는 모드 포트로 전달되기 때문

## 중복프레임 수신

- 루프 구조로 인한 동일한 데이터를 중복해서 수신
- 스위치는 주소학습이 안된 모르는  주소의 데이터를 수신할 경우 수신한 포트를 제외한 모든 포트로 무조건 전달하는 특징(플러딩:Flooding)이 있는데 이로 인해 중복데이터 전달 발생

## MAC 주소 테이블 불안정

- 루프 구조로 인해 동일한 MAC주소에 대해서 MAC주소 테이블에 저장하는 값이 수시로 바뀌는 불안정 현상 발생
- 스위치는 주소학습 기능에 의해 발신지 주소와 해당 포트 정보를 MAC주소 테이블에 저장하는데 동일한 프레임이 서로 다른 포트를 통해 들어오면 수시로 저장값이 변경됨

---

## STP 동작 원리

- STP는 루프가 존재하지 않는 스위치 네트워크 이중화를 가능하게 함
- STP는 스위치 네트워크에서 루프를 찾아 한쪽 스위치를 차단(Block) 상태로 하여 링크를 차단함으로 루프가 발생했던 기존 메시 구조를 트리 형태로 변경하여 루프가
발생하는 것을 막아줌

## STP 알고리즘

- 스위치 네트워크에서 루트 브리지(Root Bridge) 1대 선정
- 루트 브리지가 아닌 다른 스위치들은 하나의 루트 포트(Root Port) 선정
- 모든 LAN 세그먼트에서 하나의 지정 포트(Designated port) 선정
- 루트 포트와 지정 포트가 아닌 경우를 나머지 포트를 대체 포트 또는
- 비지정 포트(Non-Designated Port)라고 하며, 항상 차단(Block)함

## STP 동작 상태 확인 명령어

- Show Spanning-Tree” 명령어
- 특정 VLAN에 대한 STP 상태를 확인하기 위해서 해당 VLAN 번호 지정