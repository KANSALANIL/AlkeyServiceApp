package com.example.mydaggerhiltapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyeservices.model.HeaderListModel
import com.example.alkyeservices.interfaces.RecyclerViewItemListener
import com.example.alkyeservices.viewholder.HeaderListViewHolder
import com.example.daggerhiltdemoapp.databinding.HeaderItemBinding

class HeaderListAdapter(
    private var headerList: ArrayList<HeaderListModel>,
    private val listener: RecyclerViewItemListener
) :
    RecyclerView.Adapter<HeaderListViewHolder>() {
    private lateinit var binding: HeaderItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderListViewHolder {
        binding = HeaderItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HeaderListViewHolder(binding.root, listener)
    }

    override fun onBindViewHolder(holder: HeaderListViewHolder, position: Int) {
        holder.onBind(headerList.get(position),binding, position)
    }

    override fun getItemCount(): Int = headerList.size

}
