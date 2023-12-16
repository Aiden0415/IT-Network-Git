# Solution 1-3-1
1. ip addressing 계획
2. 케이블 연결
- host1을 Router 1에 연결
- 스위치의 fa0/1을 라우터의 fa0/1에 연결
- 스위치 1의 Fa0/2 인터페이스에 Host2 연결
- 연결을 확인
1. 호스트 pc들에게 ip address, subnet mask, gateway 를 각각 설정
2. 라우터 1을 구성합니다.
- 호스트 1의 터미널 연결을 통해 라우터 1에 연결
- 라우터에서 다음 명령을 입력합니다 (대소문자 구분)

    <img src="./image/solution1.png" alt="Alt123" width="600">

1. ping 명령어를 이용해 연결을 확인
2. 이후 ping이 성공할 경우 %를 확인후 100%일 시 끝
3. 그마저도 아닐시 check results 에 들어가 해결이 안된 문제가 있나 확인

---