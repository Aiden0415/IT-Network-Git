# MHSRP (Multiple HSRP)

## MHSRP의 개념

- 라우터는 여러 개의 HSRP 그룹을 정의할 수 있으며, 라우터가 여러 HSRP 그룹에 소속되어 동작하는 경우이를 MHSRP ( Multiple HSRP) 라고 함
- 2개 이상의 HSRP가 동작되고 있는 환경을 MHSRP라고 함

## MHSRP의 동작 방식

- 평상시에는 2대의 라우터가 각 서브넷의 액티브 라우터로 동작함
- 라우터 1의 전용회선에 장애가 발생하면 라우터 2가 액티브 라우터가 되면서 모든 트래픽이 라우터 2를 통해서 외부로 나가게 됨

## MHSRP 설정 방법

> VLAN을 사용하지 않는 경우
> 
- 서브넷으로 그룹을 구분하며, 라우터의 LAN 인터페이스에 Secondary IP 기술 사용
- Inter-VLAN 라우팅 기술에서 사용했던 Router-On-a-stick 과 MLS 방식 사용

---

## 라우터를 이용한 설정 (VLAN 미사용)

- 라우터의 LAN 인터페이스에서 Secondary IP를 이용해 각 서브넷에 속하는 주소 설정
- HSRP 그룹 번호와 가상 라우터 IP 주소를 VLAN (서브넷) 수 만큼 설정

## 라우터를 사용한 설정 (VLAN 사용)

- Router-on-a-stick 방식을 이용하여 LAN 서브 인터페이스에 VLAN 별로 서브넷에 속하는 주소 설정
- HSRP 그룹 번호와 가상 라우터 IP 주소를 VLAN (서브넷) 수 만큼 설정

## 스위치를 이용한 설정 (VLAN 사용)

- MLS 방식을 이용하여 스위치의 VLAN 인터페이스에 VLAN 별로 서브넷에 속하는 주소 설정
- VLAN 10번 망은 평상시에 Csw1 스위치를 사용하며, VLAN 12번 망은 평상시에 Csw2 스위치를 사용하도록 설정
- 각각의 스위치와 라우터 연결 구간에 장애가 발생하면 정상적으로 동작중인 (Csw1 or Csw2)를 이용하여 외부와 통신하도록 설정

> VLAN을 사용할 경우
> 

> HSRP는 시스코 장비에서만 적용이 가능함
>