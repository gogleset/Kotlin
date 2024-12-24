// 제어문
fun main(args: Array<String>) {
    var a = 5
    verify10Or8(a)
    verifyBetween10And8(a)
    var c = if (a == 10) {
        // 마지막으로 작성한 코드의 데이터 값이 return
        a + 5
    }else {
        a + 20
    }
    println("c의 값은 $c")
    println("main 함수 실행")
}

fun verify10Or8(num: Int): Boolean {
    if (num == 10 || num == 8) {
        println("a는 8 혹은 10이야")
        return true
    } else {
        println("a는 8도 10도 아니야")
        return false
    }
}

fun verifyBetween10And8(num: Int):Boolean {
    if (num <= 10 && num >= 8) {
        println("a는 8과 10 사이에 있어")
        return true
    } else {
        println("a는 8도 10도 사이에 있지 않아")
        return false
    }
}