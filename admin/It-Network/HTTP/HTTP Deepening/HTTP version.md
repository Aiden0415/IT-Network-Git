# HTTP Version (0.9 1.0 1.1 1.2 2.0 3.0 )

---

## HTTP | 0.9 (1991)

- 초기 버젼으로 매우 간단한 형태의 프로토콜
- 단일 메서드(GET)만 지원하며, 헤더 및 상태 코드가 없었음
- 연결이 한번 이루어지면 서버가 응답을 보내고 연결이 바로 종료되는 형태를 가짐

> 특징
> 
> - HTTP 초기버전을 구분하기 위해 부르는 버전(1991)
> - 요청은 단일 라인으로 구성되며, 리소스에 대한 method는 GET만 존재
> - 응답도 극도로 단순(파일 내용 자체로만 구성)
> - HTTP 헤더도 없고, HTML 파일만 전송 가능했던 것이 특징

```vbnet
/* 요청 */
GET /mypage.html

/* 응답 */
<HTML>
A very simple HTML page
</HTML>
```

## HTTP | 1.0 (1996)

- 향상된 기능을 도입해 클라이언트와 서버간의 지속적인 연결을 지원
- 여러 메서드(GET, POST, HEAD)를 지원하고, 헤더와 상태코드 등이 추가되었습니다
- 요청 헤더에 “Connection: keep-alive”를 포함해 지속적인 연결을 요청할 수 있음

> 특징
> 
> - HTTP 헤더(`Header`) 개념이 도입되어 요청과 응답이 추가되며, 메타데이터를 주고받고 프로토콜을 유연하고 확장 가능하도록 개선됨 (1996)
> - 버전 정보와 요청 method가 함께 전송되기 시작
> - 상태 코드 라인도 응답의 시작부분에 추가되어 브라우저 요청의 성공과 실패를 파악 가능해짐 (해당 결과에 대한 로컬 캐시 갱신 등의 사용이 가능해짐)
> - Content-Type 도입으로 HTML 이외의 문서 전송 기능이 가능해짐
> 
> 한계
> 
> - `커넥션 하나`당 `요청 하나`와 `응답 하나`만 처리 가능했음
> 
> → 지금 생각해보면 매우 비효율적인 동작으로 보이며, 서버 부하도 문제
> 
> → `HTTP 1.1`에서 개선
> 

```vbnet
/* 요청 */
GET /mypage.html HTTP/1.0
User-Agent: NCSA_Mosaic/2.0 (Windows 3.1)

/* 응답 */
200 OK
Date: Tue, 15 Nov 1994 08:12:31 GMT
Server: CERN/3.0 libwww/2.17
Content-Type: text/html
<HTML>
A page with an image
  <IMG SRC="/myimage.gif">
</HTML>
```

## HTTP | 1.1 (1997~1999)

- 가장 널리 사용되는 HTTP 버전 중 하나로, 지속적인 연결이 기본으로 설정되어있음
- 파이프라이닝을 통해 여러 요청을 동시에 처리할 수 있도록 함
- 캐시관리, 범위요청, 청크 전송 인코딩 등의 기능이 추가되었음

> 특징
> 
> - 1997년에 등장
>     - `Persistent Connection` 추가
>         - 지정한 timemout 동안  커넥션을 닫지 않는 방법을 통해 커넥션의 사용성이 높아짐
>     - `Pipelining` 추가
>         - 앞 요청의 응답을 기다리지 않고 `순차적인 여러 요청`을 `연속적`으로 보내고 그 순서에 맞춰 응답을 받는 방식이 등장
>         - 순차적으로 하나씩 요청 | 응답이 처리되는 기존 방식을 개선
>         - 하나의 커넥션에 여러개의 요청이 들어 있을 뿐, 동시에 여러개의 요청을 처리해 응답으로 보내주는 것은 아니다(`multiplexing` 되지는 않음)
> - 한계
>     - `Head Of Line Blocking` (HOL): 결국 앞 요청의 응답이 너무 오래걸리면 뒤 요청은 `Blocking` 되어버림
>     - `Header 구조의 중복` : 연속된 요청의 헤더의 많은 중복이 발

```vbnet
/* 요청 */
GET /en-US/docs/Glossary/Simple_header HTTP/1.1
Host: developer.mozilla.org
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate, br
Referer: https://developer.mozilla.org/en-US/docs/Glossary/Simple_header

/* 응답 */
200 OK
Connection: Keep-Alive
Content-Encoding: gzip
Content-Type: text/html; charset=utf-8
Date: Wed, 20 Jul 2016 10:55:30 GMT
Etag: "547fa7e369ef56031dd3bff2ace9fc0832eb251a"
Keep-Alive: timeout=5, max=1000
Last-Modified: Tue, 19 Jul 2016 00:59:33 GMT
Server: Apache
Transfer-Encoding: chunked
Vary: Cookie, Accept-Encoding

(content)
```

## HTTP | 1.2 (2014)

- HTTP | 2로의 전환으로 인해 HTTP | 1.2는 중단되었습니다

