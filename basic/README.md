# 타입

### 1. **기본 타입 (Primitive Types)**

기본 타입은 값의 크기와 범위에 따라 나뉘며, 코틀린에서는 모든 타입이 객체로 동작합니다.

| **타입**  | **설명**          | **크기**            | **예시**                                   |
| --------- | ----------------- | ------------------- | ------------------------------------------ |
| `Byte`    | 8비트 정수형      | 1 Byte              | `val byteVal: Byte = 127`                  |
| `Short`   | 16비트 정수형     | 2 Bytes             | `val shortVal: Short = 32767`              |
| `Int`     | 32비트 정수형     | 4 Bytes             | `val intVal: Int = 2147483647`             |
| `Long`    | 64비트 정수형     | 8 Bytes             | `val longVal: Long = 9223372036854775807L` |
| `Float`   | 32비트 부동소수점 | 4 Bytes             | `val floatVal: Float = 3.14F`              |
| `Double`  | 64비트 부동소수점 | 8 Bytes             | `val doubleVal: Double = 3.14159265358979` |
| `Char`    | 단일 문자         | 2 Bytes (16bit)     | `val charVal: Char = 'A'`                  |
| `Boolean` | 참/거짓 값        | 1 Byte (true/false) | `val boolVal: Boolean = true`              |

---

### 2. **참조 타입 (Reference Types)**

코틀린에서는 기본 타입도 내부적으로는 객체로 동작하며, 모든 참조 타입은 `Any`를 상속받습니다.

#### 2.1. **`String`**

- 문자열을 표현하는 클래스.
- 불변 객체로, 수정 불가능.
- 다중 라인 문자열(`"""`) 지원.

```kotlin
val text: String = "Hello"
val multilineText = """
    Line 1
    Line 2
""".trimIndent()
```

#### 2.2. **`Array`**

- 동일한 타입의 값들을 담는 배열.
- `arrayOf()`로 생성 가능.

```kotlin
val numbers: Array<Int> = arrayOf(1, 2, 3)
val names: Array<String> = arrayOf("Alice", "Bob")
```

#### 2.3. **컬렉션 (Collections)**

- `List`, `Set`, `Map`과 같은 자료구조 제공.
- `MutableList`, `MutableSet`, `MutableMap`은 수정 가능.

```kotlin
val list: List<Int> = listOf(1, 2, 3)
val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
```

---

### 3. **특수 타입 (Special Types)**

#### 3.1. **`Unit`**

- 반환 값이 없는 함수의 반환 타입 (Java의 `void`와 유사).

```kotlin
fun sayHello(): Unit {
    println("Hello!")
}
```

#### 3.2. **`Nothing`**

- 함수가 정상적으로 반환되지 않음을 나타냄.
- 주로 예외를 던지는 함수에 사용.

```kotlin
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}
```

#### 3.3. **`Any`**

- 모든 타입의 최상위 타입.
- 모든 객체는 `Any`를 상속받음.

```kotlin
val anyValue: Any = "Kotlin" // 문자열도 Any로 취급 가능
```

#### 3.4. **`Nullable`**

- 변수에 `null` 값을 허용하려면 타입에 `?`를 붙임.

```kotlin
var nullableString: String? = null
```

#### 3.5. **`Nothing?`**

- null만을 허용하는 타입.

```kotlin
val nothingValue: Nothing? = null
```

---

### 4. **사용자 정의 타입**

#### 4.1. **데이터 클래스 (`data class`)**

- 데이터 저장을 목적으로 사용.

```kotlin
data class Person(val name: String, val age: Int)
```

#### 4.2. **열거형 (`enum class`)**

- 상수 집합을 정의.

```kotlin
enum class Color { RED, GREEN, BLUE }
```

#### 4.3. **인터페이스 (`interface`)**

- 함수 및 프로퍼티 정의를 위한 청사진 제공.

```kotlin
interface Drawable {
    fun draw()
}
```

---

### 5. **타입 변환**

#### 5.1. 명시적 변환

- 코틀린은 암시적 타입 변환을 지원하지 않음.
- 변환 메서드(`toInt`, `toString`, `toDouble` 등)를 사용.

