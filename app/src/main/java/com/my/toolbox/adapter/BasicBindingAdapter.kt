package com.my.toolbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.my.toolbox.R
import com.my.toolbox.databinding.ItemBasicAdapterBinding
import java.util.*

class FaqAdapter(faqList: List<String>, itemOnListener: FaqAdapterCallBack) :
    RecyclerView.Adapter<FaqAdapter.ViewHolder>() {

    private var faqList: List<String> = ArrayList()
    private var itemOnListener: FaqAdapterCallBack

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemBasicAdapterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_basic_adapter,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val faqModel = getItem(position)
        //holder.binding.faqModel = faqModel
        //holder.binding.titleTV.text = faqModel.title

        holder.binding.mainCL.setOnClickListener {
            itemOnListener.onClick(position, faqModel)
        }
    }

    private fun getItem(position: Int): String {
        return faqList[position]
    }

    override fun getItemCount(): Int {
        return faqList.size
    }

    inner class ViewHolder(itemView: ItemBasicAdapterBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var binding: ItemBasicAdapterBinding = itemView
    }

    init {
        this.faqList = faqList
        this.itemOnListener = itemOnListener
    }

    interface FaqAdapterCallBack {
        fun onClick(position: Int, item: String)
    }
}