package com.gogleset.meals

//type Shape =
//| { type: "Circle"; radius: number }
//| { type: "Rectangle"; width: number; height: number }
//| { type: "Triangle" }; // 싱글톤처럼 추가 속성이 없음

// 뭐 대충 타입스크립트에서 이런방식으로 쓰는걸 코틀린에선 이렇게씀
sealed class Screen(val route: String) {
    data object RecipeScreen : Screen("recipescreen")
    data object DetailScreen : Screen("detailscreen")
}