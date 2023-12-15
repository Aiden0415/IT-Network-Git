# Template Cloning

## Template Cloning

- Debian GNU/Linux 배포판에서 가상 머신환경에서 사용되는 기술
- 효율적인 가상화 및 리눅스 컨테이너 관리를 위한 기술

## Linked Clone

- 기본 Template 이미지를 참조하고 변경된 부분만을 저장하는 방식
- Template 이미지와 공통된 데이터 블록을 사용하므로 저장공간 절약
- 다수의 Linked Clone을 생성할 때 저장공간과 디스크 1/0를 줄일 수 있으므로 여러개의 가상 머신을 빠르게 배포할떄 유용

> 장점
> 
- 저장 공간과 디스크 I/O를 절약할 수 있으며 가상 머신의 생성 시간이 빠름

> 단점
> 
- Linked Clone은 Template 이미지에 종속적이며, 원본 Template 이미지가 변경되면 모든 Linked Clone이 영향을 받을 수 있음
- 가상 머신 간에 변경된 데이터를 공유하므로, 프라이버시 및 격리의 측면에서 보안 문제가 발생할 수 있음

## Full clone

- Full Clone은 Template 이미지를 완전히 복제하여 새로운 가상 머신을 생성 즉, Template 이미지와 별도의 독립적인 복제본을 가집니다.
- Full Clone은 Template 이미지와 독립적이므로 원본 Template 이미지의 변경이 Full Clone에 영향을 주지 않음

> 장점
> 
- Full Clone은 완전히 독립적인 환경을 제공하므로 보안 및 격리 면에서 강력
- Template 이미지의 변경이 다른 가상 머신에 영향을 주지 않으므로 안정성이 향상

> 단점
> 
- Full Clone은 저장 공간과 디스크 I/O 측면에서 Linked Clone보다 비효율적일 수 있음
- 생성 시간이 Linked Clone에 비해 오래 걸릴 수 있

---

> Linked Clone은 리소스 절약이 중요하고 Template 이미지의 변경이 자주 발생하지 않는 경우 유용하며, Full Clone은 보안 및 격리가 중요하거나 Template 이미지의 변경이 빈번한 경우에 더 적합할 수 있음
>