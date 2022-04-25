package com.selimsimsek.githubapp.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.selimsimsek.domain.model.RepositoryItem
import com.selimsimsek.githubapp.R
import com.selimsimsek.githubapp.databinding.ItemReposRepoBinding

class ItemRepositoryAdapter(val itemclick: OnListItemViewClickListener) :
    RecyclerView.Adapter<ItemRepositoryAdapter.ItemRepositoryViewHolder>() {


    inner class ItemRepositoryViewHolder(val binding: ItemReposRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: RepositoryItem, position: Int) {
            binding.data = data;
            binding.root.setOnClickListener {
                itemclick.onClickItem(data, 1)
            }
            itemclick.onChangeColorInserted(binding.ivStarRoom, data)
            binding.ivStarRoom.setOnClickListener {
                itemclick.onClickStart(data)
                notifyItemChanged(position)
                itemclick.onChangeColorInserted(binding.ivStarRoom, data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRepositoryViewHolder {
        return ItemRepositoryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_repos_repo,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemRepositoryViewHolder, position: Int) {
        holder.onBind(data = data[position], position)
    }

    override fun getItemCount() = data.size

    interface OnListItemViewClickListener {
        fun onClickItem(itemViewModel: RepositoryItem, type: Int)
        fun onClickStart(item: RepositoryItem)
        fun onChangeColorInserted(imageView: ImageView, item: RepositoryItem)
    }

    val diffCallback = object : DiffUtil.ItemCallback<RepositoryItem>() {
        override fun areItemsTheSame(oldItem: RepositoryItem, newItem: RepositoryItem): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: RepositoryItem, newItem: RepositoryItem): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }
    val differ = AsyncListDiffer(this, diffCallback)

    var data: List<RepositoryItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)


}