package com.strength.internetconectionproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.strength.internetconectionproject.databinding.GridViewItemBinding
import com.strength.internetconectionproject.network.MarsData

class PhotoGridAdapter : ListAdapter<MarsData, PhotoGridAdapter.MarsDataViewHolder>(DiffCallback) {
    companion object DiffCallback : DiffUtil.ItemCallback<MarsData>() {
        override fun areItemsTheSame(oldItem: MarsData, newItem: MarsData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MarsData, newItem: MarsData): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGridAdapter.MarsDataViewHolder {
        return MarsDataViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.MarsDataViewHolder, position: Int) {
        val marsData = getItem(position)

        holder.bind(marsData)
    }

    class MarsDataViewHolder(private var binding : GridViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(marsData: MarsData) {
            binding.marsDataList = marsData
            binding.executePendingBindings()
        }

    }
}