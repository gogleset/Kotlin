package com.gogleset.app

// 다른 클래스 상속
open class BaseClass{
//    open 키워드는 override를 하게 한다.
    open fun role(){
        println("Member of the House")
    }

    fun coreValue (){
        println("Core values")
    }
}