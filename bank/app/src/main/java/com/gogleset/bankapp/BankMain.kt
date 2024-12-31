package com.gogleset.bankapp

fun main(){
    val denisBankAccount = BankAccount("Denis", 1338.20 )
    denisBankAccount.deposit(120.0)
    denisBankAccount.withdraw(1550.50)
    println(denisBankAccount.displayTransactionHistory())
    println(denisBankAccount.acctBalance())
    println(denisBankAccount.acctAccountHolder())


    val sarahAccount = BankAccount("Sarah", 0.0)
    sarahAccount.deposit(100.0)
    sarahAccount.withdraw(10.0)
    sarahAccount.deposit(300.0)

    println(sarahAccount.acctBalance())
}