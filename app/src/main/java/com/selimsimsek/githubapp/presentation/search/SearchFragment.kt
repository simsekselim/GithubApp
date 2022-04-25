package com.selimsimsek.githubapp.presentation.search

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.selimsimsek.data.utils.Constants
import com.selimsimsek.domain.model.FollowersItem
import com.selimsimsek.domain.model.SearchRequest
import com.selimsimsek.githubapp.BR
import com.selimsimsek.githubapp.R
import com.selimsimsek.githubapp.common.adapter.GenericAdapter
import com.selimsimsek.githubapp.databinding.FragmentSearchBinding
import com.selimsimsek.githubapp.presentation.base.BaseFragment
import com.selimsimsek.githubapp.presentation.details.DetailUserViewModel
import com.selimsimsek.githubapp.utils.MemberItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>(
    R.layout.fragment_search,
    SearchViewModel::class.java
),GenericAdapter.OnListItemViewClickListener<FollowersItem> {

    private val adapter = GenericAdapter(R.layout.item_users, BR.data,this)

    private val userViewModel : DetailUserViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcData()
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.searchUser(it)
                }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        viewModel.search.observe(viewLifecycleOwner) {
            adapter.data = it.items
        }
    }

    private fun rcData() {
        binding.apply {
            rcData.setHasFixedSize(false)
            rcData.adapter = adapter
            rcData.addItemDecoration(MemberItemDecoration())
        }
    }

    override fun onClickItem(item: FollowersItem, type: Int) {
        val mBundle = Bundle()
        mBundle.putString(Constants.URL_DATA, item.htmlUrl)
        findNavController().navigate(R.id.webViewFragment, mBundle)


    }

    companion object{
      const val USERNAME = "USERNAME"
    }
}