package com.mwsa.ui.user

import androidx.lifecycle.MutableLiveData
import com.mwsa.domain.user.usecases.GetUsersUseCase
import com.mwsa.ui.base.BaseViewModel
import com.mwsa.ui.user.models.UserUiModel
import com.mwsa.ui.user.models.toUiModel

class UserViewModel (
    private val getUsersUseCase: GetUsersUseCase,
) : BaseViewModel() {

    val users = MutableLiveData<List<UserUiModel>>()

    init {
        getUsers()
    }

    fun getUsers(){
        launch {
            users.value = getUsersUseCase().map { it.toUiModel() }
            users

        }
    }
}