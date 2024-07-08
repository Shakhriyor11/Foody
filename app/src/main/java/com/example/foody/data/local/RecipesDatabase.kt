package com.example.foody.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foody.data.local.entities.FavoritesEntity
import com.example.foody.data.local.entities.FoodJokeEntity
import com.example.foody.data.local.entities.RecipesEntity
import com.example.foody.data.local.type_converters.RecipesTypeConverter

@Database(
    entities = [RecipesEntity::class, FavoritesEntity::class, FoodJokeEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(RecipesTypeConverter::class)
 abstract class RecipesDatabase : RoomDatabase() {

     abstract fun recipesDao(): RecipesDao

}