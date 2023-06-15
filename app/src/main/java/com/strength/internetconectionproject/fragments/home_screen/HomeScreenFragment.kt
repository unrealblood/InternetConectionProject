package com.strength.internetconectionproject.fragments.home_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.strength.internetconectionproject.PhotoGridAdapter
import com.strength.internetconectionproject.R
import com.strength.internetconectionproject.databinding.FragmentHomeScreenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home_screen, container, false)

        val binding : FragmentHomeScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_screen, container, false)

        //val binding = GridViewItemBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

        val homeScreenViewModelFactory = HomeScreenViewModelFactory(application)

        val homeScreenViewModel = ViewModelProvider(this, homeScreenViewModelFactory)[HomeScreenViewModel::class.java]

        binding.homeScreenViewModel = homeScreenViewModel

        binding.lifecycleOwner = this

        binding.recyclerView.adapter = PhotoGridAdapter()

        return binding.root
    }
}