package com.example.alkyeservices.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyeservices.enums.ItemClickType
import com.example.alkyeservices.interfaces.RecyclerViewItemListener
import com.example.alkyeservices.model.HeaderListModel
import com.example.daggerhiltdemoapp.databinding.ItemRecentArticlesBinding

class RecentArticlesViewHolder(itemView: View, private val listener: RecyclerViewItemListener) :
    RecyclerView.ViewHolder(itemView) {
    private var TAG = RecentArticlesViewHolder::class.java.simpleName

    fun onBind(headerModel: HeaderListModel, binding: ItemRecentArticlesBinding, position: Int) {

        binding.tvName.text = headerModel.title

        binding.headerRoot.setOnClickListener {
            clickedOnDetail(headerModel)

        }
    }

    /**
     * It is called when user click on detail
     */
    private fun clickedOnDetail(headerModel: HeaderListModel) {
        itemView.apply {
            listener.onRecyclerViewItemClick(
                itemClickType = ItemClickType.DETAIL,
                model = headerModel,
                position = layoutPosition,
                view = itemView
            )

        }
    }
}