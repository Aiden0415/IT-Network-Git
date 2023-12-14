# Any, Object, Nil
## Any

swift의 모든 타입을 지칭하는 키워드

```swift
var someAny : Any = 100
someAny = "아무거나 넣을 수 있음"
someAny = 123.12

//마지막에 Double 타입의 값을 넣었더라도 Any는 Double이 아니기 때문에 할당하지 않음
//명시적인 데이터 타입 변환이 필요
let someDouble = someAny  //컴파일 에러 발생
```

## AnyObject

모든 클래스 타입을 지칭하는 프로토콜

```swift
class SomeClass{}
var someAnyObject : AnyObject = SomeClass()

//AnyObject는 클래스의 인스턴스만 수용 가능
someAnyObject = 123.12  //컴파일 에러
```

## nil

스위프트에서 ‘없음’을 의미하는 키워드

```swift
var someAny : Any
var someAnyObject : AnyObject

someAny = nil  //컴파일 오류 발생
someAnyObject = nil  //컴파일 오류 발생
```

---