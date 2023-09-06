package com.mwsa.ui.user

import android.view.View
import androidx.navigation.fragment.navArgs
import com.mwsa.ui.R
import com.mwsa.ui.base.BaseFragment
import com.mwsa.ui.base.observe
import com.mwsa.ui.databinding.UserListFragmentBinding
import kotlinx.android.synthetic.main.user_list_fragment.floating_action_button
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

        observe(userViewModel.users){
            if (it.isNotEmpty()) {
                with(binding){
                    tvUsers.visibility = View.GONE
                    rvUsers.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    appBar.visibility = View.VISIBLE
                }
            }
        }

        floating_action_button.setOnClickListener {
        }
    }

}
