# 컬렉션 타입
## Array

멤버가 순서(인덱스)를 가진 리스트 형태의 컬레션 타입 / 여러가지 리터럴 문법을 활용할 수 있다

1. Array 선언 및 생성

```swift
var integers: Array<Int> = Array<Int>()

//위와 동일한 표현
var integers : Array<Int> = [Int]()
var integers : Array<Int> = []
var integers : [Int] = Array<Int>()
var integers : [Int] = [Int]()
var integers : [Int] = []
var integers = [Int]()
```

1. Array 활용

```swift
//멤버 삽입
integers.append(1)
integers.appned(2)
integers.appned(3)
integers.append(123.12) // 오류

// 멤버 포함 여부 확인
integers.contains(1) // true
integers.contains(4) // false

// 멤버 교체
integers[0] = 100

// 멤버 삭제
integers.remove(at:0) // 100 삭제
integers.removeLast() // 2 삭제
integers.removeAll() // 모두 삭제

// 멤버 수
print(integers.count) // 0
```

## Dictionary

‘키’와 ‘값’의 쌍으로 이루어진 컬렉션 타입 / Array와 같이 여러가지 리터럴 문법을 활용할 수 있다

1. Dictitonary의 선언과 생성

```swift
var anyDictionary : Dictionary<String, Any> = [String : Any]()

// 위와 동일한 표현
var anyDictionary : Dictionary<String, Any> = Dictionary<String, Any>()
var anyDictionary : Dictionary<String, Any> = [:]
var anyDictionary : [String : Any] = Dictionary<String, Any>()
var anyDictionary : [String : Any] = [String : Any]()
var anyDictionary = [String : Any]()
```

1. Dictionary 활용

```swift
// 키에 해당하는 값 할당
anyDictionary["someKey"] = "someValue"
anyDictionary["anotherKey"] = 100

// 위와 동일한 표현
anyDictionary = ["someKey" : "someValue", "anotherKey" : 100]

// 키에 해당하는 값 변경
anyDictionary["someKey"] = "dictionary"

// 키에 해당하는 값 제거
anyDictionary.removeValue(forKey:"anotherKey")
anyDictionary["someKey"] = nil
```

## Set

중복되지 않는 멤버가 순서 없이 존재하는 컬렉션 / Array, Dictionary와 달리 축약형이 없음

1. Set 선언 및 생성

```swift
var integerSet : Set<Int> = Set<Int>()
```

1. Set 활용

```swift
integerSet.insert(1)
integerSet.insert(2)
integerSet.insert(99)
integerSet.insert(3)
integerSet.insert(99) // 반영 x

// 멤버 포함 여부 확인
integerSet.contains(1) // true
integerSet.contains(100) // false

// 멤버 삭제
integerSet.remove(1) // {2, 3, 99}
integerSet.removeFirst() // {3, 99}

// 멤버 수
print(integerSet.count) // 2
```

멤버의 유일성이 보장되기 때문에 집합연산에 활용하면 유용하다

```swift
let setA : Set<Int> = [1, 2, 3, 4, 5]
let setB : Set<Int> = [3, 4, 5, 6, 7]

//합집합
let union : Set<Int> = setA.union(setB)
//오름차순 정렬
let orderedUnion : [Int] = union.sorted()

//교집합
let intersection : Set<Int> = setA.intersection(setB)

//차집합
let subtracting : Set<Int> = setA.subtracting(setB)
```

---