# Container Service

- Container가 무엇인가 ?
- Container vs VM
- Docker란 무엇인가?
- Docker File과 Docker File의 Command 학습
- docker-compose 사용법
- Docker Ochestration이란 ?

[컨테이너란?  | IBM](https://www.ibm.com/kr-ko/topics/containers)

---

## Container란?

- Container는 데스크탑, 기존 IT, 클라우드 등에서 어디서나 실행할 수 있도록 애플리케이션 코드를 해당 라이브러리 및 종속 항목과 함께 패키징한 소프트웨어 실행 유닛
- 컨테이너는 일종의 운영체제(OS) 가상화를 활용
    - 이러한 가상화를 수행할 경우 `프로세스를 격리`하고 이러한 프로세스가 액세스할 수 있는 CPU, 메모리, 디스크의 양을 제어하기 위해 OS 커널의 특성(예: Linux 네임스페이스 및 cgroup, Windows 사일로 및 작업 오브젝트)을 활용할 수 있음
- `컨테이너는 작고 빠르며 이동이 가능함`
    - 가상 머신과는 달리 컨테이너는 모든 인스턴스에 게스트 OS를 포함할 필요가 없기 때문 | 대신 `호스트 OS의 기능과 리소스를 활용`s