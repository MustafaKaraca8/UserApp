package com.mustafa.userapp.app.presentation.user_list

import com.mustafa.userapp.core.domain.NetworkError

sealed interface UserListEvent {
    data class Error(val error: NetworkError) : UserListEvent
}