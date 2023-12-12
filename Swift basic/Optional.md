값이 있을 수도, 없을 수도 있음을 표현. nil이 할당 도리 수 있는지 없는지 표현

## 옵셔널을 쓰는 이유

> 명시적 표현
> 
- nil의 가능성을 코드만으로 표현 가능
- 문서 / 주석 작성 시간 절약

---

> 안전한 사용
> 
- 전달받은 값이 옵셔널이 아니라면 nil 체크를 하지 않고 사용 가능
- 예외 상황을 최소화하는 안전한 코딩
- 효율적 코딩

---

## 옵셔널 문법과 선언

> 옵셔널 문법
> 

enum + generics

## 옵셔널 선언

```swift
enum Optional<Wrapped> : ExpressibleByNiliteral {
	case none
	case some(Wrapped) 
}

let optionalValue: Optional<Int> = nil
let optionalValue: Int? = nil
```

## 옵셔널 표현

느낌표(!)를 이용한 암시적 추출 옵셔널

```swift
var implicitlyUnwrappedOptionalValue: Int! = 100

switch implicitlyUnwrappedOptionalValue {
case .none:
	print(“This Optional variable is nil”)
case .some(let value):
	print(“Value is \(value)”)
} 

// 기존 변수처럼 사용 가능
implicitlyUnwrappedOptionalValue = implicitlyUnwrappedOptionalValue + 1

// nil 할당 가능
implicitlyUnwrappedOptionalValue = nil
```

물음표(?)를 이용한 암시적 추출 옵셔널

```swift
var optionalValue: Int? = 100

switch optionalValue {
case .none:
	print(“This Optional variable is nil”)
case .some(let value):
	print(“Value is \(value)”)
}

// 기존 변수처럼 사용불가 - 옵셔널과 일반 값은 다른 타입이므로 연산 불가
optionValue = optionValue + 1 // 에러

// nil 할당 가능
optionValue = nil
```

## 옵셔널 추출

옵셔널 추출이란 옵셔널에 들어있는 값을 사용하기 위해 꺼내오는 것을 말한다

> 옵셔널 추출 방식
> 
- 옵셔널 바인딩
    - nil 체크 + 안전한 추출
    - 옵셔널 안에 있는 값이 들어있는지 확인하고 값이 있으면 값을 꺼내온다
    - If - let 방식 사용

```swift
func printName(_ name: String) {
	print(name)
}

var myName: String? = nil

printName(myName) // 전달되는 값의 타입이 다르기 때문에 컴파일 오류

if let name: String = myName {
	printName(name)
} else {
	print(“myName == nil”)
}

var yourName: String! = nil

If let name: String = yourName {
	printName(name)
} else {
	print(“yourName == nil”) 
}
```

,를 사용해 한번에 여러 옵셔널을 바인딩 할 수 있다. 단, 모든 옵셔널에 값이 있을 때만 동작한다

```swift
myName = “ssionii”
yourName = nil

if let name = myName, let friend = yourName {
	print(“\(name) and \(friend)”)
} // yourName이 nil이기 때문에 실행 X

yourName = “hana”

If let name = myName, let friend = yourName {
	print(“\(name) and \(friend)”)
} // ssionii and hana
```

- 강제 추출: 옵셔널에 값이 들어있는지 아닌지 확인하지 않고 강제로 값을 꺼내는 방식. 만약 값이 없을 경우 런타임 오류가 발생

```swift
var myName: String? = “ssionii”
var yourName: String! = nil

printName(myName) // ssionii
myName = nil

print(myName) // 런타임 오류

yourName = nil
print(yourName) // 런타임 오류
```

---