```kotlin
val number: Int = 10
val longNumber: Long = number.toLong()
```

#### 5.2. 타입 검사 및 캐스팅

- `is`를 사용하여 타입 확인.
- `as`를 사용하여 명시적으로 캐스팅.

```kotlin
if (number is Int) {
    println("This is an Int")
}

val obj: Any = "Kotlin"
val str = obj as String
println(str) // Kotlin
```

---

### 요약

| **타입**         | **설명**                             | **예시**                   |
| ---------------- | ------------------------------------ | -------------------------- |
| 기본 타입        | 정수, 실수, 문자, 불리언 등          | `Int`, `Double`, `Boolean` |
| 참조 타입        | 문자열, 배열, 컬렉션 등              | `String`, `Array`, `List`  |
| 특수 타입        | 반환 없음, 최상위 타입, null 관련    | `Unit`, `Any`, `Nothing`   |
| 사용자 정의 타입 | 데이터 클래스, 열거형, 인터페이스 등 | `data class`, `enum class` |

---

# 변수의 종류와 할당 방식

### 1. **변수 종류**

코틀린에서는 변수 선언 시 `val`과 `var` 두 가지 키워드를 사용합니다.

#### 1.1. **`val` (Value)**

- **읽기 전용 변수**로, 한 번 값을 할당하면 변경할 수 없습니다.
- 불변 객체를 나타낼 때 사용.
- 컴파일 시 상수(`const`)와는 다름.

```kotlin
val name: String = "Kotlin"
val age: Int = 25
// name = "Java" // 오류: val 변수는 값을 변경할 수 없습니다.
```

#### 1.2. **`var` (Variable)**

- **읽기/쓰기 가능한 변수**로, 값을 변경할 수 있습니다.
- 가변 객체를 나타낼 때 사용.

```kotlin
var city: String = "Seoul"
city = "Busan" // 정상 동작
```

---

### 2. **변수 선언 방식**

#### 2.1. **명시적 타입 지정**

- 변수의 타입을 명시적으로 선언.
- 초기값이 없어도 선언 가능하지만, 값을 할당하지 않으면 오류 발생.

```kotlin
val number: Int = 10
var greeting: String
greeting = "Hello, Kotlin!" // 초기화
```

#### 2.2. **타입 추론**

- 타입을 생략하면 초기값에 따라 자동으로 타입이 결정됩니다.

```kotlin
val number = 10       // 타입: Int
var greeting = "Hi!"  // 타입: String
```

---

### 3. **Nullable 변수**

- 변수에 `null` 값을 허용하려면 타입에 `?`를 붙여야 합니다.

```kotlin
var nullableString: String? = null // Nullable 타입
nullableString = "Not null"        // 값 할당
```

---

### 4. **초기화 지연 변수**

- 특정 조건에서만 초기화하고 싶을 때 사용.
- `lateinit`과 `lazy` 두 가지 방식.

#### 4.1. **`lateinit`**

- **가변 변수(`var`)**에서만 사용 가능.
- 초기화를 늦추지만, 초기화 전에 접근 시 예외가 발생.

```kotlin
lateinit var name: String
name = "Kotlin"  // 초기화
println(name)    // 출력: Kotlin
```

#### 4.2. **`lazy`**

- **불변 변수(`val`)**에서 사용.
- 처음 접근 시점에 초기화가 이루어짐.

```kotlin
val pi: Double by lazy {
    println("Calculating Pi...")
    3.14159
}
println(pi)  // "Calculating Pi..." 출력 후 3.14159 반환
```

---

### 5. **상수 선언**

- 컴파일 시점에 값을 고정하려면 `const`를 사용.
- 반드시 **최상위 레벨**이나 **`object` 블록**에서 선언해야 합니다.

```kotlin
const val MAX_VALUE = 100
println(MAX_VALUE) // 출력: 100
```

---

### 요약 표

