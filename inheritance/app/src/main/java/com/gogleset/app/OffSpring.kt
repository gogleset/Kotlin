package com.gogleset.app

class OffSpring: Secondary(), Archery, Singer {

    override fun archery() {
        super.archery()
        println("Archery skills enhanced by Offspring")
    }

    override fun sing() {
        super.sing()
        println("Singing skills enhanced by Offspring")
    }

}