package com.example.foody.util

class Constants {

    companion object {
        val API_KEY = "5aed2d2072d3436bbf92f1b3c4264ab9"
        val BASE_URL = "https://api.spoonacular.com/"
        val BASE_IMAGE_URL = "https://spoonacular.com/cdn/ingredients_100x100/"

        val RECIPE_RESULT_KEY = "recipeBundle"

        //        Query Constants
        const val QUERY_NUMBER = "number"
        const val QUERY_API_KEY = "apiKey"
        const val QUERY_TYPE = "type"
        const val QUERY_DIET = "diet"
        const val QUERY_ADD_RECIPE_INFORMATION = "addRecipeInformation"
        const val QUERY_FILL_INGREDIENTS = "fillIngredients"
        const val QUERY_SEARCH = "query"

        //        Room Data Base Constants
        const val DATA_BASE_NAME = "recipes_database"
        const val DATA_BASE_TABLE = "recipes_table"
        const val FAVORITE_RECIPES_TABLE = "favorite_recipes_table"
        const val FOOD_JOKE_TABLE = "food_joke_table"

        //        Bottom Sheet and Preferences
        const val DEFAULT_RECIPES_NUMBER = "50"
        const val DEFAULT_MEAL_TYPE = "main course"
        const val DEFAULT_DIET_TYPE = "gluten free"
        const val PREFERENCES_MEAL_TYPE = "mealType"
        const val PREFERENCES_MEAL_TYPE_ID = "mealTypeId"
        const val PREFERENCES_DIET_TYPE = "dietType"
        const val PREFERENCES_DIET_TYPE_ID = "dietTypeId"
        const val PREFERENCES_DATA_STORE_NAME = "recipePreferences"
        const val PREFERENCES_BACK_ONLINE = "backOnline"
    }
}