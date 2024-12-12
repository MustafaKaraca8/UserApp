package com.mustafa.userapp.app.domain

import com.mustafa.userapp.core.domain.NetworkError
import com.mustafa.userapp.core.domain.Result

interface UserDataSource {

    suspend fun getUsers(): Result<List<User>, NetworkError>
    suspend fun getUser(id: Int): Result<User, NetworkError>
}