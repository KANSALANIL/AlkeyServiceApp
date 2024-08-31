package com.example.alkyeservices.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyeservices.enums.ItemClickType
import com.example.alkyeservices.interfaces.RecyclerViewItemListener
import com.example.alkyeservices.model.HeaderListModel
import com.example.daggerhiltdemoapp.R
import com.example.daggerhiltdemoapp.databinding.ItemSocialConnectBinding


class SocialConnectViewHolder(itemView: View, private val listener: RecyclerViewItemListener) :
    RecyclerView.ViewHolder(itemView) {
    private var TAG = SocialConnectViewHolder::class.java.simpleName

    fun onBind(headerModel: HeaderListModel, binding: ItemSocialConnectBinding, position: Int) {

       // binding..text = headerModel.title
        binding.tvTitle.text  = itemView.context.getString(R.string.item_description)

        binding.socialRoot.setOnClickListener {
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