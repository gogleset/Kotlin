package com.gogleset.app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel




class ShoppingViewModel: ViewModel(){
    private val _shoppingRepository = ShoppingRepository()
    var shoppingItem: MutableList<Item> = _shoppingRepository.getShoppingItem()

    fun addShoppingItem(item: Item){
        _shoppingRepository.addShoppingItem(item)
        shoppingItem = _shoppingRepository.getShoppingItem()
    }

    fun deleteShoppingItem(item: Item){
        _shoppingRepository.deleteShoppingItem(item)
        shoppingItem = _shoppingRepository.getShoppingItem()
    }

    fun modifyShoppingItem(item: Item){
        _shoppingRepository.modifyShoppingItem(item)
        shoppingItem = _shoppingRepository.getShoppingItem()
    }
}