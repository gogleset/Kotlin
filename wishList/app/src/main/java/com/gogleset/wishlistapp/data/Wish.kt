package com.gogleset.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// room  database 만들기
@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
//    열의 이름을 지정
    @ColumnInfo("wish-title")
    val title: String = "",
    @ColumnInfo("wish-desc")
    val description: String = ""
)

object DummyWish {
    val wishList = listOf(
        Wish(title = "Google Watch 1", description = "An android"),
        Wish(title = "Google Watch 2", description = "An android"),
        Wish(title = "Google Watch 3", description = "An android"),
        Wish(title = "Google Watch 4", description = "An android"),
        Wish(title = "Google Watch 5", description = "An android"),
    )
}