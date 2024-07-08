package com.example.foody.data.remote

import com.example.foody.models.FoodJoke
import com.example.foody.models.FoodRecipeModel
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
) {

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipeModel> {
        return foodRecipesApi.getRecipes(queries)
    }

    suspend fun searchRecipes(searchQuery: Map<String, String>): Response<FoodRecipeModel> {
        return foodRecipesApi.searchRecipes(searchQuery)
    }

    suspend fun getFoodJoke(apiKey: String) : Response<FoodJoke> {
        return foodRecipesApi.getFoodJoke(apiKey)
    }

}