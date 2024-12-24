// read only 지역 변수 val
fun main(args: Array<String>) {
    // val : 변수에 값을 할당하게 되면 다시 재 할당을 시킬 수 없다
    val a: Int = 1 // 즉시 할당
    val b = 2 // 타입 추론
    val c: Int // 타입 할당 및 Int 값 예약
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
    val l: Array<Int> = [1, 2, 3];
    println(l)

    // List, Array와 비��하지만, 변경할 수 없음
    val m: List<Int> = listOf(4, 5, 6)
    println(m)
}

