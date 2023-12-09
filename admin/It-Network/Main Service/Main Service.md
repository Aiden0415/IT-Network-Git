# Main Service
- Postfix, Dovecot에 대해 공부하기
- SMTP(S), IMAP(S)와 POP3 공부하기

---

## Dovecot

- Linux / Unix 계열 시스템용 IMAP과 POP3를 사용하는 전자메일 서버
- 주 목적은 메일저장, 즉 메일 수신이며 해당 패키지를 설치한 후 Outlook 등의 메일 프로그램을 사용하며 연동하면 보다 쉽게 사용할 수 있음

## Postfix

- 메일을 송신하기 위한 패키지
- SMTP. SMTPS 프로토콜을 사용

---

## Pop3

- Post Office Protocol
- SMPT와 연관된 프로토콜
- 메일 서버에 도착한 메일을 클라이언트로 가져올 때 사용
- 메일을 서버에서 다운로드 받으면 서버의 메일은 삭제되는 특징이 있음
- TCP 110번 포트를 사용
- 비슷한 프로토콜로는 IMAP(Internet mail access protocol)이 있음 다른 점은 Pop3와 달리 메일을 다운로드 받아도 서버의 메세지가 그대로 저장된다는 점이다
- IMAP는 서버에 메일이 저장되어 인터넷이 되는 상황에서 메일을 볼 수 있고 Pop3는 클라이언트에 메세지를 가져오는 방식이라 오프라인 상태에서도 메일을 읽을 수 있다는 차이가 있다(서버에 저장이 되지 않아 부하를 주지 않는다는 장점도 있음)
- TCP 110번 포트를 사용

## SMTP

- Simple Mail Transfer Protocol
- 일반적으로 전자 메일 전송을 위한 표준 프로토콜
- 메일을 작성해서 보내면 그 메일은 SMTP 서버(보내는 메일서버, Outgoing mailserver)로 일단 전송되며 이 SMTP 서버에서 SENDMAIL ****프로그램을 구동하여 해당 메일 주소로 메일을 보내게 됨
- 이러한 역할을 하는것을 SMTP 서버, 보내는 메일 서버, Outgoing Mailserver라고 함
- SMPT의 포트는 다양한 시기와 다양한 상황에서 25, 465, 587, 2525 포트가 사용되어 왔음

## SMTPS

- Simple Mail Transfer Protocol Secure
- 전자메일을 안전하게 전송하기 위해 일반적으로 사용되는 표준 SMTP 프로토콜의 보안버젼
- SMTP는 통신을 암호화하지 않기 때문에 보안상 문제가 발생할 수 있음
- SMTPS는 이러한 이유로 TLS 또는 SSL을 사용해 데이터를 암호화함
- TLS (Transport Layer Security) 및 SSL (Secure Sockets Layer)은 네트워크 통신에서 데이터를 암호화하는 데 사용되는 프로토콜
- 465번 포트를 사용
- 최근에는 STARTTLS를 사용해 일반 SMTP 연결을 암호화하는것으로 전환되는 중

## IMAP

- Internet Map Access Protocol
- IMAP은 이메일을 받기위한 프로토콜
- 사용자가 메일 서버에서 이메일 을 내려받는 방식중 하나
- 중앙서버에서 동기화가 이뤄지기 때문에 모든 장치에서 동일한 이메일 폴더를 확인 가능
- 143번 포트를 사용