| **키워드** | **특징**                                               | **사용 예시**                |
| ---------- | ------------------------------------------------------ | ---------------------------- |
| `val`      | 불변 변수. 한 번 값 할당 후 변경 불가                  | `val name: String = "Alice"` |
| `var`      | 가변 변수. 값을 변경 가능                              | `var age: Int = 30`          |
| `?`        | Nullable 변수. `null` 값 허용                          | `var city: String? = null`   |
| `lateinit` | 가변 변수의 초기화를 지연                              | `lateinit var name: String`  |
| `lazy`     | 불변 변수의 초기화를 지연하며 첫 접근 시 초기화        | `val pi: Double by lazy {}`  |
| `const`    | 컴파일 시 상수. 최상위나 `object` 내부에서만 선언 가능 | `const val PI = 3.14159`     |

---

### 6. **코틀린의 변수 선언 방식 예시**

```kotlin
fun main() {
    val name: String = "Kotlin"   // 불변 변수
    var age: Int = 25            // 가변 변수
    var city: String? = null     // Nullable 변수

    lateinit var job: String     // 초기화 지연 변수
    job = "Developer"

    val pi: Double by lazy {     // 초기화 지연 변수 (불변)
        println("Calculating...")
        3.14159
    }

    println(name)   // Kotlin
    println(age)    // 25
    println(city)   // null
    println(job)    // Developer
    println(pi)     // Calculating... 3.14159
}
```

## Nullable과 Non-Nullable 차이

코틀린은 **null 안전성**을 기본으로 지원하며, **Nullable** 타입과 **Non-Nullable** 타입을 명시적으로 구분합니다. 이로 인해 `NullPointerException`(NPE)을 방지할 수 있습니다.

---

### 1. **Nullable과 Non-Nullable 차이**

| **특징**      | **Non-Nullable**            | **Nullable**                  |
| ------------- | --------------------------- | ----------------------------- |
| **정의**      | null 값을 가질 수 없는 변수 | null 값을 가질 수 있는 변수   |
| **타입 선언** | 타입 뒤에 `?` 없음          | 타입 뒤에 `?` 추가            |
| **사용 시**   | null 검사가 불필요          | null 검사 또는 안전 호출 필요 |

---

### 2. **Non-Nullable**

- 변수에 **null 값을 허용하지 않음**.
- 선언 시 반드시 값을 초기화해야 하며, null을 할당하려고 하면 컴파일 오류가 발생.

```kotlin
val name: String = "Kotlin"
// name = null // 오류: null 값을 할당할 수 없음
```

---

### 3. **Nullable**

- 변수에 **null 값을 허용**.
- 타입 뒤에 `?`를 붙여 선언.
- null에 안전하게 접근하기 위해 추가적인 처리가 필요.

```kotlin
val nullableName: String? = null
println(nullableName) // null 출력 가능
```

---

### 4. **Nullable 변수 접근 방법**

#### 4.1. **안전 호출 연산자 (`?.`)**

- 객체가 null인지 확인한 후, null이 아니면 실행.
- null이면 호출을 무시하고 null 반환.

```kotlin
val name: String? = null
println(name?.length) // 출력: null
```

#### 4.2. **엘비스 연산자 (`?:`)**

- null일 경우 **대체값**을 제공.

```kotlin
val name: String? = null
val length = name?.length ?: 0
println(length) // 출력: 0
```

#### 4.3. **강제 호출 (`!!`)**

- 변수에 null이 없음을 **개발자가 보장**하고 강제로 호출.
- null이 발생하면 `NullPointerException`이 발생.

```kotlin
val name: String? = "Kotlin"
println(name!!.length) // 정상 작동: 6
// val name2: String? = null
// println(name2!!.length) // 오류: NullPointerException 발생
```

#### 4.4. **null 체크 후 사용**

- `if` 문 또는 `when` 문으로 null 여부를 검사한 후 사용.

```kotlin
val name: String? = null
if (name != null) {
    println(name.length) // null이 아님을 확인 후 안전하게 사용
} else {
    println("name is null")
}
```

---

### 5. **Nullable과 Non-Nullable의 사용 사례**

#### Non-Nullable (기본 값이 반드시 필요한 경우)

- null 값이 허용되지 않는 경우에 사용.
- 예: 사용자 이름, 고정된 기본 설정 값 등.

