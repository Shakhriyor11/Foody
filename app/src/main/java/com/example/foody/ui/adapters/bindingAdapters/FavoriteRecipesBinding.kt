package com.example.foody.ui.adapters.bindingAdapters

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.data.local.entities.FavoritesEntity
import com.example.foody.ui.adapters.FavoriteRecipesAdapter

class FavoriteRecipesBinding {

    companion object {

        @BindingAdapter("viewVisibility", "setData", requireAll = false)
        @JvmStatic
        fun setDataAndViewVisibility(
            view: View,
            favEntity: List<FavoritesEntity>?,
            adapter: FavoriteRecipesAdapter?
        ) {
            if (favEntity.isNullOrEmpty()) {
                when(view) {
                    is ConstraintLayout -> {
                        view.visibility = View.VISIBLE
                    }
                    is RecyclerView -> {
                        view.visibility = View.GONE
                    }
                }
            } else {
                when(view) {
                    is ConstraintLayout -> {
                        view.visibility = View.GONE
                    }
                    is RecyclerView -> {
                        view.visibility = View.VISIBLE
                        adapter?.setData(favEntity)
                    }
                }
            }
        }
    }
}