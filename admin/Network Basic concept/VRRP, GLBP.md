# VRRP and GLBP

## VRRP 정의

- VRRP는 HSRP와 동일하게 동작하는 인터넷 표준 프로토콜로 멀티벤더 환경에서 사용 가능
- HSRP, GLBP와 함께 대표적인 FHRP
- FHRP는 게이트웨이 이중화 프로토콜을 총칭하는 용어
-  First Hop는 게이트웨이, 즉 라우터를 의미함

## VRRP 동작방식

- HSRP와 마찬가지로 가상 라우터를 정의하고 가상 라우터 역할을 수행하는 라우터를 마스터 라우터라고 부름
- 마스터 라우터에 장애가 발생하면 대기 중이던 백업 라우터가 역할을 대신함
- 마스터 라우터는 1초마다 224.0.0.18 멀티캐스트 주소와 프로토콜 번호 112를 사용하여 VRRP 정보를 백업 라우터에게 전달, 3초 이상 메시지가 도달하지 않을 경우 다음 순위 백업 라우터가 마스터 라우터가 됨
- VRRP는 실제 라우터의 주소를 가상 라우터 주소로 사용 가능(자동으로 마스터 라우터가 됨)
- 마스터 라우터 결정 기준
- VRRP 우선순위가 높은 경우
- 라우터의 IP 주소가 큰 경우

## GLBP 정의

- GLBP는 시스코에서 개발한 프로토콜로 HSRP와 마찬가지로 표준 프로토콜은 아니지만 대표적인 FHRP에 속함
- MHSRP, MVRRP의 경우 부하분산을 위해 여려 개의 그룹을 활용해야 하지만 GLBP는 다른 부가적인 절차 없이 프로토콜 자체에 부하분산 특징이 있음
- GLBP는 가상 라우터로 들어오는 트래픽을 자동으로 분류하여 여러개의 라우터를 균형있게 사용할 수 있도록 부하분산 기능 제공

## GLBP 동작방식

- 여러 대의 라우터로 구성된 라우터 그룹이 마치 한 대의 라우터로 동작되는 것처럼 보여지는 가상 라우터의 개념 사용, GLBP는 그룹 당 하나의 AVG 라우터 선출
- AVG 라우터 결정 기준
- GLBP 우선순위가 높은 경우
- 인터페이스 IP 주소가 큰 경우
- AVG 라우터는 그룹 내 다른 라우터(AVF 라우터)에게 가상 MAC 주소 할당, 외부로 패킷을 보내기 위해 발생한 ARP 요청에 대해 AVF에게 할당한 MAC 주소를 응답하여 여러 AVF로 부하가 분산되도록 함
- 그룹당 최대 4개의 가상 MAC 사용 가능 ( AVG 라우터도 AVF 라우터로 지정되어 패킷 전달
- 부하분산을 위해 ARP 응답 시 가상 MAC 주소 선정 기준
- 라웉드 로빈: 순차적으로 가상 MAC 주소 응답
- 웨이티드: AVF에 가중치가 정해져 있다면 이에 맞추어 응답
- 호스트 기준: 특정 서버나 PC에게 지정된 MAC 주소 응답

## VRRP, GLBP 명령어

- VRRP
    - vrrp group ip 명령어
    - vrrp group priority 명령어
    - vrrp group timers 명령어
    - vrrp group preempt 명령어
    - vrrp group track 명령어와 track 명령어
    - show vrrp brief 명령어
- GLBP
    - glbp group ip 명령어
    - glbp group priority 명령어
    - glbp group timers 명령어
    - glbp group preempt 명령어
    - glbp group forward preempt 명령어
    - glbp group weighting 명령어
    - glbp group track 명령어와 track 명령어
    - show glbp group 명령어