```kotlin
val age: Int = 25 // null 불허
```

#### Nullable (null 값이 허용되거나 불확실한 경우)

- 데이터가 없거나 초기화되지 않을 수 있는 경우.
- 예: 사용자 입력 값, API 응답 등.

```kotlin
val nickname: String? = null // null 허용
```

---

### 요약 코드 예시

```kotlin
fun main() {
    val nonNullable: String = "Hello"
    // nonNullable = null // 컴파일 오류

    val nullable: String? = null
    println(nullable?.length)  // 안전 호출 연산자: null
    println(nullable ?: "No value") // 엘비스 연산자: "No value"

    val forcedValue: String? = "Kotlin"
    println(forcedValue!!.length) // 강제 호출: 6
}
```

---

### **핵심**

- **Nullable**: 타입에 `?`를 붙여 선언, null 가능성 처리 필요.
- **Non-Nullable**: null 허용 불가, 안전한 기본 동작 제공.
- 코틀린의 null 안전성은 **컴파일 단계에서 null 문제를 방지**하며, 안정적인 코드를 작성하도록 돕습니다.

# Function

#### 1. **기본 함수 선언**

- `fun` 키워드를 사용하여 함수 선언.
- 매개변수와 반환 타입을 명시.

```kotlin
fun 함수명(매개변수: 타입): 반환타입 {
    // 함수 내용
    return 반환값
}
```

예시: 두 수를 더하는 함수

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}
```

---

#### 2. **Unit 함수**

- 반환값이 없을 때 `Unit`을 사용 (Java의 `void`와 유사).
- `Unit`은 생략 가능.

```kotlin
fun printMessage(message: String): Unit {
    println(message)
}
```

동일한 함수 (더 간결하게 작성 가능):

```kotlin
fun printMessage(message: String) {
    println(message)
}
```

---

#### 3. **기본값을 가진 매개변수**

- 매개변수에 기본값을 설정 가능.

```kotlin
fun greet(name: String = "Guest") {
    println("Hello, $name!")
}

greet()           // 출력: Hello, Guest!
greet("Alice")    // 출력: Hello, Alice!
```

---

#### 4. **이름을 지정한 호출**

- 인자의 순서를 변경하고 싶을 때 이름을 지정해 호출 가능.

```kotlin
fun subtract(a: Int, b: Int): Int {
    return a - b
}

val result = subtract(b = 5, a = 10) // 순서 무시하고 호출
println(result) // 출력: 5
```

---

#### 5. **람다 표현식 (익명 함수)**

- 간단한 로직은 람다로 작성 가능.

```kotlin
val multiply: (Int, Int) -> Int = { a, b -> a * b }
println(multiply(3, 4)) // 출력: 12
```

---

#### 6. **확장 함수**

- 기존 클래스에 함수를 추가하는 방식.

```kotlin
fun String.addHello(): String {
    return "Hello, $this!"
}

val result = "Kotlin".addHello()
println(result) // 출력: Hello, Kotlin!
```

---

#### 요약

| **구문**                               | **설명**                                                    |
| -------------------------------------- | ----------------------------------------------------------- |
| `fun 함수명(매개변수: 타입): 반환타입` | 기본 함수 선언                                              |
| `fun 함수명(매개변수: 타입)`           | 반환값이 없는 함수 (`Unit` 생략 가능)                       |
| `fun 함수명(매개변수: 타입 = 기본값)`  | 기본값을 가진 매개변수                                      |
| `fun 클래스명.확장함수명()`            | 클래스에 확장 함수를 추가                                   |
| 람다 함수                              | `val 함수명: (매개변수) -> 반환타입 = { 매개변수 -> 결과 }` |

# 제어문

### 1. **조건문**

#### 1.1. **`if`문**

- **표준 조건문**.
- 표현식으로 사용할 수 있어 값을 반환함.

```kotlin
// if 조건문
val x = 10
if (x > 5) {
    println("x는 5보다 큽니다.")
} else {
    println("x는 5 이하입니다.")
}

