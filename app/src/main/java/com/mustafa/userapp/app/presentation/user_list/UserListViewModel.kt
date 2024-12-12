package com.mustafa.userapp.app.presentation.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.userapp.app.domain.UserDataSource
import com.mustafa.userapp.core.domain.onError
import com.mustafa.userapp.core.domain.onSuccess
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserListViewModel(
    private val remoteUserDataSource: UserDataSource
) : ViewModel() {

    private val _userState = MutableStateFlow(UserListState())
    val userState =
        _userState
            .onStart {
                getUsers()
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000L),
                UserListState()
            )

    private val _events = Channel<UserListEvent>()
    val events = _events.receiveAsFlow()

    private fun getUsers() {
        viewModelScope.launch {
            _userState.update {
                it.copy(isLoading = true)
            }

            remoteUserDataSource
                .getUsers()
                .onSuccess { users ->
                    _userState.update {
                        it.copy(
                            isLoading = false,
                            users = users
                        )
                    }
                }
                .onError { networkError ->
                    _userState.update { it.copy(isLoading = false) }
                    _events.send(UserListEvent.Error(error = networkError))
                }
        }
    }

}