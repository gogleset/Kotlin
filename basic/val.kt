// read only 지역 변수 val
fun main(args: Array<String>) {
    // val : 변수에 값을 할당하게 되면 다시 재 할당을 시킬 수 없다
    val a: Int = 1 // 즉시 할당
    val b = 2 // 타입 추론
    val c: Int // 타입 할당 및 Int 값 예약
    // Int, Byte, Short, Long
    c = 3;
    // a = 2; //재할당 오류
    println(a)
    println(b)
    println(c)

    // 변수의 값을 재할당 가능하다
    var d = 3
    d = 1;
    println(d);

    var e : String = "안녕"
    e =  "Hello"
    println(e)

    // 논리연산자(true, false)
    val f: Boolean = true
    println(f)

    // float, double 소수점
    val g: Float = 1.1f // 4byte 할당 가능
    val h: Double = 2.2 // 8byte 할당 가능
    println(g) 
    println(h)

    // char, 16비트 Unicode 문자
    val i: Char = 'A'
    println(i)

    // String, UTF-16 문자열
    val j: String = "Hello, World!"
    println(j)

    // Any, 모든 타입의 부모
    val k: Any = 10
    println(k)

    // Array, 여러 개의 같은 타입의 값을 저장
    val l: Array<Int> = arrayOf(1, 2, 3)
    println(l)

    // List, Array와 비��하지만, 변경할 수 없음
    val m: List<Int> = listOf(4, 5, 6)
    println(m)
}


/*
val : 읽기 전용(Immutable, 변경 불가) 변수
var : 읽기 및 쓰기(Read/Write) 가능 변수

숫자 타입:
Int : 4 Byte (32bit, 정수)
Byte : 1 Byte (8bit, 정수)
Short : 2 Byte (16bit, 정수)
Long : 8 Byte (64bit, 정수)
Float : 4 Byte (32bit, 부동소수점)
Double : 8 Byte (64bit, 부동소수점)

문자와 문자열:
Char : 2 Byte (16bit, 유니코드 문자)
Boolean : true 또는 false
String : UTF-16 인코딩된 문자열

기타:
Any : 모든 타입의 최상위 클래스 (Java의 Object와 유사)
Unit : 반환 값이 없는 함수의 반환 타입 (Java의 void와 유사)
Nothing : 정상적으로 값을 반환하지 않는 함수의 반환 타입
Nullable 타입 : 변수에 `null`을 허용하려면 타입 뒤에 `?`를 붙임 (예: `String?`)
 */