// if 표현식
val max = if (x > 5) x else 5
println(max) // 10
```

---

#### 1.2. **`when`문**

- **switch문**을 대체하며, 더 강력한 기능 제공.
- 표현식이나 문으로 사용 가능.

```kotlin
val value = 2
val result = when (value) {
    1 -> "One"
    2 -> "Two"
    3 -> "Three"
    else -> "Unknown" // 기본 값
}
println(result) // Two

// 조건 사용
val age = 25
val category = when {
    age < 18 -> "미성년자"
    age in 18..64 -> "성인"
    else -> "노년"
}
println(category) // 성인
```

---

### 2. **반복문**

#### 2.1. **`for`문**

- 범위(`range`), 컬렉션, 배열 등을 순회.

```kotlin
// 범위 순회
for (i in 1..5) {
    println(i) // 1, 2, 3, 4, 5
}

// 증가값
for (i in 1..10 step 2) {
    println(i) // 1, 3, 5, 7, 9
}

// 역순 범위
for (i in 10 downTo 1) {
    println(i) // 10, 9, ..., 1
}

// 배열 순회
val array = arrayOf("A", "B", "C")
for (item in array) {
    println(item)
}

// 인덱스와 값 순회
for ((index, value) in array.withIndex()) {
    println("Index $index: $value")
}
```

---

#### 2.2. **`while`문**

- 조건이 참일 때 실행.

```kotlin
var i = 1
while (i <= 5) {
    println(i) // 1, 2, 3, 4, 5
    i++
}
```

---

#### 2.3. **`do-while`문**

- 코드 블록을 최소 한 번 실행 후 조건 검사.

```kotlin
var i = 1
do {
    println(i) // 1, 2, ..., 5
    i++
} while (i <= 5)
```

---

### 3. **제어 키워드**

#### 3.1. **`break`**

- 반복문을 종료.

```kotlin
for (i in 1..10) {
    if (i == 5) break
    println(i) // 1, 2, 3, 4
}
```

---

#### 3.2. **`continue`**

- 현재 반복을 건너뛰고 다음 반복으로 이동.

```kotlin
for (i in 1..5) {
    if (i == 3) continue
    println(i) // 1, 2, 4, 5
}
```

---

#### 3.3. **`return`**

- 함수에서 값을 반환하거나 반복문을 종료.

```kotlin
fun findEven(numbers: List<Int>): Int? {
    for (number in numbers) {
        if (number % 2 == 0) return number // 첫 번째 짝수 반환
    }
    return null // 짝수가 없을 경우
}
```

---

#### 3.4. **`label`과 함께 사용**

- 중첩된 반복문에서 특정 반복문을 종료하거나 건너뛸 때 사용.

```kotlin
loop@ for (i in 1..3) {
    for (j in 1..3) {
        if (j == 2) break@loop // 외부 반복문 종료
        println("i=$i, j=$j")
    }
}
```

---

### 4. **예외 처리**

- `try`, `catch`, `finally` 사용.

```kotlin
try {
    val result = 10 / 0
} catch (e: ArithmeticException) {
    println("예외 발생: ${e.message}")
} finally {
    println("항상 실행됩니다.")
}
```

---

### 요약 표

| **제어문**  | **설명**                       | **예시**                                 |
| ----------- | ------------------------------ | ---------------------------------------- |
| `if`        | 조건문. 값 반환 가능           | `val max = if (x > 5) x else 5`          |
| `when`      | 다중 조건 처리                 | `when (value) { 1 -> "One" else -> "" }` |
| `for`       | 반복문. 범위, 컬렉션 순회 가능 | `for (i in 1..5)`                        |
| `while`     | 조건이 참일 때 반복            | `while (i <= 5)`                         |
| `do-while`  | 최소 한 번 실행 후 조건 검사   | `do { ... } while (condition)`           |
| `break`     | 반복문 종료                    | `if (i == 5) break`                      |
| `continue`  | 반복 건너뛰기                  | `if (i == 3) continue`                   |
| `try-catch` | 예외 처리                      | `try { ... } catch (e: Exception)`       |
| `label`     | 특정 반복문 제어               | `break@label`, `continue@label`          |

---

### 예시: 모든 제어문 사용

```kotlin
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    // if와 when
    val max = if (numbers.size > 3) "Large" else "Small"
    println(max)

    val type = when (numbers.size) {
        1 -> "Single"
        2, 3 -> "Few"
        else -> "Many"
    }
    println(type)

    // 반복문
    for (i in 1..5) {
        if (i == 3) continue
        println(i)
    }

    var i = 1
    while (i <= 3) {
        println("While: $i")
        i++
    }

    // try-catch
    try {
        val result = 10 / 0
    } catch (e: ArithmeticException) {
        println("예외 발생: ${e.message}")
    }
}
```

# Class

### 코틀린 클래스 생성 방식 요약

#### 1. **기본 생성자 (Primary Constructor)**

- 클래스 정의에 바로 선언되는 생성자.
- 프로퍼티를 함께 정의하거나 초기화 가능.
- `init` 블록에서 초기화 작업 가능.

```kotlin
class Person(var name: String? = null, var age: Int = 0, var gender: Gender = Gender.MALE) {
    fun sayHello() {
        println("Hello, $name!")
    }
    fun sayBye() {
        println("Bye, $name!")
    }
}
```

사용 예시:

```kotlin
val person1 = Person(age = 20, gender = Gender.FEMALE)
person1.name = "Alice2"
```

---

#### 2. **보조 생성자 (Secondary Constructor)**

- `constructor` 키워드로 정의.
- 기본 생성자를 호출해야 함(`: this(...)`).
- 주로 기본 생성자 외 추가적인 초기화 작업에 사용.

```kotlin
class Person2(var name: String, var age: Int, var gender: Gender) { // 기본 생성자
    init {
        println("$name $age $gender 초기화 완료")
    }

