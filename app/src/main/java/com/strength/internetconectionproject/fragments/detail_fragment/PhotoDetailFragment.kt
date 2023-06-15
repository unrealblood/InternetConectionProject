package com.strength.internetconectionproject.fragments.detail_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.strength.internetconectionproject.R
import com.strength.internetconectionproject.databinding.FragmentPhotoDetailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [PhotoDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PhotoDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_photo_detail, container, false)

        val binding : FragmentPhotoDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo_detail, container, false)

        val application = requireNotNull(this.activity).application

        val photoDetailViewModelFactory = PhotoDetailViewModelFactory(application)

        val photoDetailViewModel = ViewModelProvider(this, photoDetailViewModelFactory).get(
            PhotoDetailViewModel::class.java)

        binding.photoDetailViewModel = photoDetailViewModel

        binding.lifecycleOwner = this

        return binding.root
    }
}