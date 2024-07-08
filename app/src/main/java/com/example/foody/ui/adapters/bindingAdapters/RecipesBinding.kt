package com.example.foody.ui.adapters.bindingAdapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.example.foody.data.local.entities.RecipesEntity
import com.example.foody.models.FoodRecipeModel
import com.example.foody.util.NetworkResult
import okhttp3.Response

class RecipesBinding {

    companion object {

        @BindingAdapter("readApiResponse", "readDatabase", requireAll = true)
        @JvmStatic
        fun handleReadDataErrors(
            view: View,
            apiResponse: NetworkResult<FoodRecipeModel>?,
            database: List<RecipesEntity>?
        ) {
            when(view) {
                is ImageView -> {
                    view.isVisible =
                        apiResponse is NetworkResult.Error && database.isNullOrEmpty()
                }

                is TextView -> {
                    view.isVisible =
                        apiResponse is NetworkResult.Error && database.isNullOrEmpty()
                        view.text = apiResponse?.message.toString()
                }
            }
        }

    }

}