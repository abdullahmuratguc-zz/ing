package com.muratguc.ingchallange.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.muratguc.ingchallange.R
import com.muratguc.ingchallange.data.model.RepoListResponseModel
import com.muratguc.ingchallange.databinding.ItemRepoListBinding

/**
 * Created by Murat Güç on 2/1/2021.
 */
class RepoListRVA :
    PagingDataAdapter<RepoListResponseModel, RepoListRVA.RepoViewHolder>(RepoComparator) {

    var onItemClick: ((RepoListResponseModel) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.context),
                R.layout.item_repo_list,
                viewGroup,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val uiModel = getItem(position)
        uiModel.let {
            holder.bind(uiModel!!)
        }
    }

    inner class RepoViewHolder(private val binding: ItemRepoListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RepoListResponseModel) {
            binding.repo = item
            binding.root.setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
}

object RepoComparator : DiffUtil.ItemCallback<RepoListResponseModel>() {
    override fun areItemsTheSame(oldItem: RepoListResponseModel, newItem: RepoListResponseModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RepoListResponseModel, newItem: RepoListResponseModel): Boolean {
        return oldItem == newItem
    }
}