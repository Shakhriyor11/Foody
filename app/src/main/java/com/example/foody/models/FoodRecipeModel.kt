package com.example.foody.models


import com.google.gson.annotations.SerializedName

data class FoodRecipeModel(
    @SerializedName("results")
    val results: List<Result>
)