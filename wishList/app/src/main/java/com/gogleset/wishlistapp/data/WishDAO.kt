package com.gogleset.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// 추상 클래스는 구현이 필요하지 않은 메소드를 포함한 클래스
@Dao
abstract class WishDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAWish(wishEntity: Wish)

    //    모든 테이블에 있는 항목을 가져옴
    @Query("Select * from `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update()
    abstract suspend fun updateAWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)

    //    모든 테이블에 있는 ID를 검색해서  가져옴
    @Query("Select * from `wish-table` where id=:id")
    abstract fun getAWishByID(id: Long): Flow<Wish>

}