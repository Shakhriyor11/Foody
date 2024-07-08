package com.example.foody.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foody.models.FoodRecipeModel
import com.example.foody.util.Constants.Companion.DATA_BASE_TABLE

@Entity(tableName = DATA_BASE_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipeModel
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}