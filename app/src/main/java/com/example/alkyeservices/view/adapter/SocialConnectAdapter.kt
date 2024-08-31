package com.example.mydaggerhiltapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyeservices.model.HeaderListModel
import com.example.alkyeservices.interfaces.RecyclerViewItemListener
import com.example.alkyeservices.viewholder.HeaderListViewHolder
import com.example.alkyeservices.viewholder.RecentArticlesViewHolder
import com.example.alkyeservices.viewholder.SocialConnectViewHolder
import com.example.daggerhiltdemoapp.databinding.HeaderItemBinding
import com.example.daggerhiltdemoapp.databinding.ItemRecentArticlesBinding
import com.example.daggerhiltdemoapp.databinding.ItemSocialConnectBinding

class SocialConnectAdapter(
    private var headerList: ArrayList<HeaderListModel>,
    private val listener: RecyclerViewItemListener
) :
    RecyclerView.Adapter<SocialConnectViewHolder>() {
    private lateinit var binding: ItemSocialConnectBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SocialConnectViewHolder {
        binding = ItemSocialConnectBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return SocialConnectViewHolder(binding.root, listener)
    }

    override fun onBindViewHolder(holder: SocialConnectViewHolder, position: Int) {
        holder.onBind(headerList.get(position),binding, position)
    }

    override fun getItemCount(): Int = headerList.size

}
