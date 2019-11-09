package com.example.dotaapitest.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.dotaapitest.databinding.FragmentDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application

        val binding = FragmentDetailBinding.inflate(inflater)

        binding.lifecycleOwner = this

        val marsProperty = DetailFragmentArgs.fromBundle(arguments!!).selectedProperty

        val viewModelFactory = DetailViewModelFactory(marsProperty, application)

        binding.viewModel = ViewModelProviders.of(
            this, viewModelFactory).get(DetailViewModel::class.java)

        return binding.root
    }


}
