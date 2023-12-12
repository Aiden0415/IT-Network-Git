# 클래스
클래스는 참조(reference) 타입이며, 타입이름은 대문자 카멜케이스를 사용하여 정의. swift의 클래스는 다중 상속되지 않는다

## 클래스 문법

클래스를 정의할 때는 class 키워드를 사용한다.

```swift
class Sample {
    var mutableProperty: Int = 100
    let immutableProperty: Int = 100
    static var typeProperty: Int = 100
    
    func instanceMethod() {
    	print("instance method")
    }
    static func typeMethod() {
    	print("type method - static")
    }
    class func classMethod() {
    	print("type method - class")
    }
}
```

## 클래스 사용

클래스의 인스턴스는 참조 타입이므로 let으로 선언되었더라도 인스턴스 프로퍼티의 값 변경이 가능함

```swift
var mutableReference: Sample = Sample()
mutableReference.mutableProperty = 200
mutableReference.immutableProperty = 200 // 컴파일 오류

let immutableReference: Sample = Sample()
immutableReference.mutableProperty = 200
immutableReference.immutableProperty = 200 // 컴파일 오류

// 타입 프로퍼티 및 메서드
Sample.typeProperty = 300
Sample.typeMethod() // type method

// 인스턴스에서는 타입 프로퍼티나 타입 메서드를 사용할 수 없다.
mutableReference.typeProperty = 400 // 컴파일 오류
mutableReference.typeMethod() // 컴파일 오류
```

## 클래스 예시

```swift
class Student {
    var name: String = "unknown"
    var `class`: String = "Swift"
    
    class func selfIntroduce() {
    	print("학생타입입니다")
    }
    
    func selfIntroduce() {
    	print("저는 \(self.class)반 \(name)입니다")
    }
}

Student.selfIntroduce() // 학생타입입니다

var ssionii: Student = Student()
ssionii.name = "ssionii"
ssionii.class = "스위프트"
ssionii.selfIntroduce() // 저는 스위프트반 ssionii입니다

let jina: Student = Student()
jina.name = "jina"
jina.selfIntroduce() // 저는 Swift반 jina입니다
```