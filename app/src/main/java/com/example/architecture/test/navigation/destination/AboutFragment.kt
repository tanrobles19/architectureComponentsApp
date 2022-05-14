package com.example.architecture.test.navigation.destination

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.architecture.test.databinding.AboutLayoutBinding

class AboutFragment: Fragment() {

    private lateinit var _binding: AboutLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = AboutLayoutBinding.inflate(inflater, container, false)
        return _binding.root
    }

}