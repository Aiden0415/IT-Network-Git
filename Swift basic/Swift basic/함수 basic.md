# 함수 기본 
함수 선언의 기본 형태

```swift
func 함수이름(매개변수1이름: 매개변수1타입, 매개변수2이름: 매개변수2타입...) -> 반환타입{
return 반환값
}

func sum(a: Int, b: Int) -> Int {
return a+b
}
```

반환값이 없는 함수

```swift
func 함수이름(매개변수1이름: 매개변수1타입, 매개변수2이름: 매개변수2타입) -> Void {
return
}

func printMyName(name: String){
print(name)
}
```

매개변수가 없는 함수

```swift
func 함수이름() -> 반환타입 {
return 반환값
}

func maxIntegerValue() -> Int{
return Int.max
}
```

함수의 호출

```swift
sum(a: 2, b: 3) //5
printMyName(name: "abc") //abc
maxIntegerValue() //Int의 최대값
```

---