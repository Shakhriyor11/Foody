package com.example.foody.ui.adapters.bindingAdapters

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.foody.data.local.entities.FoodJokeEntity
import com.example.foody.models.FoodJoke
import com.example.foody.util.NetworkResult
import com.google.android.material.card.MaterialCardView

class FoodJokeBinding {
    companion object {

        @BindingAdapter("readApiResponse3", "readDatabase3", requireAll = false)
        @JvmStatic
        fun setCardAndProgressVisibility(
            view: View,
            apiResponse: NetworkResult<FoodJoke>?,
            database: List<FoodJokeEntity>?
        ) {
            when (apiResponse) {
                is NetworkResult.Loading -> {
                    when (view) {
                        is MaterialCardView -> {
                            view.visibility = View.GONE
                        }

                        is ProgressBar -> {
                            view.visibility = View.VISIBLE
                        }
                    }
                }

                is NetworkResult.Error -> {
                    when (view) {
                        is MaterialCardView -> {
                            view.visibility = View.VISIBLE
                            if (database != null) {
                                if (database.isEmpty()) {
                                    view.visibility = View.GONE
                                }
                            }
                        }

                        is ProgressBar -> {
                            view.visibility = View.GONE
                        }
                    }
                }

                is NetworkResult.Success -> {
                    when (view) {
                        is MaterialCardView -> {
                            view.visibility = View.VISIBLE
                        }

                        is ProgressBar -> {
                            view.visibility = View.GONE
                        }
                    }
                }

                else -> {}
            }
        }

        @BindingAdapter("readApiResponse4", "readDatabase4", requireAll = true)
        @JvmStatic
        fun setErrorViewVisibility(
            view: View,
            apiResponse: NetworkResult<FoodJoke>?,
            database: List<FoodJokeEntity>?
        ) {
            if (database != null) {
                if (database.isEmpty()) {
                    view.visibility = View.VISIBLE
                    if (view is TextView) {
                        if (apiResponse != null) {
                            view.text = apiResponse.message.toString()
                        }
                    }
                }
            }
            if (apiResponse is NetworkResult.Success) {
                view.visibility = View.GONE
            }
        }
    }
}