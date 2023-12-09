# 기능반 11-11~12 강의

/etc/resolv.conf

host / nslookup /dig 명령으로 dns 질의

resolv.conf

- nameserver - 1.1.1.1
    - nameserver 2.2.2.2
- search google.com
- domain google.com

hostname -f

ns.google.com

hostname 

ns

---

## 인증기관 (CA, Certificate Authority)

- 인증서를 발급 | 폐기

## 비대칭키(RSA)

- 암호화키(공개키, public key)와 복호화키(비밀키|개인키 ,private key)가 다름
- server 는 공개키를 공개함
- client는 공개키로 암호화를 해서 server에서 보냄
- server은 개인키로 복호화를 해서 내용을 봄
- use case
    - https
    - smtps
    - ssh

## 대칭키(DH)

- 암호화 하는 키와 복호화키가 같음
- envelope encryption (봉투 암호화)
    - 대칭키를 비대칭키로 암호화해서 보냄
    - 비대칭키를 수신받은 대상은 개인키로 복호화해서 대칭키를 안전하게 전달받음

## SCP(ssh-copy)

scp root@1.1.1.1:/usr/local/share/ca-certificates/ca.crt /usr/local/share/ca-certificates/ca.crt