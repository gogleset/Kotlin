fun main(args: Array<String>){
    //for loop
    val array = arrayOf("hello", "world", "my","kotlin","first")
    // index 조회
    println(array[1])
    println("ㅡㅡㅡ")
    // array 전체 loop
    for(item in array){
        println(item)
    }
    println("ㅡㅡㅡ")
    // 범위 
    for(item in 1..5){
        println(item)
    }
    println("ㅡㅡㅡ")
    // 범위, 증가값
    for(item in 1..10 step 2){
        println(item)
    }
    println("ㅡㅡㅡ")
    // 역순 범위
    for(item in 10 downTo 1){
        println(item)
    }
    // index, 값 모두에 접근
    for((index, value) in array.withIndex()){
        if(index == 2){
            println(index)
        }
        println(value)
    }
    println("Hello world!")
    
    
}