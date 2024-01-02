# OSPF

## OSPF

- Link State 프로토콜을 기반으로 하는 대표적인 표준 라우팅 프로토콜
- IP Protocol 89번을 사용
- AD 값은 110
- Metric은 Cost값을 사용 ( 10^8/Bandwidth )
- SPF(Shortest Path First) 또는 Dijkstra라는 알고리즘을 이용하여 목적지까지의 최적 경로를 계산
- Area 단위로 구성하여 대규모 네트워크를 만정되게 운영할 수 있음
- CPU 와 DRAM 같은 장비의 자원이 많이 필요

## Link-State

- 크의 변화가 있을때만 업데이트 한다
- Classless, VLSM, CIDR을 허용
- 멀티캐스트 또는 유니캐스트로 광고

## OSPF DR, BDR, DROther

- LSA 중계 역할을 하는 라우터를 DR(Designated Router)이라고 하며, DR에 장애가 발생할 시 대신 DR 역할을 하는 라우터를 BDR(Backup DR)이라고 함
- DR, BDR은 브로드캐스트 및 논브로드캐스트 네트워크에서만 사용되며, p to p 네트워크에서는 사용되지 않음