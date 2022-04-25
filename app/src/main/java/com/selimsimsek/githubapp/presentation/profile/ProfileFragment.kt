package com.selimsimsek.githubapp.presentation.profile

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.selimsimsek.data.utils.Constants
import com.selimsimsek.data.utils.Constants.URL_DATA
import com.selimsimsek.domain.model.RepositoryItem
import com.selimsimsek.githubapp.R
import com.selimsimsek.githubapp.common.adapter.ItemRepositoryAdapter
import com.selimsimsek.githubapp.databinding.FragmentProfileBinding
import com.selimsimsek.githubapp.presentation.base.BaseFragment
import com.selimsimsek.githubapp.utils.MemberItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>(
    R.layout.fragment_profile,
    ProfileViewModel::class.java
), ItemRepositoryAdapter.OnListItemViewClickListener {

    override val isSharedViewModel: Boolean = true

    private val adapter = ItemRepositoryAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rcData.setHasFixedSize(false)
            rcData.adapter = adapter
            rcData.addItemDecoration(MemberItemDecoration())
        }

        viewModel.item.observe(viewLifecycleOwner){
            adapter.data = it
        }

        viewModel.user.observe(viewLifecycleOwner) {
            binding.data = it
        }
        binding.btnGoToWeb.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString(URL_DATA, viewModel.user.value?.htmlUrl)
            findNavController().navigate(R.id.webViewFragment, mBundle)
        }

        binding.group.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString(URL_DATA, viewModel.user.value?.blog)
            findNavController().navigate(R.id.webViewFragment, mBundle)
        }
        binding.btnLink.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString(URL_DATA, viewModel.user.value?.blog)
            findNavController().navigate(R.id.webViewFragment, mBundle)
        }
    }



    override fun onClickItem(item: RepositoryItem, type: Int) {
        val mBundle = Bundle()
        mBundle.putString(Constants.URL_DATA, item.htmlUrl)
        findNavController().navigate(R.id.webViewFragment, mBundle)
    }

    override fun onClickStart(item: RepositoryItem) {
        TODO("Not yet implemented")
    }

    override fun onChangeColorInserted(imageView: ImageView, item: RepositoryItem) {
        imageView.setImageResource(R.mipmap.ic_star_yellow_light)
    }

}