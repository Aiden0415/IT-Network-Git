# Active Directory란

---

## Active Directory란 무엇인가

- 기본적으로 ACD는 사용자가 `마이크로소프트 IT 환경`에서 업무를 수행하는데 도움을 주는 데이터베이스이자 서비스 집합
    - 데이터베이스(또는 디렉토리)는 환경에 대한 중요한 정보를 담고있음
        - 예를들어 데이터베이스에는 100명의 사용자 계정을 각 사용자의 직책, 전화번호, 비밀번호와 같은 세부정보와 함께 리스팅 가능
        - 또한 각 사용자의 권한도 기록
            - EX) 모든 사용자가 회사 복지 정보를 읽도록 허용하고, 금융문서는 소수의 사람만 보거나 수정하도록 허용할 수 있음
    - 서비스는 IT환경에서 일어나는 대부분의 활동을 제어
        - 특히 서비스는 일반적으로 사용자가 입력하는 사용자 ID와 비밀번호를 확인하는 방법으로, 사용자가 주장하는 본인이 맞는지 검증하고(인증), 각기 허용된 데이터만 액세스 할 수 있도록 함(승인)

## AD의 구조

- AD는 크게 도메인(Domain), 트리(tree), 포리스트(Forest)의 세가지 계층이 있음
    - `도메인`은 관련된 사용자, 컴퓨터 및 기타 AD 객체로 구성되는 그룹
    - 여러개의 도메인을 `트리`로 결합할 수 있다
    - 여러개의 트리를 `포리스트(Forest)`로 그룹화 할 수 있음
- 도메인은 관리 경계이다
    - 특정 도메인을 위한 객체는 하나의 데이터베이스에 저장되며 함께 관리가 가능
- 프리스트는 보안 경계이다
    - 서로 다른 포리스트의 객체는 각 포리스트의 관리자가 해당 객체간 신뢰를 형성하지 않는 한 상호작용할 수 없음
        - 상호 독립된 여러개의 사업부가 있는 경우 여러개의 포리스트를 만드는것이 좋음

## AD 데이터베이스 안에는 무엇이 있는가?

- AD 데이터베이스(디렉토리)에는 도메인의 AD 객체(AD objects)에 대한 정보가 포함됨
    - 보편적인 AD 객체 유형으로는 사용자, 컴퓨터, 어플래캐이션, 프린터, 공유폴더 등이 있음
- 일부 `객체`는 다른 객체를 포함할 수 있음(AD를 ‘계층적’이라고 말하는 이유)
    - 객체에는 특성(attributes)이 있음
        - 명확이 드러나는 특성도 있고, 잘 드러나지 않는 특성도 있음
    - 예를들어 사용자 객체는 일반적으로 그 사람의 이름, 비밀번호, 이메일 주소와 같은 특성 외의 고유한 전역 고유 식별자(Globally Unique Identifier, GUID)와 보안식별자(Security Identifier, SID), 마지막 로그온 시간, 그룹 멤버십과 같은 특성도 포함
- `데이터베이스`는 구조적임
    - 즉 저장되는 데이터의 유형과 데이터를 조직화화는 방법을 좌우하는 설계가 존재
        - 이 설계를 `스키마(schema)`라고 함
        - AD도 예외는 아님 | AD스키마에는 AD 포리스트에 생성 가능한 모든 객체 클래스와 공식적인 정의와 AD 객체에 존재할 수 있는 모든 특성이 포함
        - AD에는 기본 스키마가 제공되지만 관리자가 비즈니스 요구에 맞게 기본 스키마를 수정할 수 있음