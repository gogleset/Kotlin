package com.gogleset.bankapp



class BankAccount(private var accountHolder: String, private var balance: Double) {
//  거래 내역 리스트 클래스 내에서만 접근 가능
    private val transactionHistory = mutableListOf<String>() // 제네릭으로 초기화하면 먼저 값을 안 넣어줘도 된다.
//  입금
    fun deposit(amount: Double){
        balance += amount
        transactionHistory.add("$accountHolder deposited $amount")
    }
//  출금
    fun withdraw(amount: Double){
        if (amount <= balance){
            balance -= amount
            transactionHistory.add("$accountHolder withdraw $amount")
        } else {
            println("출금할 수 없습니다.")
        }

    }
//  거래 내역 표시
    fun displayTransactionHistory(){
        println("$accountHolder 의 전체 거래 내역입니다.")
        for(transaction in transactionHistory){
            println(transaction)
        }
    }
//    계좌 잔액 내역 표시
    fun acctBalance():Double{
        return balance;
    }
//   이름 내역 표시
    fun acctAccountHolder():String{
        return accountHolder;
    }
}