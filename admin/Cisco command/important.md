# Important commands
## DHCP

dhcp를 설정할때 범위을 정해야 하는데

```jsx
ip dhcp excluded-address 192.168.1.1 192.168.1.99
ip dhcp excluded-address 192.168.1.201 192.168.1.254
```

해당 명령어를 이용해 사용할수 없는 대역을 지정한다.

## Default Routing

- 디폴트 라우트(Defalut Route)란 경로를 찾지 못한 모든 네트워크들의 경로를 미리 정해놓는 것

```java
configure terminal
ip route 0.0.0.0 0.0.0.0 <목적지-IP-주소>
```

## Sorce NAT

-IP 패킷의 TCP/UDP 포트 숫자와 소스 및 목적지의 IP 주소 등을 재기록하면서 라우터를 통해 네트워크 트래픽을 주고 받는 기술

```java
configure terminal
interface <내부-인터페이스>
ip nat inside
exit
interface <외부-인터페이스>
ip nat outside
exit
```

```java
ip nat inside source list 1 interface <외부-인터페이스> overload
```

```java
access-list 1 permit <내부-네트워크> <서브넷-마스크>
```

## Port forwarding

- 컴퓨터 네트워크에서 패킷이 라우터나 방화벽과 같은 네트워크 게이트웨이를 가로지르는 동안

하나의 IP 주소와 포트 번호 결합의 통신 요청을 다른 곳으로 넘겨주는 **네트워크 주소 변환(NAT)**의 응용

```java
ip nat inside source static tcp 192.168.1.2 80 interface FastEthernet0/0 80
```

## Syslog service

- 대충 말해서 로그 관리 설정이다

```java
enable
configure terminal
logging <SYSLOG-서버-IP-주소>
```

```java
logging trap informational
```

## Radius service

- RADIUS는 Remote Authentication Dial-In User Service의 약자로 AAA 기능 구현을 위한 인증 프로토콜

```java
enable
configure terminal
aaa new-model
radius-server host <RADIUS-서버-IP> key <RADIUS-비밀키>
```

```java
line vty 0 4
login authentication RADIUS_AUTH
```

### radius login

```java
line vty 0 4
login authentication default
```