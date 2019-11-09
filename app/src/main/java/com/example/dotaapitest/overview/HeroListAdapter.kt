package com.example.dotaapitest.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dotaapitest.databinding.GridViewItemBinding
import com.example.dotaapitest.network.DotaProperty

class HeroListAdapter : ListAdapter<DotaProperty, HeroListAdapter.DotaPropertyViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<DotaProperty>() {
        override fun areItemsTheSame(oldItem: DotaProperty, newItem: DotaProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DotaProperty, newItem: DotaProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DotaPropertyViewHolder {
        return DotaPropertyViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: DotaPropertyViewHolder, position: Int) {
        val dotaProperty = getItem(position)
        holder.bind(dotaProperty)

    }

    class DotaPropertyViewHolder(private var binding: GridViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dotaProperty: DotaProperty) {
            binding.property = dotaProperty
            binding.executePendingBindings()
        }
    }
}