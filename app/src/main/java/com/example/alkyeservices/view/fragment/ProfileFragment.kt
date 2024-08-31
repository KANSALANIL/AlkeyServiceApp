package com.example.alkyeservices.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daggerhiltdemoapp.databinding.FragmentProfileBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val navHostFragment = childFragmentManager.findFragmentById(R.id.navHostFrameLayout) as NavHostFragment
//        val navController = navHostFragment.navController
//        binding?.bottomNavigation!!.setupWithNavController(navController)
//        binding.bottomNavigation.setupWithNavController(
//            findNavController(R.id.navHostFrameLayout)
//        )

/*        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }*/
    }

}