package com.mwsa.ui.user

import com.mwsa.ui.R
import com.mwsa.ui.base.BaseFragment
import com.mwsa.ui.base.observe
import com.mwsa.ui.databinding.UserListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : BaseFragment<UserListFragmentBinding>(R.layout.user_list_fragment) {

    private val userAdapter by lazy {UserAdapter(context)}
    private val userViewModel by viewModel<UserViewModel>()

    override fun onViewCreated() {
        with(binding){
            adapter = userAdapter
            viewModel = userViewModel
        }

        initObserver()
    }

    private fun initObserver(){
        observe(userViewModel.users, userAdapter::update)
    }

}
