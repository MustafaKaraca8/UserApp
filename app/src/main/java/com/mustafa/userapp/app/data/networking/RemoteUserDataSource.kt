package com.mustafa.userapp.app.data.networking

import com.mustafa.userapp.app.data.mappers.toUser
import com.mustafa.userapp.app.data.networking.dto.UsersResponseDto
import com.mustafa.userapp.app.domain.User
import com.mustafa.userapp.app.domain.UserDataSource
import com.mustafa.userapp.core.data.networking.constructUr
import com.mustafa.userapp.core.data.networking.safeCall
import com.mustafa.userapp.core.domain.NetworkError
import com.mustafa.userapp.core.domain.Result
import com.mustafa.userapp.core.domain.map
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteUserDataSource(
    private val httpClient: HttpClient
) : UserDataSource {

    override suspend fun getUsers(): Result<List<User>, NetworkError> {
        return safeCall<UsersResponseDto> {
            httpClient.get(
                urlString = constructUr("/users")
            )
        }.map { response ->
            response.data.map { userDto ->
                userDto.toUser()
            }
        }
    }

    override suspend fun getUser(id: Int): Result<User, NetworkError> {
        TODO("Not yet implemented")
    }

}