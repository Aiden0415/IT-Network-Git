# 기본 데이터 타입 
- swift는 데이터 타입에 엄격한 언어
- 서로 다른 데이터 타입 간의 자료 교환이 굉장히 까다로움

## Bool

true와 false만 값으로 가짐.

```swift
var someBool : Bool = false
someBool = true
someBool = 1   //컴파일 오류 발생 
```

## Int, Uint

Int : 정수 타입 / 64비트 정수형     ex) +10 / -3 

UInt : 양수의 정수 타입 / 64비트의 양의 정수형  ex) +4  

```swift
var someInt : Int = 100

var someInt : UInt = 100
someUInt = -100  //컴파일 오류 발생
```

## Float, Double

Float : 실수 타입 / 32비트 부동소수형  

Double : 실수 타입 / 64비트 부동소수형

```swift
var someFloat  =3.14
someFloat = 3

var someDouble = 3.14
someDouble = 3
someDouble = someFloat  //컴파일 오류 발생
```

## Character, String

Character : 문자 타입 / 유니코드 사용 / 큰따옴표(””) 사용

String : 문자열 타입 / 유니코드 사용 / 큰따옴표(””) 사용

```swift
var someCharacter : Character = "A"
soemCharacter = "a"
someCharacter = "abc"  //컴파일 오류 발생

var someString : String = "hello"
someString = someString + "world"
someString = someCharacter  //컴파일 오류 발생
```
