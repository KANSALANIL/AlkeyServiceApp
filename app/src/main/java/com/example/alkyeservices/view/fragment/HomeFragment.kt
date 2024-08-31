package com.example.alkyeservices.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.alkyeservices.enums.ItemClickType
import com.example.alkyeservices.interfaces.RecyclerViewItemListener
import com.example.alkyeservices.model.DataProvider
import com.example.alkyeservices.model.HeaderListModel
import com.example.daggerhiltdemoapp.R
import com.example.daggerhiltdemoapp.databinding.FragmentHomeBinding
import com.example.mydaggerhiltapplication.Adapter.HeaderListAdapter
import com.example.mydaggerhiltapplication.Adapter.RecentArticlesAdapter
import com.example.mydaggerhiltapplication.Adapter.SocialConnectAdapter

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class HomeFragment : Fragment(), RecyclerViewItemListener {

    private lateinit var binding: FragmentHomeBinding
    private var headerListAdapter: HeaderListAdapter? = null
    private var recentArticlesAdapter: RecentArticlesAdapter? = null
    private var socialConnectAdapter: SocialConnectAdapter? = null
    private var headerList = ArrayList<HeaderListModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
        /*        binding.buttonSecond.setOnClickListener {
                    findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
                }*/
    }

    private fun setUpAdapter() {
        headerList.clear()
        headerList = DataProvider.getData();
        setheaderListAdapterr()
        setRecentArticlesAdapter()
        setSocialConnectAdapter()
    }

    private fun setSocialConnectAdapter() {
        socialConnectAdapter = SocialConnectAdapter(headerList, this)

        binding.rvSocialConnect.apply {
            itemAnimator = DefaultItemAnimator()
            adapter = socialConnectAdapter
        }
    }

    private fun setRecentArticlesAdapter() {
        recentArticlesAdapter = RecentArticlesAdapter(headerList, this)

        binding.rvRecentArticles.apply {
            itemAnimator = DefaultItemAnimator()
            adapter = recentArticlesAdapter
        }
    }

    /**
     * Here set header list adapter
     */
    private fun setheaderListAdapterr() {
        headerListAdapter = HeaderListAdapter(headerList, this)

        binding.rvHeader.apply {
            itemAnimator = DefaultItemAnimator()
            adapter = headerListAdapter
        }


    }

    override fun onRecyclerViewItemClick(
        itemClickType: ItemClickType,
        model: Any?,
        position: Int,
        view: View
    ) {

        findNavController().navigate(R.id.action_main_home_fragment_to_articleDetailFragment)

    }

}