package com.example.mydaggerhiltapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyeservices.model.HeaderListModel
import com.example.alkyeservices.interfaces.RecyclerViewItemListener
import com.example.alkyeservices.viewholder.HeaderListViewHolder
import com.example.alkyeservices.viewholder.RecentArticlesViewHolder
import com.example.daggerhiltdemoapp.databinding.HeaderItemBinding
import com.example.daggerhiltdemoapp.databinding.ItemRecentArticlesBinding

class RecentArticlesAdapter(
    private var headerList: ArrayList<HeaderListModel>,
    private val listener: RecyclerViewItemListener
) :
    RecyclerView.Adapter<RecentArticlesViewHolder>() {
    private lateinit var binding: ItemRecentArticlesBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentArticlesViewHolder {
        binding = ItemRecentArticlesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return RecentArticlesViewHolder(binding.root, listener)
    }

    override fun onBindViewHolder(holder: RecentArticlesViewHolder, position: Int) {
        holder.onBind(headerList.get(position),binding, position)
    }

    override fun getItemCount(): Int = headerList.size

}
