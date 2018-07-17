package com.bodeslab.architectureexamplekotlin.di.module.application

import com.bodeslab.architectureexamplekotlin.repository.Repository
import com.bodeslab.architectureexamplekotlin.repository.RepositoryImpl
import com.bodeslab.architectureexamplekotlin.repository.data.LocalData
import com.bodeslab.architectureexamplekotlin.repository.data.RemoteData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesRepository(localData: LocalData, remoteData: RemoteData): Repository {
        return RepositoryImpl(localData, remoteData)
    }
}