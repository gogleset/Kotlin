fun main(args: Array<String>){
    // 메인함수(프로그램 시작지점)
    // 변수(String, Int, Boolean, long, Double, Float)
    // val, var
    val a : String = "abc"
    // a = "asd"
    var b : String = "asd"
    b = "asdd"
    val c : Int = sum(1,2)
    val d : Int = sum(b = 1, a = 2)
    println(c)
    println(d)
}

// 함수
fun sum(a: Int, b: Int): Int {
    printsArg(a, b);
    return a + b
}
fun printsArg(a: Int, b: Int): Unit { // void같은 unit
    println(a)
    println(b)
}