## HTTP | 2.0 (2015)

- 성능 향상을 목표로 하는 주요 변경 사항이 포함됨
- 단일 연결을 통해 여러 요청 및 응답을 다중화하여 성능을 향상시킴
- 헤더 압축 및 이진 프레임 형식을 도입하여 효율성 개선

> 설명
> 
> - 기존 HTTP 1.X 버전의 성능 향상에 초점을 맞춘 프로토콜 (2015년 등장)
> - 표준의 대체가 아닌 확장 (표준 : HTTP 1.1)
> - 특징
>     - 1) HTTP 메시지 전송 방식의 전환
>     - 2) `Multiplexed Streams`
>     - 3) `Stream Prioritization`
>     - 4) `Server Push`
>     - 5) `Header Compression`
> 
> ---
> 
> ### HTTP 메시지 전송 방식의 전환
> 
> - 기존 : 일반 텍스트 형식
> - 개선
>     - `Binary Framing` 계층을 추가해서 보내는 메시지를 프레임(`frame`)이라는 단위로 분할하며 추가적으로 `바이너리`로 `인코딩`을 한다(바이너리 형식 사용으로 `파싱속도` 및 `전송 속도`가 빠르고 `오류 발생 가능성`이 낮아짐)
> 
> ---
> 
> ### Multiplexed Streams
> 
> - 기존 : HTTP 1.1의 Pipelining 으로 하나의 커넥션에 여러 요청이 있지만, 결국 동시에 여러 요청을 처리해 응답으로 주지는 못하였음
> - 개선
>     - 구성된 연결 내에 전달되는 `바이트의 양방향 흐름`을 의미하는 `Stream`으로 요청 / 응답이 교환됨(`하나의 커넥션` 안에 `여러개의 Stream` 존재 가능)
>     - 메시지가 이진화된 텍스트인 프레임(`frame`)으로 나뉘어 요청마다 구분되는 `Stream`을 통해 전달
>     - 즉, 프레임(`frame`)이 각 요청의 스트림(`stream`)을 통해 전달되며, 하나의 커넥션 안에 여러개의 스트림(`stream`)을 가질 수 있게되어 다중화(`multiplexing`)가 가능해짐> `동시에 여러 요청을 처리`하는 것이 가능해짐> `Stream`을 통해서 `각 요청`의 `응답의 순서가 의미`가 없어져서 `HOL Blocking`이 자연스럽게 해결됨
> 
> ---
> 
> ### Stream Prioritization
> 
> - 리소스간 우선순위를 설정하는 기능
> - Stream에 우선순위를 부여해서 인터리빙되고 전달하는 것이 가능해짐
> 
> ---
> 
> ### Server Push
> 
> - 단일 클라이언트 요청에 여러 응답을 보낼 수 있는 특징을 통해 Server에서 client에게 필요한 추가적인 리소스를 push해주는 기능
> 
> ---
> 
> ### Header Compression
> 
> - 기존 : 연속된 요청의 경우 많은 중복된 헤더의 전송으로 오버헤드가 많이발생했음
> - 개선
>     - 요청과 응답의 헤더 메타데이터를 압축해서 오버헤드를 감소
>     - 1) 전송되는 헤더 필드를 `static dynamic table`로 서버에서 유지
>     - 2) 이전에 표시된 헤더를 제외한 필드를 허프만(`huffman`) 인코딩을 수행해서 데이터를 압축
> 
> ---
> 
> ### [ HTTP 2.0 한계 ]
> 
> - 각 요청마다 Stream으로 구분해서 병렬적으로 처리하지만,결국 이에는 TCP 고유의 `HOL Blocking`이 존재
> - 왜냐하면, 서로 다른 Stream이 전송되고 있을 때, 하나의 Stream에서 유실이 발생되거나 문제가 생기면 결국 다른 Stream도 문제가 해결될 때 까지 지연되는 현상이 발생되기 때문
> - 즉, 이러한 TCP의 태생적인 `HOL Blocking`을 해결하기 위해 `QUIC / HTTP3.0`이 등장

## HTTP | 3.0 (2018)

- QUIC(Quick UDP Internet Connection)프로토콜울 기반으로 하는 새로운 전송 프로토콜을 도입
- TCP 대신 UDP를 사용해 성능 향상
- 다중화, 연결 설정 및 흐름제어 등을 개선해 빠른 웹 페이지 로딩을 지원

> QUIC ?
> 
> - Google에서 개발한 UDP 기반의 전송 프로토콜 (Quick UDP Internet Connections)
> - Google에서 TCP의 구조적 문제로 성능 향상이 어렵다고 판단하여 UDP 기반을 선택
> - QUIC은 TCP의 3-way handshake과정을 최적화 하는 것에 초점을 두고 개발됨
> - QUIC은 TCP의 Stream은 하나의 chain으로 연결되는 것과 다르게 각 Stream당 독립된 Stream chain을 구성하여 TCP HOL Blocking을 해결하였다
> - HTTP 3.0
>     - QUIC을 기반으로 나온 새로운 HTTP 메이저 버전