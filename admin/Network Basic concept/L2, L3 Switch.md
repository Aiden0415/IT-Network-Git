# L2, L3 Switch memory

## L2, L3 Switch CLI

- Bootstrap 프로그램과 Rom Monitor를 저장하고 있음
- 키보드로부터 명령어를 입력받아 프로그램을 작동시키는 사용자 인터페이스
- 명령어 해석기 기능 수행
- CLI는 사용자 모드와 운영자 모드로 구성
- 운영자 모드에서 시스템 설정 가능

## RAM

- IOS와 설정파일인 running-config 파일등이 저장
- 라우팅테이블(Routing table)와 같은 각종 테이블과 작업 행을 위한 데이터
영역 제공

## Flash Memory

- 운영체제 프로그램인 IOS를 저장하고 있음

## NVRAM

- 비휘발성 메모리로서 백업설정파일인 startup-config 파일을 저장함
- RAM과 달리 전원이 꺼져도 내용을 유지가능함

## ROM

- 부팅 절차
    
    Power on -> POST 수행 -> IOS 로딩 -> startup-config 로딩-> 사용자 모드 진입
    
    ---
    

- **command words**
    - enable/disable : 운영자 모드 변환/사용자 모드 변환
    - congif terminal : 전역 설정 모드 변환
    - end/exit : 운영자 초기 모드로 이동/이전 모드로 이동
    - hostname : 라우터와 스위치의 이름을 지정
    - interface : 인터페이스 모드로 이동
    - line : 라인 모드로 이동
    - enable secret : 운영자 모드 변환 시 적용되는 패스워드 설정
    - show : 시스템 상태 정보 보기
    - copy : 파일 복사 기능, 주로 running-config파일을 startup-config파일 복사
    - erase/delete : 파일 시스템 삭제/파일 삭제
    - setup : 대화형으로 시스템 설정 실행
    - reload : 시스템을 중지시키고 재부팅
    - ? : 도움기능으로 현재 모드에서 사용 가능한 명령어 리스트와 설명 제공
    - ↑ : 이전에 실행했던 명령어를 찾아줌
    - show history : 이전에 실행했던 명령어 리스트 보기