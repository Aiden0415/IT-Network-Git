# HSRP

## HSRP의 개념

- 한 라우터에 장애가 발생하였을 때 자동으로 다른 라우터가 게이트웨이 역할을 수행함으로써 장애를 복구하는 기능을 가진 프로토콜
- 시스코에서 개발한 게이트웨이 장애 극복 프로토콜

## HSRP의 동작방식

- PC에서 가상 라우터에 설정된 가상의 IP주소를 디폴트 게이트웨이로 설정
- 라우터 1은 액티브 라우터 역할, 주기적으로 Hello 메세지 방송
- 라우터 2는 스탠바이 라우터 역할 수행, 액티브 라우터 감시, 주기적으로 Hello 메세지 발송
- 액티브 라우터 장애 발생 시 자동으로 스탠바이 라우터가 역할 대행

## HSRP 패킷

- HSRP 패킷
    - 버전
    - 동작코드
    - 상태
    - Hellotime
    - Holdtime
    - 우선순위
    - 그룹 번호
    - 인증데이터
    - 가상 라우터의 IP 주소

- HSRP 상태
    - 초기상태 (Initial State)
    - 런 상태 (Learn State)
    - 리슨 상태 (Listen State)
    - 스피크 상태 (Speak State)
    - 스탠바이 상태 (Standby State)
    - 액티브 상태 (Active State)

## HSRP의 standby 명령어

- standby group-id ip  - HSRP Group 번호, 가상 라우터 IP 주소 설정
- standby group-id priority - 라우터의 우선순위 지정
- standby group-id timers - Hello 패킷 주기, Holdtime 주기 지정
- standby group-id preempt - 우선순위가 높은 라우터가 액티브 상태가 됨
- standby group-id track - 스탠바이 라우터가 액티브 라우터 역할 수

> HSRP show 명령어
> 
- show standby brief - HSRP의 설정 상태 확인

> HSRP debug 명령어
> 
- debug standby - 라우터의 상태변화 확인

---

> HSRP는 시스코 장비만 적용이 가능함
>