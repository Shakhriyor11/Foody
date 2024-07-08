package com.example.foody.ui.adapters.bindingAdapters

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.data.local.entities.FavoritesEntity
import com.example.foody.ui.adapters.FavoriteRecipesAdapter

class FavoriteRecipesBinding {

    companion object {

        @BindingAdapter("setVisibility", "setData", requireAll = false)
        @JvmStatic
        fun setVisibility(
            view: View,
            favEntity: List<FavoritesEntity>?,
            adapter: FavoriteRecipesAdapter?
        ) {
            when(view) {
                is  RecyclerView -> {
                    val checkData = favEntity.isNullOrEmpty()
                    view.isGone = checkData
                    if (!checkData) {
                        favEntity?.let { adapter?.setData(it) }
                    }
                }
                else -> view.isVisible = favEntity.isNullOrEmpty()
            }
        }
    }
}