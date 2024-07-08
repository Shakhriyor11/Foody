package com.example.foody.ui.adapters.bindingAdapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.foody.data.local.entities.RecipesEntity
import com.example.foody.models.FoodRecipeModel
import com.example.foody.util.NetworkResult

class RecipesBinding {

    companion object {

        @BindingAdapter("readApiResponse", "readDatabase", requireAll = true)
        @JvmStatic
        fun errorImageVisibility(
            imgView: ImageView,
            apiResponse: NetworkResult<FoodRecipeModel>?,
            database: List<RecipesEntity>?
        ) {
            if (apiResponse is NetworkResult.Error && database.isNullOrEmpty()) {
                imgView.visibility = View.VISIBLE
            } else if (apiResponse is NetworkResult.Loading) {
                imgView.visibility = View.GONE
            } else if (apiResponse is NetworkResult.Success) {
                imgView.visibility = View.GONE
            }
        }

        @BindingAdapter("readApiResponse2", "readDatabase2", requireAll = true)
        @JvmStatic
        fun errorMessageVisibility(
            txtView: TextView,
            apiResponse: NetworkResult<FoodRecipeModel>?,
            database: List<RecipesEntity>?
        ) {
            if (apiResponse is NetworkResult.Error && database.isNullOrEmpty()) {
                txtView.visibility = View.VISIBLE
                txtView.text = apiResponse.message.toString()
            } else if (apiResponse is NetworkResult.Loading) {
                txtView.visibility = View.GONE
            } else if (apiResponse is NetworkResult.Success) {
                txtView.visibility = View.GONE
            }
        }

    }

}