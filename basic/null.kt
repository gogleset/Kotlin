// null - safety
// kotlin에선 기본적으로 null을 할당 할 수 없음

fun main(args: Array<String>){
    var a : String? = null // nullable value
    println(a); // nullsafe call

    // var b : String = "안녕하세요"
    // b = null // error: Null can't be a value of a non-null type String
    // println(b); 

    var c: String? = "asd"
    println(c?.length) 
    println(c!!.length) // !! 의 의미는 무조건 이 값이 있다. non-null
    c = null;
    println(c?.length) 
    println(c?.length ?: "이 값은 null 입니다") // ?: 의 의미는 전 값이 null이면 후 값을 실행
}

// ? 이 값은 null 일 수도 있다.
// ?: 이 값이 null 일 떄 후방 실행
// !! 이 값은 무조건 null이 아니다.