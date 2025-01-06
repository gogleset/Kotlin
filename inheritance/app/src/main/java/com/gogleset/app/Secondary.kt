package com.gogleset.app

// 다른 클래스 상속(파생 클래스)
open class Secondary: BaseClass(){
    override fun role() {
//      부모에서 정의한 내용을 실행하라는 의미
        super.role()
        println("Knight of the House of BaseClass")
    }
}