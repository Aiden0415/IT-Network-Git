# 클로저
- 클로저는 실행 가능한 코드 블럭임
- 함수와 다르게 이름정의는 필요하지 않지만, 매개변수 전달과 변환 값이 존재할 수 있다는 점이 동일함
- 함수는 이름이 있는 클로저임
- 일급객체로 전달인자, 변수, 상수 등에 저장 및 전달이 가능

## 클로저 문법

```swift
{(매개변수 목록) -> 반환타입 in
	실행코드
}
```

## 클로저 사용

```swift
//sum이라는 상수에 클로저 할당
let sum: (Int, Int) -> Int = {(a: Int, b: Int) in
	return a+b
}

let sumResult: Int = sum(1, 2)
```

## 함수의 전달인자로서의 클로저

클로저는 주로 함수의 전달인자로 많이 사용되며, 함수 내부에서 원하는 코드 블럭을 실행할 수 있다.

```swift
let add: (Int, Int) -> Int
add = { (a: Int, b: Int) in
	return a+b
}
 
let sub: (Int, Int) -> Int
sub = { (a: Int, b: Int) in
	return a-b
}

func calculate(a: Int, b: Int, method: (Int, Int) -> Int ) -> Int {
	return method(a, b)
} 

var calculated: Int

calculated = calculate(a: 30, b: 10, method: add)
print(calculated) // 40

calculated = calculate(a: 30, b: 10, method: sub)
print(calculated) // 20

// 함수를 호출 할 때 클로저를 작성하여 전달
calculated = calculate(a: 50, b: 10, method: { (left: Int, right: Int) -> Int in
	return left * right
})
```

---

## 다양한 클로저 표현

클로저는 아래 규칙을 통해 다양한 모습으로 표현될 수 있다.

> 후행 클로저
> 

클로저가 함수의 마지막 전달인자일 때, 마지막 매개변수 이름을 생략한 후 함수 소괄호 외부에 클로저를 구현할  수 있음

```swift
var result = calculate(a: 10, b: 10){left: Int, right: Int) -> Int in
	return left + right
}
```

> 반환타입 생략
> 

calculate(a:b:method:) 함수의 method 매개변수는 Int 타입을 반환할 것이라는 사실을 컴파일러도 알기 때문에 굳이 클로저에서 반환타입을 명시해주지 않아도 됨. 대신 in 키워드는 생략 불가능

```swift
result = calculate(a: 10, b: 10, method: { (left: Int, right: Int) in
	return left + right
}) 

// 후행클로저와 함께 사용할 수도 있다.
result = calculate(a: 10, b: 10){ (left: Int, right: Int) in
	return left + right
}
```

> 단축 인자 이름
> 

클로저의 매개변수 이름이 굳이 불필요하다면 단축 인자이름을 활용할수 있음. 단축 인자이름은 클로저의 매개변수의 순서대로 $0, $1, #2… 처럼 표현

```swift
result = calculate(a: 10, b: 10, method: {
	return $0 + $1
})

//후행 클로저와 함께 사용
result = calculate(a: 10, b: 10) {
	$0 + $1
}

// 후행 클로저와 함께 사용
result = calculate(a: 10, b: 10) { 
	return $0 + $1
}
```

> 암시적 반환 표현
> 

클로적 반환하는 값이 있다면 클로저의 마지막 줄의 결과값은 암시적으로 반환값으로 취급함

```swift
result = calculate(a: 10, b: 10) {
	$0 + $1
}

// 간결하게 한 줄로 표현 가능
result = calculate(a: 10, b: 10) { $0 + $1 }
```

---