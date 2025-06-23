package com.pkgupta.sampleapp.di

import com.pkgupta.sampleapp.api.users.UserApi
import com.pkgupta.sampleapp.domain.repository.UserRepository
import com.pkgupta.sampleapp.domain.usecases.GetUsers
import com.pkgupta.sampleapp.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(api: UserApi): UserRepository {
        return UserRepositoryImpl(api)
    }

    @Provides
    fun provideGetUsersUseCase(repository: UserRepository): GetUsers {
        return GetUsers(repository)
    }
}