package com.gogleset.kotlinbasics

fun main() {

//   불변하는 List
    val shoppingList = listOf("Processor", "RAM", "Graphics Card", "SSD")
//   수정가능한 List
    val mutableShoppingList =
        mutableListOf<String>("Processor", "RAM", "Graphics Card", "SSD", "Graphics card2")

    // mutable list items
    mutableShoppingList.add("Cooling System")
    mutableShoppingList.remove("Graphics card2")
    mutableShoppingList.removeAt(1)
    println(mutableShoppingList)
    mutableShoppingList.add("POWER")
    mutableShoppingList.add(1, "NEW RAM")
    println(mutableShoppingList[1])
    mutableShoppingList[1] = "진짜 램"
//    mutableShoppingList.set(3, "진짜진짜램")
    println(mutableShoppingList)


    // Ram이라는 요소가 있는지 확인
    if (shoppingList.contains("RAM")) {
        println("Has Ram In The List")
    } else {
        println("No Ram In The List")
    }

    println("item in Shopping list")
//    for (item in shoppingList) {
//        println(item)
//        if (item == "RAM") {
//            break;
//        }
//    }
    println(shoppingList.size)
//    인덱스를 추출할 수 있는 방법 중 하나 (js for 루프랑 비슷하다)
    for (index in 0 until shoppingList.size) { // until도 되지만, ..도 가능하다
        println("item ${shoppingList[index]}, index :: $index")
    }
}