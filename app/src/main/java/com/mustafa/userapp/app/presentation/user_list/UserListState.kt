package com.mustafa.userapp.app.presentation.user_list

import com.mustafa.userapp.app.domain.User

data class UserListState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList()
)
