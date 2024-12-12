package com.mustafa.userapp.app.presentation.user_list

sealed interface UserListAction {
    data class OnUserClick(val userId: Int) : UserListAction
}