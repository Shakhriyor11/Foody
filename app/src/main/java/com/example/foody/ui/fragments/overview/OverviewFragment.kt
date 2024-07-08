package com.example.foody.ui.fragments.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import coil.load
import com.example.foody.R
import com.example.foody.databinding.FragmentOverviewBinding
import com.example.foody.models.Result
import com.example.foody.util.Constants.Companion.RECIPE_RESULT_KEY
import dagger.hilt.android.AndroidEntryPoint
import org.jsoup.Jsoup

@AndroidEntryPoint
class OverviewFragment : Fragment() {

    private lateinit var binding: FragmentOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOverviewBinding.inflate(inflater, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        binding.ivMain.load(myBundle?.image)
        binding.tvTitle.text = myBundle?.title
        binding.tvLikes.text = myBundle?.aggregateLikes.toString()
        binding.tvTime.text = myBundle?.readyInMinutes.toString()
        binding.tvSummary.text = myBundle?.summary
        myBundle?.summary.let {
            if (it != null) {
                val summary = Jsoup.parse(it).text()
                binding.tvSummary.text = summary
            }
        }

        if (myBundle?.vegetarian == true) {
            binding.ivVegetarianCheckmark.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            binding.tvVegetarianCheckmark.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }

        if (myBundle?.vegan == true) {
            binding.ivVeganCheckmark.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            binding.tvVeganCheckmark.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }

        if (myBundle?.dairyFree == true) {
            binding.ivDairyFreeCheckmark.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            binding.tvDairyFreeCheckmark.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }

        if (myBundle?.glutenFree == true) {
            binding.ivGlutenFreeCheckmark.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            binding.tvGlutenFreeCheckmark.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }

        if (myBundle?.veryHealthy == true) {
            binding.ivHealthyCheckmark.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            binding.tvHealthyCheckmark.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }

        if (myBundle?.cheap == true) {
            binding.ivCheapCheckmark.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            binding.tvCheapCheckmark.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }

        return binding.root
    }
}