    constructor(name: String, age: Int, gender: Gender, hobby: String) : this(name, age, gender) {
        println("보조 생성자입니다.")
        println("$hobby")
    }

    fun sayHello() {
        println("Hello, $name!")
    }
    fun sayBye() {
        println("Bye, $name!")
    }
}
```

사용 예시:

```kotlin
val person2 = Person2("Charlie", 19, Gender.FEMALE, "취미는 없습니다")
```

---

#### 3. **보조 생성자만 있는 클래스**

- 기본 생성자가 없는 경우.
- 모든 생성자는 `constructor`로 정의.
- 초기화는 보조 생성자에서 처리.

```kotlin
class Person3 {
    constructor(name: String, age: Int, gender: Gender) {
        println("보조 생성자입니다.1")
        println("$name $age $gender 초기화 완료")
    }
    constructor(name: String, age: Int, gender: Gender, hobby: String) : this(name, age, gender) {
        println("보조 생성자입니다.2")
        println("$hobby")
    }

    fun sayHello(name: String) {
        println("Hello, $name!")
    }
    fun sayBye(name: String) {
        println("Bye, $name!")
    }
}
```

사용 예시:

```kotlin
val person3 = Person3("Charlie", 40, Gender.FEMALE, "취미는 없습니다")
```

---

### 요약 표

| **클래스 방식**        | **설명**                                             | **사용 예시**                                                |
| ---------------------- | ---------------------------------------------------- | ------------------------------------------------------------ |
| **기본 생성자**        | 클래스 선언 시 바로 정의. `init` 블록 사용 가능.     | `val person = Person(name = "Alice", age = 20)`              |
| **보조 생성자**        | `constructor`로 정의. 기본 생성자 호출 필요.         | `val person = Person2("Bob", 25, Gender.MALE, "취미 없음")`  |
| **보조 생성자만 사용** | 기본 생성자 없이 모든 생성자를 `constructor`로 정의. | `val person = Person3("Charlie", 40, Gender.FEMALE, "독서")` |

---

### 정리

코틀린에서는 기본 생성자를 사용하는 것이 일반적이며, 필요 시 보조 생성자를 추가해 더 복잡한 초기화 로직을 구현할 수 있다. 단, 보조 생성자 사용은 최소화하고 기본 생성자와 `init` 블록을 적극 활용하는 것을 권장한다.
