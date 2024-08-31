package com.example.alkyeservices.view

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
import com.example.daggerhiltdemoapp.databinding.FragmentArticleDetailBinding
import com.example.mydaggerhiltapplication.Adapter.HeaderListAdapter
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener


class ArticleDetailFragment : Fragment(), RecyclerViewItemListener {

    private lateinit var binding: FragmentArticleDetailBinding
    private var adapter: HeaderListAdapter? = null
    private var headerList = ArrayList<HeaderListModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentArticleDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
        clickOnBack()
        binding.appBarLayout.addOnOffsetChangedListener(OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (Math.abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
                //  Collapsed

                binding.toolBar.visibility = View.VISIBLE
                binding.clIntroHearder.visibility = View.VISIBLE
                binding.viewDividerHearder.visibility = View.VISIBLE

                binding.clIntro.visibility = View.GONE
                binding.viewDivider.visibility = View.GONE

            } else {
                //Expanded

                binding.clIntroHearder.visibility = View.GONE
                binding.viewDividerHearder.visibility = View.GONE
                binding.toolBar.visibility = View.GONE

                binding.clIntro.visibility = View.VISIBLE
                binding.viewDivider.visibility = View.VISIBLE
            }
        })

    }

    private fun setUpAdapter() {
        headerList.clear()

        headerList = DataProvider.getData()

        adapter = HeaderListAdapter(headerList, this)

        binding.rvRelatedArticles.apply {
            itemAnimator = DefaultItemAnimator()
            adapter = adapter
        }

        binding.rvRelatedArticles.adapter = adapter
    }

    /**
     * here add click on back button
     */
    private fun clickOnBack() {
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onRecyclerViewItemClick(
        itemClickType: ItemClickType,
        model: Any?,
        position: Int,
        view: View
    ) {

        /*   findNavController().navigate(R.id.action_articleDetailFragment_self)

           lifecycleScope.launch {
               delay(100)
               findNavController().popBackStack()
           }*/


    }
}