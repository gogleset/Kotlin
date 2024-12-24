fun main(args: Array<String>) {
    var person1 = Person(age = 20, gender = Gender.FEMALE)
    person1.name =  "Alice2"
    println(person1.gender)
    person1.sayHello()
    person1.sayBye()

    val person2 = Person(gender = Gender.MALE)
    person2.sayHello()
    person2.sayBye()

    val person3 = Person("Charlie", 40, Gender.FEMALE)
    person3.sayHello()
    person3.sayBye()

    var person4 = Person2("Charlies", 19, Gender.FEMALE, "취미는 없습니다");
    var person5 = Person3("Charliesqa", 21, Gender.FEMALE, "취미는 없습니다");
    // null - safety
    
}

enum class Gender {
    MALE,
    FEMALE
}


// 설계도
class Person(var name: String? = null,var age: Int = 0, var gender: Gender = Gender.MALE){
    fun sayHello(){
        println("Hello, $name!")
    }
    fun sayBye(){
        println("Bye, $name!")
    }
    
}

class Person2(var name: String, var age: Int, var gender: Gender){ // 주 생성자
    // init 함수는 제일 먼저 호출되는 블럭
    init {
        println("$name $age $gender 초기화 완료")
    }
    // 보조생성자, 주 생성자의 값들을 상속
    constructor(name: String, age: Int, gender: Gender, hobby: String) : this(name, age, gender){
        println("보조 생성자입니다.")
        println("$hobby")
    }
    fun sayHello(){
        println("Hello, $name!")
    }
    fun sayBye(){
        println("Bye, $name!")
    }
    
}

// 보조 생성자로 프로퍼티 생성
class Person3 {
    // init 함수는 제일 먼저 호출되는 블럭
    // init {
    //     println("$name $age $gender 초기화 완료")
    // }

    // 보조생성자1
    constructor(name: String, age: Int, gender: Gender){
        println("보조 생성자입니다.1")
        println("$name $age $gender 초기화 완료")
    }
    constructor(name: String, age: Int, gender: Gender, hobby: String) : this(name, age, gender){
        println("보조 생성자입니다.2")
        println("$hobby")
        println("$name $age $gender $hobby 초기화 완료")
    }
    fun sayHello(name:String){
        println("Hello, $name!")
    }
    fun sayBye(name: String){
        println("Bye, $name!")
    }
    
}