package com.example.alkyeservices.viewholder

import android.content.Context
import android.view.View
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyeservices.model.HeaderListModel
import com.example.alkyeservices.enums.ItemClickType
import com.example.alkyeservices.interfaces.RecyclerViewItemListener
import com.example.daggerhiltdemoapp.R
import com.example.daggerhiltdemoapp.databinding.HeaderItemBinding

class HeaderListViewHolder(itemView: View, private val listener: RecyclerViewItemListener): RecyclerView.ViewHolder(itemView) {
    private var TAG = HeaderListViewHolder::class.java.simpleName

    fun onBind(headerModel: HeaderListModel, binding: HeaderItemBinding, position:Int){

       // binding.ivProduct.setImageURI(headerModel.image.toUri())
        binding.tvName.text = itemView.context.getString(R.string.technology)
        binding.headerRoot.setOnClickListener {
            clickedOnDetail(headerModel)

        }
    }

    /**
     * It is called when user click on detail
     */
    private fun clickedOnDetail(headerModel : HeaderListModel) {
        itemView.apply {
            listener.onRecyclerViewItemClick(
                itemClickType = ItemClickType.DETAIL,
                model = headerModel!!,
                position = layoutPosition,
                view = itemView
            )

        }
    }
}

