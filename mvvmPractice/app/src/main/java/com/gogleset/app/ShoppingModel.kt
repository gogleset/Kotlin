package com.gogleset.app

data class Item(
    var id: Int,
    var name: String,
    var quantity: Int,
)

class ShoppingRepository {
    private val _shoppingItem = mutableListOf<Item>()

    fun getShoppingItem() = _shoppingItem

    fun addShoppingItem(item: Item) {
        _shoppingItem.add(item)
    }

    fun modifyShoppingItem(item: Item) {
        _shoppingItem.map {
            if(it.id == item.id) item else it
        }.toMutableList()
    }

    fun deleteShoppingItem(item:Item){
        _shoppingItem.removeIf { it.id == item.id }
    }
}