package com.selimsimsek.githubapp.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.selimsimsek.githubapp.BR
import com.selimsimsek.githubapp.presentation.MainActivity
import com.selimsimsek.githubapp.utils.snackbar

abstract class BaseFragment<TViewModel : BaseViewModel, TBinding : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int,
    private val viewModelType: Class<TViewModel>
) : Fragment() {

    protected lateinit var viewModel: TViewModel
    protected lateinit var binding: TBinding

    open val isSharedViewModel = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            if (isSharedViewModel) {
                requireActivity()
            } else {
                this
            }
        )[viewModelType]

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            val activity = (requireActivity() as MainActivity)
            if (isLoading) {
                activity.showDialog()
            } else
                activity.dismissDialog()
        }
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.baseEvent.observe(viewLifecycleOwner) {
            onViewEvent(it)
        }
    }

    private fun onViewEvent(event: BaseViewEvent) {
        when (event) {
            is BaseViewEvent.NavigateTo ->
                findNavController().navigate(event.directions)
            is BaseViewEvent.ShowMessage ->
                snackbar(event.message.toString())
            is BaseViewEvent.NavigateBack ->
                findNavController().popBackStack()
        }
    }


}


