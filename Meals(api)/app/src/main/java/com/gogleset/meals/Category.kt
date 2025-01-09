package com.gogleset.meals

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class CategoryResponse(
    val categories: List<Category>,
)

//데이터 직렬화/역직렬화를 자동으로 처리(안드로이드에서 화면 간 데이터 전달)
@Parcelize
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String,
) : Parcelable
