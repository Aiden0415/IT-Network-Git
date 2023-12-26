# BGP
## BGP란?

- Border Gateway Protocol (BGP)
- 인터넷에서 데이터를 전송하는데 가장 적합한 네트워크 경로를 결정하는 일련의 규칙
- 인터넷은 표준화된 프로토콜, 디바이스 및 다양한 통신기술을 통해 이루어져 인터넷에서 검색하면 데이터는 목적지에 도달하기 전에 여러 네트워크를 통해 이동한다
- BGP의 역할은 데이터가 이동할 수 있는 모든 경로를 살펴보고 최적의 경로를 선택하는 것
- ex) 미국의 사용자가 유럽의 Origin 서버로 애플리케이션을 로드하면 BGP가 해당 통신을 빠르고 효율적으로 연결

## BGP가 중요한 이유

- BGP는 데이터 라우팅을 통해 인터넷을 작동시킴
- 인터넷의 핵심은 수십만개의 자율 시스템으로 구성되기 떄문에 BGP 라우팅은 매우 중요

## BGP의 기능

### 최적경로탐색

- 데이터가 인터넷을 통해 소스에서 대상으로 이동함에 따라, 소스와 대상 사이에 있는 모든 자율 시스템은 데이터 패킷의 다음 위치를 결정해야함
- 이 결정은 지리적 위치, 네트워크 정체 및 데이터 전송 비용과 같은 여로 요인을 기준으로 함
- BGP 라우팅은 이러한 용인을 고려하여 데이터가 소스에서 대상까지 최단 경로로 이동하도록 하는 다음 최적 자융 시스템을 결정하는데 도움을 줌

### 네트워크 연결변경 사항 검색

- 인터넷의 구조는 동적임
- 자율 시스템이 추가됨에 따라 기존 시스템이 지속적으로 제거
- 모든 자율 시스템은 새 경로와 이전 경로에 대한 정보를 지속적으로 업데이트해야 함
- BGP는 시스템이 이러한 네트워크 변경 사항을 검색하고 그에 따라 지속적으로 업데이트되도록 함

### 네트워크 정책 관리

- BGP는 자율 시스템 관리자가 자체 라우팅 정책을 구현할 수 있는 유연성을 제공
- 예를 들어 BGP를 실행하는 라우터가 자율 시스템의 내부 및 외부 경로를 구분하도록 구성할 수 있음
- 관리자는 데이터를 내부로 라우팅할지 아니면 외부로 라우팅할지를 결정하는 규칙을 설정할 수 있음

### 네트워크 보안 계층 추가

- BGP는 네트워크 관리의 보안을 지원
- 예를 들어 BGP는 사전 구성된 암호를 사용하여 라우터 간에 메시지를 인증할 수 있음
- 관리자는 정상적인 자율 시스템에서 들어오는 BGP 메시지를 확인하고 무단 트래픽 필터링이 가능함

## BGP의 작동 원리

- Border Gateway Protocol(BGP)은 **피어링**이라는 메커니즘을 사용하여 작동
- 관리자는 특정 라우터를 BGP 피어 또는 BGP 스피커 라우터로 할당
- 피어는 자율 시스템의 엣지 또는 경계에 있는 디바이스라고 생각할 수 있음

### 경로 검색

- BGP 피어는 Network Layer Reachability Information(NLRI) 및 경로 속성을 통해 인접 BGP 피어와 라우팅 정보를 교환
- NLRI에는 인접 피어에 대한 연결 정보가 포함됩니다. 경로 속성에는 지연 시간, 홉 수, 전송 비용 등의 정보가 포함
- 정보를 교환한 후 각 BGP 피어는 주변 네트워크 연결의 그래프를 구성할 수 있음

### 경로 저장

- 검색 프로세스 중에 모든 BGP 라우터는 경로 알림 정보를 수집해 라우팅 테이블 형태로 저장
- 라우팅 테이블을 사용해 경로를 선택하고 자주 업데이트함

### 경로 선택

- BGP 라우터는 저장된 정보를 사용해 트래픽을 최적으로 라우팅
- 경로 선택의 주된 요소는 저장된 경로 그래프에 의해 결정되는 최단 경로
- 여러 경로에서 대상에 도달할 수 있는 경우 BGP는 다른 경로 속성을 순차적으로 평가하여 최상의 대상을 선택함
