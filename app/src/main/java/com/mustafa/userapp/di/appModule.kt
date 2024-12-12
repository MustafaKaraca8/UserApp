package com.mustafa.userapp.di

import com.mustafa.userapp.app.data.networking.RemoteUserDataSource
import com.mustafa.userapp.app.domain.UserDataSource
import com.mustafa.userapp.app.presentation.user_list.UserListViewModel
import com.mustafa.userapp.core.data.networking.HttpClientFactory
import io.ktor.client.engine.cio.CIO
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create())}
    singleOf(::RemoteUserDataSource).bind<UserDataSource>()

    viewModelOf(::UserListViewModel)
}