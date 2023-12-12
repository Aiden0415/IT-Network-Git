# URL에 [www.google.com을](http://www.google.xn--com-of0o/) 입력하였을 때의 패킷의 동작 과정

---

## DNS 조회

- 클라이언트가 “www.google.com”을 입력하면, 먼저 로컬 DNS 캐시에서 해당 도메인에 대한 IP 주소를 찾음
- 로컬 DNS에 캐시가 없거나 만료되었으면, 클라이언트는 DNS 서버에 질의(Query)하여 IP 주소를 찾음
- DNS 서버는 계층적으로 동작하며, 최상위 루트 DNS 서버부터 순서대로 도메인에 대한 IP주소를 찾아 클라이언트에게 응답

## TCP 연결 설정(3 way hasdshake)

- 클라이언트는 얻은 IP주소를 사용해 해당 서버에 TCP 연결을 시도
- 클라이언트가 서버에게 TCP연결을 요청하기 위해 SYN 패킷을 보냄
- 서버는 SYN을 받고, 클라이언트에게 연결을 수락하고 SYN-ACK을 보냄
- 클라이언트는 서버에게 ACK을 보내고 이로써 TCP 연결이 성립됨

## HTTP 요청

- 클라이언트는 TCP 연결이 설정된 후에 HTTP 요청을 보냄
- HTTP 요청은 일반적으로 다음과 같은 형태를 가지며, 이는 서버에게 특정 리소스를 요청하는것을 나타냄

```vbnet
GET / HTTP/1.1
Host: www.google.com
```

- 이 요청은 서버에게 전송되어 해당 리소스(홈페이지)를 요청

## 서버의 HTTP 응답

- 서버는 받은 HTTP 요청에 대한 응답으로 HTTP 응답 메세지를 생성
- 응답 메시지에는 HTTP 상태코드, 응답 헤더, 요청한 리소스의 본문이 포함
- 이 응답 메시지가 클라이언트에게 전송됨

## TCP 연결 해제 (4 way handshake)

- 클라이언트와 서버는 데이터 전송이 완료되면 TCP 연결을 종료학 위해 4 way handshake를 수행
- 클라이언트가 서버에게 연결 종료를 요청하는 FIN 패킷을 보냄
- 클라이언트는 서버의 FIN을 받아 ACK을 보내고, 이로서 연결이 종료됨