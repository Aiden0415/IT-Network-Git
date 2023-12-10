# Frame Relay

## Frame Relay 개요

- 프레임 릴레이는 1:N 교환형 WAN 서비스를 제공하고 네트워크 계층의 삭제와 2계층의 오류
- 흐름제어 기능을 단순화하여 프레임 릴레이 교환기의 처리 부담을 덜게 되어 데이터의 처리 속도를 개선함

## Frame Relay

- LAN과 LAN을 연결하는 즉, 라우터와 라우터를 연결하는 릴레이 교환망 기능을 제공
- 프레임 릴레이 교환망에서는 가상회선(VC, Virtual Circuit)번호를 주소로 사용
- 가상회선은 두 개의 네트워크 장치 간이 통신을 위해 만들어지는 논리회선, 즉, 통신채널을 의미하며 PVC(Permanent Virtual Circuit)와 SVC(Switched Virtual Circuit) 가 있음
- PVC는 일반적으로 빈번한 데이터 전송환경에 많이 사용, SVC는 일시적인 데이터 전송환경에 사용되는데 프레임 릴레이에서는 PVC를 사용
- PVC를 식별하기 위해 프레임 릴레이에서는 DLCI(Data-link connection identifier) 라는 채널번호를 사용하며 프레임 릴레이 회선 사업자에 의해 할당함
- 라우터와 프레임 릴레이 교환기 사이의 가상회선을 유지하고 관리하기 위해 LMI(Local Management Interface)프로토콜을 사용
- 프레임 릴레이의 프레임 구조는 HDLC 프레임과 유사하나 제어필드(Control Field) 가 없음